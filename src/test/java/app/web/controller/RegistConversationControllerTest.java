package app.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Locale;

import javax.servlet.http.Cookie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import app.cfg.Root;
import app.cfg.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({ @ContextConfiguration(name = "parent", classes = { Root.class}), @ContextConfiguration(name = "child", classes = { WebConfig.class }) })
public class RegistConversationControllerTest {

	@Autowired
	private WebApplicationContext wac;

	@Test
	public void test() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		mockMvc.perform(get("/regist/steps").locale(Locale.SIMPLIFIED_CHINESE).param("locale", "zh_CN").cookie(new Cookie("lang", "en_US"))).andExpect(jsonPath("$").isArray());
	}

}
