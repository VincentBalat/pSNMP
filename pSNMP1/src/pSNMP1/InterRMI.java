package pSNMP1;

import java.net.InetAddress;
import java.rmi.RemoteException;

public interface InterRMI extends java.rmi.Remote {
	
	String getNom() throws RemoteException;

	void setNom(String nom) throws RemoteException;

	InetAddress getAdresse() throws RemoteException;

	void setAdresse(String adresse) throws RemoteException;

}
