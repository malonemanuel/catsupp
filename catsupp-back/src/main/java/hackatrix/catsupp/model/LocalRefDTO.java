package hackatrix.catsupp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocalRefDTO
{
	private String id;
	private String nombre;
	private String href;
}
