package com.acme.mailreader.utils;

import java.util.Comparator;

import domaine.Mail;

/**
 * Comparateur de mails
 * 
 * Comme on désire afficher les mails les plus importants en premier, l'element le plus grand retourne une valeur négative
 *
 */
public class MailComparator implements Comparator<Mail> {
	
	public static final int mail1superieurAMail2 = -1;
	public static final int mail2superieurAMail1 = -1;
	public static final int importanceIdentique = 0;
	
	public int compare(Mail mail1, Mail mail2) {
		if (mail1 == null || mail2 == null) {
			return importanceIdentique;
		}
		if (mail1.isImportant() != mail2.isImportant()) {
			return this.getQuelMailEstImportant(mail1, mail2);
		}
		if (mail1.getStatut() != mail2.getStatut()) {
			return this.getQuelMailEstImportantParStatus(mail1,mail2);
		}
		if (mail1.getSujet() != mail2.getSujet()) {
			return mail2.getSujet().compareTo(mail1.getSujet());
		}
		return mail2.getDate().compareTo(mail1.getDate());
	}
	private int getQuelMailEstImportant(Mail mail1, Mail mail2) {
		if (mail1.isImportant() && !mail2.isImportant()) {
			return mail1superieurAMail2;
		} else {
			return mail2superieurAMail1;
		}
	}
	private int getQuelMailEstImportantParStatus(Mail mail1, Mail mail2) {
		int comp = mail1.getStatut().ordinal()
				- mail2.getStatut().ordinal();
		return comp > importanceIdentique ? mail1superieurAMail2: mail2superieurAMail1;
	}
}
