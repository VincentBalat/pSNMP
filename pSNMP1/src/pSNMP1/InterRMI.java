package pSNMP1;

import java.rmi.RemoteException;

public interface InterRMI extends java.rmi.Remote {
	
	Integer connect() throws RemoteException;
	
	void disconnect(int id) throws RemoteException;
	
	String getNom() throws RemoteException;

	String getAdresse() throws RemoteException;

}
