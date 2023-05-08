# StockManagementSystem
Application web  permettant de simplifier la gestion et l’archivage de ses Différentes opérations (Vente et achat) ainsi que la gestion de stockage de ses données (Produits, clients, fournisseurs…)

----------------------------
Your Front-end SPA should be public-client and springboot micro service should be Bearer only Client and Gateway could be Confidential Client.

You can check the Keycloak provided oidc adapters. For springboot you use the keycloak provided adapter --> https://stackoverflow.com/questions/49056708/is-keycloak-behind-api-gateway-a-good-practice

Similar solution using api gateway is discussed here ---> https://stackoverflow.com/questions/49056708/is-keycloak-behind-api-gateway-a-good-practice

https://www.baeldung.com/spring-cloud-gateway-oauth2#bd-2-spring-cloud-gateway-as-an-oauth-20-resource-server


# SENARIO 1 : Spring Gateway as OAuth 2.0 Client [LINK](https://www.baeldung.com/postman-keycloak-endpoints)
### DEPENDENCIES

     implementation'org.springframework.cloud:spring-cloud-starter-gateway'
     implementation'org.springframework.boot:spring-boot-starter-oauth2-client'
     implementation'org.springframework.security:spring-security-oauth2-resource-server'

### YAML
 

     spring:
        application:
          name: api-gateway
        cloud:
          gateway:
            routes:
              - id: PRODUCTS
                uri: http://localhost:8082
                predicates:
                  - Path=/api/v1/product/**
                filters:
                  - TokenRelay=
        security:
          oauth2:
            client:
              provider:
                keycloak:
                  issuer-uri: http://localhost:8080/realms/stock_manager
              registration:
                stock-manager:
                  provider: keycloak
                  client-id: gateway-app
                  client-secret: ZhpVhhrnSU68sIeBuS48TsjGySSgoiCz
                  redirect-uri: http://localhost:8080/login/oauth2/code
                  scope: openid,profile,email



# SENARIO 2 : Spring Gateway as OAuth 2.0 Resource Server[LINK](https://www.baeldung.com/postman-keycloak-endpoints)

### DEPENDENCIES

     implementation'org.springframework.cloud:spring-cloud-starter-gateway'
     implementation'org.springframework.boot:spring-boot-starter-oauth2-client'
     implementation'org.springframework.security:spring-security-oauth2-resource-server'

### YAML

    spring:
      application:
        name: api-gateway
      cloud:
        gateway:
          routes:
            - id: PRODUCTS
              uri: http://localhost:8082
              predicates:
                - Path=/api/v1/product/**
      security:
        oauth2:
          resourceserver:
            opaquetoken:
              introspection-uri: http://localhost:8080/realms/stock_manager/protocol/openid-connect/token/introspect
              client-id: gateway-app
              client-secret: ZhpVhhrnSU68sIeBuS48TsjGySSgoiCz

# SENARIO 3 :  Spring Gateway + KEYCLOAK
### GATEWAY
### DEPENDENCIES

     implementation'org.springframework.cloud:spring-cloud-starter-gateway'
     implementation'org.springframework.boot:spring-boot-starter-oauth2-client'
     implementation'org.springframework.security:spring-security-oauth2-resource-server'

### YAML
    server:
      port: 8888
    
    app:
      config:
        keycloak:
          url: http://localhost:8080
          realm: stock_manager
    
    spring:
      application:
        name: api-gateway
      cloud:
        gateway:
          routes:
            - id: PRODUCTS
              uri: http://localhost:8082
              predicates:
                - Path=/api/v1/product/**
              filters:
                - TokenRelay=
      security:
        oauth2:
          client:
            provider:
              keycloak:
                token-uri: ${app.config.keycloak.url}/realms/${app.config.keycloak.realm}/protocol/openid-connect/token
                authorization-uri: ${app.config.keycloak.url}/realms/${app.config.keycloak.realm}/protocol/openid-connect/auth
                user-name-attribute: preferred_username
                user-info-uri: ${app.config.keycloak.url}/realms/${app.config.keycloak.realm}/protocol/openid-connect/userinfo
                jwk-set-uri: ${app.config.keycloak.url}/realms/${app.config.keycloak.realm}/protocol/openid-connect/certs
                user-info-authentication-method: header
            registration:
              internet-banking-core-client:
                provider: keycloak
                client-id: gateway-app
                client-secret: ZhpVhhrnSU68sIeBuS48TsjGySSgoiCz
                authorization-grant-type: authorization_code
                redirect-uri: http://localhost:8080/login/oauth2/code
                scope: openid
          resourceserver:
            jwt:
              jwk-set-uri: ${app.config.keycloak.url}/realms/${app.config.keycloak.realm}/protocol/openid-connect/certs

### CLASS CONFIGURATION

    @Configuration
    @EnableWebFluxSecurity
    public class SecurityConfig {
      private String serverPort = "3000";
      private String host = "http://localhost";
    
      private final ReactiveClientRegistrationRepository clientRegistrationRepository;
    
      public SecurityConfig(ReactiveClientRegistrationRepository clientRegistrationRepository) {
        this.clientRegistrationRepository = clientRegistrationRepository;
      }
    
      @Bean
      public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
          .csrf(csrf -> csrf.csrfTokenRepository(CookieServerCsrfTokenRepository.withHttpOnlyFalse()))
          .logout(logout -> logout.logoutSuccessHandler(oidcLogoutSuccessHandler()))
          .cors()
          .configurationSource(createCorsConfigSource())
          .and()
          .authorizeExchange(
            exchanges -> exchanges.pathMatchers("/manifest.json", "/*.png", "/static/**", "/api/user")
            .permitAll().anyExchange().authenticated())
          .oauth2Login()
          .and()
          .oauth2ResourceServer()
          .jwt();
        return http.build();
      }
    
      @Bean
      CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
      }
    
      public CorsConfigurationSource createCorsConfigSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", config);
        return source;
      }
    
      private ServerLogoutSuccessHandler oidcLogoutSuccessHandler() {
        OidcClientInitiatedServerLogoutSuccessHandler oidcLogoutSuccessHandler = new OidcClientInitiatedServerLogoutSuccessHandler(
          this.clientRegistrationRepository) {
          @Override
          public Mono < Void > onLogoutSuccess(WebFilterExchange exchange, Authentication authentication) {
            setPostLogoutRedirectUri(host + ":" + serverPort);
            return super.onLogoutSuccess(exchange, authentication);
          }
        };
        return oidcLogoutSuccessHandler;
      }
    
      @Bean
      WebFilter addCsrfToken() {
        return (exchange, next) -> exchange. < Mono < CsrfToken >> getAttribute(CsrfToken.class.getName())
          .doOnSuccess(token -> {}).then(next.filter(exchange));
      }
    }
## OTHER MICROSERVICES

    spring:
        resourceserver:
    	    jwt:
    		    jwk-set-uri: ${app.config.keycloak.url}/realms/${app.config.keycloak.realm}/protocol/openid-connect/certs
