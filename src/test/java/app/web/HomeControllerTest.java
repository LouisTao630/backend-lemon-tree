package app.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class HomeControllerTest {

	@Test
	public void testHome() throws Exception {
		HomeController controller = new HomeController();
		MockMvc mockMvc=standaloneSetup(controller).build();
		mockMvc.perform(get("/homepage")).andExpect(view().name("home"));
	}

}
