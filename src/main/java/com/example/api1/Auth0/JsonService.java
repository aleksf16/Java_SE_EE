package com.example.api1.Auth0;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
public class JsonService {

    public String role(String userInfo) throws ParseException {
        String message = null;
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(userInfo);
        String role = json.get("https://localhost/roles").toString();
        role = role.substring(2, role.length() - 2);

        return role;
    }
}
