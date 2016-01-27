package pSNMP1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Agentsimple extends UnicastRemoteObject implements InterRMI {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Agentsimple() throws RemoteException {
		try{
			// get the address of this host.
			address= (InetAddress.getLocalHost()).toString();
		} catch(Exception e){
			throw new RemoteException("can't get inet address.");
		}

		port=3232;  // this port(registry�fs port)

		System.out.println("this address="+address+",port="+port);

		try{
			// create the registry and bind the name and object.
			registry = LocateRegistry.createRegistry( port );
			registry.rebind("rmiServer", this);
		} catch(RemoteException e){
			throw e;

		}
	    
	}

	private String name;
	private String address;
	private int port;
	private Registry registry;

	public String getNom() {
		try {
			name = new String(InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}

	public void setNom(String nom) {
		this.name = nom;
	}

	public String getAdresse() {
		try {
			address = (InetAddress.getLocalHost()).toString();
		}
		catch(UnknownHostException e) {
			e.printStackTrace();
		}
		return address;
	}

	public void setAdresse(String address) {		//Modifier l'adresse 
		this.address = address;
	}
	
	public static void main(String[] args) throws RemoteException { 
		try{
        	Agentsimple a=new Agentsimple();
        } catch (Exception e) {
        	e.printStackTrace();
        	System.exit(1);
        }
	}

}