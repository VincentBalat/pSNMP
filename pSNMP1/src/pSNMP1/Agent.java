package pSNMP1;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Agent {
	
public static void main (String args[]) {
		
		try {
			LocateRegistry.createRegistry(1099);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Naming.bind("Manager", (Remote) new Agentsimple());
		} catch (MalformedURLException | RemoteException
				| AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
