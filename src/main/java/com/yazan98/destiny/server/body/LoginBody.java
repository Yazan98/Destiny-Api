package com.yazan98.destiny.server.body;

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 4:45 PM
 */
public class LoginBody {

    private String email;
    private String password;

    public LoginBody() {

    }

    public LoginBody(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
