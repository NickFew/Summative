/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realsumative1;

/**
 *
 * @author nwf60
 */
public class Exercise {
    private String name;
    private String description;
    private String videoURL;

    public Exercise(String name, String description, String videoURL) {
        this.name = name;
        this.description = description;
        this.videoURL = videoURL;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getVideoURL() {
        return videoURL;
    }
    public String toString(){
        return getName();
    }// used solve problem of it not displaying the name but instead the to array

}

