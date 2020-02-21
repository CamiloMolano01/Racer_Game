package co.edu.uptc.vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Selector extends JFrame {
	private JButton botonUnJugador;
	private JButton botonDosJugadores;
	private BotonListener botonList;
	private JPanel panelUno;
	private JPanel panelDos;

	private JLabel j1;
	private JLabel carroj1;
	private JTextField nombrej1;
	private ButtonGroup grupoBotones1;
	private JRadioButton j1boton1;
	private JRadioButton j1boton2;
	private JRadioButton j1boton3;
	private JRadioButton j1boton4;
	private JRadioButton j1boton5;
	private JRadioButton j1boton6;
	private JLabel limagen1;
	private ImageIcon imagen1;
	private JPanel pbotones1;

	private JLabel j2;
	private JLabel carroj2;
	private JTextField nombrej2;
	private ButtonGroup grupoBotones2;
	private JRadioButton j2boton1;
	private JRadioButton j2boton2;
	private JRadioButton j2boton3;
	private JRadioButton j2boton4;
	private JRadioButton j2boton5;
	private JRadioButton j2boton6;
	private JLabel limagen2;
	private ImageIcon imagen2;
	private JPanel pbotones2;

	private Component espacio;
	private JButton botonAtras;
	private JButton botonIniciar;
	private int modo;

	public Selector() {

		setResizable(false);
		setLayout(new FlowLayout());
		modo = 0;

		espacio = Box.createRigidArea(new Dimension(10, 0));

		panelUno = new JPanel();
		panelUno.setLayout(new BoxLayout(panelUno, BoxLayout.Y_AXIS));

		panelDos = new JPanel();
		panelDos.setLayout(new BoxLayout(panelDos, BoxLayout.Y_AXIS));

		pbotones1 = new JPanel();
		pbotones1.setLayout(new FlowLayout());

		pbotones2 = new JPanel();
		pbotones2.setLayout(new FlowLayout());

		botonList = new BotonListener(this);

		botonUnJugador = new JButton("UN JUGADOR");
		botonUnJugador.setActionCommand("unJugador");
		botonUnJugador.addActionListener(botonList);

		botonDosJugadores = new JButton("DOS JUGADORES");
		botonDosJugadores.setActionCommand("dosJugadores");
		botonDosJugadores.addActionListener(botonList);

		botonAtras = new JButton("ATRAS");
		botonAtras.setActionCommand("atras");
		botonAtras.addActionListener(botonList);

		botonIniciar = new JButton("ARRANCAR!");
		botonIniciar.setActionCommand("iniciar");
		botonIniciar.addActionListener(botonList);

		j1 = new JLabel("Escriba el nombre de su corredor #1:");
		nombrej1 = new JTextField();
		carroj1 = new JLabel("Seleccione su auto favorito ");
		j1boton1 = new JRadioButton("1");
		j1boton2 = new JRadioButton("2");
		j1boton3 = new JRadioButton("3");
		j1boton4 = new JRadioButton("4");
		j1boton5 = new JRadioButton("5");
		j1boton6 = new JRadioButton("6");
		grupoBotones1 = new ButtonGroup();
		grupoBotones1.add(j1boton1);
		grupoBotones1.add(j1boton2);
		grupoBotones1.add(j1boton3);
		grupoBotones1.add(j1boton4);
		grupoBotones1.add(j1boton5);
		grupoBotones1.add(j1boton6);
		imagen1 = new ImageIcon("./imagenes/seleccion.png");
		limagen1 = new JLabel();
		limagen1.setIcon(imagen1);

		pbotones1.add(j1boton1);
		pbotones1.add(j1boton2);
		pbotones1.add(j1boton3);
		pbotones1.add(j1boton4);
		pbotones1.add(j1boton5);
		pbotones1.add(j1boton6);

		panelUno.add(botonAtras);
		panelUno.add(j1);
		panelUno.add(nombrej1);
		panelUno.add(carroj1);
		panelUno.add(limagen1);
		panelUno.add(pbotones1);
		panelUno.add(botonIniciar);

		j2 = new JLabel("Escriba el nombre de su corredor #2:");
		nombrej2 = new JTextField();
		carroj2 = new JLabel("Seleccione su auto favorito");
		j2boton1 = new JRadioButton("1");
		j2boton2 = new JRadioButton("2");
		j2boton3 = new JRadioButton("3");
		j2boton4 = new JRadioButton("4");
		j2boton5 = new JRadioButton("5");
		j2boton6 = new JRadioButton("6");
		grupoBotones2 = new ButtonGroup();
		grupoBotones2.add(j2boton1);
		grupoBotones2.add(j2boton2);
		grupoBotones2.add(j2boton3);
		grupoBotones2.add(j2boton4);
		grupoBotones2.add(j2boton5);
		grupoBotones2.add(j2boton6);
		imagen2 = new ImageIcon("./imagenes/seleccion.png");
		limagen2 = new JLabel();
		limagen2.setIcon(imagen2);

		pbotones2.add(j2boton1);
		pbotones2.add(j2boton2);
		pbotones2.add(j2boton3);
		pbotones2.add(j2boton4);
		pbotones2.add(j2boton5);
		pbotones2.add(j2boton6);

		panelDos.add(j2);
		panelDos.add(nombrej2);
		panelDos.add(carroj2);
		panelDos.add(limagen2);
		panelDos.add(pbotones2);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		modos();
		setVisible(true);
	}

	public void modos() {

		removerTodo();
		setTitle("");
		setSize(400, 400);

		add(botonUnJugador);
		add(botonDosJugadores);

	}

	public void Unjugador() {
		removerTodo();
		setTitle("MODO UN JUGADOR");
		setSize(400, 450);
		add(panelUno);
	}

	public void DosJugadores() {
		removerTodo();
		setSize(800, 450);
		setTitle("MODO DOS JUGADORES");
		add(panelUno);
		add(espacio);
		add(panelDos);

	}

	public void removerTodo() {
		remove(panelUno);
		remove(panelDos);
		remove(espacio);

		remove(botonUnJugador);
		remove(botonDosJugadores);
	}

	public static void main(String[] args) {
		Selector s = new Selector();

	}

	public String getSelectedButtonText(ButtonGroup grupo) {
		for (Enumeration<AbstractButton> buttons = grupo.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				return button.getText();
			}
		}

		return null;
	}

	public int getModo() {
		return modo;
	}

	public void setModo(int modo) {
		this.modo = modo;
	}

	public JButton getBotonUnJugador() {
		return botonUnJugador;
	}

	public void setBotonUnJugador(JButton botonUnJugador) {
		this.botonUnJugador = botonUnJugador;
	}

	public JButton getBotonDosJugadores() {
		return botonDosJugadores;
	}

	public void setBotonDosJugadores(JButton botonDosJugadores) {
		this.botonDosJugadores = botonDosJugadores;
	}

	public BotonListener getBotonList() {
		return botonList;
	}

	public void setBotonList(BotonListener botonList) {
		this.botonList = botonList;
	}

	public JPanel getPanelUno() {
		return panelUno;
	}

	public void setPanelUno(JPanel panelUno) {
		this.panelUno = panelUno;
	}

	public JPanel getPanelDos() {
		return panelDos;
	}

	public void setPanelDos(JPanel panelDos) {
		this.panelDos = panelDos;
	}

	public JLabel getJ1() {
		return j1;
	}

	public void setJ1(JLabel j1) {
		this.j1 = j1;
	}

	public JLabel getCarroj1() {
		return carroj1;
	}

	public void setCarroj1(JLabel carroj1) {
		this.carroj1 = carroj1;
	}

	public JTextField getNombrej1() {
		return nombrej1;
	}

	public void setNombrej1(JTextField nombrej1) {
		this.nombrej1 = nombrej1;
	}

	public ButtonGroup getGrupoBotones1() {
		return grupoBotones1;
	}

	public void setGrupoBotones1(ButtonGroup grupoBotones1) {
		this.grupoBotones1 = grupoBotones1;
	}

	public JRadioButton getJ1boton1() {
		return j1boton1;
	}

	public void setJ1boton1(JRadioButton j1boton1) {
		this.j1boton1 = j1boton1;
	}

	public JRadioButton getJ1boton2() {
		return j1boton2;
	}

	public void setJ1boton2(JRadioButton j1boton2) {
		this.j1boton2 = j1boton2;
	}

	public JRadioButton getJ1boton3() {
		return j1boton3;
	}

	public void setJ1boton3(JRadioButton j1boton3) {
		this.j1boton3 = j1boton3;
	}

	public JRadioButton getJ1boton4() {
		return j1boton4;
	}

	public void setJ1boton4(JRadioButton j1boton4) {
		this.j1boton4 = j1boton4;
	}

	public JRadioButton getJ1boton5() {
		return j1boton5;
	}

	public void setJ1boton5(JRadioButton j1boton5) {
		this.j1boton5 = j1boton5;
	}

	public JRadioButton getJ1boton6() {
		return j1boton6;
	}

	public void setJ1boton6(JRadioButton j1boton6) {
		this.j1boton6 = j1boton6;
	}

	public JLabel getLimagen1() {
		return limagen1;
	}

	public void setLimagen1(JLabel limagen1) {
		this.limagen1 = limagen1;
	}

	public ImageIcon getImagen1() {
		return imagen1;
	}

	public void setImagen1(ImageIcon imagen1) {
		this.imagen1 = imagen1;
	}

	public JPanel getPbotones1() {
		return pbotones1;
	}

	public void setPbotones1(JPanel pbotones1) {
		this.pbotones1 = pbotones1;
	}

	public JLabel getJ2() {
		return j2;
	}

	public void setJ2(JLabel j2) {
		this.j2 = j2;
	}

	public JLabel getCarroj2() {
		return carroj2;
	}

	public void setCarroj2(JLabel carroj2) {
		this.carroj2 = carroj2;
	}

	public JTextField getNombrej2() {
		return nombrej2;
	}

	public void setNombrej2(JTextField nombrej2) {
		this.nombrej2 = nombrej2;
	}

	public ButtonGroup getGrupoBotones2() {
		return grupoBotones2;
	}

	public void setGrupoBotones2(ButtonGroup grupoBotones2) {
		this.grupoBotones2 = grupoBotones2;
	}

	public JRadioButton getJ2boton1() {
		return j2boton1;
	}

	public void setJ2boton1(JRadioButton j2boton1) {
		this.j2boton1 = j2boton1;
	}

	public JRadioButton getJ2boton2() {
		return j2boton2;
	}

	public void setJ2boton2(JRadioButton j2boton2) {
		this.j2boton2 = j2boton2;
	}

	public JRadioButton getJ2boton3() {
		return j2boton3;
	}

	public void setJ2boton3(JRadioButton j2boton3) {
		this.j2boton3 = j2boton3;
	}

	public JRadioButton getJ2boton4() {
		return j2boton4;
	}

	public void setJ2boton4(JRadioButton j2boton4) {
		this.j2boton4 = j2boton4;
	}

	public JRadioButton getJ2boton5() {
		return j2boton5;
	}

	public void setJ2boton5(JRadioButton j2boton5) {
		this.j2boton5 = j2boton5;
	}

	public JRadioButton getJ2boton6() {
		return j2boton6;
	}

	public void setJ2boton6(JRadioButton j2boton6) {
		this.j2boton6 = j2boton6;
	}

	public JLabel getLimagen2() {
		return limagen2;
	}

	public void setLimagen2(JLabel limagen2) {
		this.limagen2 = limagen2;
	}

	public ImageIcon getImagen2() {
		return imagen2;
	}

	public void setImagen2(ImageIcon imagen2) {
		this.imagen2 = imagen2;
	}

	public JPanel getPbotones2() {
		return pbotones2;
	}

	public void setPbotones2(JPanel pbotones2) {
		this.pbotones2 = pbotones2;
	}

	public Component getEspacio() {
		return espacio;
	}

	public void setEspacio(Component espacio) {
		this.espacio = espacio;
	}

	public JButton getBotonAtras() {
		return botonAtras;
	}

	public void setBotonAtras(JButton botonAtras) {
		this.botonAtras = botonAtras;
	}

	public JButton getBotonIniciar() {
		return botonIniciar;
	}

	public void setBotonIniciar(JButton botonIniciar) {
		this.botonIniciar = botonIniciar;
	}

}
