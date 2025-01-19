/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realsumative1;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
/**
 * Handles the login functionality for users, including account creation and authentication.
 */
public class LoginManager {
    private Map<String, String> userMap = new HashMap<>();
    private String userFile = "resources/users";

    /**
     * Constructs a LoginManager and loads the user data from the file.
     */
    public LoginManager() {
        loadUsers();
    }
    /**
     * Logs in the user with the specified username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return true if the login is successful, false otherwise.
     */
    public boolean login(String username, String password) {
        return userMap.containsKey(username) && userMap.get(username).equals(password);
    }
    /**
     * Creates a new user account with the specified username and password.
     *
     * @param username The username of the new user.
     * @param password The password of the new user.
     * @return true if the account is created successfully, false if the username already exists.
     */
    public boolean createAccount(String username, String password) {
        if (userMap.containsKey(username)) {
            return false; // Username already exists
        }
        userMap.put(username, password);
        saveUser(username, password);
        return true;
    }
    /**
     * Saves the newly created user's username and password to the user file.
     *
     * @param username The username of the new user.
     * @param password The password of the new user.
     */
    private void saveUser(String username, String password) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(userFile, true))) {
            pw.println(username + "," + password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Loads the user data from the user file into the userMap.
     */
    private void loadUsers() {
        try (BufferedReader br = new BufferedReader(new FileReader(userFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    userMap.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}