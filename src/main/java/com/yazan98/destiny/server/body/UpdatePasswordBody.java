package com.yazan98.destiny.server.body;

/**
 * Created By : Yazan Tarifi
 * Date : 1/1/2020
 * Time : 2:07 PM
 */
public class UpdatePasswordBody {

    private Long id;
    private String oldPassword;
    private String newPassword;

    public UpdatePasswordBody() {

    }

    public UpdatePasswordBody(Long id, String oldPassword, String password) {
        this.id = id;
        this.oldPassword = oldPassword;
        this.newPassword = password;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
