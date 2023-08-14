import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DayOfWeekServer {
    public static void main(String[] args) {
        try {
            DayOfWeekService dayOfWeekService = new DayOfWeekServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("DayOfWeekService", dayOfWeekService);
            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
