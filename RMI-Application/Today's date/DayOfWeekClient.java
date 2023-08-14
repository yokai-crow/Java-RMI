import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

public class DayOfWeekClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            DayOfWeekService dayOfWeekService = (DayOfWeekService) registry.lookup("DayOfWeekService");

            Date today = new Date();
            String dayOfWeek = dayOfWeekService.getDayOfWeek(today);
            System.out.println("Today is " + dayOfWeek);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
