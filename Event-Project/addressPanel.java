package projectevents;

import javax.swing.*;
import java.awt.*;
import java.util.*;



public class addressPanel extends JPanel
{
	
    private JLabel m_addressLabel; //initiates a LABEL for ADDRESS
    private JLabel m_cityLabel; //initiates a LABEL for CITY
    private JLabel m_stateLabel; //initiates a LABEL for STATE
    private JLabel m_zipLabel; //initiates a LABEL for ZIP CODE
    private JTextField m_addressField; //initiates a TEXTFIELD
    private JTextField m_cityField; //initiates a TEXTFIELD
    private JTextField m_stateField; //initiates a TEXTFIELD
    private JTextField m_zipField; //initiates a TEXTFIELD
    
    
	/**
     constructor
	 */

	public addressPanel()
	{


		//sets up the layout for the Location to have 3 rows and 1 column
		setLayout(new GridLayout(4, 2));
        
        //make labels
        m_addressLabel = new JLabel("Address");
        m_cityLabel = new JLabel("City");
        m_stateLabel = new JLabel("State");
        m_zipLabel = new JLabel("Zip Code");
        
        //make text fields
        m_addressField = new JTextField();
        m_addressField.setEditable(true);
        m_cityField = new JTextField();
        m_cityField.setEditable(true);
        m_stateField = new JTextField();
        m_stateField.setEditable(true);
        m_zipField = new JTextField();
        m_zipField.setEditable(true);
        
        //add all components in order
        add(m_addressLabel);
        add(m_addressField);
        add(m_cityLabel);
        add(m_cityField);
        add(m_stateLabel);
        add(m_stateField);
        add(m_zipLabel);
        add(m_zipField);
        
        
		

		//sets the size of the window
		//setSize(400, 150);

		//sets up where the window will pop up on the user's screen
		//setLocationRelativeTo(null);

		//allows the window to be visible
		setVisible(true);
	}
    
    /**
     getcity method
     */
    
    public String getCity()
    {
        return m_cityField.getText();
    }
    
    /**
     getState method
     */
    
    public String getState()
    {
        return m_stateField.getText();
    }
    
    /**
     getAddress
     */
    
    public String getAddress()
    {
        return m_addressField.getText();
    }
    
    /**
     getZip
     */
    
    public String getZip()
    {
        return m_zipField.getText();
    }
    
    /**
     clearCity
     */
    
    public void clearCity()
    {
        m_cityField.setText("");
    }
    
    /**
     clearState
     */
    
    public void clearState()
    {
        m_stateField.setText("");
    }
    
    /**
     clearAddress
     */
    
    public void clearAddress()
    {
        m_addressField.setText("");
    }
    
    public void clearZip()
    {
        m_zipField.setText("");
    }

}





