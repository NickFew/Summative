/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realsumative1;

/**
 *
 * @author nwf60
 */
import com.sun.javafx.scene.web.Debugger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoginManager {
    private ArrayList<User> users = new ArrayList<>();

    public LoginManager() {
        readUsers();
//        users.add(new User("test", "password")); // Example user
    }

    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean createAccount(String username, String password) {
        if (users.isEmpty()) {
            addUserText(username,password);
            return true;
        }
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false; // Username already exists
            }
        }

        users.add(new User(username, password));
        addUserText(username,password);
        return true;
    }
    // Help from Elliott
    public void addUserText(String username, String password) {
        // username,password
        try (PrintWriter pw = new PrintWriter(new FileWriter("resources/users",true))) {
            String combined = username + "," + password;
            pw.println(combined);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    // Help from Elliott
    public void readUsers() {
        try(BufferedReader br = new BufferedReader(new FileReader("resources/users"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                User user = new User(parts[0],parts[1]);
                users.add(user);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}