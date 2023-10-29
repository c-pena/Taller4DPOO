package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.Tablero;
import modelo.Top10;

public class PanelJava2D extends JPanel implements MouseListener{
    
    private static Tablero tablero;
    private static Top10 top10;

    public PanelJava2D() {
        setBackground(Color.WHITE);
        setOpaque(false);
        addMouseListener(this);
        top10 = VentanaPrincipal.getTop10();
        PanelJava2D.tablero = new Tablero(VentanaPrincipal.getTamano());
        tablero.desordenar(VentanaPrincipal.getDificultad()*VentanaPrincipal.getTamano());
        repaint();
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int ancho = this.getWidth();
        int alto = this.getHeight();
        int anchoRec = ancho/tablero.darTablero().length;
        int altoRec = alto/tablero.darTablero().length;
        String workingDir = System.getProperty("user.dir");
        String filePath = workingDir + File.separator + "data" + File.separator + "luz.png";
        for (int i = 0; i < tablero.darTablero().length; i++) {
            for (int j = 0; j < tablero.darTablero().length; j++) {
                Rectangle2D.Double rect = new Rectangle2D.Double(i*anchoRec,j*altoRec,anchoRec,altoRec);
                if(tablero.darTablero()[i][j] == true) {
                    g.setColor(Color.YELLOW);
                    g2d.fill(rect);
                    g.setColor(Color.BLACK);
                    try {
                        BufferedImage image = ImageIO.read(new File(filePath));
                        g2d.drawImage(image,i*anchoRec,j*altoRec,anchoRec,altoRec,null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    g.setColor(Color.LIGHT_GRAY);
                    g2d.fill(rect);
                    g.setColor(Color.BLACK);
                }
                g2d.draw(rect);
            }
        }
    }

    private int[] convertirCoordenadasACasilla(int x, int y) {
        int ladoTablero = tablero.darTablero().length;
        int altoPanelTablero = getHeight();
        int anchoPanelTablero = getWidth();
        int altoCasilla = altoPanelTablero / ladoTablero;
        int anchoCasilla = anchoPanelTablero / ladoTablero;
        int fila = (int) (y / altoCasilla);
        int columna = (int) (x / anchoCasilla);
        return new int[] { fila, columna };
    }

    public static void reiniciarTablero() {
        tablero.reiniciar();
        PanelEstado.setJugadas(tablero.darJugadas());
        VentanaPrincipal.repaintVentanaPrincipal();
    }

    public static void nuevoTablero() {
        tablero = new Tablero(VentanaPrincipal.getTamano());
        tablero.desordenar(VentanaPrincipal.getDificultad()*VentanaPrincipal.getTamano());
        PanelEstado.setJugadas(tablero.darJugadas());
        VentanaPrincipal.repaintVentanaPrincipal();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int click_x = e.getX();
        int click_y = e.getY();
        int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
        tablero.jugar(casilla[1], casilla[0]);
        PanelEstado.setJugadas(tablero.darJugadas());
        VentanaPrincipal.repaintVentanaPrincipal();
        repaint();
        Boolean estado = tablero.tableroIluminado();
        if (estado) {
            Integer puntaje = tablero.calcularPuntaje();
            Boolean esTop10 = top10.esTop10(puntaje);
            String nombre = VentanaPrincipal.getNombreJugador();
            if (esTop10) {
                top10.agregarRegistro(nombre, puntaje);
                System.out.println("Puntaje guardado en top 10");
            }
            String titulo = "Ganaste " + nombre + "! Tu puntaje final fue: " + puntaje;
            JDialog gano = new JDialog((JFrame) getTopLevelAncestor(),titulo);
            gano.setLocationRelativeTo(getTopLevelAncestor());
            gano.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            gano.setSize(480, 30);
            gano.setVisible(true);
            nuevoTablero();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    
}
