package pSNMP1;

import java.rmi.RemoteException;

public interface InterRMI extends java.rmi.Remote {
	
	String getNom() throws RemoteException;

	void setNom(String nom) throws RemoteException;

	String getAdresse() throws RemoteException;

	void setAdresse(String adresse) throws RemoteException;

}
