package com.secondstack.flatoutstore.simple.request;

/**
 * Created with IntelliJ IDEA.
 * User: latief
 * Date: 5/16/12
 * Time: 2:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class RequestUserPass {

    private String username;
    private String newUsername;
    private String newPassword;
    private String confirmNewPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestUserPass that = (RequestUserPass) o;

        if (confirmNewPassword != null ? !confirmNewPassword.equals(that.confirmNewPassword) : that.confirmNewPassword != null)
            return false;
        if (newPassword != null ? !newPassword.equals(that.newPassword) : that.newPassword != null) return false;
        if (newUsername != null ? !newUsername.equals(that.newUsername) : that.newUsername != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (newUsername != null ? newUsername.hashCode() : 0);
        result = 31 * result + (newPassword != null ? newPassword.hashCode() : 0);
        result = 31 * result + (confirmNewPassword != null ? confirmNewPassword.hashCode() : 0);
        return result;
    }
}
