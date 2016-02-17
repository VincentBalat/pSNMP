package pSNMP1;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Agent {
	
	public void main() {
		Agentsimple a = null;
		try {
			a = new Agentsimple();
			// create the registry and bind the name and object.
			Registry registry = LocateRegistry.createRegistry(a.getPort());
			registry.rebind("Manager", a);
		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }

}
