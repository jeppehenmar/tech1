package models;

/**
 * Created by jeppe on 09-03-2017.
 */
public class User {
    private String username;
    private String password;
    private UserType type;
    private boolean checked;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.type = null;
        checked = false;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserType getType() {
        return type;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

}
