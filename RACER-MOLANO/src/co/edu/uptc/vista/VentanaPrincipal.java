package co.edu.uptc.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

	private PanelPantalla panelPantalla;
	private PanelBotones panelBotones;
	private int iniciar = 0;
	private int seguir = 0;

	public VentanaPrincipal(String nombre1, String nombre2, int carro1, int carro2, int modo) throws InterruptedException {
		inicializador(nombre1, nombre2, carro1, carro2, modo);
	}

	public void inicializador(String nombre1, String nombre2, int carro1, int carro2, int modo) throws InterruptedException {
		setSize(470, 710);
		setResizable(false);
		setLayout(new BorderLayout());

		panelPantalla = new PanelPantalla(this, nombre1, nombre2, carro1, carro2, modo);
		panelBotones = new PanelBotones(this);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(panelBotones, BorderLayout.CENTER);
		add(panelPantalla, BorderLayout.NORTH);

		setVisible(true);
	}




	public PanelPantalla getPanelPantalla() {
		return panelPantalla;
	}

	public void setPanelPantalla(PanelPantalla panelPantalla) {
		this.panelPantalla = panelPantalla;
	}

	public PanelBotones getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(PanelBotones panelBotones) {
		this.panelBotones = panelBotones;
	}

	public int getIniciar() {
		return iniciar;
	}

	public void setIniciar(int iniciar) {
		this.iniciar = iniciar;
	}

}
