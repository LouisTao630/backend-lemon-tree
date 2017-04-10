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

	public static final String[] sentences = new String[] { "������������ϵ��ʽ�������һ���ϵ��ġ�", "�ҵ����ѣ�������Ӧ����γƺ�����", "������Լ��һ�����ţ���������Ⱥ����һ�۾��ܿ����㡣" };

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
