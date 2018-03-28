package projectevents;

import java.util.*;
import java.io.*;
import java.time.*;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;



public class Event implements Comparable
{
   
    private LocalDateTime m_event;
    private Month m_month;
    private int m_dayOfMonth;
    private int m_year;
    private int m_hourOfDay;
    private int m_minute;
    private Locale m_locale = Locale.getDefault();
    private DateTimeFormatter m_dateFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy h:mm a");
    private DecimalFormat m_minuteFormatter = new DecimalFormat("##");
    private String m_title;
    private String m_description;
    private String m_address;
    private String m_city;
    private String m_state;
    private String m_zipCode;
    
    /**
     constructor with EventDescription
     @param year
     @param month
     @param dayOfMonth
     @param hour
     @param minute
     @param description
     */
    
    public Event(int year, int month, int dayOfMonth, int hour, int minute, String title, String description, String address, String city, String zip, String state)throws DateTimeException
    {
        //title
        m_title = title;
        
        //description of event
        m_description = description;
        
        //address
        m_address = address;
        
        //city
        m_city = city;
        
        //state
        m_state = state;
        
        //zipCode
        m_zipCode = zip;

        
        //year
        m_year = year;
        
        //month
        m_month = Month.of(month);
        
        //dayOfMonth
        m_dayOfMonth = dayOfMonth;
        
        //hour of day
        m_hourOfDay = hour;
        
        //minute of day
        m_minute = minute;
        
        m_event = LocalDateTime.of(m_year, m_month, m_dayOfMonth, m_hourOfDay, m_minute);
        
        
      
    }
    
    public Event(int year, int month, int dayOfMonth, int hour, int minute)throws DateTimeException
    {

        this(year, month, dayOfMonth, hour, minute, null, null, null, null, null, null);
        
    }
    
    /**
     setTitle
     @param String  String representation of the description's title
     */
    
    public void setTitle(String title)
    {
        m_title = title;
    }
    
    /**
     getTitle
     @return String  String representation of the description's title
     */
    
    public String getTitle()
    {
        return m_title;
    }
    
    /**
     setDescription
     @param description
     */
    
    public void setDescription(String description)
    {
        m_description = description;
    }
    
    /**
     getDescription
     @return the event description
     */
    
    public String getDescription()
    {
        return m_description;
    }
    /**
     setAddress
     @param String  String representation of the description's address
     */
    
    public void setAddress(String address)
    {
        m_address = address;
    }
    
    /**
     getAddress
     @return String  String representation of the description's address
     */
    
    public String getAddress()
    {
        return m_address;
    }
    
    /**
     setCity
     @param String  String representation of the description's city
     */
    
    public void setCity(String city)
    {
        m_city = city;
    }
    
    /**
     getCity
     @return String  String representation of the description's city
     */
    
    public String getCity()
    {
        return m_city;
    }
    
    /**
     setZip
     @param String  String representation of the description's zip
     */
    
    public void setZip(String zip)
    {
        m_zipCode = zip;
    }
    
    /**
     getZip
     @return String  String representation of the description's zip
     */
    
    public String getZip()
    {
        return m_zipCode;
    }
    
    /**
     setState
     @param String  String representation of the description's state
     */
    
    public void setState(String state)
    {
        m_state = state;
    }
    
    /**
     getState
     @return String  String representation of the description's state
     */
    
    public String getState()
    {
        return m_state;
    }

    /**
     toString
     @return str    string that represents the event
     */
    
    public String toString()
    {
        String str = m_title + "\n" + m_description + "\n" + m_address + "\n" + m_city + ", " + m_state + " " + m_zipCode + "\n" + m_event.format(m_dateFormatter)+ "\n";
        return str;
    }
    
    /**
     setYear
     @param year    int representation the event's year field
     */
    
    public void setYear(int year)
    {
        m_year = year;
        m_event = m_event.withYear(m_year);
        
    }
    
    /**
     getYear
     @return int representation of the event's year field
     */
    
    public int getYear()
    {
        return m_event.getYear();
    }
    
    /**
     setMonth
     @param month   int representation of the event's month field
     */
    
    public void setMonth(int month)
    {
        m_month = Month.of(month);
        m_event = m_event.withMonth(m_month.getValue());
        
    }
    
    /**
     getMonth
     @return String representation of the event's month field
     */
    
    public String getMonth()
    {
        return m_event.getMonth().getDisplayName(TextStyle.FULL, m_locale);
    }
    
    /**
     setDayOfMonth
     @param dayOfMonth  int representation of the event's day of the month field
     */
    
    public void setDayOfMonth(int dayOfMonth)
    {
        m_dayOfMonth = dayOfMonth;
        m_event = m_event.withDayOfMonth(m_dayOfMonth);
    }
    
    /**
     getDayOfMonth
     @return int representation of the event's day of the month field
     */
    
    public int getDayOfMonth()
    {
        return m_event.getDayOfMonth();
    }
    
    /**
     setHour
     @param hour    int representation of the event's hour field
     */
    
    public void setHour(int hour)
    {
        m_hourOfDay = hour;
        m_event = m_event.withHour(m_hourOfDay);
    }
    
    /**
     getHour
     @return int representation of the event's hour field
     */
    
    public int getHour()
    {
        return m_event.getHour();
    }
    
    /**
     setMinute
     @param minute  int represenation of the event's minute field
     */
    
    public void setMinute(int minute)
    {
        int m_minute = minute;
        m_event = m_event.withMinute(m_minute);
    }
    
    /**
     getMinute
     @return int representation of the event's minute field
     */
    
    public int getMinute()
    {
        return m_event.getMinute();
    }
    
    /**
     getDayOfWeek
     @return String representation of the event's day of the week
     */
    
    public String getDayOfWeek()
    {
        DayOfWeek m_day = m_event.getDayOfWeek();
        return m_day.getDisplayName(TextStyle.FULL, m_locale);
    }
    
    @Override
    /**
     compareTo method
     compare the date alone to make the mehtod more simple
     */
    
    public int compareTo(Object event)
    {
        /**
        Event e = (Event)event;
        if(this.getTitle().equals(e.getTitle()) && this.getAddress().equals(e.getAddress()) && this.getCity().equals(e.getCity()) && this.getState().equals(e.getState()) && this.getZip().equals(e.getZip()) && this.getYear() == e.getYear() && this.getMonth().equals(e.getMonth()) && this.getDayOfMonth() == e.getDayOfMonth() && this.getHour() == e.getHour() && this.getMinute() == e.getMinute())
            return 0;
         */
         Event e = (Event)event;
        if((this.getYear() == e.getYear() && this.getMonth().equals(e.getMonth()) && this.getDayOfMonth() == e.getDayOfMonth()))
           return 0;
        else
            return -1;
        
    }
    @Override
    /**
     equals method
     */
    
    public boolean equals(Object e)
    {
        
        return this.compareTo(e) == 0;
    }


    
    

    public static void main(String args[])
    {
        
         
        Event myEvent = new Event(2016, 2, 28, 15, 30, "My Birthday", "The best day of my life", "2018 Foxworthy Ave.", "San Jose", "95124", "California");
        System.out.println(myEvent);
        System.out.println("Year: " + myEvent.getYear());
        System.out.println("Month: " + myEvent.getMonth());
        System.out.println("Day: " + myEvent.getDayOfMonth());
        System.out.println("Day of Week: " + myEvent.getDayOfWeek());
        System.out.println("Hour: " + myEvent.getHour());
        System.out.println("Minute: " + myEvent.getMinute());
        System.out.println("City: " + myEvent.getCity());
        
        System.out.println("Setting Year to 2015.");
        myEvent.setYear(2015);
        System.out.println("Setting Month to June.");
        myEvent.setMonth(6);
        System.out.println("Setting the date to the 30th.");
        myEvent.setDayOfMonth(30);
        System.out.println("Setting the hour to 12");
        myEvent.setHour(12);
        System.out.println("Setting the minute to 0");
        myEvent.setMinute(0);
        System.out.println(myEvent);
         
        
    }
    
}
