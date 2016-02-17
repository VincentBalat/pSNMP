package SNMP;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class InstaMib {
	
	private String racine = null;
	private File f[] = new File[100];

	public InstaMib(String r) {
		super();
		racine = r;
	}

	public String getRacine() {
		return racine;
	}

	public static void main(String[] args) {
		
		String req = null;
		InstaMib IM = null;
		BufferedReader fluxEntreeStandard = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Veuillez entrer la racine de la MIB : ");
		
		try {
			IM = new InstaMib((String)fluxEntreeStandard.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File dir = new File (IM.getRacine()+"/MIB");
		if(dir.exists()){
			System.out.println("Il existe d�j� une MIB dans ce r�pertoire voulez vous l'�craser ? (o ou n)");
			try {
				req = (String)fluxEntreeStandard.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(req.equals("o")){
				dir.mkdirs();
				
				System.out.println("Op�ration effectu�e");
			} else {
				System.out.println("Op�ration annul�e");
			}
		}
		
	}
	
	

}
