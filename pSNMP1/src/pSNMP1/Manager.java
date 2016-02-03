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
		Integer id = 0;
	    
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
		
		try{
	           // get the �gregistry�h
	           registry=LocateRegistry.getRegistry(a[0],(new Integer(a[1])).intValue());
	           // look up the remote object
	           iRMI=(InterRMI)(registry.lookup("Manager"));
	           id = iRMI.connect();
	           if(id<0 || id>=20){
	        	   System.out.println("Full");
	           }
	           System.out.println("Identifiant de connexion : "+id);
	           
	           while (id<20 && id>=0) {
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
				  		iRMI.disconnect(id);
				  		id=-1;
				  	} else {
				  		System.out.println("Commande introuvable");
				  	}
				  	
				}
	       }
	       catch(RemoteException e){
	           e.printStackTrace();
	       }
	       catch(NotBoundException e){
	           e.printStackTrace();
	     }
		 
	}
}