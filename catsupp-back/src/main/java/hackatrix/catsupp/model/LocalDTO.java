package hackatrix.catsupp.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocalDTO {
	private String id;
	private String nombre;
	private List<PlatoRefDTO> platos;
	private String href;
}
