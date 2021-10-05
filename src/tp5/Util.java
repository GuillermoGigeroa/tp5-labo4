package tp5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public abstract class Util {

	// Metodo para enviar alertas en pantalla

	public static void alerta(String texto) {
		JOptionPane.showMessageDialog(null, texto);
	}

	// Metodo para cargar la lista de generos

	public static JComboBox<Categoria> listaGeneros() {
		JComboBox<Categoria> listaCargada = new JComboBox<Categoria>();
		ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();
		listaCategorias.add(new Categoria("Seleccione un genero"));
		listaCategorias.add(new Categoria("Terror"));
		listaCategorias.add(new Categoria("Accion"));
		listaCategorias.add(new Categoria("Suspenso"));
		listaCategorias.add(new Categoria("Romantica"));
		Iterator<Categoria> iterator = listaCategorias.iterator();
		while (iterator.hasNext()) {
			listaCargada.addItem(iterator.next());
		}
		return listaCargada;
	}

	// Metodo para extraer un DefaultListModel<Pelicula> de un TreeSet<Pelicula>

	public static DefaultListModel<Pelicula> obtenerDefaultListModel(TreeSet<Pelicula> origen) {
		DefaultListModel<Pelicula> dlmPeliculas = new DefaultListModel<Pelicula>();
		dlmPeliculas = new DefaultListModel<Pelicula>();
		Iterator<Pelicula> lista = origen.iterator();
		while (lista.hasNext()) {
			dlmPeliculas.addElement(lista.next());
		}
		return dlmPeliculas;
	}
}
