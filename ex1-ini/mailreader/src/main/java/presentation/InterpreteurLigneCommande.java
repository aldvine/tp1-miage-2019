package presentation;

import domaine.Mail;
import service.MailService;

// interpretation de la ligne de commande 
public class InterpreteurLigneCommande {
	private MailService mailService;
		public InterpreteurLigneCommande() {
			this.mailService = new MailService();
		}
		
		/**
		 * Parse les arguments de la ligne de commande
		 * @param args tableau d'arguments
		 */
		public void nouveauMail(String[] args){
			Boolean production = Boolean.parseBoolean(args[0]);
			String sujet = args[1];
			Mail mail = new Mail.Builder(sujet).build();
			if(production) {
				mailService.envoyerMail(mail);
			} else {
				System.out.println("Recette");
			}
		}
}
