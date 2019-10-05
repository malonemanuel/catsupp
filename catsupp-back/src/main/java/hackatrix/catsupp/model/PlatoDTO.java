package hackatrix.catsupp.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlatoDTO {
	private String id;
	private String nombre;
	private String imagen;
	private List<IngredienteDTO> ingredientes;
	
	private String href;
}
