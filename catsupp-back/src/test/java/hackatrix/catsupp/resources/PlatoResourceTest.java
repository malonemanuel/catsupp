package hackatrix.catsupp.resources;

import static hackatrix.catsupp.services.Constantes.HOST;
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
public class PlatoResourceTest {

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
		.perform(get("/locales/kentucky/platos/pizza_muzzarella"))
		.andExpect(status().isOk())
		.andExpect(content().json("{"
				+ "\"id\": \"pizza_muzzarella\","
				+ "\"nombre\": \"Pizza de Muzzarella\","
				+ "\"ingredientes\": ["
				+ "{\"nombre\":\"Masa\",\"imagen\":\"http://" + HOST + ":4200/assets/img/ingrediente/masa.jpg\"},"
				+ "{\"nombre\":\"Queso\",\"imagen\":\"http://" + HOST + ":4200/assets/img/ingrediente/queso.jpg\"},"
				+ "{\"nombre\":\"Salsa de tomate\",\"imagen\":\"http://" + HOST + ":4200/assets/img/ingrediente/salsadetomate.jpg\"}"
				+ "]"
				+ "}"))
		;
	}
	
	@Test
	public void test_local_inexistente() throws Exception {
		mockMvc
		.perform(get("/locales/kentucky/platos/inexistente"))
		.andExpect(status().isNotFound())
		;
	}

}
