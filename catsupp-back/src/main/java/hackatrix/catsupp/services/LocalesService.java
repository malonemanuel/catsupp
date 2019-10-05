package hackatrix.catsupp.services;

import static hackatrix.catsupp.services.Constantes.CELESTE;
import static hackatrix.catsupp.services.Constantes.KENTUCKY;
import static hackatrix.catsupp.services.Constantes.KENT_BROCKMAN;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hackatrix.catsupp.exceptions.NotFoundException;
import hackatrix.catsupp.model.LocalDTO;
import hackatrix.catsupp.model.LocalRefDTO;

@Service
public class LocalesService {

	private List<LocalDTO> locales = Arrays.asList(KENTUCKY, KENT_BROCKMAN, CELESTE);
	private List<LocalRefDTO> localesRefs = Arrays.asList(new LocalRefDTO(KENTUCKY), new LocalRefDTO(KENT_BROCKMAN), new LocalRefDTO(CELESTE));
	
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
