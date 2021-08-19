package com.example.api1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Config {

    @Bean
    ClientRegistrationRepository clientRegistrationRepository(){

        Map<String,Object> map = new HashMap<>();
        String issuer = "http://localhost:8080/";
        map.put("issuer",issuer);
        ClientRegistration clientRegistration = ClientRegistration.withRegistrationId("auth0")
                .clientId("C2MwsXmdZXV0GFCKRZ4tcg1CRCHtzuNL")
                .clientSecret("btYPwN4R1PWy4cmwE5ggrH1hGmLdKWwUf_cnQeS2-ZjCWD25Rw-mBowbkJLHm7hz")
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .scope("openid", "profile", "email")
                .authorizationUri("https://dev-pcug19gs.us.auth0.com/authorize")
                .issuerUri("https://dev-pcug19gs.us.auth0.com/")
                .tokenUri("https://dev-pcug19gs.us.auth0.com/oauth/token")
                .jwkSetUri("https://dev-pcug19gs.us.auth0.com/.well-known/jwks.json")
                .userInfoUri("https://dev-pcug19gs.us.auth0.com/userinfo")
                .userNameAttributeName("nickname")
                .clientName("https://dev-pcug19gs.us.auth0.com/")
                .providerConfigurationMetadata(map)
                .redirectUri("{baseUrl}/role").build();
        return new InMemoryClientRegistrationRepository(clientRegistration);
    }

}
