package hackatrix.catsupp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hackatrix.catsupp.model.LocalDTO;
import hackatrix.catsupp.model.LocalRefDTO;
import hackatrix.catsupp.services.LocalesService;

@RestController
public class LocalesResource {

	private static final String BASE = "/locales";
	
	@Autowired
	private LocalesService localesService;

	@GetMapping(path=BASE + "/{id}")
	public LocalDTO get(@PathVariable("id") String id) {
		return localesService.findById(id);
	}
	
	@GetMapping(path=BASE)
	public List<LocalRefDTO> find(@RequestParam("q") String query) {
		return localesService.findByNameApproximate(query);
	}
	
	
}