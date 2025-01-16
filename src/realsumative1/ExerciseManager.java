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
    //Shoulder exercises
        exercises.add(new Exercise("Rotator Cuff Stretch", "A gentle stretch for the rotator cuff (shoulder).", "https://example.com/video1"));
        exercises.add(new Exercise("Shoulder External Rotation", "Strengthens the rotator cuff muscles (shoulder).", "https://example.com/video2"));
        exercises.add(new Exercise("Lateral Raise", "Strengthens the lateral deltoid muscle (shoulder).", "https://example.com/video3"));
        exercises.add(new Exercise("Shoulder Press", "Strengthens the trapezius, deltoids, and triceps (shoulder).", "https://example.com/video4"));
        exercises.add(new Exercise("Pike Push-ups", "Strengthens the deltoids (shoulder).", "https://example.com/video5"));
        exercises.add(new Exercise("Face Pulls", "Strengthens the lateral deltoid muscle (shoulder).", "https://example.com/video6"));
        exercises.add(new Exercise("Reverse Flys", "Strengthens the traps, rear delts, rotator cuffs, and mid-back (shoulder).", "https://example.com/video7"));
        exercises.add(new Exercise("Upright Row", "Strengthens the posterior chain (shoulder).", "https://example.com/video8"));
        exercises.add(new Exercise("Shrugs", "Strengthens the traps (shoulder).", "https://example.com/video9"));

// Core exercises
        exercises.add(new Exercise("Plank", "Strengthens the core muscles.", "https://example.com/video10"));
        exercises.add(new Exercise("Russian Twists", "Improves rotational core strength.", "https://example.com/video11"));
        exercises.add(new Exercise("Leg Raises", "Targets the lower abdominal muscles.", "https://example.com/video12"));
        exercises.add(new Exercise("Bicycle Crunches", "Works the entire core.", "https://example.com/video13"));

// Leg exercises
        exercises.add(new Exercise("Squats", "Strengthens the quadriceps, hamstrings, and glutes.", "https://example.com/video14"));
        exercises.add(new Exercise("Lunges", "Targets the quads, glutes, and calves.", "https://example.com/video15"));
        exercises.add(new Exercise("Calf Raises", "Strengthens the calf muscles.", "https://example.com/video16"));
        exercises.add(new Exercise("Hamstring Curls", "Focuses on the hamstring muscles.", "https://example.com/video17"));

// Arm exercises
        exercises.add(new Exercise("Bicep Curls", "Targets the bicep muscles.", "https://example.com/video18"));
        exercises.add(new Exercise("Tricep Dips", "Strengthens the triceps.", "https://example.com/video19"));
        exercises.add(new Exercise("Hammer Curls", "Works both biceps and forearms.", "https://example.com/video20"));
        exercises.add(new Exercise("Push-ups", "Builds upper body strength.", "https://example.com/video21"));

// Back exercises
        exercises.add(new Exercise("Pull-ups", "Strengthens the lats, traps, and biceps.", "https://example.com/video22"));
        exercises.add(new Exercise("Deadlifts", "Engages the entire posterior chain.", "https://example.com/video23"));
        exercises.add(new Exercise("Seated Rows", "Targets the mid-back muscles.", "https://example.com/video24"));
        exercises.add(new Exercise("Superman Exercise", "Strengthens the lower back and glutes.", "https://example.com/video25"));

// Cardio exercises
        exercises.add(new Exercise("Jumping Jacks", "Increases heart rate and burns calories.", "https://example.com/video26"));
        exercises.add(new Exercise("Burpees", "A full-body cardio workout.", "https://example.com/video27"));
        exercises.add(new Exercise("Mountain Climbers", "Builds endurance and core strength.", "https://example.com/video28"));
        exercises.add(new Exercise("High Knees", "Improves cardiovascular fitness.", "https://example.com/video29"));


    }

    public List<Exercise> getExercises(String need) {
        // In a real app, filter exercises based on the need
        return exercises;
    }

}