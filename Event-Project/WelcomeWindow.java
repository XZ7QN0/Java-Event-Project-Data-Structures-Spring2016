package projectevents;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;


public class WelcomeWindow extends JFrame
{
    private JPanel m_loginButtonPanel;
    private JPanel m_registerButtonPanel;
    private JButton m_loginButton;
    private JButton m_registerButton;
    
    /**
     constructor
     */
    
    public WelcomeWindow()
    {
        setLayout(new GridLayout(1,2));
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setTitle("Welcome!");
        
        makeLoginButtonPanel();
        
        makeRegisterButtonPanel();
        
        add(m_loginButtonPanel);
        
        add(m_registerButtonPanel);
        
        setSize(250, 75);
        
        setLocationRelativeTo(null);
        
        setVisible(true);
    }
    
    /**
     makeLoginButtonPanel method makes the login button panel
     */
    
    public void makeLoginButtonPanel()
    {
        m_loginButtonPanel = new JPanel();
        
        m_loginButtonPanel.setLayout(new BorderLayout());
        
        m_loginButton = new JButton("Login");
        
        m_loginButton.addActionListener(new ButtonListener());
        
        m_loginButtonPanel.add(m_loginButton, BorderLayout.CENTER);
        
    }
    
    /**
     makeRegisterButton method makes the register button
     */
    
    public void makeRegisterButtonPanel()
    {
        m_registerButtonPanel = new JPanel();
        
        m_registerButtonPanel.setLayout(new BorderLayout());
        
        m_registerButton = new JButton("Register");
        
        m_registerButton.addActionListener(new ButtonListener());
        
        m_registerButtonPanel.add(m_registerButton, BorderLayout.CENTER);
    }
    
    /**
     main method
     */
    
    public static void main(String[] args)
    {
        new WelcomeWindow();
    }
    
    private class ButtonListener implements ActionListener
    {
        /**
         actionPerformed method deals with the mouse click on both of our buttons appropriately
         */
        
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == m_loginButton)
            {
                new LoginWindow();
            }
            if(event.getSource() == m_registerButton)
            {
                new RegisterWindow();
            }
        }
    }
}