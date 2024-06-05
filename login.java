
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame {
    // Constructor
    public login() {
        // Set the frame properties
        setTitle("Login System");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        // Create and add components to the panel
        JLabel userLabel = new JLabel("Username:");
        JTextField userText = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordText = new JPasswordField();
        JButton loginButton = new JButton("Login");

        panel.add(userLabel);
        panel.add(userText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(new JLabel()); // Empty cell
        panel.add(loginButton);

        // Add panel to the frame
        add(panel);

        // Event handling for the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                // Implement authentication logic here
                if (authenticate(username, password)) {
                    // JOptionPane.showMessageDialog(null, "Login successful");
                    JFrame frame = new JFrame("A Simple GUI");
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(500, 500);
                    frame.setLocation(430, 100);
                
                    JPanel panel = new JPanel();
                
                    frame.add(panel);
                
                    JLabel lbl = new JLabel("Select one of the possible choices and click OK");
                    lbl.setVisible(true);
                
                    panel.add(lbl);
                
                    String[] choices = {"NONE","CHOICE 1", "CHOICE 2", "CHOICE 3", "CHOICE 4", "CHOICE 5", "CHOICE 6"};

                    // Create and set up the main frame
                    JFrame mainFrame = new JFrame("Main GUI");
                    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    mainFrame.setSize(300, 200);
                    mainFrame.setLocation(400, 200);
            
                    // Create and add the JComboBox to the main frame
                    final JComboBox<String> cb = new JComboBox<>(choices);
                    mainFrame.add(cb);
                    mainFrame.setVisible(true);
            
                    // Add action listener to JComboBox
                    cb.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String selectedChoice = (String) cb.getSelectedItem();
                            if (selectedChoice.equals("NONE")) {
                                // Create and set up the new frame
                                
                            }
                        }
                    });
                
                    cb.setVisible(true);
                    panel.add(cb);
                
                    JButton btn = new JButton("OK");
                    panel.add(btn);

                    // Proceed to the next screen or functionality
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }
        });

        setVisible(true);
    }

    // Authentication method (stub)
    private boolean authenticate(String username, String password) {
        // This is where you'd implement your authentication logic
        // For demonstration, let's assume a fixed username and password
        return username.equals("admin") && password.equals("password");
    }

    public static void main(String[] args) {
        new login();
    }
}
