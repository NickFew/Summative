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

public class ExerciseManager {
    private List<Exercise> exercises;

    public ExerciseManager() {
        exercises = new ArrayList<>();
        exercises.add(new Exercise("Rotator Cuff Stretch", "A gentle stretch for the rotator cuff.", "https://example.com/video1"));
        exercises.add(new Exercise("Shoulder External Rotation", "Strengthens the rotator cuff muscles.", "https://example.com/video2"));
    }

    public List<Exercise> getExercises(String need) {
        // In a real app, filter exercises based on the need
        return exercises;
    }
}