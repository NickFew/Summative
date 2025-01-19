/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realsumative1;

import java.awt.event.ActionListener;

/**
 *
 * @author nwf60
 */
public class Progress {
    private int painLevel;
    private String area;
    private int difficulty;

    public Progress(int painLevel, String area, int difficulty) {
        this.painLevel = painLevel;
        this.area = area;
        this.difficulty = difficulty;
    }

    public Progress() {
        this(0,null,0);
    }

    public static void addActionListener(ActionListener actionListener) {
    }

    public int getPainLevel() {
        return painLevel;
    }

    public String getArea() {
        return area;
    }
    /**
     * Returns a string representation of the progress entry.
     *
     * @return A string summarizing the progress details.
     */
    public int getDifficulty() {
        return difficulty;
    }
}