package projectevents;

import javax.swing.*;
import javax.swing.JPasswordField;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;



class LoginWindow extends JFrame
{
    private JPanel m_namePanel;
    private JPanel m_passwordPanel;
    private JPanel m_loginButtonPanel;
    private JTextField m_nameField;
    private JPasswordField m_passwordField;
    private JLabel m_nameLabel;
    private JLabel m_passwordLabel;
    private JButton m_loginButton;
    private String m_userName;
    private String m_password;
    private JOptionPane m_pane;
    private JPanel m_centerPanel;
    
    /**
     constructor
     */
    
    public LoginWindow()
    {
        //set the title of the window to "login"
        setTitle("Login");
        
        //allow the window to close when the user clicks the exit button
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //set up the layout for the loginWindow to have 3 rows and 1 column
        setLayout(new BorderLayout());
        
        //make the name panel
        makeNamePanel();
        
        //make the password panel
        makePasswordPanel();
        
        //make the loginButtonPanel
        makeLoginButtonPanel();
        
        //makeCenterPanel
        makeCenterPanel();
        
        //add all the panels to the middle of the loginWindow
        add(m_centerPanel, BorderLayout.CENTER);
        add(m_loginButtonPanel, BorderLayout.SOUTH);
        
        //set the size of the window
        setSize(200, 100);
        
        //set up where the window will pop up on the user's screen
        setLocationRelativeTo(null);
        
        //allow the window to be visible
        setVisible(true);
    }
    
    /**
     makeNamePanel method makes the panel that asks the user to enter his/her name
     */
    
    public void makeNamePanel()
    {
        //make the jpanel for the username portion of the login window
        m_namePanel = new JPanel();
        
        //set the layout of the namePanel to gridLayout with 1 row and 2 columns
        m_namePanel.setLayout(new GridLayout(1, 2));
        
        //create a label that properly labels the text field that will hold usernames
        m_nameLabel = new JLabel("username:", SwingConstants.CENTER);
        
        //initialize the nameField to allow users to type their names
        m_nameField = new JTextField();
        
        //allow the name field to be edited
        m_nameField.setEditable(true);
        
        //add the label and the text field to the namePanel
        m_namePanel.add(m_nameLabel);
        m_namePanel.add(m_nameField);
        
    }
    
    /**
     makePasswordPanel method makes the panel that asks the user for his/her password
     */
    
    public void makePasswordPanel()
    {
        //make the password jpanel
        m_passwordPanel = new JPanel();
        
        //set the layout of the passwordPanel to 1 row and 2 columns
        m_passwordPanel.setLayout(new GridLayout(1, 2));
        
        //make the password label that properly labels the textfield that holds passwords
        m_passwordLabel = new JLabel("Password:", SwingConstants.CENTER);
        
        
        //make the password field to hold passwords
        m_passwordField = new JPasswordField();
        
        //allows the passwordfield to be editable
        m_passwordField.setEditable(true);
        
        //add the passwordlabel and the password field to the passwordPanel
        m_passwordPanel.add(m_passwordLabel);
        m_passwordPanel.add(m_passwordField);
    }
    
    /**
     makeCenterPanel method adds the password panel and username panel to the centerPanel
     */
    
    public void makeCenterPanel()
    {
        m_centerPanel = new JPanel();
        
        m_centerPanel.setLayout(new GridLayout(2, 1));
        
        m_centerPanel.add(m_namePanel);
        m_centerPanel.add(m_passwordPanel);
        
    }
    
    /**
     makeLoginButtonPanel method makes the panel that holds the login button that the user clicks on
     */
    
    public void makeLoginButtonPanel()
    {
        //make the jpanel that will hold the login button
        m_loginButtonPanel = new JPanel();
        
        //set the layout to grid layout with 1 row and now columns
        m_loginButtonPanel.setLayout(new GridLayout(1, 0));
        
        //set the title of the login button
        m_loginButton = new JButton("Login");
        
        //add the loginListener to the loginButton
        m_loginButton.addActionListener(new loginListener());
        
        //add the loginButton to the loginButtonPanel
        m_loginButtonPanel.add(m_loginButton);
        
    }
    
    /**
     loginListener class allows the login button to work correctly
     */
    
    private class loginListener implements ActionListener
    {
        /**
         actionPerformed deals with the mouseClick on the login button appropriately
         */
        
        public void actionPerformed(ActionEvent event)
        {
            
    
            if(event.getSource() == m_loginButton)
            {
                //retrieve the text in the username and the password fields
                m_userName = m_nameField.getText();
                
                m_password = m_passwordField.getText();
                
                String filename = m_userName + m_password + ".txt";
                
                try
                {
                    makeFile(filename);
                    new EventWindow(filename);
                    
                }
                catch(IOException exception)
                {
                    m_pane.showMessageDialog(null, "Please enter a valid username and password");

                }                
            }            
        }
        
        /**
         makeFile method takes the username and makes a textFile entitled the username
         @param username
         */
        
        public void makeFile(String filename) throws IOException
        {
            Scanner myFile = new Scanner(new File(filename));
            
        }
    }
    
    /**
     main method
     */
    
    public static void main(String[] args)
    {
        LoginWindow myWindow = new LoginWindow();
    }
}