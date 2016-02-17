package pSNMP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Manager {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		InterRMI iRMI = null;
		BufferedReader fluxEntreeStandard = null;
		String req = null;
		Registry registry;
		boolean fin = false;
	    
	    fluxEntreeStandard = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Address:port = ");
		try {
			req = (String)fluxEntreeStandard.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String a [] = req.split(":");
		
		System.out.println("Address = "+a[0]+" port = "+a[1]);
		
	    // get the regis	try
	    registry=LocateRegistry.getRegistry(a[0],(new Integer(a[1])).intValue());
	    // look up the remote object
	    try {
	    	iRMI=(InterRMI)(registry.lookup("Manager"));
		} catch (NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
	    do{
			System.out.println("Tapez votre requete : ");

			try {
				req = fluxEntreeStandard.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
									  	  
			if (req.startsWith("GETNOM")){
			  		
				System.out.println("> "+iRMI.getNom());
					
			} else if (req.startsWith("GETADDR")){
				  		
			iRMI.getAdresse();
			System.out.println("> "+iRMI.getAdresse().toString());
			  		
			} else if (req.startsWith("FIN")){
				System.out.println("connexion terminée");
				fin = true;
			} else {
				System.out.println("Commande introuvable");
			}
	    } while (!fin);
	}
}