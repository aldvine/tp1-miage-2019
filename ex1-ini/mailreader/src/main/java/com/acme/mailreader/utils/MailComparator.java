package com.acme.mailreader.utils;

import java.util.Comparator;

import com.acme.mailreader.model.Mail;

/**
 * Comparateur de mails
 * 
 * Comme on désire afficher les mails les plus importants en premier, l'element le plus grand retourne une valeur négative
 *
 */
public class MailComparator implements Comparator<Mail> {
	private int mail1superieurAMail2 = -1;
	private int mail2superieurAMail1 = -1;
	private int importanceIdentique = 0;
	public int compare(Mail mail1, Mail mail2) {
		if (mail1 == null || mail2 == null) {
			return this.importanceIdentique;
		}
		if (mail1.isImportant() != mail2.isImportant()) {
			return this.getWhichMailIsImportant(mail1, mail2);
		}
		if (mail1.getStatut() != mail2.getStatut()) {
			return this.getWhichMailIsImportantByStatus(mail1,mail2);
		}
		if (mail1.getSujet() != mail2.getSujet()) {
			return mail2.getSujet().compareTo(mail1.getSujet());
		}
		return mail2.getDate().compareTo(mail1.getDate());
	}
	private int getWhichMailIsImportant(Mail mail1, Mail mail2) {
		if (mail1.isImportant() && !mail2.isImportant()) {
			return this.mail1superieurAMail2;
		} else {
			return this.mail2superieurAMail1;
		}
	}
	private int getWhichMailIsImportantByStatus(Mail mail1, Mail mail2) {
		int comp = mail1.getStatut().ordinal()
				- mail2.getStatut().ordinal();
		return comp > this.importanceIdentique ? this.mail1superieurAMail2: this.mail2superieurAMail1;
	}
}
