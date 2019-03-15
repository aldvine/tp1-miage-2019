package service;

import domaine.Mail;
import infrastructure.MailSender;

// vérifier le mail et envoyer au mailSender

public class MailService {
	private MailSender mailSender;
	public MailService() {
		this.mailSender = new MailSender();
	}
	/**
	 * @param mail Mail à envoyer
	 */
	public void envoyerMail(Mail mail){
		mailSender.envoyerMail();
	}
}
