package projectevents;

import java.awt.GridLayout;
import javax.swing.*;


public class descriptionPanel extends JPanel
{
    
    private JLabel titlelabel;
    private JLabel descriptionlabel;
    private JTextField titlefield;
    private JTextField descriptionfield;

    public descriptionPanel()
    {
        
        setLayout(new GridLayout(2,1));
        
        titlelabel = new JLabel("Title");
        descriptionlabel = new JLabel("Description");
        titlefield = new JTextField();
        titlefield.setEditable(true);
        descriptionfield = new JTextField();
        descriptionfield.setEditable(true);
        
        add(titlelabel);
        add(titlefield);
        add(descriptionlabel);
        add(descriptionfield);
    }
    
    /**
     getDescription method
     */
    
    public String getDescription()
    {
        return descriptionfield.getText();
        
    }
    
    /**
     getTitle method
     */
    
    public String getTitle()
    {
        return titlefield.getText();
    }
    
    /**
     setTitle method
     */
    
    public void clearTitle()
    {
        titlefield.setText("");
    }
    
    /**
     setDescription
     */
    
    public void clearDescription()
    {
        descriptionfield.setText("");
    }
    
        
}