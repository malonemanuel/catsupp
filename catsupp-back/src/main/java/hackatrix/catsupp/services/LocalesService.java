package hackatrix.catsupp.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hackatrix.catsupp.exceptions.NotFoundException;
import hackatrix.catsupp.model.LocalDTO;
import hackatrix.catsupp.model.LocalRefDTO;
import hackatrix.catsupp.model.PlatoRefDTO;

@Service
public class LocalesService {

	private static final String KENTUCKY_ID = "kentucky";
	private static final String KENT_BROCKMAN_ID = "kent_brockman";
	private static final String KENTUCKY_NAME = "Kentucky";
	private static final String KENT_BROCKMAN_NAME = "Kent Brockman";
	private static final PlatoRefDTO PIZZA_MUZZARELLA = new PlatoRefDTO("pizza_muzzarella", "Pizza de Muzzarella", "http://ejemplo/locales/kentucky/platos/pizza_muzzarella");
	private static final PlatoRefDTO PIZZA_FUGAZETTA = new PlatoRefDTO("pizza_fugazzeta", "Pizza de Fugazzeta", "http://ejemplo/locales/kentucky/platos/pizza_fugazzeta");
	
	private static final LocalDTO KENTUCKY = new LocalDTO(KENTUCKY_ID, KENTUCKY_NAME, Arrays.asList(PIZZA_MUZZARELLA, PIZZA_FUGAZETTA));
	private static final LocalDTO KENT_BROCKMAN = new LocalDTO(KENT_BROCKMAN_ID, KENT_BROCKMAN_NAME, new ArrayList<PlatoRefDTO>());
	private static final LocalRefDTO KENTUCKY_REF = new LocalRefDTO(KENTUCKY_ID, KENTUCKY_NAME, "http://ejemplo/locales/kentucky");
	private static final LocalRefDTO KENT_BROCKMAN_REF = new LocalRefDTO(KENT_BROCKMAN_ID, KENT_BROCKMAN_NAME, "http://ejemplo/locales/kent_brockman");

	private List<LocalDTO> locales = Arrays.asList(KENTUCKY, KENT_BROCKMAN);
	private List<LocalRefDTO> localesRefs = Arrays.asList(KENTUCKY_REF, KENT_BROCKMAN_REF);
	
	
	public LocalDTO findById(String id) {
		Optional<LocalDTO> local = locales.stream().filter(l -> l.getId().equals(id)).findAny();
		return local.orElseThrow(() -> new NotFoundException());
	}

	public List<LocalRefDTO> findByNameApproximate(String query) {
		return localesRefs.stream()
				.filter(l -> l.getNombre().toLowerCase().startsWith(query.toLowerCase()))
				.collect(Collectors.toList());
	}

}
