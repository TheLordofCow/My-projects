package edu.uncc.assignment07.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Post implements Serializable {
    public String created_by_name, post_id, created_by_uid, post_text, created_at;

    public Post() {
    }

    public Post(JSONObject json) throws JSONException {
        created_by_name = json.getString("created_by_name");
        post_id = json.getString("post_id");
        created_by_uid = json.getString("created_by_uid");
        post_text = json.getString("post_text");
        created_at = json.getString("created_at");
    }

    public String getCreated_by_name() {
        return created_by_name;
    }

    public String getPost_id() {
        return post_id;
    }

    public String getCreated_by_uid() {
        return created_by_uid;
    }

    public String getPost_text() {
        return post_text;
    }

    public String getCreated_at() {
        return created_at;
    }

    @Override
    public String toString() {
        return "Post{" +
                "created_by_name='" + created_by_name + '\'' +
                ", post_id='" + post_id + '\'' +
                ", created_by_uid='" + created_by_uid + '\'' +
                ", post_text='" + post_text + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}

