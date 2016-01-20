package pSNMP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;


public class Manager {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		InterRMI iRMI = null;
		BufferedReader fluxEntreeStandard = null;
		String req = null;
	    
	    fluxEntreeStandard = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			iRMI = (InterRMI)Naming.lookup("rmi://localhost/Agent");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		do {
			System.out.println("Tapez votre requete : ");
			
			try {
				req = fluxEntreeStandard.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String s [] = req.split(" ");
		  	  
		  	if (req.startsWith("GETNOM")){
		  		
				System.out.println("> "+iRMI.getNom());
				
		  	} else if (req.startsWith("SETNOM")) {
		  		
		  		iRMI.setNom(s[1]);
		  		System.out.println("> Nouveau nom : "+iRMI.getNom());

		  	} else if (req.startsWith("GETADDR")){
		  		
		  		iRMI.getAdresse();
				System.out.println("> "+iRMI.getAdresse().toString());
		  		
		  	} else if (req.startsWith("SETADDR")){
		  		
		  		System.out.println("> Nouvelle adresse : "+iRMI.getAdresse().toString());
				
		  	} else {
		  		System.out.println("Commande introuvable");
		  	}
		} while (req.startsWith("FIN"));
	}

}