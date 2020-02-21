package co.edu.uptc.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class BotonListener implements ActionListener {

	private Selector vista;

	public BotonListener(Selector vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String b = e.getActionCommand();

		if (b.equals("unJugador")) {
			vista.setModo(1);
			vista.Unjugador();
			actualizar();
		}

		if (b.equals("dosJugadores")) {
			vista.setModo(2);
			vista.DosJugadores();
			actualizar();
		}

		if (b.equals("atras")) {
			vista.modos();
			actualizar();
		}

		if (b.equals("iniciar")) {
			
			String nombre1 = vista.getNombrej1().getText();
			VentanaPrincipal v;
			if (vista.getModo() == 1) {
				if (nombre1.length() > 0 && vista.getSelectedButtonText(vista.getGrupoBotones1()) != null) {
					int carro1 = Integer.parseInt(vista.getSelectedButtonText(vista.getGrupoBotones1()));
					try {
						v = new VentanaPrincipal(nombre1, "", carro1, 0, 1);
						Thread hilo2 = new Thread() {
							public void run() {
								try {
									vista.dispose();
									v.getPanelPantalla().getTiempo().stop();
									Thread.sleep(1000);
									v.getPanelPantalla().getTiempo().start();
									v.getPanelPantalla().modoSolo();

								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						};
						hilo2.start();
					} catch (InterruptedException e1) {

						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debe escribir un nombre y elegir un auto", "ERROR",
							JOptionPane.WARNING_MESSAGE);
				}

			} else if (vista.getModo() == 2) {
				String nombre2 = vista.getNombrej2().getText();

				if ((nombre2.length() > 0 && vista.getSelectedButtonText(vista.getGrupoBotones2()) != null
						&& nombre1.length() > 0 && vista.getSelectedButtonText(vista.getGrupoBotones1()) != null)) {
					int carro2 = Integer.parseInt(vista.getSelectedButtonText(vista.getGrupoBotones2()));
					int carro1 = Integer.parseInt(vista.getSelectedButtonText(vista.getGrupoBotones1()));
					try {
						v = new VentanaPrincipal(nombre1, nombre2, carro1, carro2, 2);
						Thread hilo2 = new Thread() {
							public void run() {
								try {
									vista.dispose();
									v.getPanelPantalla().getTiempo().stop();
									Thread.sleep(1000);
									v.getPanelPantalla().getTiempo().start();
									v.getPanelPantalla().modoSolo();

								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						};
						hilo2.start();
					} catch (InterruptedException e1) {

						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debe escribir un nombre y elegir un auto", "ERROR",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		}

	}

	public void actualizar() {
		vista.repaint();
		vista.revalidate();
	}

}
