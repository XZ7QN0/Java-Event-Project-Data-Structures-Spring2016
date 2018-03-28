package projectevents;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class datePanel extends JPanel {
    private JPanel monthPanel;
    private JPanel dayPanel;
    private JPanel yearPanel;
    private JPanel hourPanel;
    private JPanel minutePanel;
    private JPanel createDatePanel;
    
    private JTextField monthField;
    private JTextField dayField;
    private JTextField yearField;
    private JTextField hourField;
    private JTextField minuteField;
    
    private JLabel monthLabel;
    private JLabel dayLabel;
    private JLabel yearLabel;
    private JLabel hourLabel;
    private JLabel minuteLabel;
    
    private JButton createDateButton;
    
    private JOptionPane pane;
    
    private String month, day, year, hour, minute;
    
    public datePanel()
    {
        
        setLayout(new GridLayout(5, 2));
        
        monthPanel();
        dayPanel();
        yearPanel();
        hourPanel();
        minutePanel();
        
        
        add(monthPanel);
        add(dayPanel);
        add(yearPanel);
        add(hourPanel);
        add(minutePanel);
        
        
        setVisible(true);
    }
    
    public void monthPanel()
    {
        monthPanel = new JPanel();
        monthPanel.setLayout(new GridLayout(1, 2));
        
        monthLabel = new JLabel("Month:");
        monthField = new JTextField();
        monthField.setEditable(true);
        
        monthPanel.add(monthLabel);
        monthPanel.add(monthField);
    }
    
    public void dayPanel()
    {
        dayPanel = new JPanel();
        dayPanel.setLayout(new GridLayout(1, 2));
        
        dayLabel = new JLabel("Day:");
        dayField = new JTextField();
        dayField.setEditable(true);
        
        dayPanel.add(dayLabel);
        dayPanel.add(dayField);
    }
    
    public void yearPanel()
    {
        yearPanel = new JPanel();
        yearPanel.setLayout(new GridLayout(1, 2));
        
        yearLabel = new JLabel("Year:");
        yearField = new JTextField();
        yearField.setEditable(true);
        
        yearPanel.add(yearLabel);
        yearPanel.add(yearField);
    }
    
    public void hourPanel()
    {
        hourPanel = new JPanel();
        hourPanel.setLayout(new GridLayout(1, 2));
        
        hourLabel = new JLabel("Hour:");
        hourField = new JTextField();
        hourField.setEditable(true);
        
        hourPanel.add(hourLabel);
        hourPanel.add(hourField);
    }
    
    public void minutePanel()
    {
        minutePanel = new JPanel();
        minutePanel.setLayout(new GridLayout(1, 2));
        
        minuteLabel = new JLabel("Minute:");
        minuteField = new JTextField();
        minuteField.setEditable(true);
        
        minutePanel.add(minuteLabel);
        minutePanel.add(minuteField);
    }
    /**
     getMonth method
     */
    
    public int getMonth()
    {
        String month = monthField.getText();
        month = month.trim();
        int numMonth = Integer.parseInt(month);
        return numMonth;
    }
    
    /**
     getDay method
     */
    
    public int getDay()
    {
        String day = dayField.getText();
        day = day.trim();
        int numDay = Integer.parseInt(day);
        return numDay;
        
        
    }
    
    /**
     getYear method
     */
    
    public int getYear()
    {
        String year = yearField.getText();
        year = year.trim();
        int numYear = Integer.parseInt(year);
        return numYear;
    }
    
    /**
     getHour
     */
    
    public int getHour()
    {
        String hour = hourField.getText();
        hour = hour.trim();
        int numHour = Integer.parseInt(hour);
        return numHour;
    }
    
    /**
     getMinute
     */
    
    public int getMinute()
    {
        String minute = minuteField.getText();
        minute = minute.trim();
        int numMinute = Integer.parseInt(minute);
        return numMinute;
    }
    
    /**
     clearMonth
     */
    
    public void clearMonth()
    {
        monthField.setText("");
    }
    
    /**
     clearYear method
     */
    
    public void clearYear()
    {
        yearField.setText("");
    }
    
    /**
     clearDay
     */
    
    public void clearDay()
    {
        dayField.setText("");
    }
    
    /**
     clear hour
     */
    
    public void clearHour()
    {
        hourField.setText("");
    }
    
    /**
     clearMinute
     */
    
    public void clearMinute()
    {
        minuteField.setText("");
    }
     
    
    
}
