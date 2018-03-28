package projectevents;

import java.io.*;
import java.util.*;



public class UserFile extends FileWriter
{
    private String m_fileName;
    private BagInterface<Event> m_eventBag;
    private PrintWriter m_writer;
    private CalendarScanner m_reader;
    
    /**
     constructor
     */
    
    public UserFile(String fileName)throws IOException
    {
        super(fileName, true);
        
        m_reader = new CalendarScanner(fileName);
        
        m_writer = new PrintWriter(this);
        
        m_eventBag = new ArrayBag<Event>();
    }
    
    /**
     add method
     */
    
    public boolean add(Event e)
    {
        return m_eventBag.add(e);
    }
    
    /**
     remove method
     @return event
     */
    
    public Event remove()
    {
        return m_eventBag.remove();
    }
    
    /**
     remove a specific event
     @return boolean
     */
    
    public boolean remove(Event e)
    {
        return m_eventBag.remove(e);
    }
    
    /**
     getNumberOfEvents
     @return int number of events on the calander
     */
    
    public int getNumberOfEvents()
    {
        return m_eventBag.getCurrentSize();
    }
    
    /**
     isEmpty method
     @return boolean
     */
    
    public boolean isEmpty()
    {
        return m_eventBag.isEmpty();
    }
    
    /**
     isFull method
     @return boolean
     */
    
    public boolean isFull()
    {
        return m_eventBag.isFull();
    }
    
    /**
     clear method
     */
    
    public void clear()
    {
        m_eventBag.clear();
    }
    
    /**
     getFrequencyOf
     @return int
     */
    
    public int getFrequencyOf(Event e)
    {
        return m_eventBag.getFrequencyOf(e);
    }
    
    /**
     contains method checks to see if a given event is in the file
     @return boolean
     */
    
    public boolean contains(Event e)
    {
        return m_eventBag.contains(e);
    }
    
    
    /**
     toArray method returns an array of events
     @return Event[]
     */
    
    public Object[] toArray()
    {
        Object[] arr = m_eventBag.toArray();
        return arr;
    }
    
    /**
     print method
     */
    
    public void print(Event e)throws IOException
    {
        m_writer.print(e.toString());
        this.close();
    }
    
    
    
    /**
     print
     */
    

    public void print()throws IOException
    {
        
        Object[] arr = toArray();
        
        for(int count = 0; count < arr.length; count++)
        {
            m_writer.print(arr[count]);
        }
        this.close();
        
    }
    
    /**
     readFile method
     */
    
    public void readFile()
    {
        while(m_reader.hasNextLine())
        {
            Event newEvent = m_reader.getEvent();
            add(newEvent);
        }
    }
    
    
    public static void main(String[] args)throws IOException
    {
        
        System.out.println("This Program Tests All Methods In The UserFile Class");
        
        
        Event myEvent1 = new Event(2016, 2, 28, 15, 30, "My Birthday", "The Best Day of my life", "2018 Foxworthy Ave.", "San Jose", "95124", "California");
        
        Event myEvent2 = new Event(2000, 12, 28, 18, 30, "Vacation", "I can't wait", "1212 Beach Avenue", "Honolulu", "9495", "Hawaii");
        
        Event myEvent3 = new Event(2000, 6, 14, 19, 00, "Basketball Game", "Let's ball", "30 Oracle Arena Drive", "Oakland", "9854", "California");
        
        UserFile myFile = new UserFile("jon2222.txt");
        
        myFile.readFile();
        
        Object[] arr = myFile.toArray();
        
        for(int count = 0; count < arr.length; count++)
        {
          System.out.println(arr[count]);
        }   
    }
}