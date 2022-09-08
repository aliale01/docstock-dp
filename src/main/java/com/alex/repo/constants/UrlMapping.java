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
    String ROLES = API + "roles";
    String USERS = API + "/users";


}
