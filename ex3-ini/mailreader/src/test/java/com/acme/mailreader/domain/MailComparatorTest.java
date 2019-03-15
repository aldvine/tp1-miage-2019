package com.acme.mailreader.domain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.time.Instant;

import org.junit.Before;
import org.junit.Test;

import com.acme.mailreader.domain.Mail;
import com.acme.mailreader.domain.MailComparator;
import com.acme.mailreader.domain.Mail.Statut;

public class MailComparatorTest {
	
	private MailComparator comparator;

	@Before
	public void setUp() throws Exception {
		this.comparator = new MailComparator();
	}
	@Test
	public final void egauxSiDeuxMailsNuls() {
		Mail mail1 = null;
		Mail mail2 = null;
		assertThat(comparator.compare(mail1, mail2), is(0));
	}
	@Test
	public final void egauxSiUnDesMailsNuls() {
		Mail mail1 = new Mail();
		Mail mail2 = null;
		assertThat(comparator.compare(mail1, mail2), is(0));
	}	
	@Test
	public final void mailLuPlusGrand() throws DateIncorrecteException{
		Mail mail1 = new Mail.Builder("uyyuy").important(false).statut(Statut.UNSENT).build();
		Mail mail2 = new Mail.Builder("uyyuy").important(false).statut(Statut.SENT).build();
		Mail mail3 = new Mail.Builder("uyyuy").important(false).statut(Statut.READ).build();
		assertThat(comparator.compare(mail1, mail3),is(1));
		assertThat(comparator.compare(mail2, mail3),is(1));
	}
	
	@Test
	public final void mailSentPlusGrandQueUnsentEtPlusPetitQueRead() throws DateIncorrecteException{
		Mail mail1 = new Mail.Builder("uyyuy").important(false).statut(Statut.UNSENT).build();
		Mail mail2 = new Mail.Builder("uyyuy").important(false).statut(Statut.SENT).build();
		Mail mail3 = new Mail.Builder("uyyuy").important(false).statut(Statut.READ).build();
		assertThat(comparator.compare(mail1, mail2),is(1));
		assertThat(comparator.compare(mail2, mail3),is(1));
	}
	@Test
	public final void mail1PlusImportantQueLeMail2SiMail1ALeStatutImportantAVrai() throws DateIncorrecteException{
		Mail mail1 = new Mail.Builder("test").important(true).statut(Statut.READ).date(Instant.now()).build();
		Mail mail2 = new Mail.Builder("test").important(false).statut(Statut.READ).date(Instant.now()).build();
		assertThat(comparator.compare(mail1, mail2), is(-1));
	}
	
	@Test
	public final void mail1PlusImportantQueLeMail2SiMail1AUneDate() throws DateIncorrecteException{
		Mail mail1 = new Mail.Builder("test").important(false).statut(Statut.READ).date(Instant.now()).build();
		Mail mail2 = new Mail.Builder("test").important(false).statut(Statut.READ).build();
		assertThat(comparator.compare(mail1, mail2), is(-1));
	}
	

	
	
}
