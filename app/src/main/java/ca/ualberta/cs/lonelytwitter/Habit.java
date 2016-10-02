package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mmooney on 9/28/16.
 * This class is valled in order to create a habit. Each habit has description, 140 letters at max
 * a date it was created on. And a list of days that it is due to be completed on.
 */


    public class Habit {
        private String description;
        private Date date;
        private ArrayList<Due> due;


        public Habit(String description, Date date, Due due){
            this.description = description;
            this.date = date;
            this.due.add(due);
        }

        public void setDescription(String description) throws TweetTooLongException {
            if (description.length() > 140){
                //Do something! Do ANYTHING!
                throw new TweetTooLongException();
            }
            this.description = description;
        }


        public String getDescription() {
            return description;
        }
    }

}
