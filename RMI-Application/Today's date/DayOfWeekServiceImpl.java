import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DayOfWeekServiceImpl extends UnicastRemoteObject implements DayOfWeekService {
    protected DayOfWeekServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String getDayOfWeek(Date date) throws RemoteException {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        return sdf.format(date);
    }
}
