package tp5;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.TreeSet;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPanelCargarPelicula extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btnAceptar;
	private JComboBox<Categoria> cbGenero;
	private JLabel lblID;
	private JLabel ID;
	private JLabel lblNombre;
	private JLabel lblGenero;
	private JTextField txtNombre;
	private GridBagLayout gridBagLayout;
	private GridBagConstraints gbc_lblID;
	private GridBagConstraints gbc_ID;
	private GridBagConstraints gbc_lblNombre;
	private GridBagConstraints gbc_txtNombre;
	private GridBagConstraints gbc_lblGenero;
	private GridBagConstraints gbc_cbGenero;
	private GridBagConstraints gbc_btnAceptar;
	private Pelicula peliculaActual;
	private Categoria categoriaActual;
	private TreeSet<Pelicula> listaPeliculas;

	public JPanelCargarPelicula(TreeSet<Pelicula> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
		limpiarPeliculaActual();

		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 17, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblID = new JLabel("ID");
		gbc_lblID = new GridBagConstraints();
		gbc_lblID.insets = new Insets(0, 0, 5, 5);
		gbc_lblID.gridx = 1;
		gbc_lblID.gridy = 1;
		add(lblID, gbc_lblID);

		ID = new JLabel("");
		ID.setText(String.valueOf(Pelicula.getProximoID()));
		gbc_ID = new GridBagConstraints();
		gbc_ID.insets = new Insets(0, 0, 5, 5);
		gbc_ID.gridx = 3;
		gbc_ID.gridy = 1;
		add(ID, gbc_ID);

		lblNombre = new JLabel("Nombre");
		gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 2;
		add(lblNombre, gbc_lblNombre);

		txtNombre = new JTextField();
		gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 3;
		gbc_txtNombre.gridy = 2;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);

		lblGenero = new JLabel("Genero");
		gbc_lblGenero = new GridBagConstraints();
		gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenero.gridx = 1;
		gbc_lblGenero.gridy = 3;
		add(lblGenero, gbc_lblGenero);

		cbGenero = Util.listaGeneros();
		gbc_cbGenero = new GridBagConstraints();
		gbc_cbGenero.insets = new Insets(0, 0, 5, 5);
		gbc_cbGenero.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbGenero.gridx = 3;
		gbc_cbGenero.gridy = 3;
		add(cbGenero, gbc_cbGenero);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBotonAceptar();
			}
		});

		gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.gridwidth = 3;
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 5;
		add(btnAceptar, gbc_btnAceptar);
	}

	private void accionBotonAceptar() {
		/*
		 * Primero verifica que la lista no sea ni -1 ni 0 porque no puede existir
		 * pelicula sin categoria.
		 */
		if (cbGenero.getSelectedIndex() < 1) {
			Util.alerta("Por favor, seleccione un género antes de continuar.");
			return;
		} else {
			cargarCategoria((Categoria) cbGenero.getSelectedItem());
		}
		// Luego verifica si el nombre está cargado correctamente.
		String nombrePelicula = txtNombre.getText().trim();
		if (nombrePelicula.isEmpty()) {
			Util.alerta("Por favor, escriba un nombre antes de continuar.");
			return;
		} else {
			cargarPelicula(new Pelicula(nombrePelicula, categoriaActual));
		}
		// En caso de que se hayan cargado correctamente ambas cosas, lo carga en la
		// lista.
		if (verificarSiEstaCompleto()) {
			agregarPelicula(peliculaActual);
		}
	}

	private void reiniciarPanel() {
		// Limpia los datos del panel y resetea la lista.
		ID.setText(String.valueOf(Pelicula.getProximoID()));
		txtNombre.setText(null);
		cbGenero.setSelectedIndex(0);
		limpiarPeliculaActual();
	}

	private void limpiarPeliculaActual() {
		peliculaActual = null;
		categoriaActual = null;
	}

	private void agregarPelicula(Pelicula pelicula) {
		// Agrega la pelicula al TreeSet y luego avisa que ya fue cargado.
		listaPeliculas.add(pelicula);
		Util.alerta("Película \"" + peliculaActual.getNombre() + "\" cargada correctamente.");
		reiniciarPanel();
	}

	private void cargarCategoria(Categoria categoria) {
		this.categoriaActual = categoria;
	}

	private void cargarPelicula(Pelicula pelicula) {
		this.peliculaActual = pelicula;
	}

	private boolean verificarSiEstaCompleto() {
		// Verifica que ambos campos hayan sido cargados correctamente, sino devuelve
		// false.
		if (peliculaActual != null && categoriaActual != null) {
			return true;
		}
		return false;
	}
}
