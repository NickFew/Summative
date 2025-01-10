/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realsumative1;

/**
 *
 * @author nwf60
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProgressManager {
    private String file;

    public ProgressManager(String file) {
        this.file = file;
    }

    public void saveProgress(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (Progress progress : user.getProgress()) {
                writer.write(user.getUsername() + "," + progress.getPainLevel() + "," + progress.getArea() + "," + progress.getDifficulty());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Progress> getProgress(String username) {
        List<Progress> progressList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(username)) {
                    int painLevel = Integer.parseInt(parts[1]);
                    String area = parts[2];
                    int difficulty = Integer.parseInt(parts[3]);
                    progressList.add(new Progress(painLevel, area, difficulty));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return progressList;
    }
}