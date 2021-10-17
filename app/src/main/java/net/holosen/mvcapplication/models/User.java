package net.holosen.mvcapplication.models;

public class User implements IUser {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Boolean isValid() {
        if (username.isEmpty())
            return false;
        if (password.isEmpty())
            return false;
        if (password.length() < 8)
            return false;
        return true;
    }
}
