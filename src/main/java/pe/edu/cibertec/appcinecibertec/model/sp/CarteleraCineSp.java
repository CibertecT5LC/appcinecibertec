package pe.edu.cibertec.appcinecibertec.model.sp;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CarteleraCineSp {
	@Id
	private Integer id;
	private String titulo;
	private String genero;
	private String formato;
	private String descsala;
	private Integer asientos;
	private Date fecha;
	private String horainicio;
	private String horafin;
}
