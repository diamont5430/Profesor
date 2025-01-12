package commons;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class appUser {

    @Id
    private String username;

    private String password;

    private String color;

    public appUser(String username, String password, String color) {
        this.username = username;
        this.password = password;
        this.color = color;
    }
    public appUser(){
    }

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
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public void changeColor(String color) {
        this.color = color;
    }
}
