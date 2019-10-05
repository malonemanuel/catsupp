package hackatrix.catsupp.resources;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hackatrix.catsupp.model.LocalDTO;
import hackatrix.catsupp.model.LocalRefDTO;
import hackatrix.catsupp.model.PlatoDTO;
import hackatrix.catsupp.services.LocalesService;
import hackatrix.catsupp.services.PlatosService;

@RestController
public class LocalesResource {

	private static final String BASE = "/locales";
	private static final String PLATOS = "/platos";
	
	@Autowired
	private LocalesService localesService;
	@Autowired
	private PlatosService platosService;

	@GetMapping(path=BASE + "/{id}")
	public LocalDTO get(@PathVariable("id") String id) {
		return localesService.findById(id);
	}
	
	@GetMapping(path=BASE + "/{idLocal}" + PLATOS + "/{idPlato}")
	public PlatoDTO getPlato(@PathVariable("idLocal") String idLocal, @PathVariable("idPlato") String idPlato) {
		return platosService.findById(idLocal, idPlato);
	}
	
	@GetMapping(path=BASE)
	public List<LocalRefDTO> find(@RequestParam(value="q", required=true) String queryEnc) {
		String query = URLDecoder.decode(queryEnc, StandardCharsets.UTF_8);
		return localesService.findByNameApproximate(query);
	}
	
	
}
