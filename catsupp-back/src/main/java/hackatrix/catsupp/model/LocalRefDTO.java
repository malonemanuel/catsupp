package hackatrix.catsupp.model;

public class LocalRefDTO
{
	private final LocalDTO localDTO;
	public LocalRefDTO(LocalDTO localDTO) {
		this.localDTO = localDTO;
	}
	public String getId() {
		return this.localDTO.getId();
	}
	public String getNombre() {
		return this.localDTO.getNombre();
	}
	public String getHref() {
		return this.localDTO.getHref();
	}
}
