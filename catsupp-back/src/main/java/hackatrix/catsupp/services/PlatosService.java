package hackatrix.catsupp.services;

import java.util.List;

import org.springframework.stereotype.Component;

import hackatrix.catsupp.exceptions.NotFoundException;
import hackatrix.catsupp.model.PlatoDTO;

@Component
public class PlatosService {

	public PlatoDTO findById(String idLocal, String idPlato) {
		List<PlatoDTO> listas = Constantes.PLATOS.get(idLocal);
		if (listas == null) {
			throw new NotFoundException();
		}
		return listas.stream().filter(p -> p.getId().equals(idPlato)).findAny().orElseThrow(() -> new NotFoundException());
	}

}
