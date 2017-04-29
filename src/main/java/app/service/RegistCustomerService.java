package app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import app.web.data.RegistSpokenSentence;

@Service
public interface RegistCustomerService {

	/**
	 * Return all registration steps
	 * 
	 * @return
	 */
	public abstract List<RegistSpokenSentence> getAllSteps();

}