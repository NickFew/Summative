/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realsumative1;

/**
 * Represents an exercise with a name, description, and video URL.
 */
public class Exercise {
    private String name;
    private String description;
    private String videoURL;
    /**
     * Constructs an Exercise object with the specified name, description, and video URL.
     *
     * @param name The name of the exercise.
     * @param description A brief description of the exercise.
     * @param videoURL The URL to the exercise demonstration video.
     */
    public Exercise(String name, String description, String videoURL) {
        this.name = name;
        this.description = description;
        this.videoURL = videoURL;
    }

    /**
     * Returns the name of the exercise.
     *
     * @return The name of the exercise.
     */
    public String getName() {
        return name;
    }
    /**
     * Returns the description of the exercise.
     *
     * @return The description of the exercise.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Returns the URL of the exercise video.
     *
     * @return The URL of the exercise video.
     */
    public String getVideoURL() {
        return videoURL;
    }
    /**
     * Returns a string representation of the exercise.
     *
     * @return The name of the exercise.
     */
    public String toString(){
        return getName();
    }

}

