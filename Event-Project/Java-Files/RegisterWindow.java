package projectevents;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.lang.String;


public class RegisterWindow extends JFrame
{
    private JPanel m_namePanel;
    private JLabel m_firstNameLabel;
    private JLabel m_lastNameLabel;
    private JTextField m_firstNameField;
    private JTextField m_lastNameField;
    private JPanel m_userPasswordPanel;
    private JLabel m_userNameLabel;
    private JLabel m_passwordLabel;
    private JTextField m_userNameField;
    private JPasswordField m_passwordField;
    private JPanel m_registerButtonPanel;
    private JButton m_registerButton;
    private JPanel m_centerPanel;
    private String m_password;
    private String m_userName;
    private JOptionPane m_pane;
    
    
    /**
     constructor
     */
    
    public RegisterWindow()
    {
        //set the title of the window to "login"
        setTitle("Register");
        
        //allow the window to close when the user clicks the exit button
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //set up the layout for the loginWindow to have 3 rows and 1 column
        setLayout(new BorderLayout());
        
        //make the name panel
        makeNamePanel();
        
        //make the password panel
        makeUserPasswordPanel();
        
        //make main panel
        makeCenterPanel();
        
        //make the registerButtonPanel
        makeRegisterButtonPanel();
        
        
        
        //add all the panels to the register Window
        add(m_centerPanel, BorderLayout.CENTER);
        add(m_registerButtonPanel, BorderLayout.SOUTH);
        
        //set the size of the window
        setSize(300, 150);
        
        //set up where the window will pop up on the user's screen
        setLocationRelativeTo(null);
        
        //allow the window to be visible
        setVisible(true);
    }
    
    /**
     makeNamePanel method makes the panel that asks the user to enter his/her first and last name
     */
    
    public void makeNamePanel()
    {
        //make the jpanel for the name portion of the register window
        m_namePanel = new JPanel();
        
        //set the layout of the namePanel to gridLayout with 1 row and 2 columns
        m_namePanel.setLayout(new GridLayout(2, 2));
        
        //create labels that properly labels the text field that will hold first and last names
        m_firstNameLabel = new JLabel("First Name:", SwingConstants.CENTER);
        m_lastNameLabel = new JLabel("Last Name:", SwingConstants.CENTER);
        
        //initialize the m_firstNameField and the m_lastNameField to allow users to type their names
        m_firstNameField = new JTextField();
        m_lastNameField = new JTextField();
        
        //allow the name field to be edited
        m_firstNameField.setEditable(true);
        m_lastNameField.setEditable(true);
        
        //add the label and the text field to the namePanel
        m_namePanel.add(m_firstNameLabel);
        m_namePanel.add(m_firstNameField);
        m_namePanel.add(m_lastNameLabel);
        m_namePanel.add(m_lastNameField);
        
        
    }
    
    /**
     makeUserPasswordPanel makes a panel that asks the user for their username and their password
     */
    
    public void makeUserPasswordPanel()
    {
        //make the password pannel
        m_userPasswordPanel = new JPanel();
        
        //set the layout of the password panel
        m_userPasswordPanel.setLayout(new GridLayout(2,2));
        
        //make the username label and the username field
        m_userNameLabel = new JLabel("username:", SwingConstants.CENTER);
        m_userNameField = new JTextField();
        m_userNameField.setEditable(true);
        
        //make the password field and the password label
        m_passwordLabel = new JLabel("Password:", SwingConstants.CENTER);
        m_passwordField = new JPasswordField();
        m_passwordField.setEditable(true);
        
        //add the components to the password panel
        m_userPasswordPanel.add(m_userNameLabel);
        m_userPasswordPanel.add(m_userNameField);
        m_userPasswordPanel.add(m_passwordLabel);
        m_userPasswordPanel.add(m_passwordField);
        
        
    }
    
    /**
     makeCenterPanel adds the name panel and the password to the center panel
     */
    
    public void makeCenterPanel()
    {
        m_centerPanel = new JPanel();
        
        m_centerPanel.setLayout(new GridLayout(2, 1));
        
        m_centerPanel.add(m_namePanel);
        
        m_centerPanel.add(m_userPasswordPanel);
    }
    
    /**
     makeRegisterButtonPanel method makes the panel that holds the register button that the user clicks on
     */
    
    public void makeRegisterButtonPanel()
    {
        //make the jpanel that will hold the login button
        m_registerButtonPanel = new JPanel();
        
        //set the layout to grid layout with 1 row and now columns
        m_registerButtonPanel.setLayout(new GridLayout(1, 0));
        
        //set the title of the login button
        m_registerButton = new JButton("Register");
        
        //add the loginListener to the loginButton
        m_registerButton.addActionListener(new RegisterListener());
        
        //add the loginButton to the loginButtonPanel
        m_registerButtonPanel.add(m_registerButton);
        
    }
    
    private class RegisterListener implements ActionListener
    {
        /**
         actionPerformed method
         */
        
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == m_registerButton)
            {
                m_userName = m_userNameField.getText();
                String fakePassword = getEncryptedPassword(m_passwordField);
                m_password = m_passwordField.getText();
                String filename = m_userName + m_password +".txt";
                try
                {
                    makeFile(filename);
                    m_pane = new JOptionPane();
                    m_pane.showMessageDialog(null, "Success!\nusername: " + m_userName + "\n" + "Password: " + fakePassword);
                }
                catch(IOException exception)
                {
                    m_pane.showMessageDialog(null, "Please enter a valid username and password");
                }
               
                
                
            }
            
        }
        
        /**
         makeFile method makes a text file that is entitled the username and password.txt
         */
        
        public void makeFile(String filename)throws IOException
        {
            
            FileWriter myFile = new FileWriter(filename, true);
            
        }
        
        /**
         getEncryptedPassword returns a string object of symbols instead of the actual password
         @param password    the user's password represented as a char array
         @return string     the string of symbols
         */
        
        public String getEncryptedPassword(JPasswordField password)
        {
            char[] symbols = password.getPassword();
            char star = '*';
            String newPassword = "";
            for(int count = 0; count < symbols.length; count++)
            {
                newPassword += String.valueOf(star);
            }
            
            return newPassword;
        }
    }

    
    /**
     main method
     */
    
    public static void main(String[] args)
    {
        new RegisterWindow();
    }

}