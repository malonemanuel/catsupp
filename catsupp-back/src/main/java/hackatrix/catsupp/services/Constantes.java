package hackatrix.catsupp.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import hackatrix.catsupp.model.IngredienteDTO;
import hackatrix.catsupp.model.LocalDTO;
import hackatrix.catsupp.model.PlatoDTO;
import hackatrix.catsupp.model.PlatoRefDTO;

public class Constantes {
//	public static final String HOST = "catsupphost";
	public static final String HOST = "192.168.43.231";
	public static final String LOC_BASE = "http://" + HOST + ":8080/locales/";
	public static final String IMG_BASE = "http://" + HOST + ":4200/assets/img/ingrediente/";
	public static final String IMG_PLATO = "http://" + HOST + ":4200/assets/img/plato/";
	
	private static final IngredienteDTO ACEITE = new IngredienteDTO("Aceite", IMG_BASE + "aceite.jpg");
	private static final IngredienteDTO AJI = new IngredienteDTO("Aji", IMG_BASE + "aji.jpg");
	private static final IngredienteDTO MASA = new IngredienteDTO("Masa", IMG_BASE + "masa.jpg");
	private static final IngredienteDTO QUESO = new IngredienteDTO("Queso", IMG_BASE + "queso.jpg");
	private static final IngredienteDTO SALSA_TOMATE = new IngredienteDTO("Salsa de tomate", IMG_BASE + "salsadetomate.jpg");
	private static final IngredienteDTO TOMATE = new IngredienteDTO("Tomate", IMG_BASE + "tomate.jpg");
	private static final IngredienteDTO CEBOLLA = new IngredienteDTO("Cebolla", IMG_BASE + "cebolla.jpg");
	
	public static final String KENTUCKY_ID = "kentucky";
	public static final String KENT_BROCKMAN_ID = "kent_brockman";
	public static final String KENTUCKY_NAME = "Kentucky";
	public static final String KENT_BROCKMAN_NAME = "Kent Brockman";
	public static final String CELESTE_ID = "pizzeria-celeste-en-saavedra";
	public static final String CELESTE_NAME = "Pizzeria Celeste en Saavedra";

	public static final PlatoDTO PIZZA_MUZZARELLA = new PlatoDTO("pizza_muzzarella", "Pizza de Muzzarella", toPlatoImg("pizzaMuzzarella.jpg"), Arrays.asList(MASA, QUESO, SALSA_TOMATE), LOC_BASE + KENTUCKY_ID + "/platos/pizza_muzzarella");
	public static final PlatoDTO PIZZA_NAPOLITANA = new PlatoDTO("pizza_napolitana", "Pizza Napolitana", toPlatoImg("pizzaNapo.jpg"), Arrays.asList(MASA, QUESO, SALSA_TOMATE, TOMATE), LOC_BASE + KENTUCKY_ID + "/platos/pizza_napolitana");
	public static final PlatoDTO PIZZA_FUGAZETTA = new PlatoDTO("pizza_fugazzeta", "Pizza de Fugazzeta", toPlatoImg("pizzaFugazzeta.jpg"), Arrays.asList(MASA, QUESO, CEBOLLA), LOC_BASE + KENTUCKY_ID + "/platos/pizza_fugazzeta");
	public static final PlatoRefDTO PIZZA_MUZZARELLA_REF = new PlatoRefDTO(PIZZA_MUZZARELLA);
	public static final PlatoRefDTO PIZZA_FUGAZETTA_REF = new PlatoRefDTO(PIZZA_FUGAZETTA);
	

	private static final List<PlatoDTO> PLATOS_KENTUCKY = Arrays.asList(PIZZA_MUZZARELLA, PIZZA_FUGAZETTA);
	private static final List<PlatoDTO> PLATOS_KENT_BROCKMAN = Arrays.asList();
	private static final List<PlatoDTO> PLATOS_CELESTE = Arrays.asList();
	
	
	// Locales
	public static final LocalDTO KENTUCKY = new LocalDTO(
			KENTUCKY_ID, 
			KENTUCKY_NAME, 
			toRef(PLATOS_KENTUCKY), 
			toUrl(KENTUCKY_ID));
	public static final LocalDTO KENT_BROCKMAN = new LocalDTO(
			KENT_BROCKMAN_ID, 
			KENT_BROCKMAN_NAME, 
			toRef(PLATOS_KENT_BROCKMAN), 
			toUrl(KENT_BROCKMAN_ID));
	public static final LocalDTO CELESTE = new LocalDTO(
			CELESTE_ID, 
			CELESTE_NAME, 
			toRef(PLATOS_CELESTE), 
			toUrl(CELESTE_ID));
	
	@SuppressWarnings("serial")
	public static final Map<String, List<PlatoDTO>> PLATOS = new HashMap<>(){{
		put(KENTUCKY_ID, PLATOS_KENTUCKY);
		put(KENT_BROCKMAN_ID, PLATOS_KENT_BROCKMAN);
		put(CELESTE_ID, PLATOS_CELESTE);
	}};
	
	private static String toUrl(String id) {
		return LOC_BASE + id;
	}
	private static String toPlatoImg(String id) {
		return IMG_PLATO + id;
	}
	private static final List<PlatoRefDTO> toRef(List<PlatoDTO> platos) {
		return platos.stream().map(p -> new PlatoRefDTO(p)).collect(Collectors.toList());
	}
}
