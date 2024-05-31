import services.AuthService;
import services.GroupService;
import services.MessageService;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Main {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);

            MessageService messageSkeleton = new MessageService();
            AuthService authServicSkeleton = new AuthService();
            GroupService groupServiceSkeleton = new GroupService();
            Naming.rebind("rmi://localhost:1099/Message", messageSkeleton);
            Naming.rebind("rmi://localhost:1099/Auth", authServicSkeleton);
            Naming.rebind("rmi://localhost:1099/Group", groupServiceSkeleton);

            System.out.println("Serveur démarré");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
