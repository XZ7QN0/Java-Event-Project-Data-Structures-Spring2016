package projectevents;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class EventWindow extends JFrame
{
    private UserFile m_file;
    private Event m_event;
    private datePanel m_datePanel;
    private addressPanel m_addressPanel;
    private descriptionPanel m_descriptionPanel;
    private JButton m_addButton;
    private JButton m_clearButton;
    private JButton m_closeButton;
    
    public static void main(String[] args)throws IOException
    {
        
        new EventWindow("jon2222.txt");
    }
    
    /**
     constructor
     */
    
    public EventWindow(String filename)throws IOException
    {
        //make the text file that user will add events to
        m_file = new UserFile(filename);
        
        //set the title
        setTitle("Event");
        
        //set the close operation
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //set the layout for the window
        setLayout(new FlowLayout());
        
        //make the date panel
        m_datePanel = new datePanel();
        
        //make the address panel
        m_addressPanel = new addressPanel();
        
        //make the description panel
        m_descriptionPanel = new descriptionPanel();
        
        //add all the panels to the window
        add(m_descriptionPanel);
        add(m_datePanel);
        add(m_addressPanel);
        
        //make a button
        m_addButton = new JButton("Add");
        m_clearButton = new JButton("Clear");
        m_closeButton = new JButton("Close");
        
        //add the loginListener to the loginButton
        m_addButton.addActionListener(new ButtonListener());
        m_clearButton.addActionListener(new ButtonListener());
        m_closeButton.addActionListener(new ButtonListener());
        
        //add the loginButton to the loginButtonPanel
        add(m_addButton);
        add(m_clearButton);
        add(m_closeButton);
        
        //set up where the window will pop up on the screen
        setLocationRelativeTo(null);
        
        //make the window visible
        setVisible(true);
        
        setSize(500, 200);  
    }
    
    /**
     closeWindow method
     */
    
    public void closeWindow()
    {
        this.dispose();
    }
    
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == m_addButton)
            {
                String title = m_descriptionPanel.getTitle();
                String description = m_descriptionPanel.getDescription();
                String city = m_addressPanel.getCity();
                String state = m_addressPanel.getState();
                String zip = m_addressPanel.getZip();
                String address = m_addressPanel.getAddress();
                int year = m_datePanel.getYear();
                int month = m_datePanel.getMonth();
                int day = m_datePanel.getDay();
                int hour = m_datePanel.getHour();
                int minute = m_datePanel.getMinute();
                
                m_event = new Event(year, month, day, hour, minute, title, description, address, city, zip, state);
                
                m_file.add(m_event);
            }
            
            if(e.getSource() == m_clearButton)
            {
                m_descriptionPanel.clearTitle();
                m_descriptionPanel.clearDescription();
                m_addressPanel.clearCity();
                m_addressPanel.clearState();
                m_addressPanel.clearZip();
                m_addressPanel.clearAddress();
                m_datePanel.clearYear();
                m_datePanel.clearMonth();
                m_datePanel.clearDay();
                m_datePanel.clearHour();
                m_datePanel.clearMinute();
            }
            
            if(e.getSource() == m_closeButton)
            {
                try
                {
                    m_file.print();
                }
                catch(IOException exception)
                {
                    System.out.println("Exception, can't print");
                }
                closeWindow();
            }
        }
    }
}