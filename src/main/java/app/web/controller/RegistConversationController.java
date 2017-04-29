package app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.service.RegistCustomerService;
import app.web.data.RegistSpokenSentence;

@RestController
@RequestMapping("/regist")
public class RegistConversationController {

	@Autowired
	private RegistCustomerService service;

	@RequestMapping(value = "/steps", produces = "application/json")
	public @ResponseBody List<RegistSpokenSentence> getLastConversation() {
		return service.getAllSteps();
	}
}
