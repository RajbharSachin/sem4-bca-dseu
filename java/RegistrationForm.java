import java.awt.*;
import java.awt.event.*;

public class RegistrationForm extends Frame {
    // Label components
    private Label nameLabel;
    private Label rollNoLabel;
    private Label genderLabel;
    private Label subjectLabel;
    private Label collegeLabel;
    private Label remarksLabel;

    // Text field components
    private TextField nameField;
    private TextField rollNoField;

    // Checkbox component for gender
    private CheckboxGroup genderGroup;
    private Checkbox maleCheckbox;
    private Checkbox femaleCheckbox;
    private Checkbox otherCheckbox;

    // Choice component for subject
    private Choice subjectChoice;

    // List component for colleges
    private List collegeList;

    // Text area component for remarks
    private TextArea remarksArea;

    // Button component
    private Button submitButton;

    public RegistrationForm() {
        // Set the layout
        setLayout(new GridBagLayout());

        // Create labels
        nameLabel = new Label("Name:");
        rollNoLabel = new Label("Roll No.:");
        genderLabel = new Label("Gender:");
        subjectLabel = new Label("Subject Choice:");
        collegeLabel = new Label("Colleges:");
        remarksLabel = new Label("Remarks:");

        // Create text fields
        nameField = new TextField(20);
        rollNoField = new TextField(10);

        // Create checkboxes for gender
        genderGroup = new CheckboxGroup();
        maleCheckbox = new Checkbox("Male", genderGroup, true);
        femaleCheckbox = new Checkbox("Female", genderGroup, false);
        otherCheckbox = new Checkbox("Other", genderGroup, false);

        // Create choice for subject
        subjectChoice = new Choice();
        subjectChoice.add("Mathematics");
        subjectChoice.add("Science");
        subjectChoice.add("History");
        subjectChoice.add("English");
        subjectChoice.add("Computer Science");

        // Create list for colleges
        collegeList = new List(3);
        collegeList.add("ABC College");
        collegeList.add("XYZ College");
        collegeList.add("PQR College");

        // Create text area for remarks
        remarksArea = new TextArea(5, 20);

        // Create submit button
        submitButton = new Button("Submit");

        // Add components to the frame using GridBagLayout
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);

        // Add name components
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(nameLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        add(nameField, constraints);

        // Add roll no components
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(rollNoLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        add(rollNoField, constraints);

        // Add gender components
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(genderLabel, constraints);

        Panel genderPanel = new Panel();
        genderPanel.add(maleCheckbox);
        genderPanel.add(femaleCheckbox);
        genderPanel.add(otherCheckbox);
        constraints.gridx = 1;
        constraints.gridy = 2;
        add(genderPanel, constraints);

        // Add subject choice components
        constraints.gridx = 0;
        constraints.gridy = 3;
        add(subjectLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        add(subjectChoice, constraints);

        // Add college components
        constraints.gridx = 0;
        constraints.gridy = 4;
        add(collegeLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;
        add(collegeList, constraints);

        // Add remarks components
        constraints.gridx = 0;
        constraints.gridy = 5;
        add(remarksLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 5;
        add(remarksArea, constraints);

        // Add submit button
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        add(submitButton, constraints);

        // Add action listener to the button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Retrieve input values
                String name = nameField.getText();
                String rollNo = rollNoField.getText();
                String gender = genderGroup.getSelectedCheckbox().getLabel();
                String subject = subjectChoice.getSelectedItem();
                String college = collegeList.getSelectedItem();
                String remarks = remarksArea.getText();

                // TODO: Perform registration logic with the input values

                // Clear fields after submission
                nameField.setText("");
                rollNoField.setText("");
                genderGroup.setSelectedCheckbox(maleCheckbox);
                subjectChoice.select(0);
                collegeList.select(0);
                remarksArea.setText("");
            }
        });

        // Set frame properties
        setTitle("Registration Form");
        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}
