import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class CalendarTest {
     public static void main(String[] args) {
          Date aDate = null;
          Calendar aCalendar = Calendar.getInstance();
          aCalendar.setTimeInMillis(1450000000000L);
          aDate = aCalendar.getTime();
          System.out.println(new SimpleDateFormat("dd-MMM-yyyy").format(aDate));
          aCalendar.add(Calendar.DAY_OF_MONTH, 60);
          aDate = aCalendar.getTime();
          System.out.println(new SimpleDateFormat("dd-MMM-yyyy").format(aDate));
     }
}