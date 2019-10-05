package hackatrix.catsupp.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import hackatrix.catsupp.exceptions.NotFoundException;
import hackatrix.catsupp.model.LocalDTO;
import hackatrix.catsupp.model.LocalRefDTO;

@Service
public class LocalesService {

	private static final String KENTUCKY_ID = "kentucky";
	private static final String KENT_BROCKMAN_ID = "kent_brockman";
	private static final String KENTUCKY_NAME = "Kentucky";
	private static final String KENT_BROCKMAN_NAME = "Kent Brockman";
	
	private static final LocalDTO KENTUCKY = new LocalDTO(KENTUCKY_ID, KENTUCKY_NAME);
	private static final LocalDTO KENT_BROCKMAN = new LocalDTO(KENT_BROCKMAN_ID, KENT_BROCKMAN_NAME);
	private static final LocalRefDTO KENTUCKY_REF = new LocalRefDTO(KENTUCKY_ID, KENTUCKY_NAME, "http://ejemplo/locales/kentucky");
	private static final LocalRefDTO KENT_BROCKMAN_REF = new LocalRefDTO(KENT_BROCKMAN_ID, KENT_BROCKMAN_NAME, "http://ejemplo/locales/kent_brockman");

	public LocalDTO findById(String id) {
		if (KENTUCKY_ID.equals(id)) {
			return KENTUCKY;
		} else if (KENT_BROCKMAN_ID.equals(id)) {
				return KENT_BROCKMAN;
		} else {
			throw new NotFoundException();
		}
	}

	public List<LocalRefDTO> findByNameApproximate(String query) {
		return Arrays.asList(KENTUCKY_REF, KENT_BROCKMAN_REF);
	}

}
