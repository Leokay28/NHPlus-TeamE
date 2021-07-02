package model;

import java.io.IOException;

public class UserSession {
    private float uid;
    private String username;
    private String role;

    public UserSession(float uid, String username, String role) throws IOException {
        this.uid = uid;
        this.username = username;
        this.role = role;
    }

    public float getUid() {
        return uid;
    }

    public void setUid(float uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
