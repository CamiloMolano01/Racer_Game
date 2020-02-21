package co.edu.uptc.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;

import javax.sound.midi.ControllerEventListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelPantalla extends JPanel implements ActionListener, KeyListener {

	private VentanaPrincipal vista;
	private JPanel infoJuego;
	private JPanel pantalla;
	private boolean titila1;
	private boolean titila2;

	private ImageIcon Icarro;
	private ImageIcon Icarro2;
	private JLabel puntos;
	private Font letraJuegos;
	private Font letraGoogle;
	private boolean pausa;
	private int pausar;

	private Timer tiempo;
	private int x = 250;
	private int y = 350;
	private int x2 = 120;
	private int y2 = 350;
	private int yVia = 30;
	private double velX = 0;
	private double velY = 0;
	private double velX2 = 0;
	private double velY2 = 0;
	private int numeroOponente;
	private int score;
	private int vidas;
	private boolean finalizo;
	private String imageLoc[];
	private int lx[];
	private int ly[];
	private int speedOpponent[];
	private int modo;
	private int auto1;
	private String nombre1;
	private int auto2;
	private String nombre2;
	private int algo;

	public PanelPantalla(VentanaPrincipal vista, String nombre1, String nombre2, int auto1, int auto2, int modo)
			throws InterruptedException {
		tiempo = new Timer(17, this);
		tiempo.start();
		this.vista = vista;
		this.modo = modo;
		this.auto1 = auto1;
		this.nombre1 = nombre1;
		this.auto2 = auto2;
		this.nombre2 = nombre2;
		pausar = 0;	
		algo = 0;
		titila1 = false;
		titila2 = false;
		pausa = false;
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(340, 460));
		setMaximumSize(new Dimension(340, 460));

		letraJuegos = new Font("Karmatic Arcade", Font.PLAIN, 15);
		letraGoogle = new Font("Open Sans", Font.PLAIN, 12);
		if (modo == 2) {
			vidas = 6;
		} else {
			vidas = 3;
		}

		numeroOponente = 0;
		score = 0;
		finalizo = false;
		lx = new int[20];
		ly = new int[20];
		imageLoc = new String[20];
		speedOpponent = new int[20];

		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);

	}

	public void paint(Graphics g) {
		super.paint(g);
		
		/*if(algo == 0) {
			algo++;
			ready(g, algo, Color.RED);
			
		}if(algo == 1) {
			algo++;
			ready(g, algo, Color.YELLOW);
			
		}if(algo == 2) {
			algo++;
			ready(g, algo, Color.GREEN);
		}*/
		
		
		if (modo == 2) {
			Icarro = new ImageIcon("./imagenes/auto" + auto1 + ".png");
			Icarro2 = new ImageIcon("./imagenes/auto" + auto2 + ".png");
		} else {
			Icarro = new ImageIcon("./imagenes/auto" + auto1 + ".png");
		}

		Thread hilo = new Thread() {
			public void run() {
				try {

					if (titila1) {
						Icarro = new ImageIcon("./imagenes/auto" + auto1 + "t" + ".png");
						Thread.sleep(150);
						Icarro = new ImageIcon("./imagenes/auto" + auto1 + ".png");
						Thread.sleep(150);
						Icarro = new ImageIcon("./imagenes/auto" + auto1 + "t" + ".png");
						Thread.sleep(150);
						Icarro = new ImageIcon("./imagenes/auto" + auto1 + ".png");
						Thread.sleep(150);
						Icarro = new ImageIcon("./imagenes/auto" + auto1 + "t" + ".png");
						Thread.sleep(150);
						Icarro = new ImageIcon("./imagenes/auto" + auto1 + ".png");
						Thread.sleep(150);
						Icarro = new ImageIcon("./imagenes/auto" + auto1 + "t" + ".png");
						Thread.sleep(150);
						Icarro = new ImageIcon("./imagenes/auto" + auto1 + ".png");
						Thread.sleep(150);

						titila1 = false;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		hilo.start();

		Thread hilo2 = new Thread() {
			public void run() {
				try {

					if (titila2) {
						Icarro2 = new ImageIcon("./imagenes/auto" + auto2 + "t" + ".png");
						Thread.sleep(150);
						Icarro2 = new ImageIcon("./imagenes/auto" + auto2 + ".png");
						Thread.sleep(150);
						Icarro2 = new ImageIcon("./imagenes/auto" + auto2 + "t" + ".png");
						Thread.sleep(150);
						Icarro2 = new ImageIcon("./imagenes/auto" + auto2 + ".png");
						Thread.sleep(150);
						Icarro2 = new ImageIcon("./imagenes/auto" + auto2 + "t" + ".png");
						Thread.sleep(150);
						Icarro2 = new ImageIcon("./imagenes/auto" + auto2 + ".png");
						Thread.sleep(150);
						Icarro2 = new ImageIcon("./imagenes/auto" + auto2 + "t" + ".png");
						Thread.sleep(150);
						Icarro2 = new ImageIcon("./imagenes/auto" + auto2 + ".png");
						Thread.sleep(150);
						titila2 = false;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		hilo2.start();

		Image img = Icarro.getImage();

		ImageIcon Icorazon = new ImageIcon("./imagenes/corazon.png");
		Image imgC = Icorazon.getImage();

		ImageIcon IcorazonNegro = new ImageIcon("./imagenes/corazonNegro.png");
		Image imgR = IcorazonNegro.getImage();

		Graphics2D obj = (Graphics2D) g;
		obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		try {
			corazones(imgC, imgR, g);
			hacerPista(g);
			hacerLineas(g);
			
			if (yVia > 360) {
				hacerLineas(g);
			}

			obj.drawImage(img, x, y, this);
			if (modo == 2) {
				Image img2 = Icarro2.getImage();
				obj.drawImage(img2, x2, y2, this);
			}

			if (numeroOponente > 0) {
				for (int i = 0; i < numeroOponente; i++) {
					obj.drawImage(getToolkit().getImage(imageLoc[i]), lx[i], ly[i], this);
				}
			}

			
			
			if(finalizo) {
				finish(g);
				if(modo == 2) {
					Icarro = new ImageIcon("./imagenes/auto" + auto1 + "t" + ".png");
					Icarro2 = new ImageIcon("./imagenes/auto" + auto2 + "t" + ".png");
				}else {
					Icarro = new ImageIcon("./imagenes/auto" + auto1 + "t" + ".png");
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void hacerPista(Graphics g) {
		g.setColor(new Color(100, 219, 120));
		g.fillRect(0, 0, 340, 460);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(30, 0, 280, 460);
		g.setFont(letraJuegos);
		g.setColor(Color.black);
		g.drawString("PUNTUACION:", 340, 20);
		g.setFont(letraJuegos);
		g.setColor(Color.black);
		g.drawString(puntaje(), 360, 40);
		g.setFont(letraGoogle);
		g.setColor(Color.black);
		g.drawString(nombre1, x - 5, y);
		g.drawString(nombre2, x2 - 5, y2);
	}

	public void corazones(Image imgC, Image imgR, Graphics g) {
		if (vidas == 6) {
			g.drawImage(imgC, 345, 60, this);
			g.drawImage(imgC, 385, 60, this);
			g.drawImage(imgC, 425, 60, this);
			g.drawImage(imgC, 345, 100, this);
			g.drawImage(imgC, 385, 100, this);
			g.drawImage(imgC, 425, 100, this);
		} else if (vidas == 5) {
			g.drawImage(imgC, 345, 60, this);
			g.drawImage(imgC, 385, 60, this);
			g.drawImage(imgC, 425, 60, this);
			g.drawImage(imgC, 345, 100, this);
			g.drawImage(imgC, 385, 100, this);
			g.drawImage(imgR, 425, 100, this);
		} else if (vidas == 4) {
			g.drawImage(imgC, 345, 60, this);
			g.drawImage(imgC, 385, 60, this);
			g.drawImage(imgC, 425, 60, this);
			g.drawImage(imgC, 345, 100, this);
			g.drawImage(imgR, 385, 100, this);
			g.drawImage(imgR, 425, 100, this);
		} else if (vidas == 3) {
			g.drawImage(imgC, 345, 60, this);
			g.drawImage(imgC, 385, 60, this);
			g.drawImage(imgC, 425, 60, this);
			g.drawImage(imgR, 345, 100, this);
			g.drawImage(imgR, 385, 100, this);
			g.drawImage(imgR, 425, 100, this);
		} else if (vidas == 2) {
			g.drawImage(imgC, 345, 60, this);
			g.drawImage(imgC, 385, 60, this);
			g.drawImage(imgR, 425, 60, this);
			g.drawImage(imgR, 345, 100, this);
			g.drawImage(imgR, 385, 100, this);
			g.drawImage(imgR, 425, 100, this);
		} else if (vidas == 1) {
			g.drawImage(imgC, 345, 60, this);
			g.drawImage(imgR, 385, 60, this);
			g.drawImage(imgR, 425, 60, this);
			g.drawImage(imgR, 345, 100, this);
			g.drawImage(imgR, 385, 100, this);
			g.drawImage(imgR, 425, 100, this);
		} else {
			g.drawImage(imgR, 345, 60, this);
			g.drawImage(imgR, 385, 60, this);
			g.drawImage(imgR, 425, 60, this);
			g.drawImage(imgR, 345, 100, this);
			g.drawImage(imgR, 385, 100, this);
			g.drawImage(imgR, 425, 100, this);
		}

	}

	public void hacerLineas(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(170, yVia - 90, 8, 50);

		g.setColor(Color.WHITE);
		g.fillRect(170, yVia, 8, 50);

		g.setColor(Color.WHITE);
		g.fillRect(170, yVia + 90, 8, 50);

		g.setColor(Color.WHITE);
		g.fillRect(170, yVia + 180, 8, 50);

		g.setColor(Color.WHITE);
		g.fillRect(170, yVia + 270, 8, 50);

		g.setColor(Color.WHITE);
		g.fillRect(170, yVia + 360, 8, 50);

		g.setColor(Color.YELLOW);
		g.fillRect(35, yVia - 90, 5, 550);

		g.setColor(Color.YELLOW);
		g.fillRect(300, yVia - 90, 5, 550);

	}

	public void moverCamino(int count) throws InterruptedException {
		if (speedOpponent[numeroOponente] == 5) {
			yVia += 5;
		} else if (speedOpponent[numeroOponente] == 4) {
			yVia += 4;
		} else if (speedOpponent[numeroOponente] == 3) {
			yVia += 3;
		}  else if (speedOpponent[numeroOponente] == 2) {
			yVia += 2;
		}else {
			yVia++;
		}

		if (yVia > 90) {
			yVia = 0;
		}

		for (int i = 0; i < numeroOponente; i++) {
			ly[i] += speedOpponent[i];
		}

		int index[] = new int[numeroOponente];
		for (int i = 0; i < numeroOponente; i++) {
			if (ly[i] <= 460) {
				index[i] = 1;
			}
		}
		int c = 0;
		for (int i = 0; i < numeroOponente; i++) {
			if (index[i] == 1) {
				imageLoc[c] = imageLoc[i];
				lx[c] = lx[i];
				ly[c] = ly[i];
				speedOpponent[c] = speedOpponent[i];
				c++;
			}
		}
		
		if(vidas> 0) {
			score += numeroOponente - c;
		}
		

		numeroOponente = c;

		int diferencia;
		for (int i = 0; i < numeroOponente; i++) {
			diferencia = y - ly[i];
			if (titila1 == false) {
				if ((lx[i] >= x && lx[i] <= x + 25) || (lx[i] + 25 >= x && lx[i] + 25 <= x + 25)) {
					if ((y + 55 >= ly[i] && !(y >= ly[i] + 55))) {
						vidas--;
						if (vidas > 0) {
							try {
								Thread.sleep(100);
								titila1 = true;
							} catch (InterruptedException e) {

								e.printStackTrace();
							}
							break;
						} else {
							finalizo = true;
							tiempo.stop();
						}
					}
				}
			} else {

			}
			if (modo == 2) {
				if (titila2 == false) {
					if ((lx[i] >= x2 && lx[i] <= x2 + 25) || (lx[i] + 25 >= x2 && lx[i] + 25 <= x2 + 25)) {
						if (y2 + 55 >= ly[i] && !(y2 >= ly[i] + 55)) {
							vidas--;
							if (vidas > 0) {
								try {
									Thread.sleep(100);
									titila2 = true;
								} catch (InterruptedException e) {

									e.printStackTrace();
								}
								break;
							} else {
								finalizo = true;
								tiempo.stop();
								
							}
						}
					}

				}
			}

		}
	}

	public void finish(Graphics  g) {
		Graphics2D g2D;
	    g2D = (Graphics2D) g;
	    g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		FontRenderContext frc = g2D.getFontRenderContext();
		Font font1 = new Font("Karmatic Arcade", Font.BOLD, 24);
	    String str1 = new String("GAME OVER");
	    TextLayout tl = new TextLayout(str1, font1, frc);
	    g2D.setColor(Color.RED);
	    tl.draw(g2D, 80, 150);
		
		repaint();
		revalidate();
	}
	
	public void ready(Graphics  g, int num, Color color) {
		Graphics2D g2D;
	    g2D = (Graphics2D) g;
	    g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		FontRenderContext frc = g2D.getFontRenderContext();
		Font font1 = new Font("Karmatic Arcade", Font.BOLD, 24);
	    String str1 = new String("" + num);
	    TextLayout tl = new TextLayout(str1, font1, frc);
	    g2D.setColor(color);
	    tl.draw(g2D, 80, 150);
		
		repaint();
		revalidate();
	}

	public String puntaje() {
		String puntaje;
		if (score < 10) {
			puntaje = "00000";
		} else if (score < 100) {
			puntaje = "0000";
		} else if (score < 1000) {
			puntaje = "000";
		} else if (score < 10000) {
			puntaje = "00";
		} else if (score < 100000) {
			puntaje = "0";
		} else {
			puntaje = "";
		}
		String puntaje1 = puntaje + score;

		return puntaje1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (modo == 2) {
			if ((x + velX < getSize().getWidth() - 190 && x + velX > 180 && y + velY > -1
					&& y + velY < getSize().getHeight() - 60)
					&& (x2 + velX2 < getSize().getWidth() - 320 && x2 + velX2 > 40 && y2 + velY2 > -1
							&& y2 + velY2 < getSize().getHeight() - 60)) {
				x = (int) (x + velX);
				y = (int) (y + velY);
				x2 = (int) (x2 + velX2);
				y2 = (int) (y2 + velY2);
			} else {
				velX = 0;
				velY = 0;
				velX2 = 0;
				velY2 = 0;
			}
		} else {
			if ((x + velX < getSize().getWidth() - 190 && x + velX > 40&& y + velY > -1
					&& y + velY < getSize().getHeight() - 60)) {
				x = (int) (x + velX);
				y = (int) (y + velY);

			} else {
				velX = 0;
				velY = 0;

			}
		}

		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int b = e.getKeyCode();

		if (modo == 2) {
			if (b == KeyEvent.VK_A) {

				if (velX2 > -4) {
					velX2 -= 2;
				}
				if (velX2 < -4 && velX2 > -6) {
					velX2--;
				}

			}

			if (b == KeyEvent.VK_D) {
				if (velX2 < 4) {
					velX2 += 2;
				}
				if (velX2 > 4 && velX2 < 6) {
					velX2++;
				}
			}

			if (b == KeyEvent.VK_W) {
				if (velY2 > -4) {
					velY2 -= 2;
				}
				if (velY2 < -4 && velY2 > -6) {
					velY2--;
				}

			}

			if (b == KeyEvent.VK_S) {
				velY2 += 3;
			}

		}
		if (b == KeyEvent.VK_LEFT) {
			if (velX > -4) {
				velX -= 2;
			}
			if (velX < -4 && velX > -6) {
				velX--;
			}
		}
		if (b == KeyEvent.VK_RIGHT) {
			if (velX < 4) {
				velX += 2;
			}
			if (velX > 4 && velX < 6) {
				velX++;
			}
		}

		if (b == KeyEvent.VK_UP) {
			if (velY > -4) {
				velY -= 2;
			}
			if (velY < -4 && velY > -6) {
				velY--;
			}
		}

		if (b == KeyEvent.VK_DOWN) {
			velY += 3;
		}

		if (b == KeyEvent.VK_SPACE) {

			if (pausa) {
				tiempo.start();
				pausar = 0;

				pausa = false;
			} else {
				tiempo.stop();

				pausar = 1;

				pausa = true;
			}

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int b = e.getKeyCode();

		if (modo == 2) {
			if (b == KeyEvent.VK_A) {
				velX2 = 0;
			}
			if (b == KeyEvent.VK_D) {
				velX2 = 0;
			}
			if (b == KeyEvent.VK_W) {
				velY2 = 0;

			}
			if (b == KeyEvent.VK_S) {
				velY2 = 0;

			}
		}

		if (b == KeyEvent.VK_LEFT) {
			velX = 0;
		}
		if (b == KeyEvent.VK_RIGHT) {
			velX = 0;
		}
		if (b == KeyEvent.VK_UP) {
			velY = 0;

		}
		if (b == KeyEvent.VK_DOWN) {
			velY = 0;

		}
	}

	public void modoSolo() throws InterruptedException {
		int count = 1, c = 1;
		while (true) {
			moverCamino(count);
			while (c <= 1) {
				repaint();
				try {
					Thread.sleep(6);
				} catch (Exception e) {
					System.out.println(e);
				}
				c++;
			}
			c = 1;
			count++;
			if (numeroOponente < 6 && count % 200 == 0) {
				imageLoc[numeroOponente] = "./imagenes/oponente" + ((int) ((Math.random() * 100) % 6) + 1) + ".png";

				ly[numeroOponente] = -120;

				int p = (int) (Math.random() * 100) % 6;
				if (p == 0) {
					p = 270;
				} else if (p == 1) {
					p = 230;
				} else if (p == 2) {
					p = 180;
				} else if (p == 3) {
					p = 140;
				} else if (p == 4) {
					p = 90;
				} else {
					p = 40;
				}
				lx[numeroOponente] = p;
				if (score < 20) {
					speedOpponent[numeroOponente] = 1;
				} else if (score < 50) {
					speedOpponent[numeroOponente] = 2;
				} else if (score < 100) {
					speedOpponent[numeroOponente] = 3;
				}else if (score < 150) {
					speedOpponent[numeroOponente] = 4;
				} else {
					speedOpponent[numeroOponente] = 5;
				}
				numeroOponente++;
			}
		}

	}

	public Timer getTiempo() {
		return tiempo;
	}

	public void setTiempo(Timer tiempo) {
		this.tiempo = tiempo;
	}

}
