package pSNMP1;

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
	private int port = 3232;
	private boolean connectid[] = new boolean[20];
	private boolean freeid[] = new boolean[20];
	private int nbco = 0;

	public Agentsimple() throws RemoteException {
		try{
			// get the address of this host.
			ia = InetAddress.getLocalHost();
		} catch(Exception e){
			throw new RemoteException("can't get inet address.");
		}

		System.out.println("name="+ia.getHostName()+", address="+ia.getHostAddress()+", port="+port);
		
		//Initialisation des connexions
		for(int i=0;i<20;i++){
			connectid[i]=false;
			freeid[i]=true;
		}
	    
	}
	
	public Integer connect(){
		int i = -1;
		do {
			i++;
			if(i==19){
				return -1;
			}
		} while(freeid[i]==false);
		freeid[i]=true;
		connectid[i]=false;
		nbco++;
		return i;
	}
	
	public void disconnect(int id){
		freeid[id]=true;
		connectid[id]=false;
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

	public int getNbco() {
		return nbco;
	}

}