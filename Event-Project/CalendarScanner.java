package projectevents;

import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.*;
import java.time.*;


public class CalendarScanner
{
    private File m_file;
    private Scanner m_fileScanner;
    
    public static void main(String[] args)throws IOException, DateTimeException
    {
        CalendarScanner myScanner = new CalendarScanner("date.txt");
        Event myEvent = myScanner.getEvent();
        System.out.println(myEvent);
    }
        
    
    public CalendarScanner(String filename)throws IOException
    {
        m_file = new File(filename);
        m_fileScanner = new Scanner(m_file);
    }
    /**
     traverseDate
     */
    
    private String[] traverseLine(String line)
    {
        StringTokenizer myTokenizer = new StringTokenizer(line, ",: ");
        String[] arr = new String[myTokenizer.countTokens()];
        for(int count = 0; count < arr.length; count++)
        {
            arr[count] = myTokenizer.nextToken();
        }
        
        return arr;
    }
    
    /**
     getEvent method
     */
    
    public Event getEvent()throws DateTimeException
    {
        String title = getTitle();
        String description = getDescription();
        String address = getAddress();
        String location = getLocation();
        String city = getCity(location);
        String state = getState(location);
        String zip = getZip(location);
        String date = getDate();
        String dayOfWeek = getDayOfWeek(date);
        int month = getMonthOfYear(date);
        int day = getDayOfMonth(date);
        int year = getYear(date);
        int hour = getHour(date);
        int minute = getMinute(date);
        String AmPm = getAmPm(date);

        
        Event myEvent = new Event(year, month, day, hour, minute, title, description, address, city, zip, state);
        
        return myEvent;
        
    }
    
    /**
     getDescription method
     */
    
    public String getDescription()
    {
        String description = m_fileScanner.nextLine();
        return description;
    }
    
    /**
     getTitle method
     */
    
    public String getTitle()
    {
        String title = m_fileScanner.nextLine();
        return title;
    }
    
    /**
     getAddress method
     */
    
    public String getAddress()
    {
        String address = m_fileScanner.nextLine();
        
        return address;
    }
    
    /**
     get
    
    /**
     getDate method
     */
    
    public String getDate()
    {
        String date = m_fileScanner.nextLine();
        
        return date;
        
    }
    
    /**
     getLocation method
     */
    
    public String getLocation()
    {
        String location = m_fileScanner.nextLine();
        return location;
    }
    
    /**
     getCity method
     */
    
    public String getCity(String location)
    {
        String [] arr = traverseLine(location);
        String  city = arr[0];
        return city;
        
    }
    
    /**
     getState method
     */
    
    public String getState(String location)
    {
        String [] arr = traverseLine(location);
        String state = arr[1];
        return state;
    }
    
    /**
     getZip method
     */
    
    public String getZip(String location)
    {
        String[] arr = traverseLine(location);
        String zip = arr[2];
        return zip;
    }
    
   
    
    /**
     getDayOfWeek method
     */
    
    public String getDayOfWeek(String date)
    {
        String[] arr = traverseLine(date);
        String dayOfWeek = arr[0];
        return dayOfWeek;
        
    }
    
    /**
     getMonthOfYear method
     */
    
    public int getMonthOfYear(String date)
    {
        String[] arr = traverseLine(date);
        String monthOfYear = arr[1];
        int month;
        switch(monthOfYear)
        {
            case "January":
                month = 1;
                break;
            case "February":
                month = 2;
                break;
            case "March":
                month = 3;
                break;
            case "April":
                month = 4;
                break;
            case "May":
                month = 5;
                break;
            case "June":
                month = 6;
                break;
            case "July":
                month = 7;
                break;
            case "August":
                month = 8;
                break;
            case "September":
                month = 9;
                break;
            case "October":
                month = 10;
                break;
            case "November":
                month = 11;
                break;
            case "December":
                month = 12;
                break;
            default:
                month = -1;
                
        }
        return month;
        
    }
    
    /**
     getDayOfMonth method
     */
    
    public int getDayOfMonth(String date)
    {
        String[] arr = traverseLine(date);
        String dayOfMonth = arr[2];
        int numDayOfMonth = Integer.parseInt(dayOfMonth);
        return numDayOfMonth;
        
    }
    
    /**
     getYear method
     */
    
    public int getYear(String date)
    {
        String[] arr = traverseLine(date);
        String year = arr[3];
        int numYear = Integer.parseInt(year);
        return numYear;
    }
    
    /**
     getHour method
     */
    
    public int getHour(String date)
    {
        String[] arr = traverseLine(date);
        String hour = arr[4];
        int numHour = Integer.parseInt(hour);
        return numHour;
    }
    
    /**
     getMinute method
     */
    
    public int getMinute(String date)
    {
        String[] arr = traverseLine(date);
        String minute = arr[5];
        int numMinute = Integer.parseInt(minute);
        return numMinute;
        
    }
    
    /**
     getAmPm method
     */
    
    public String getAmPm(String date)
    {
        String[] arr = traverseLine(date);
        String amPM = arr[6];
        return amPM;
    }
    
    /**
     hasNextLine method
     */
    
    public boolean hasNextLine()
    {
        return m_fileScanner.hasNextLine();
    }
}