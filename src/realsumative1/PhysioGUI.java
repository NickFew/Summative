/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realsumative1;

/**
 *
 * @author nwf60
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhysioGUI {
    private JFrame frame;
    private LoginManager loginManager;
    private ExerciseManager exerciseManager;
    private ProgressManager progressManager;
    private User currentUser;

    public PhysioGUI() {
        loginManager = new LoginManager();
        exerciseManager = new ExerciseManager();
        progressManager = new ProgressManager("progress.txt");
        frame = new JFrame("Physio App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        showLoginScreen();
    }

    public void showLoginScreen() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton createAccountButton = new JButton("Create Account");

        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(loginButton);
        panel.add(createAccountButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());
                if (loginManager.login(username, password)) {
                    currentUser = new User(username, password);
                    showExerciseScreen();
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid login.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());
                if (loginManager.createAccount(username, password)) {
                    JOptionPane.showMessageDialog(frame, "Account created successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Username already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    public void showExerciseScreen() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create search bar components
        JPanel searchPanel = new JPanel(new BorderLayout());
        JTextField searchField = new JTextField();
        JButton searchButton = new JButton("Search");

        searchPanel.add(new JLabel("Search: "), BorderLayout.WEST);
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.EAST);

        // Create the exercise list with a scroll bar
        DefaultListModel<Exercise> listModel = new DefaultListModel<>();
        for (Exercise exercise : exerciseManager.getExercises("need")) {
            listModel.addElement(exercise); // Automatically sorted exercises
        }
        JList<Exercise> exerciseList = new JList<>(listModel);
        exerciseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(exerciseList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Search functionality
        searchButton.addActionListener(e -> {
            String query = searchField.getText().toLowerCase(); // Case-insensitive search
            listModel.clear();

            for (Exercise exercise : exerciseManager.getExercises("need")) {
                if (exercise.getName().toLowerCase().contains(query) ||
                        exercise.getDescription().toLowerCase().contains(query)) {
                    listModel.addElement(exercise); // Add matching exercises to the list
                }
            }

            if (listModel.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No matches found.", "Search", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        JButton Progress = new JButton("Progress");

        Progress.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ShowProgressScreen();
            }
        });

        // Select button for showing exercise details and selecting the progress tab
        JButton selectButton = new JButton("Select");
        selectButton.addActionListener(e -> {
            Exercise selectedExercise = exerciseList.getSelectedValue();
            if (selectedExercise != null) {
                JOptionPane.showMessageDialog(frame, selectedExercise.getDescription());
            } else {
                JOptionPane.showMessageDialog(frame, "Please select an exercise.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add components to the panel
        panel.add(searchPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(selectButton, BorderLayout.SOUTH);
        panel.add(Progress,BorderLayout.WEST);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
    public void ShowProgressScreen(){
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        frame.setVisible(true);

    }
}