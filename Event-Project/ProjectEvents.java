package projectevents;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectEvents {
    public static void main(String[] args) {
        CalendarScanner myScanner = null;
        try {
            myScanner = new CalendarScanner("jon2222.txt");
        } catch (IOException ex) {
            Logger.getLogger(ProjectEvents.class.getName()).log(Level.SEVERE, null, ex);
        }
        Event myEvent = myScanner.getEvent();
        System.out.println(myEvent);
    }
}