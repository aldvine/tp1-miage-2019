package com.acme.mailreader.bdd;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.acme.mailreader.domain.DateIncorrecteException;
import com.acme.mailreader.domain.Mail;
import com.acme.mailreader.domain.MailComparator;
import com.acme.mailreader.domain.Mail.Statut;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Les steps (actions) du test
 * 
 * <p>
 * A noter qu'une nouvelle instance de cette classe est créée à chaque scenario
 * </p>
 *
 */

public class MailValidStep {

	
	private static final Map<String, Integer> sujetValidAsString = new HashMap<String, Integer>();
	static {
		sujetValidAsString.put("OK", 1);
		sujetValidAsString.put("NOK", -1);
	}
	private Mail mail;
	@Given("^Un mail avec l'importance \"([^\"]*)\", le statut \"([^\"]*)\", le sujet \"([^\"]*)\" et la date \"([^\"]*)\"$")
	public void un_mail(boolean importance, Statut statut, String sujet, String date)
			throws DateIncorrecteException {

		this.mail = new Mail.Builder(sujet).important(importance).statut(statut).date(Instant.parse(date)).build();
	}

	
	@Then("^le sujet doit être non vide : \"([^\"]*)\"$")
	public void sujetMailValide(String sujet_valide) throws Throwable {
		Integer valide = -1;
		if(this.mail.getSujet() != null && this.mail.getSujet() != ""  && !this.mail.getSujet().isEmpty()) {
			valide  = 1;
		}
		assertThat(valide,is(sujetValidAsString.get(sujet_valide)));
	}
}
