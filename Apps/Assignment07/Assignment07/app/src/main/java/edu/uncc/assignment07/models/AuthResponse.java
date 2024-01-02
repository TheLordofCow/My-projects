package edu.uncc.assignment07.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class AuthResponse implements Serializable {
    String user_id, user_fullname, token;

    /*

    {
    "status": "ok",
    "token": "wcUJRckNsODlsbkgyZUJS",
    "user_id": 1,
    "user_fullname": "Alice Smith"
}
     */

    public AuthResponse(JSONObject json) throws JSONException {
        user_fullname = json.getString("user_fullname");
        user_id = json.getString("user_id");
        token = json.getString("token");
    }

    public AuthResponse(String user_id, String user_fullname, String token) {
        this.user_id = user_id;
        this.user_fullname = user_fullname;
        this.token = token;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_fullname() {
        return user_fullname;
    }

    public void setUser_fullname(String user_fullname) {
        this.user_fullname = user_fullname;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
