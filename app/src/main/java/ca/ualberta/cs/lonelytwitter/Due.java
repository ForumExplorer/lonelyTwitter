package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;
/**
 * Created by mmooney on 9/28/16.
 */
public class Due {
    public Date Today;
    public ArrayList<Date> When;

    public Due(Date today, ArrayList<Date> when) {
        Today = today;
        When = when;
    }

    public void setToday(Date today) {
        Today = today;
    }

    public Date getToday() {
        return Today;
    }
}
