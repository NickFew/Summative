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

// User class
public class User {
    private String username;
    private String password;
    private List<Progress> progress;
    /**
     * Constructs a User object with the specified username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.progress = new ArrayList<>();
    }
    /**
     * Returns the username of the user.
     *
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }
    /**
     * Returns the password of the user.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }
    /**
     * Returns the list of progress entries for the user.
     * This allows tracking the user's physiotherapy progress over time.
     *
     * @return The list of progress entries.
     */
    public List<Progress> getProgress() {
        return progress;
    }
    /**
     * Adds a new progress entry to the user's progress list.
     *
     * @param progressEntry The progress entry to be added.
     */
    public void addProgress(Progress progressEntry) {
        progress.add(progressEntry);
    }
}