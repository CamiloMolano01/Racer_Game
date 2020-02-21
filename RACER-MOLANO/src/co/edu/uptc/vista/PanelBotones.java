package co.edu.uptc.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotones extends JPanel {

	private VentanaPrincipal vista;
	private JPanel panelFlechas;
	private JPanel panelOtrosBotones;

	private JPanel flowArriba;
	private JPanel flowAbajo;
	private JPanel boxDerecha;
	private JPanel boxIzquierda;
	
	private JPanel flowBotones;
	private JPanel boxBotonGrande;

	private JButton Farriba;
	private JButton Fabajo;
	private JButton Fizquierda;
	private JButton Fderecha;

	private ImageIcon Iarriba;
	private ImageIcon Iabajo;
	private ImageIcon Iderecha;
	private ImageIcon Iizquierda;
	private ImageIcon IbotonGrande;
	private ImageIcon Ipausa;
	private ImageIcon Isonido;
	private ImageIcon Isalir;

	private JButton botonGrande;
	private JButton pausa;
	private JButton sonido;
	private JButton salir;

	public PanelBotones(VentanaPrincipal vista) {
		this.vista = vista;
		setPreferredSize(new Dimension(470, 340));
		setBackground(new Color(0, 139, 107));
		setLayout(new BorderLayout());

		flowArriba = new JPanel();
		flowArriba.setLayout(new FlowLayout());
		flowArriba.setPreferredSize(new Dimension(100, 100));

		flowAbajo = new JPanel();
		flowAbajo.setLayout(new FlowLayout());
		flowAbajo.setPreferredSize(new Dimension(100, 60));

		boxDerecha = new JPanel();
		boxDerecha.setLayout(new BoxLayout(boxDerecha, BoxLayout.Y_AXIS));
		boxDerecha.setPreferredSize(new Dimension(125, 70));

		boxIzquierda = new JPanel();
		boxIzquierda.setLayout(new BoxLayout(boxIzquierda, BoxLayout.Y_AXIS));
		boxIzquierda.setPreferredSize(new Dimension(125, 70));

		panelFlechas = new JPanel();
		panelFlechas.setBackground(Color.BLACK);
		panelFlechas.setPreferredSize(new Dimension(250, 340));
		panelFlechas.setLayout(new BorderLayout());

		panelOtrosBotones = new JPanel();
		panelOtrosBotones.setBackground(Color.blue);
		panelOtrosBotones.setPreferredSize(new Dimension(220, 340));
		panelOtrosBotones.setLayout(new BorderLayout());
		
		flowBotones = new JPanel();
		flowBotones.setLayout(new FlowLayout());
		flowBotones.setPreferredSize(new Dimension(220, 80));
		
		boxBotonGrande = new JPanel();
		boxBotonGrande.setLayout(new BoxLayout(boxBotonGrande, BoxLayout.Y_AXIS));
		boxBotonGrande.setPreferredSize(new Dimension(220, 260));
		
		//Flechas----------------------------------------------------------------

		Farriba = new JButton();
		Fabajo = new JButton();
		Fderecha = new JButton();
		Fizquierda = new JButton();
		
		Iarriba = new ImageIcon("./imagenes/arriba.png");
		Farriba.setIcon(Iarriba);
		
		Iabajo = new ImageIcon("./imagenes/abajo.png");
		Fabajo.setIcon(Iabajo);
		
		Iderecha = new ImageIcon("./imagenes/derecha.png");
		Fderecha.setIcon(Iderecha);
		
		Iizquierda = new ImageIcon("./imagenes/izquierda.png");
		Fizquierda.setIcon(Iizquierda);
		

		Farriba.setPreferredSize(new Dimension(80,55));
		Farriba.setBorderPainted(false);
		Farriba.setOpaque(false);
		Farriba.setContentAreaFilled(false);
		Farriba.setFocusPainted(false);
		Farriba.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		Fabajo.setPreferredSize(new Dimension(80, 55));
		Fabajo.setBorderPainted(false);
		Fabajo.setOpaque(false);
		Fabajo.setContentAreaFilled(false);
		Fabajo.setFocusPainted(false);
		Fabajo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		Fderecha.setPreferredSize(new Dimension(55,55));
		Fderecha.setAlignmentX(CENTER_ALIGNMENT);
		Fderecha.setBorderPainted(false);
		Fderecha.setOpaque(false);
		Fderecha.setContentAreaFilled(false);
		Fderecha.setFocusPainted(false);
		Fderecha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		Fizquierda.setPreferredSize(new Dimension(55, 55));
		Fizquierda.setAlignmentX(CENTER_ALIGNMENT);
		Fizquierda.setBorderPainted(false);
		Fizquierda.setOpaque(false);
		Fizquierda.setContentAreaFilled(false);
		Fizquierda.setFocusPainted(false);
		Fizquierda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		flowArriba.add(Box.createRigidArea(new Dimension(-9, 125)));
		flowArriba.add(Farriba);
		
		flowAbajo.add(Fabajo);
		
		boxDerecha.add(Fderecha);

		boxIzquierda.add(Fizquierda);

		panelFlechas.add(flowArriba, BorderLayout.NORTH);
		panelFlechas.add(flowAbajo, BorderLayout.SOUTH);
		panelFlechas.add(boxIzquierda, BorderLayout.WEST);
		panelFlechas.add(boxDerecha, BorderLayout.EAST);
		
		//Otros Botones-------------------------------------------------------------
		
		botonGrande = new JButton();
		pausa = new JButton();
		sonido = new JButton();
		salir = new JButton();
		
		
		IbotonGrande = new ImageIcon("./imagenes/botonGrande.png");
		botonGrande.setIcon(IbotonGrande);
		botonGrande.setMaximumSize(new Dimension(120, 120));
		botonGrande.setBorderPainted(false);
		botonGrande.setOpaque(false);
		botonGrande.setContentAreaFilled(false);
		botonGrande.setFocusPainted(false);
		botonGrande.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonGrande.setActionCommand("run");
		botonGrande.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String h = e.getActionCommand();
				if(h.equals("run")) {
					vista.setIniciar(1);
					vista.repaint();
					vista.revalidate();
				}
				
			}
		});
		
		Ipausa = new ImageIcon("./imagenes/pausa.png");
		pausa.setIcon(Ipausa);
		pausa.setPreferredSize(new Dimension(32, 32));
		pausa.setBorderPainted(false);
		pausa.setOpaque(false);
		pausa.setContentAreaFilled(false);
		pausa.setFocusPainted(false);
		pausa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		Isalir = new ImageIcon("./imagenes/salir.png");
		salir.setIcon(Isalir);
		salir.setPreferredSize(new Dimension(32,32));
		salir.setBorderPainted(false);
		salir.setOpaque(false);
		salir.setContentAreaFilled(false);
		salir.setFocusPainted(false);
		salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		Isonido = new ImageIcon("./imagenes/sonido.png");
		sonido.setIcon(Isonido);
		sonido.setPreferredSize(new Dimension(32,32));
		sonido.setBorderPainted(false);
		sonido.setOpaque(false);
		sonido.setContentAreaFilled(false);
		sonido.setFocusPainted(false);
		sonido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		boxBotonGrande.add(Box.createRigidArea(new Dimension(40, 10)));
		boxBotonGrande.add(botonGrande);
		
		flowBotones.add(pausa);
		flowBotones.add(Box.createRigidArea(new Dimension(15, 0)));
		flowBotones.add(sonido);
		flowBotones.add(Box.createRigidArea(new Dimension(15, 0)));
		flowBotones.add(salir);
		
		panelOtrosBotones.add(flowBotones, BorderLayout.NORTH);
		panelOtrosBotones.add(boxBotonGrande, BorderLayout.CENTER);
		
		//--------------------------------------------------

		add(panelFlechas, BorderLayout.CENTER);
		add(panelOtrosBotones, BorderLayout.EAST);

	}

}
