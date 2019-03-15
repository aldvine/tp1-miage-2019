package presentation;

// récuperation des arguments 
public class ClientMail {

	
	private static boolean production;

	public static void main(String[] args) {
		   InterpreteurLigneCommande interpreteurLigneCommande = new InterpreteurLigneCommande();
		   interpreteurLigneCommande.nouveauMail(args);
	}		
}
