package com.alex.repo.constants;

public interface UrlMapping {

    String API = "/api";
    String AUTH = "/auth";
    String REGISTER = AUTH + "/register";
    String LOGIN = AUTH + "/login";
    String REFRESH = AUTH + "/refresh";
    String LOGOUT = AUTH + "/logout";
    String UPLOAD = ("/upload");
    String DOCUMENTS = API + "/documents";
    String ROLES = API + "/roles";
    String USERS = API + "/users";

    String[] SWAGGER_WHITELIST = {
            // -- Swagger UI v2
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            // -- Swagger UI v3 (OpenAPI)
            "/v3/api-docs/**",
            "/swagger-ui/**"
            // other public endpoints of your API may be appended to this array
    };



}
