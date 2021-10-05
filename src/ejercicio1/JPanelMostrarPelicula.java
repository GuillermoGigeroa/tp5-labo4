package ejercicio1;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.TreeSet;

public class JPanelMostrarPelicula extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblPeliculas;
	private GridBagLayout gridBagLayout;
	private GridBagConstraints gbc_lblPeliculas;
	private GridBagConstraints gbc_list;
	private DefaultListModel<Pelicula> dlmListaPeliculas;
	private JList<Pelicula> lista;

	public JPanelMostrarPelicula(TreeSet<Pelicula> listaPeliculas) {
		dlmListaPeliculas = Util.obtenerDefaultListModel(listaPeliculas);
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblPeliculas = new JLabel("Peliculas");
		gbc_lblPeliculas = new GridBagConstraints();
		gbc_lblPeliculas.insets = new Insets(0, 0, 5, 5);
		gbc_lblPeliculas.gridx = 1;
		gbc_lblPeliculas.gridy = 1;
		add(lblPeliculas, gbc_lblPeliculas);

		lista = new JList<Pelicula>();
		lista.setModel(dlmListaPeliculas);
		gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 2;
		gbc_list.gridy = 1;
		add(lista, gbc_list);
	}
}
