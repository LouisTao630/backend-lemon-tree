package app.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

public class RegistConversationControllerTest {

	@Test
	public void test() throws Exception {
		RegistConversationController controller = new RegistConversationController();
		MockMvc mockMvc=standaloneSetup(controller).build();
		mockMvc.perform(get("/regist/speak")).andExpect(jsonPath("$").isArray());
	}

}
