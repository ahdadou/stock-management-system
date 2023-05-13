//package ma.gtw.filter;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpHeaders;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.client.oidc.web.server.logout.OidcClientInitiatedServerLogoutSuccessHandler;
//import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//import org.springframework.security.web.server.WebFilterExchange;
//import org.springframework.security.web.server.authentication.logout.ServerLogoutSuccessHandler;
//import org.springframework.security.web.server.csrf.CookieServerCsrfTokenRepository;
//import org.springframework.security.web.server.csrf.CsrfToken;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.reactive.CorsConfigurationSource;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//import org.springframework.web.server.WebFilter;
//import reactor.core.publisher.Mono;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Configuration
//@EnableWebFluxSecurity
//public class SecurityConfig {
//
////    @Value("${port.front-end}")
//    private String serverPort = "3000";
//
////    @Value("${host.front-end}")
//    private String host = "http://localhost";
//
//    private final ReactiveClientRegistrationRepository clientRegistrationRepository;
//
//    public SecurityConfig(ReactiveClientRegistrationRepository clientRegistrationRepository) {
//        this.clientRegistrationRepository = clientRegistrationRepository;
//    }
//
//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//        http.csrf(csrf -> csrf.csrfTokenRepository(CookieServerCsrfTokenRepository.withHttpOnlyFalse()))
//                .logout(logout -> logout.logoutSuccessHandler(oidcLogoutSuccessHandler()))
//                .cors()
//                .configurationSource(createCorsConfigSource())
//                .and()
//                .authorizeExchange(
//                        exchanges -> exchanges.pathMatchers("/manifest.json", "/*.png", "/static/**", "/api/user")
//                                .permitAll().anyExchange().authenticated())
//                .oauth2Login()
//                .and()
//                .oauth2ResourceServer()
//                .jwt();
//        return http.build();
//    }
//
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("*"));
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//
//    public CorsConfigurationSource createCorsConfigSource() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.addAllowedOrigin("*");
//        config.addAllowedMethod("OPTIONS");
//        config.addAllowedMethod("GET");
//        config.addAllowedMethod("PUT");
//        config.addAllowedMethod("POST");
//        config.addAllowedMethod("DELETE");
//        source.registerCorsConfiguration("/**", config);
//        return source;
//    }
//
//    private ServerLogoutSuccessHandler oidcLogoutSuccessHandler() {
//        OidcClientInitiatedServerLogoutSuccessHandler oidcLogoutSuccessHandler = new OidcClientInitiatedServerLogoutSuccessHandler(
//                this.clientRegistrationRepository) {
//            @Override
//            public Mono<Void> onLogoutSuccess(WebFilterExchange exchange, Authentication authentication) {
//
//                // logout was called and proxied, let's default redirection to "origin"
//                List<String> origin = exchange.getExchange().getRequest().getHeaders().get(HttpHeaders.ORIGIN);
//
//                setPostLogoutRedirectUri(host + ":" + serverPort);
//                return super.onLogoutSuccess(exchange, authentication);
//            }
//        };
//        return oidcLogoutSuccessHandler;
//    }
//
//    @Bean
//    WebFilter addCsrfToken() {
//        return (exchange, next) -> exchange.<Mono<CsrfToken>>getAttribute(CsrfToken.class.getName())
//                .doOnSuccess(token -> {
//                }).then(next.filter(exchange));
//    }
//}
