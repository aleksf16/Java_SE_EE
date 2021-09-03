package com.example.api1.Auth0;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * Controller for the home page.
 */
@Controller
public class Auth0Controller {

    private final JsonService jsonService;

    @Autowired
    public Auth0Controller(JsonService jsonService) {
        this.jsonService = jsonService;
    }

    @GetMapping("/me/role")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) throws ParseException {

        String userInfo = claimsToJson(principal.getClaims());
        if(jsonService.role(userInfo).equals("READER"))
            return "reader";
        else if(jsonService.role(userInfo).equals("ADMIN"))
            return "admin";
        else return null;
    }

    private String claimsToJson(Map<String, Object> claims) {
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(claims);
        } catch (JsonProcessingException jpe) {
            System.out.println("error parsing json");
        }
        return "Error parsing claims to JSON.";
    }
}
