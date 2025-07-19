package tn.esprit.spring.security;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

@Configuration
public class FeignClientOAuth2Config {

    private final OAuth2AuthorizedClientManager authorizedClientManager;

    public FeignClientOAuth2Config(OAuth2AuthorizedClientManager authorizedClientManager) {
        this.authorizedClientManager = authorizedClientManager;
    }

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return requestTemplate -> {
            OAuth2AuthorizeRequest authorizeRequest = OAuth2AuthorizeRequest.withClientRegistrationId("contrat-service")
                    .principal("islem")
                    .build();

            String accessToken = authorizedClientManager.authorize(authorizeRequest).getAccessToken().getTokenValue();

            requestTemplate.header("Authorization", "Bearer " + accessToken);
        };
    }
}