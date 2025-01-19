/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realsumative1;

/**
 * Manages the progress entries of users, allowing them to track and save their progress in physiotherapy exercises.
 */

import java.io.*;
import java.util.*;

public class ProgressManager {

    private String filename;
    /**
     * Constructs a ProgressManager and initializes the list of progress entries.
     */
    public ProgressManager() {
        filename = "resources/Progress";
    }
    /**
     * Saves a single progress entry to the progress file.
     *
     * @param progress The progress entry to be saved.
     */
    public void saveProgress(Progress progress) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write("Pain level:" + progress.getPainLevel() + ", Difficulty" + progress.getDifficulty() + ", Area of pain:" + progress.getArea());
            writer.newLine(); // Move to the next line
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Loads all progress entries from the progress file into the progressList.
     */
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
    /**
     * Returns the list of all progress entries.
     *
     * @return The list of progress entries.
     */
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

