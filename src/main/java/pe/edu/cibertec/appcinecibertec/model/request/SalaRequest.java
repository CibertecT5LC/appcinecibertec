package pe.edu.cibertec.appcinecibertec.model.request;

import lombok.Data;

@Data
public class SalaRequest {
	private Integer idsala;
	private String descsala;
	private Integer asientos;
	private Integer idestado;
}
