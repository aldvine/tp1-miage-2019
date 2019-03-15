package com.acme.mailreader.domain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.time.Instant;

import org.junit.Test;

import com.acme.mailreader.domain.Mail.Statut;

public class MailTest {

	MailComparator comparator = new MailComparator();

	@Test(expected = DateIncorrecteException.class)
	public final void erreurSiDateAvant1970() throws DateIncorrecteException {
		 new Mail.Builder("uyyuy").important(false).statut(Statut.READ).date( Instant.parse("1965-02-03T01:02:00Z")).build();
	}

	@Test
	public final void premierPlusPetitSiDateNulle() throws DateIncorrecteException {
		Mail mail1 = new Mail.Builder("uyyuy").important(false).statut(Statut.READ).build();
		Mail mail2 = new Mail.Builder("uyyuy").important(false).statut(Statut.READ).date(Instant.now()).build();
		assertThat(comparator.compare(mail1, mail2), is(1));
	}
	@Test(expected = DateIncorrecteException.class)
	public final void erreurSiDateApres2100() throws DateIncorrecteException {
		new Mail.Builder("uyyuy").important(false).statut(Statut.READ).date( Instant.parse("2107-02-03T01:02:00Z")).build();
	}
	
	
	
	

}
