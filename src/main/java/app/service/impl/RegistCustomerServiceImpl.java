package app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import app.service.RegistCustomerService;
import app.web.data.REGIST_SENTENCE;
import app.web.data.RegistSpokenSentence;

@Service
public class RegistCustomerServiceImpl implements RegistCustomerService {

	@Autowired
	private MessageSource source;

//	@Cacheable("registAllSteps")
	public List<RegistSpokenSentence> getAllSteps() {

		List<RegistSpokenSentence> speakQueue = new ArrayList<RegistSpokenSentence>();

		for (REGIST_SENTENCE sentence : REGIST_SENTENCE.values()) {
			RegistSpokenSentence s = new RegistSpokenSentence();
			s.setId(0);
			s.setSentence(source.getMessage(sentence.name(), null, Locale.SIMPLIFIED_CHINESE));
			s.setType("email");
			speakQueue.add(s);
		}
		return speakQueue;
	}

}
