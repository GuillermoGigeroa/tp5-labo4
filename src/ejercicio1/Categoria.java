package ejercicio1;

public class Categoria implements Comparable<Categoria> {

	private final int id;
	private String nombre;
	private static int contador;

	// Constructores
	public Categoria() {
		id = generarID();
		nombre = "Sin nombre";
	}

	public Categoria(String _nombre) {
		this.id = generarID();
		this.nombre = _nombre;
	}

	// Metodos

	private int generarID() {
		int idActual = contador;
		contador++;
		return idActual;
	}

	@Override
	public int compareTo(Categoria o) {
		return this.getNombre().toLowerCase().compareTo(o.getNombre().toLowerCase());
	}

	@Override
	public String toString() {
		return nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	// Getters y Setters

	public String getNombre() {
		return nombre;
	}

	protected int getId() {
		return id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
