package view;

import java.util.Calendar;
/**
 * This is the class of TimeManagement with some functions to work with it
 *
 * @author Yana Nestsiukovich
 */
public class TimeManagement {
    private static Calendar today;
    public static Calendar getToday(){
        return today;
    }
    public static void setToday(Calendar t){
        today = t;
    }
}
