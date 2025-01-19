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
import java.util.*;

public class ProgressManager {

    private String filename;

    public ProgressManager() {
        filename = "resources/Progress";
    }

    public void saveProgress(Progress progress) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write("Pain level:" + progress.getPainLevel() + ", Difficulty" + progress.getDifficulty() + ", Area of pain:" + progress.getArea());
            writer.newLine(); // Move to the next line
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<String> seeSavedProgress() {
        List<String> progressList = new ArrayList<>();

        // Read from the progress file
        try (BufferedReader reader = new BufferedReader(new FileReader("resources/Progress"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    progressList.add("Pain Level: " + parts[0] + ", Difficulty: " + parts[1] + ", Area: " + parts[2]);
                }
            }
        } catch (IOException e) {
            System.err.println("Error while reading progress: " + e.getMessage());
            e.printStackTrace();
        }

        return progressList;
    }
    public String readFile() {
        String fullString = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("resources/Progress"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fullString += line + "\n";
            }
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }
        return fullString; // Return the complete file content
    }
}

