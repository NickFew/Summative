/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realsumative1;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LoginManager {
    private Map<String, String> userMap = new HashMap<>();
    private String userFile = "resources/users";

    public LoginManager() {
        loadUsers();
    }

    public boolean login(String username, String password) {
        return userMap.containsKey(username) && userMap.get(username).equals(password);
    }

    public boolean createAccount(String username, String password) {
        if (userMap.containsKey(username)) {
            return false; // Username already exists
        }
        userMap.put(username, password);
        saveUser(username, password);
        return true;
    }

    private void saveUser(String username, String password) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(userFile, true))) {
            pw.println(username + "," + password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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