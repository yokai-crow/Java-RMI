import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DayOfWeekServiceImpl extends UnicastRemoteObject implements DayOfWeekService {
    protected DayOfWeekServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String getDayOfWeek(Date date) throws RemoteException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int dayOfWeekValue = calendar.get(Calendar.DAY_OF_WEEK);
        String dayName;

        switch (dayOfWeekValue) {
            case Calendar.SUNDAY:
                dayName = "Sunday";
                break;
            case Calendar.MONDAY:
                dayName = "Monday";
                break;
            case Calendar.TUESDAY:
                dayName = "Tuesday";
                break;
            case Calendar.WEDNESDAY:
                dayName = "Wednesday";
                break;
            case Calendar.THURSDAY:
                dayName = "Thursday";
                break;
            case Calendar.FRIDAY:
                dayName = "Friday";
                break;
            case Calendar.SATURDAY:
                dayName = "Saturday";
                break;
            default:
                dayName = "Unknown";
                break;
        }

        return dayName;
    }
}
