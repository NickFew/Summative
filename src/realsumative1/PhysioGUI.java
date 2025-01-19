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
/**
 * Manages the GUI   App, including the login, exercise selection, and progress tracking panaels.
 */
public class PhysioGUI {
    private JFrame frame;
    private LoginManager loginManager;
    private ExerciseManager exerciseManager;
    private ProgressManager progressManager;
    private User currentUser;
    /**
     * Constructs the PhysioGUI and initializes necessary managers.
     */
    public PhysioGUI() {
        loginManager = new LoginManager();
        exerciseManager = new ExerciseManager();
        progressManager = new ProgressManager();
        frame = new JFrame("Physio App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        showLoginScreen();
    }
    /**
     * Displays the login screen where users can enter their username and password.
     */
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
    /**
     * Displays the exercise selection screen with a list of exercises and a search bar.
     */
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

        // Create the Sign Out button
        JButton signOutButton = new JButton("Sign Out");
        signOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLoginScreen(); //back to the login screen
            }
        });

        // Create Progress Button
        JButton Progress = new JButton("Progress");

        Progress.addActionListener(new ActionListener() {
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
        panel.add(Progress, BorderLayout.WEST);
        panel.add(signOutButton, BorderLayout.EAST); // Add Sign Out button at the East side

        frame.setContentPane(panel);
        frame.setVisible(true);
    }
    /**
     * Displays the progress screen where users can input and submit their progress details.
     */
    public void ShowProgressScreen() {
        // Create the panel for progress screen
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        // Add labels and input fields
        JLabel painLevelLabel = new JLabel("Pain Level (1-10):");
        JTextField painLevelField = new JTextField();
        JLabel difficultyLabel = new JLabel("Difficulty (1-10):");
        JTextField difficultyField = new JTextField();
        JLabel areaLabel = new JLabel("Area of Pain:");
        JTextField areaField = new JTextField();

        JButton submitButton = new JButton("Submit");
        JButton backButton = new JButton("Back");

        // Add components to the panel
        panel.add(painLevelLabel);
        panel.add(painLevelField);
        panel.add(difficultyLabel);
        panel.add(difficultyField);
        panel.add(areaLabel);
        panel.add(areaField);
        panel.add(submitButton);
        panel.add(backButton);

        // Add functionality to the Submit button
        submitButton.addActionListener(e -> {
            String painLevelText = painLevelField.getText();
            String difficultyText = difficultyField.getText();
            String area = areaField.getText();

            try {
                int painLevel = Integer.parseInt(painLevelText);
                int difficulty = Integer.parseInt(difficultyText);

                // Validate input
                if (painLevel < 1 || painLevel > 10) {
                    JOptionPane.showMessageDialog(frame, "Pain Level must be between 1 and 10.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (difficulty < 1 || difficulty > 10) {
                    JOptionPane.showMessageDialog(frame, "Difficulty must be between 1 and 10.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (area.isEmpty() || !area.matches("[a-zA-Z\\s]+")) {
                    JOptionPane.showMessageDialog(frame, "Area of Pain must be a valid string (letters and spaces only).", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Create a Progress object
                Progress progress = new Progress(painLevel, area, difficulty);

                // Save the progress using ProgressManager
                progressManager.saveProgress(progress);

                // Inform the user that the progress was saved
                JOptionPane.showMessageDialog(frame, "Progress Saved!\n" +
                        "Pain Level: " + painLevel + "\n" +
                        "Difficulty: " + difficulty + "\n" +
                        "Area of Pain: " + area, "Success", JOptionPane.INFORMATION_MESSAGE);

                // Clear fields after saving
                painLevelField.setText("");
                difficultyField.setText("");
                areaField.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Pain Level and Difficulty must be valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        JButton viewFileButton = new JButton("View Progress File");
        viewFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayFile();
            }
        });

        panel.add(viewFileButton);
        frame.add(panel);

        // Add functionality to the Back button
        backButton.addActionListener(e -> showExerciseScreen());

        // Set the panel as the content pane and make it visible
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
    /**
     * Displays the progress file for the user to view their saved progress.
     */
    public void displayFile() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false); // Make the text area read-only
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Retrieve and display the file content
        String fileContent = progressManager.readFile();
        if (fileContent == null || fileContent.isEmpty()) {
            fileContent = "No progress data available.";
        }
        textArea.setText(fileContent);

        panel.add(scrollPane, BorderLayout.CENTER);

        // Create the Back button
        JButton backButton = new JButton("Back to Exercise Screen");
        backButton.addActionListener(e -> showExerciseScreen());

        // Add the Back button at the bottom of the panel
        panel.add(backButton, BorderLayout.SOUTH);

        // Set the panel as the content pane and make it visible
        frame.setContentPane(panel);
        frame.revalidate(); // Refresh the frame to show the new panel
        frame.repaint();
    }
}