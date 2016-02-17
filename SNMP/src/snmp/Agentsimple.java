package SNMP;

import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Agentsimple extends UnicastRemoteObject implements InterRMI {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InetAddress ia;
	private int port = 3233;

	public Agentsimple() throws RemoteException {
		try{
			// get the address of this host.
			ia = InetAddress.getLocalHost();
		} catch(Exception e){
			throw new RemoteException("can't get inet address.");
		}

		System.out.println("name="+ia.getHostName()+", address="+ia.getHostAddress()+", port="+port);
	    
	}
	
	public String getNom() {
		return ia.getHostName();
	}

	public String getAdresse() {
		return ia.getHostAddress();
	}

	public int getPort() {
		return port;
	}
	
	public static void main(String[] args) throws RemoteException {
		Agentsimple a = new Agentsimple();
		try {
			// create the registry and bind the name and object.
			Registry registry = LocateRegistry.createRegistry(a.getPort());
			registry.rebind("Manager", a);
		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}