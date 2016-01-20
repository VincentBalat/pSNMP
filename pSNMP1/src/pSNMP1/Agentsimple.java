package pSNMP1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

public class Agentsimple {
	
	public Agentsimple() {
		super();
		this.adresse = getAdresse();
		String hostName = null;
	    
	}

	private String nom;
	
	private InetAddress adresse;

	public String getNom() {
		nom = new String(getAdresse().getHostName());
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public InetAddress getAdresse() {
		try {
			adresse = InetAddress.getLocalHost();
		}
		catch(UnknownHostException e) {
			e.printStackTrace();
		}
		return adresse;
	}

	public void setAdresse(InetAddress adresse) {
		this.adresse = adresse;
	}
	
	/*public static void main(String[] args) throws RemoteException { 
		BanqueSimple s = new BanqueSimple(); s.creerCompte("ABC1234", 1000); s.ajouter("ABC1234", 100); s.retirer("ABC1234", 30);
	
		double solde = s.getSolde("ABC1234");
		
		Date date = s.getDerniereOperation("ABC1234"); System.out.println("ABC1234 -> " + solde + " " + date);
		
	}*/

}