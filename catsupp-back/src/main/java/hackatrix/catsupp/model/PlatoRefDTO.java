package hackatrix.catsupp.model;

public class PlatoRefDTO {
	private final PlatoDTO plato;

	public PlatoRefDTO(PlatoDTO plato) {
		this.plato = plato;
	}
	public String getId() {
		return plato.getId();
	}
	public String getNombre() {
		return plato.getNombre();
	}
	public String getHref() {
		return plato.getHref();
	}
}
