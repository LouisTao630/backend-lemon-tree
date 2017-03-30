package app.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistConversationController {
	
	
	@RequestMapping("/regist/lastConversation")
	public @ResponseBody String getLastConversation(){
		return "Hello World!";
	}
}
