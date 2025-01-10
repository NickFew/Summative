/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realsumative1;

/**
 *
 * @author nwf60
 */
import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<Progress> progress;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.progress = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Progress> getProgress() {
        return progress;
    }

    public void addProgress(Progress progressEntry) {
        progress.add(progressEntry);
    }
}