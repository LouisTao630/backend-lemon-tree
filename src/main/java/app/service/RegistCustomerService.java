package app.service;

import java.util.List;

import app.web.data.RegistSpokenSentence;

public interface RegistCustomerService {

	/**
	 * Return all registration steps
	 * 
	 * @return
	 */
	public abstract List<RegistSpokenSentence> getAllSteps();

}
