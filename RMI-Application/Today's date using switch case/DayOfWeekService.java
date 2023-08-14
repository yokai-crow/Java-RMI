import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface DayOfWeekService extends Remote {
    String getDayOfWeek(Date date) throws RemoteException;
}
