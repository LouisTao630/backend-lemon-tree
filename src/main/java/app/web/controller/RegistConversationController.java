package app.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.web.data.RegistSpokenSentence;

@RestController
@RequestMapping("/regist")
public class RegistConversationController {

	public static final String[] sentences = new String[] { "能留下您的联系方式吗？我想我会联系你的。", "我的朋友，请问我应该如何称呼您？", "让我们约定一个暗号，这样在人群中我一眼就能看见你。" };

	@RequestMapping(value = "/speak", produces = "application/json")
	public @ResponseBody List<RegistSpokenSentence> getLastConversation() {
		List<RegistSpokenSentence> speakQueue = new ArrayList<RegistSpokenSentence>();
		RegistSpokenSentence s = new RegistSpokenSentence();
		s.setId(0);
		s.setSentence(sentences[0]);
		s.setType("email");
		speakQueue.add(s);

		s = new RegistSpokenSentence();
		s.setId(1);
		s.setSentence(sentences[1]);
		s.setType("name");
		speakQueue.add(s);

		s = new RegistSpokenSentence();
		s.setId(2);
		s.setSentence(sentences[2]);
		s.setType("password");
		speakQueue.add(s);

		return speakQueue;
	}
}
