package ejercicio1;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.util.TreeSet;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame implements Ventana {
	private static final long serialVersionUID = 1L;
	private JPanel contenedor;
	private JMenuBar mbBarra;
	private JMenu mnPeliculas;
	private JMenuItem mntmAgregar;
	private JMenuItem mntmListar;
	private JPanelCargarPelicula cargar;
	private JPanelMostrarPelicula mostrar;
	private TreeSet<Pelicula> listaPeliculas;

	public VentanaPrincipal() {
		listaPeliculas = new TreeSet<Pelicula>();
		setTitle("Programa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(posX, posY, ancho, alto);

		mbBarra = new JMenuBar();
		setJMenuBar(mbBarra);

		mnPeliculas = new JMenu("Peliculas");
		mbBarra.add(mnPeliculas);

		mntmAgregar = new JMenuItem("Agregar");
		mntmAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregar();
			}
		});

		mnPeliculas.add(mntmAgregar);

		mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listar();
			}
		});

		mnPeliculas.add(mntmListar);
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		contenedor.setLayout(new BorderLayout(0, 0));
		setContentPane(contenedor);
	}

	public void agregar() {
		contenedor.removeAll();
		cargar = new JPanelCargarPelicula(listaPeliculas);
		contenedor.add(cargar);
		contenedor.repaint();
		contenedor.revalidate();
	}

	public void listar() {
		contenedor.removeAll();
		mostrar = new JPanelMostrarPelicula(listaPeliculas);
		contenedor.add(mostrar);
		contenedor.repaint();
		contenedor.revalidate();
	}

	@Override
	public void hacerVisible() {
		this.setVisible(true);
	}

}
