//package ma.gtw.filter;
//
//import java.net.URI;
//
//import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.server.ServerRequest;
//import org.springframework.web.reactive.function.server.ServerResponse;
//
//import reactor.core.publisher.Mono;
//
//@Component
//public class GatewayHandler {
//
//    public Mono<ServerResponse> getCurrentUser(ServerRequest request) {
//
//        return request.principal().map(p -> ((OAuth2AuthenticationToken) p).getPrincipal())
//                .flatMap(n -> ServerResponse.ok().bodyValue(n.getAttribute("preferred_username")));
//
//    }
//
//    public Mono<ServerResponse> getPrivate(ServerRequest serverRequest) {
//        return ServerResponse.temporaryRedirect(URI.create("/")).build();
//    }
//
//}