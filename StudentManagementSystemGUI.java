import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManagementSystemGUI extends JFrame {
    private StudentManagementSystem system;

    public StudentManagementSystemGUI() {
        system = new StudentManagementSystem();
        setTitle("Student Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        addButton("Add Student", e -> addStudent());
        addButton("Remove Student", e -> removeStudent());
        addButton("Search Student", e -> searchStudent());
        addButton("Display All Students", e -> displayStudents());
        addButton("Exit", e -> dispose());

        setVisible(true);
    }

    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        add(button);
    }

    private void addStudent() {
        String name = getInput("Enter student name:");
        if (name != null && !name.isEmpty()) {
            int rollNumber = getIntInput("Enter student roll number:");
            String grade = getInput("Enter student grade:");
            system.addStudent(new Student(name, rollNumber, grade));
            showMessage("Student added successfully.");
        } else {
            showMessage("Name cannot be empty.");
        }
    }

    private void removeStudent() {
        int rollNumber = getIntInput("Enter roll number of student to remove:");
        system.removeStudent(rollNumber);
        showMessage("Student removed successfully.");
    }

    private void searchStudent() {
        int rollNumber = getIntInput("Enter roll number of student to search:");
        Student foundStudent = system.searchStudent(rollNumber);
        if (foundStudent != null) {
            showMessage("Student found:\n" + foundStudent);
        } else {
            showMessage("Student not found.");
        }
    }

    private void displayStudents() {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(300, 200));

        StringBuilder sb = new StringBuilder();
        for (Student student : system.getStudents()) {
            sb.append(student).append("\n");
        }
        textArea.setText(sb.length() > 0 ? sb.toString() : "No students found.");

        showMessage(scrollPane);
    }

    private String getInput(String message) {
        return JOptionPane.showInputDialog(this, message);
    }

    private int getIntInput(String message) {
        return Integer.parseInt(getInput(message));
    }

    private void showMessage(Object message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentManagementSystemGUI::new);
    }
}
