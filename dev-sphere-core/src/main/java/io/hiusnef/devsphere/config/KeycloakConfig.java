package io.hiusnef.devsphere.config;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import jakarta.annotation.PreDestroy;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Component
@ConfigurationProperties(prefix = "keycloak")
public class KeycloakConfig {
private String realm;
    private String serverUrl;
    private String username;
    private String password;
    private String clientId;
    private String clientSecret;

    private Keycloak keycloak;

    @Bean
    public Keycloak keycloakBuilder() {
        keycloak = KeycloakBuilder.builder()
                .realm(realm)
                .serverUrl(serverUrl)
                .clientId(clientId)
                .grantType("client_credentials")
                .clientSecret(clientSecret)
                .build();
        return keycloak;
    }

    @PreDestroy
    public void onDestroy() throws Exception {
        log.info("Closing Keycloak client");
        keycloak.close();
    }
}
