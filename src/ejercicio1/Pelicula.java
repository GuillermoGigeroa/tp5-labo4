package ejercicio1;

public class Pelicula implements Comparable<Pelicula> {
	
	private final int id;
	private String nombre;
	private static int contador = 1;
	private Categoria genero;
	
	// Constructores
	
	public Pelicula() {
		id = generarID();
		nombre = "Sin nombre";
		genero = new Categoria();
	}

	public Pelicula(String pelicula, Categoria genero) {
		this.id = generarID();
		this.nombre = pelicula;
		this.genero = genero;
	}
	
	// Metodos
	
	private int generarID() {
		int idActual = contador;
		contador++;
		return idActual;
	}
	
	public static int getProximoID() {
		return contador;
	}
	
	// Getters y Setters
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Categoria getGenero() {
		return genero;
	}
	public void setGenero(Categoria genero) {
		this.genero = genero;
	}

	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return nombre + " - " + genero + ".";
	}
	
	@Override
	public int compareTo(Pelicula o) {
		int compareToPeliculas = this.getNombre().toLowerCase().compareTo(o.getNombre().toLowerCase());
		if (compareToPeliculas != 0) {
			return compareToPeliculas;
		}
		else {
			return this.getGenero().getNombre().toLowerCase().compareTo(o.getGenero().getNombre().toLowerCase());
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
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
		Pelicula other = (Pelicula) obj;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
