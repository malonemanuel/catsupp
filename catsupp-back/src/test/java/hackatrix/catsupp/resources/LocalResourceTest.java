package hackatrix.catsupp.resources;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import hackatrix.catsupp.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class LocalResourceTest {

	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void test_local_existente() throws Exception {
		mockMvc
		.perform(get("/locales/kentucky"))
		.andExpect(status().isOk())
		.andExpect(content().json("{"
				+ "\"id\": \"kentucky\","
				+ "\"nombre\": \"Kentucky\""
				+ "}"))
		;
	}
	
	@Test
	public void test_local_inexistente() throws Exception {
		mockMvc
		.perform(get("/locales/inexistente"))
		.andExpect(status().isNotFound())
		;
	}

	@Test
	public void test_search_por_nombre() throws Exception {
		mockMvc
		.perform(get("/locales?q=kent"))
		.andExpect(status().isOk())
		.andExpect(content().json("["
				+ "{"
				+ "\"id\": \"kentucky\","
				+ "\"nombre\": \"Kentucky\","
				+ "\"href\": \"http://ejemplo/locales/kentucky\""
				+ "},"
				+ "{"
				+ "\"id\": \"kent_brockman\","
				+ "\"nombre\": \"Kent Brockman\","
				+ "\"href\": \"http://ejemplo/locales/kent_brockman\""
				+ "}"
				+ "]"))
		;
	}

}
