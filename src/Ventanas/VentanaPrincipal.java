package Ventanas;

import Clases.Algoritmo_Dijkstra;
import Clases.Algoritmo_Prim;
import Clases.Arboles;
import Clases.Pintar;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class VentanaPrincipal extends JFrame {
  Pintar pintar = new Pintar();
  
  Arboles arboles = new Arboles();
  
  private int tope;
  
  private int nodoFin;
  
  private int permanente;
  
  int n;
  
  int nn;
  
  int id;
  
  int id2;
  
  private int aristaMayor;
  
  private JButton jButton1;
  
  private JButton jButton10;
  
  private JButton jButton11;
  
  private JButton jButton12;
  
  private JButton jButton13;
  
  private JButton jButton14;
  
  private JButton jButton2;
  
  private JButton jButton3;
  
  private JButton jButton4;
  
  private JButton jButton5;
  
  private JButton jButton6;
  
  private JButton jButton7;
  
  private JButton jButton8;
  
  private JButton jButton9;
  
  private JDialog jDialog1;
  
  private JFileChooser jFileChooser2;
  
  private JLabel jLabel1;
  
  private JLabel jLabel2;
  
  private JLabel jLabel3;
  
  private JMenu jMenu1;
  
  private JMenu jMenu2;
  
  private JMenu jMenu3;
  
  private JMenuBar jMenuBar1;
  
  private JMenuItem jMenuItem1;
  
  private JMenuItem jMenuItem10;
  
  private JMenuItem jMenuItem11;
  
  private JMenuItem jMenuItem12;
  
  private JMenuItem jMenuItem13;
  
  private JMenuItem jMenuItem2;
  
  private JMenuItem jMenuItem3;
  
  private JMenuItem jMenuItem4;
  
  private JMenuItem jMenuItem5;
  
  private JMenuItem jMenuItem6;
  
  private JMenuItem jMenuItem7;
  
  private JMenuItem jMenuItem8;
  
  private JMenuItem jMenuItem9;
  
  public static JPanel jPanel1;
  
  private JPanel jPanel2;
  
  private JPanel jPanel3;
  
  private JPopupMenu.Separator jSeparator1;
  
  private JPopupMenu.Separator jSeparator2;
  
  private JPopupMenu.Separator jSeparator3;
  
  private JPopupMenu.Separator jSeparator4;
  
  private JPopupMenu.Separator jSeparator5;
  
  private JLabel jmapa;
  
  private JTextField jtacumulado;
  
  public static void R_repaint(int tope, Arboles arboles) {
    int j;
    for (j = 0; j < tope; j++) {
      for (int k = 0; k < tope; k++) {
        if (arboles.getmAdyacencia(j, k) == 1)
          Pintar.pintarLinea(jPanel1.getGraphics(), arboles.getCordeX(j), arboles.getCordeY(j), arboles.getCordeX(k), arboles.getCordeY(k), arboles.getmCoeficiente(j, k)); 
      } 
    } 
    for (j = 0; j < tope; j++)
      Pintar.pintarCirculo(jPanel1.getGraphics(), arboles.getCordeX(j), arboles.getCordeY(j), String.valueOf(arboles.getNombre(j))); 
  }
  
  public static int ingresarNodoOrigen(String nodoOrige, String noExiste, int tope) {
    int nodoOrigen = 0;
    try {
      nodoOrigen = Integer.parseInt(JOptionPane.showInputDialog("" + nodoOrige));
      if (nodoOrigen >= tope) {
        JOptionPane.showMessageDialog(null, "" + noExiste + "\nDebe de ingresar  un Nodo existente");
        nodoOrigen = ingresarNodoOrigen(nodoOrige, noExiste, tope);
      } 
    } catch (Exception ex) {
      nodoOrigen = ingresarNodoOrigen(nodoOrige, noExiste, tope);
    } 
    return nodoOrigen;
  }
  
  public int ingresarTamano(String tama) {
    int tamano = 0;
    try {
      tamano = Integer.parseInt(JOptionPane.showInputDialog("" + tama));
      if (tamano < 1) {
        JOptionPane.showMessageDialog(null, "Debe Ingresar un TamaAceptado..");
        tamano = ingresarTamano(tama);
      } 
    } catch (Exception ex) {
      tamano = ingresarTamano(tama);
    } 
    return tamano;
  }
  
  public boolean cicDerechoSobreNodo(int xxx, int yyy) {
    for (int j = 0; j < this.tope; j++) {
      if (xxx + 2 > this.arboles.getCordeX(j) && xxx < this.arboles.getCordeX(j) + 13 && yyy + 2 > this.arboles.getCordeY(j) && yyy < this.arboles.getCordeY(j) + 13) {
        if (this.n == 0) {
          this.id = j;
          R_repaint(this.tope, this.arboles);
          Pintar.clickSobreNodo(jPanel1.getGraphics(), this.arboles.getCordeX(j), this.arboles.getCordeY(j), null, Color.orange);
          this.n++;
        } else {
          this.id2 = j;
          this.n++;
          Pintar.clickSobreNodo(jPanel1.getGraphics(), this.arboles.getCordeX(j), this.arboles.getCordeY(j), null, Color.orange);
          if (this.id == this.id2) {
            this.n = 0;
            Pintar.pintarCirculo(jPanel1.getGraphics(), this.arboles.getCordeX(this.id), this.arboles.getCordeY(this.id), String.valueOf(this.arboles.getNombre(this.id)));
            this.id = -1;
            this.id2 = -1;
          } 
        } 
        this.nn = 0;
        return true;
      } 
    } 
    return false;
  }
  
  public void clicIzqSobreNodo(int xxx, int yyy) {
    for (int j = 0; j < this.tope; j++) {
      if (xxx + 2 > this.arboles.getCordeX(j) && xxx < this.arboles.getCordeX(j) + 13 && yyy + 2 > this.arboles.getCordeY(j) && yyy < this.arboles.getCordeY(j) + 13) {
        if (this.nn == 0) {
          this.permanente = j;
          R_repaint(this.tope, this.arboles);
        } else {
          this.nodoFin = j;
        } 
        this.nn++;
        this.n = 0;
        this.id = -1;
        Pintar.clickSobreNodo(jPanel1.getGraphics(), this.arboles.getCordeX(j), this.arboles.getCordeY(j), null, Color.GREEN);
        break;
      } 
    } 
  }
  
  public void adactarImagen(File file) {
    try {
      BufferedImage read = ImageIO.read(file);
      Image scaledInstance = read.getScaledInstance(this.jmapa.getWidth(), this.jmapa.getHeight(), 1);
      this.jmapa.setIcon(new ImageIcon(scaledInstance));
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, "Error al cargar la imagen");
    } 
  }
  
  private void initComponents() {
    this.jDialog1 = new JDialog();
    this.jFileChooser2 = new JFileChooser();
    jPanel1 = new JPanel();
    this.jmapa = new JLabel();
    this.jButton1 = new JButton();
    this.jPanel2 = new JPanel();
    this.jButton2 = new JButton();
    this.jButton3 = new JButton();
    this.jButton4 = new JButton();
    this.jButton5 = new JButton();
    this.jButton6 = new JButton();
    this.jButton7 = new JButton();
    this.jButton8 = new JButton();
    this.jButton9 = new JButton();
    this.jButton10 = new JButton();
    this.jButton11 = new JButton();
    this.jButton12 = new JButton();
    this.jButton13 = new JButton();
    this.jButton14 = new JButton();
    this.jLabel1 = new JLabel();
    this.jPanel3 = new JPanel();
    this.jtacumulado = new JTextField();
    this.jLabel2 = new JLabel();
    this.jLabel3 = new JLabel();
    this.jMenuBar1 = new JMenuBar();
    this.jMenu1 = new JMenu();
    this.jSeparator1 = new JPopupMenu.Separator();
    this.jMenuItem13 = new JMenuItem();
    this.jMenuItem3 = new JMenuItem();
    this.jSeparator3 = new JPopupMenu.Separator();
    this.jMenuItem2 = new JMenuItem();
    this.jSeparator2 = new JPopupMenu.Separator();
    this.jMenuItem5 = new JMenuItem();
    this.jMenuItem7 = new JMenuItem();
    this.jSeparator4 = new JPopupMenu.Separator();
    this.jMenuItem4 = new JMenuItem();
    this.jMenuItem6 = new JMenuItem();
    this.jMenuItem1 = new JMenuItem();
    this.jSeparator5 = new JPopupMenu.Separator();
    this.jMenuItem8 = new JMenuItem();
    this.jMenu2 = new JMenu();
    this.jMenuItem10 = new JMenuItem();
    this.jMenuItem9 = new JMenuItem();
    this.jMenuItem11 = new JMenuItem();
    this.jMenu3 = new JMenu();
    this.jMenuItem12 = new JMenuItem();
    this.jDialog1.setMinimumSize(new Dimension(700, 450));
    this.jDialog1.setResizable(false);
    this.jDialog1.getContentPane().setLayout((LayoutManager)null);
    this.jFileChooser2.setMaximumSize(new Dimension(21475, 21474));
    this.jFileChooser2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaPrincipal.this.jFileChooser2ActionPerformed(evt);
          }
        });
    this.jDialog1.getContentPane().add(this.jFileChooser2);
    this.jFileChooser2.setBounds(10, 20, 670, 390);
    setDefaultCloseOperation(3);
    setTitle(":::::::::Grafos::::::::::");
    setResizable(false);
    getContentPane().setLayout((LayoutManager)null);
    jPanel1.setBackground(new Color(141, 141, 141));
    jPanel1.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(0, 102, 102)));
    jPanel1.setMinimumSize(new Dimension(770, 522));
    jPanel1.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            VentanaPrincipal.this.jPanel1MouseClicked(evt);
          }
          
          public void mousePressed(MouseEvent evt) {
            VentanaPrincipal.this.jPanel1MousePressed(evt);
          }
        });
    jPanel1.addMouseMotionListener(new MouseMotionAdapter() {
          public void mouseMoved(MouseEvent evt) {
            VentanaPrincipal.this.jPanel1MouseMoved(evt);
          }
        });
    jPanel1.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent evt) {
            VentanaPrincipal.this.jPanel1KeyPressed(evt);
          }
          
          public void keyReleased(KeyEvent evt) {
            VentanaPrincipal.this.jPanel1KeyReleased(evt);
          }
        });
    jPanel1.setLayout((LayoutManager)null);
    jPanel1.add(this.jmapa);
    this.jmapa.setBounds(10, 10, 750, 500);
    getContentPane().add(jPanel1);
    jPanel1.setBounds(210, 10, 770, 520);
    this.jButton1.setText("Repain");
    this.jButton1.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(0, 0, 0)));
    this.jButton1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaPrincipal.this.jButton1ActionPerformed(evt);
          }
        });
    getContentPane().add(this.jButton1);
    this.jButton1.setBounds(50, 410, 80, 50);
    this.jPanel2.setBorder(BorderFactory.createTitledBorder(""));
    this.jPanel2.setLayout((LayoutManager)null);
    this.jButton2.setBackground(new Color(0, 153, 153));
    this.jButton2.setForeground(new Color(153, 153, 0));
    this.jButton2.setBorder(BorderFactory.createMatteBorder(40, 40, 40, 40, new Color(102, 255, 255)));
    this.jButton2.addMouseListener(new MouseAdapter() {
          public void mousePressed(MouseEvent evt) {
            VentanaPrincipal.this.jButton2MousePressed(evt);
          }
          
          public void mouseReleased(MouseEvent evt) {
            VentanaPrincipal.this.jButton2MouseReleased(evt);
          }
        });
    this.jButton2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaPrincipal.this.jButton2ActionPerformed(evt);
          }
        });
    this.jPanel2.add(this.jButton2);
    this.jButton2.setBounds(10, 10, 20, 20);
    this.jButton3.setBackground(new Color(204, 0, 204));
    this.jButton3.setForeground(new Color(153, 153, 0));
    this.jButton3.setBorder(BorderFactory.createMatteBorder(40, 40, 40, 40, new Color(102, 255, 255)));
    this.jButton3.addMouseListener(new MouseAdapter() {
          public void mousePressed(MouseEvent evt) {
            VentanaPrincipal.this.jButton3MousePressed(evt);
          }
          
          public void mouseReleased(MouseEvent evt) {
            VentanaPrincipal.this.jButton3MouseReleased(evt);
          }
        });
    this.jButton3.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaPrincipal.this.jButton3ActionPerformed(evt);
          }
        });
    this.jPanel2.add(this.jButton3);
    this.jButton3.setBounds(40, 10, 20, 20);
    this.jButton4.setBackground(new Color(189, 182, 182));
    this.jButton4.setForeground(new Color(153, 153, 0));
    this.jButton4.setBorder(BorderFactory.createMatteBorder(40, 40, 40, 40, new Color(102, 255, 255)));
    this.jButton4.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            VentanaPrincipal.this.jButton4MouseClicked(evt);
          }
          
          public void mousePressed(MouseEvent evt) {
            VentanaPrincipal.this.jButton4MousePressed(evt);
          }
          
          public void mouseReleased(MouseEvent evt) {
            VentanaPrincipal.this.jButton4MouseReleased(evt);
          }
        });
    this.jButton4.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaPrincipal.this.jButton4ActionPerformed(evt);
          }
        });
    this.jPanel2.add(this.jButton4);
    this.jButton4.setBounds(100, 10, 20, 20);
    this.jButton5.setBackground(new Color(51, 0, 51));
    this.jButton5.setForeground(new Color(153, 153, 0));
    this.jButton5.setBorder(BorderFactory.createMatteBorder(40, 40, 40, 40, new Color(102, 255, 255)));
    this.jButton5.addMouseListener(new MouseAdapter() {
          public void mousePressed(MouseEvent evt) {
            VentanaPrincipal.this.jButton5MousePressed(evt);
          }
          
          public void mouseReleased(MouseEvent evt) {
            VentanaPrincipal.this.jButton5MouseReleased(evt);
          }
        });
    this.jButton5.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaPrincipal.this.jButton5ActionPerformed(evt);
          }
        });
    this.jPanel2.add(this.jButton5);
    this.jButton5.setBounds(10, 40, 20, 20);
    this.jButton6.setBackground(Color.lightGray);
    this.jButton6.setForeground(new Color(153, 153, 0));
    this.jButton6.setBorder(BorderFactory.createMatteBorder(40, 40, 40, 40, new Color(102, 255, 255)));
    this.jButton6.addMouseListener(new MouseAdapter() {
          public void mousePressed(MouseEvent evt) {
            VentanaPrincipal.this.jButton6MousePressed(evt);
          }
          
          public void mouseReleased(MouseEvent evt) {
            VentanaPrincipal.this.jButton6MouseReleased(evt);
          }
        });
    this.jButton6.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaPrincipal.this.jButton6ActionPerformed(evt);
          }
        });
    this.jPanel2.add(this.jButton6);
    this.jButton6.setBounds(40, 40, 20, 20);
    this.jButton7.setBackground(new Color(164, 167, 255));
    this.jButton7.setForeground(new Color(153, 153, 0));
    this.jButton7.setBorder(BorderFactory.createMatteBorder(40, 40, 40, 40, new Color(102, 255, 255)));
    this.jButton7.addMouseListener(new MouseAdapter() {
          public void mousePressed(MouseEvent evt) {
            VentanaPrincipal.this.jButton7MousePressed(evt);
          }
          
          public void mouseReleased(MouseEvent evt) {
            VentanaPrincipal.this.jButton7MouseReleased(evt);
          }
        });
    this.jButton7.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaPrincipal.this.jButton7ActionPerformed(evt);
          }
        });
    this.jPanel2.add(this.jButton7);
    this.jButton7.setBounds(70, 70, 20, 20);
    this.jButton8.setBackground(new Color(141, 141, 141));
    this.jButton8.setForeground(new Color(153, 153, 0));
    this.jButton8.setBorder(BorderFactory.createMatteBorder(40, 40, 40, 40, new Color(102, 255, 255)));
    this.jButton8.addMouseListener(new MouseAdapter() {
          public void mousePressed(MouseEvent evt) {
            VentanaPrincipal.this.jButton8MousePressed(evt);
          }
          
          public void mouseReleased(MouseEvent evt) {
            VentanaPrincipal.this.jButton8MouseReleased(evt);
          }
        });
    this.jButton8.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaPrincipal.this.jButton8ActionPerformed(evt);
          }
        });
    this.jPanel2.add(this.jButton8);
    this.jButton8.setBounds(100, 40, 20, 20);
    this.jButton9.setBackground(new Color(0, 0, 255));
    this.jButton9.setForeground(new Color(153, 153, 0));
    this.jButton9.setBorder(BorderFactory.createMatteBorder(40, 40, 40, 40, new Color(102, 255, 255)));
    this.jButton9.addMouseListener(new MouseAdapter() {
          public void mousePressed(MouseEvent evt) {
            VentanaPrincipal.this.jButton9MousePressed(evt);
          }
          
          public void mouseReleased(MouseEvent evt) {
            VentanaPrincipal.this.jButton9MouseReleased(evt);
          }
        });
    this.jPanel2.add(this.jButton9);
    this.jButton9.setBounds(100, 70, 20, 20);
    this.jButton10.setBackground(new Color(153, 0, 0));
    this.jButton10.setForeground(new Color(153, 153, 0));
    this.jButton10.setBorder(BorderFactory.createMatteBorder(40, 40, 40, 40, new Color(102, 255, 255)));
    this.jButton10.addMouseListener(new MouseAdapter() {
          public void mousePressed(MouseEvent evt) {
            VentanaPrincipal.this.jButton10MousePressed(evt);
          }
          
          public void mouseReleased(MouseEvent evt) {
            VentanaPrincipal.this.jButton10MouseReleased(evt);
          }
        });
    this.jButton10.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaPrincipal.this.jButton10ActionPerformed(evt);
          }
        });
    this.jPanel2.add(this.jButton10);
    this.jButton10.setBounds(70, 10, 20, 20);
    this.jButton11.setBackground(new Color(0, 102, 102));
    this.jButton11.setForeground(new Color(153, 153, 0));
    this.jButton11.setBorder(BorderFactory.createMatteBorder(40, 40, 40, 40, new Color(102, 255, 255)));
    this.jButton11.addMouseListener(new MouseAdapter() {
          public void mousePressed(MouseEvent evt) {
            VentanaPrincipal.this.jButton11MousePressed(evt);
          }
          
          public void mouseReleased(MouseEvent evt) {
            VentanaPrincipal.this.jButton11MouseReleased(evt);
          }
        });
    this.jPanel2.add(this.jButton11);
    this.jButton11.setBounds(40, 70, 20, 20);
    this.jButton12.setBackground(Color.white);
    this.jButton12.setForeground(new Color(153, 153, 0));
    this.jButton12.setBorder(BorderFactory.createMatteBorder(40, 40, 40, 40, new Color(102, 255, 255)));
    this.jButton12.addMouseListener(new MouseAdapter() {
          public void mousePressed(MouseEvent evt) {
            VentanaPrincipal.this.jButton12MousePressed(evt);
          }
          
          public void mouseReleased(MouseEvent evt) {
            VentanaPrincipal.this.jButton12MouseReleased(evt);
          }
        });
    this.jPanel2.add(this.jButton12);
    this.jButton12.setBounds(70, 40, 20, 20);
    this.jButton13.setBackground(new Color(0, 51, 51));
    this.jButton13.setForeground(new Color(153, 153, 0));
    this.jButton13.setBorder(BorderFactory.createMatteBorder(40, 40, 40, 40, new Color(102, 255, 255)));
    this.jButton13.addMouseListener(new MouseAdapter() {
          public void mousePressed(MouseEvent evt) {
            VentanaPrincipal.this.jButton13MousePressed(evt);
          }
          
          public void mouseReleased(MouseEvent evt) {
            VentanaPrincipal.this.jButton13MouseReleased(evt);
          }
        });
    this.jPanel2.add(this.jButton13);
    this.jButton13.setBounds(10, 70, 20, 20);
    this.jButton14.setText("OK");
    this.jButton14.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaPrincipal.this.jButton14ActionPerformed(evt);
          }
        });
    this.jPanel2.add(this.jButton14);
    this.jButton14.setBounds(30, 100, 60, 23);
    getContentPane().add(this.jPanel2);
    this.jPanel2.setBounds(40, 40, 130, 130);
    this.jLabel1.setFont(new Font("AngsanaUPC", 2, 18));
    this.jLabel1.setText("\"Llega rapido\"");
    getContentPane().add(this.jLabel1);
    this.jLabel1.setBounds(30, 190, 160, 20);
    this.jPanel3.setBorder(BorderFactory.createTitledBorder("Acumulado"));
    this.jPanel3.setLayout((LayoutManager)null);
    this.jtacumulado.setEnabled(false);
    this.jtacumulado.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaPrincipal.this.jtacumuladoActionPerformed(evt);
          }
        });
    this.jPanel3.add(this.jtacumulado);
    this.jtacumulado.setBounds(10, 20, 110, 30);
    getContentPane().add(this.jPanel3);
    this.jPanel3.setBounds(30, 470, 130, 60);
    this.jLabel2.setFont(new Font("AngsanaUPC", 2, 18));
    this.jLabel2.setText("Creado por : Quispe Dupuy Miguel Angel");
    getContentPane().add(this.jLabel2);
    this.jLabel2.setBounds(220, 530, 400, 20);
    this.jLabel3.setIcon(new ImageIcon(getClass().getResource("/Ventanas/aauto.PNG")));
    this.jLabel3.setMaximumSize(new Dimension(100, 105));
    this.jLabel3.setMinimumSize(new Dimension(100, 105));
    getContentPane().add(this.jLabel3);
    this.jLabel3.setBounds(-120, 230, 340, 100);
    this.jMenu1.setText("Archivos");
    this.jMenu1.add(this.jSeparator1);
    this.jMenuItem13.setAccelerator(KeyStroke.getKeyStroke(67, 2));
    this.jMenuItem13.setText("Camino MCorto");
    this.jMenuItem13.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaPrincipal.this.jMenuItem13ActionPerformed(evt);
          }
        });
    this.jMenu1.add(this.jMenuItem13);
    this.jMenuItem3.setAccelerator(KeyStroke.getKeyStroke(82, 2));
    this.jMenuItem3.setText("Recubrir");
    this.jMenuItem3.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaPrincipal.this.jMenuItem3ActionPerformed(evt);
          }
        });
    this.jMenu1.add(this.jMenuItem3);
    this.jMenu1.add(this.jSeparator3);
    this.jMenuItem2.setAccelerator(KeyStroke.getKeyStroke(78, 2));
    this.jMenuItem2.setText("Nueva Arista");
    this.jMenuItem2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaPrincipal.this.jMenuItem2ActionPerformed(evt);
          }
        });
    this.jMenu1.add(this.jMenuItem2);
    this.jMenu1.add(this.jSeparator2);
    this.jMenuItem5.setText("Matriz De coeficiente");
    this.jMenuItem5.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaPrincipal.this.jMenuItem5ActionPerformed(evt);
          }
        });
    this.jMenu1.add(this.jMenuItem5);
    this.jMenuItem7.setText("Matiz De adyacencia");
    this.jMenuItem7.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaPrincipal.this.jMenuItem7ActionPerformed(evt);
          }
        });
    this.jMenu1.add(this.jMenuItem7);
    this.jMenu1.add(this.jSeparator4);
    this.jMenuItem4.setText("Muestra ");
    this.jMenuItem4.addMouseListener(new MouseAdapter() {
          public void mousePressed(MouseEvent evt) {
            VentanaPrincipal.this.jMenuItem4MousePressed(evt);
          }
        });
    this.jMenuItem4.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaPrincipal.this.jMenuItem4ActionPerformed(evt);
          }
        });
    this.jMenu1.add(this.jMenuItem4);
    this.jMenuItem6.setAccelerator(KeyStroke.getKeyStroke(76, 2));
    this.jMenuItem6.setText("Cargar Mapa");
    this.jMenuItem6.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaPrincipal.this.jMenuItem6ActionPerformed(evt);
          }
        });
    this.jMenu1.add(this.jMenuItem6);
    this.jMenuItem1.setAccelerator(KeyStroke.getKeyStroke(78, 8));
    this.jMenuItem1.setText("Nuevo Proyecto");
    this.jMenuItem1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaPrincipal.this.jMenuItem1ActionPerformed(evt);
          }
        });
    this.jMenu1.add(this.jMenuItem1);
    this.jMenu1.add(this.jSeparator5);
    this.jMenuItem8.setAccelerator(KeyStroke.getKeyStroke(83, 2));
    this.jMenuItem8.setText("Salir");
    this.jMenuItem8.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaPrincipal.this.jMenuItem8ActionPerformed(evt);
          }
        });
    this.jMenu1.add(this.jMenuItem8);
    this.jMenuBar1.add(this.jMenu1);
    this.jMenu2.setText("Eliminar");
    this.jMenuItem10.setAccelerator(KeyStroke.getKeyStroke(69, 8));
    this.jMenuItem10.setText("Eliminar Nodo");
    this.jMenuItem10.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaPrincipal.this.jMenuItem10ActionPerformed(evt);
          }
        });
    this.jMenu2.add(this.jMenuItem10);
    this.jMenuItem9.setAccelerator(KeyStroke.getKeyStroke(69, 2));
    this.jMenuItem9.setText("Eliminar Arista");
    this.jMenuItem9.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaPrincipal.this.jMenuItem9ActionPerformed(evt);
          }
        });
    this.jMenu2.add(this.jMenuItem9);
    this.jMenuItem11.setAccelerator(KeyStroke.getKeyStroke(69, 10));
    this.jMenuItem11.setText("Eliminar Todas Las Arsitas ");
    this.jMenuItem11.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaPrincipal.this.jMenuItem11ActionPerformed(evt);
          }
        });
    this.jMenu2.add(this.jMenuItem11);
    this.jMenuBar1.add(this.jMenu2);
    this.jMenu3.setText("Opciones ");
    this.jMenuItem12.setAccelerator(KeyStroke.getKeyStroke(112, 0));
    this.jMenuItem12.setText("Color");
    this.jMenuItem12.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaPrincipal.this.jMenuItem12ActionPerformed(evt);
          }
        });
    this.jMenu3.add(this.jMenuItem12);
    this.jMenuBar1.add(this.jMenu3);
    setJMenuBar(this.jMenuBar1);
    setSize(new Dimension(1012, 623));
    setLocationRelativeTo((Component)null);
  }
  
  private void jPanel1MousePressed(MouseEvent evt) {
    int xxx = evt.getX();
    int yyy = evt.getY();
    if (evt.isMetaDown()) {
      clicIzqSobreNodo(xxx, yyy);
      if (this.nn == 2) {
        this.nn = 0;
        Algoritmo_Dijkstra Dijkstra = new Algoritmo_Dijkstra(this.arboles, this.tope, this.permanente, this.nodoFin);
        Dijkstra.dijkstra();
        this.jtacumulado.setText("" + Dijkstra.getAcumulado());
      } 
    } else {
      if (!cicDerechoSobreNodo(xxx, yyy))
        if (this.tope < 50) {
          this.arboles.setCordeX(this.tope, xxx);
          this.arboles.setCordeY(this.tope, yyy);
          this.arboles.setNombre(this.tope, this.tope);
          Pintar.pintarCirculo(jPanel1.getGraphics(), this.arboles.getCordeX(this.tope), this.arboles.getCordeY(this.tope), String.valueOf(this.arboles.getNombre(this.tope)));
          this.tope++;
        } else {
          JOptionPane.showMessageDialog(null, "Se ha llegado al Maximo de nodos..");
        }  
      if (this.n == 2) {
        this.n = 0;
        int ta = ingresarTamano("Ingrese Tema");
        if (this.aristaMayor < ta)
          this.aristaMayor = ta; 
        this.arboles.setmAdyacencia(this.id2, this.id, 1);
        this.arboles.setmAdyacencia(this.id, this.id2, 1);
        this.arboles.setmCoeficiente(this.id2, this.id, ta);
        this.arboles.setmCoeficiente(this.id, this.id2, ta);
        Pintar.pintarLinea(jPanel1.getGraphics(), this.arboles.getCordeX(this.id), this.arboles.getCordeY(this.id), this.arboles.getCordeX(this.id2), this.arboles.getCordeY(this.id2), ta);
        Pintar.pintarCirculo(jPanel1.getGraphics(), this.arboles.getCordeX(this.id), this.arboles.getCordeY(this.id), String.valueOf(this.arboles.getNombre(this.id)));
        Pintar.pintarCirculo(jPanel1.getGraphics(), this.arboles.getCordeX(this.id2), this.arboles.getCordeY(this.id2), String.valueOf(this.arboles.getNombre(this.id2)));
        this.id = -1;
        this.id2 = -1;
      } 
    } 
  }
  
  private void jMenuItem4MousePressed(MouseEvent evt) {}
  
  private void jMenuItem4ActionPerformed(ActionEvent evt) {
    jPanel1.paint(jPanel1.getGraphics());
    this.n = 0;
    this.id = -1;
    this.id2 = -1;
    int[][] Matriz = { { 0, 1, 0, 1, 1, 0, 0, 1 }, { 1, 0, 1, 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 1, 0, 0, 0 }, { 1, 0, 1, 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0, 1, 0, 0 } };
    int[][] coe = { { 0, 50, 0, 46, 216, 0, 0, 578 }, { 50, 0, 59, 0, 0, 0, 0, 0 }, { 0, 59, 0, 89, 174, 0, 0, 0 }, { 46, 0, 89, 0, 0, 0, 0, 0 }, { 216, 0, 174, 0, 0, 471, 0, 0 }, { 0, 0, 0, 0, 471, 0, 194, 398 }, { 0, 0, 0, 0, 0, 194, 0, 0 }, { 578, 0, 0, 0, 0, 398, 0, 0 } };
    int[] xx1 = { 202, 102, 8, 198, 248, 352, 481, 416 };
    int[] yy1 = { 12, 74, 165, 113, 233, 300, 368, 177 };
    int[] nom = { 0, 1, 2, 3, 4, 5, 6, 7 };
    this.aristaMayor = 600;
    int j;
    for (j = 0; j < 8; j++) {
      this.arboles.setCordeX(j, xx1[j]);
      this.arboles.setCordeY(j, yy1[j]);
      this.arboles.setNombre(j, nom[j]);
    } 
    for (j = 0; j < 8; j++) {
      for (int k = 0; k < 8; k++) {
        this.arboles.setmAdyacencia(j, k, Matriz[j][k]);
        this.arboles.setmCoeficiente(j, k, coe[j][k]);
      } 
    } 
    this.tope = 8;
    R_repaint(this.tope, this.arboles);
  }
  
  private void jMenuItem3ActionPerformed(ActionEvent evt) {
    if (this.tope < 1) {
      JOptionPane.showMessageDialog(null, "Aun no se ha creado Un nodo");
    } else {
      Algoritmo_Prim Prim = new Algoritmo_Prim(this.arboles, this.tope, this.aristaMayor);
      Prim.prim();
      this.jtacumulado.setText("" + Prim.getCumulado());
    } 
  }
  
  private void jMenuItem5ActionPerformed(ActionEvent evt) {
    if (this.tope == 0) {
      JOptionPane.showMessageDialog(null, "Aun no se ha credo un nodo : ");
    } else {
      setEnabled(false);
      (new Matrices(this.tope, this.arboles, 2, this)).setVisible(true);
    } 
  }
  
  private void jMenuItem7ActionPerformed(ActionEvent evt) {
    if (this.tope == 0) {
      JOptionPane.showMessageDialog(null, "Aun no se ha credo un nodo : ");
    } else {
      setEnabled(false);
      (new Matrices(this.tope, this.arboles, 1, this)).setVisible(true);
    } 
  }
  
  private void jMenuItem2ActionPerformed(ActionEvent evt) {
    if (this.tope <= 1) {
      JOptionPane.showMessageDialog(null, "Cree nuevo nodo : ");
    } else {
      setEnabled(false);
      (new VentanaArista(this.arboles, this.pintar, this.tope, this)).setVisible(true);
      jPanel1.paint(jPanel1.getGraphics());
      R_repaint(this.tope, this.arboles);
    } 
  }
  
  private void jButton1ActionPerformed(ActionEvent evt) {
    R_repaint(this.tope, this.arboles);
  }
  
  private void jPanel1KeyPressed(KeyEvent evt) {}
  
  private void jPanel1KeyReleased(KeyEvent evt) {}
  
  private void jMenuItem8ActionPerformed(ActionEvent evt) {
    System.exit(0);
  }
  
  private void jMenuItem1ActionPerformed(ActionEvent evt) {
    int j;
    for (j = 0; j < this.tope; j++) {
      this.arboles.setCordeX(j, 0);
      this.arboles.setCordeY(j, 0);
      this.arboles.setNombre(j, 0);
    } 
    for (j = 0; j < this.tope; j++) {
      for (int k = 0; k < this.tope; k++) {
        this.arboles.setmAdyacencia(j, k, 0);
        this.arboles.setmCoeficiente(j, k, 0);
      } 
    } 
    this.tope = 0;
    jPanel1.repaint();
  }
  
  private void jPanel1MouseMoved(MouseEvent evt) {}
  
  private void jMenuItem9ActionPerformed(ActionEvent evt) {
    if (this.tope >= 2) {
      setEnabled(false);
      (new EliminarAristas(this.pintar, this.arboles, this.tope, this)).setVisible(true);
      jPanel1.paint(jPanel1.getGraphics());
      R_repaint(this.tope, this.arboles);
    } else {
      JOptionPane.showMessageDialog(null, "No Hay Nodos Enlazados... ");
    } 
  }
  
  private void jMenuItem10ActionPerformed(ActionEvent evt) {
    int Eliminar = ingresarNodoOrigen("Ingrese Nodo a Eliminar ", "Nodo No existe", this.tope);
    if (Eliminar <= this.tope && Eliminar >= 0 && this.tope > 0) {
      for (int i = 0; i < this.tope; i++) {
        for (int k = 0; k < this.tope; k++) {
          if (i == Eliminar || k == Eliminar)
            this.arboles.setmAdyacencia(i, k, -1); 
        } 
      } 
      int l;
      for (l = 0; l < this.tope - 1; l++) {
        for (int m = 0; m < this.tope; m++) {
          if (this.arboles.getmAdyacencia(l, m) == -1) {
            this.arboles.setmAdyacencia(l, m, this.arboles.getmAdyacencia(l + 1, m));
            this.arboles.setmAdyacencia(l + 1, m, -1);
            this.arboles.setmCoeficiente(l, m, this.arboles.getmCoeficiente(l + 1, m));
          } 
        } 
      } 
      for (l = 0; l < this.tope; l++) {
        for (int m = 0; m < this.tope - 1; m++) {
          if (this.arboles.getmAdyacencia(l, m) == -1) {
            this.arboles.setmAdyacencia(l, m, this.arboles.getmAdyacencia(l, m + 1));
            this.arboles.setmAdyacencia(l, m + 1, -1);
            this.arboles.setmCoeficiente(l, m, this.arboles.getmCoeficiente(l, m + 1));
          } 
        } 
      } 
      this.arboles.setCordeX(Eliminar, -10);
      this.arboles.setCordeY(Eliminar, -10);
      this.arboles.setNombre(Eliminar, -10);
      int j;
      for (j = 0; j < this.tope; j++) {
        for (int k = 0; k < this.tope - 1; k++) {
          if (this.arboles.getCordeX(k) == -10) {
            this.arboles.setCordeX(k, this.arboles.getCordeX(k + 1));
            this.arboles.setCordeX(k + 1, -10);
            this.arboles.setCordeY(k, this.arboles.getCordeY(k + 1));
            this.arboles.setCordeY(k + 1, -10);
            this.arboles.setNombre(k, this.arboles.getNombre(k + 1));
            this.arboles.setNombre(k + 1, -10);
          } 
        } 
      } 
      for (j = 0; j < this.tope; j++)
        this.arboles.setNombre(j, j); 
      for (j = 0; j < this.tope + 1; j++) {
        for (int k = 0; k < this.tope + 1; k++) {
          if (this.arboles.getmAdyacencia(j, k) != -1) {
            this.arboles.setmAdyacencia(j, k, this.arboles.getmAdyacencia(j, k));
          } else {
            this.arboles.setmAdyacencia(j, k, 0);
          } 
          if (this.arboles.getmCoeficiente(j, k) != -10) {
            this.arboles.setmCoeficiente(j, k, this.arboles.getmCoeficiente(j, k));
          } else {
            this.arboles.setmCoeficiente(j, k, 0);
          } 
        } 
      } 
      this.tope--;
      jPanel1.paint(jPanel1.getGraphics());
      R_repaint(this.tope, this.arboles);
    } 
  }
  
  private void jMenuItem11ActionPerformed(ActionEvent evt) {
    for (int j = 0; j < this.tope; j++) {
      for (int k = 0; k < this.tope; k++) {
        this.arboles.setmAdyacencia(j, k, 0);
        this.arboles.setmAdyacencia(k, j, 0);
        this.arboles.setmCoeficiente(j, k, 0);
        this.arboles.setmCoeficiente(k, j, 0);
      } 
    } 
    jPanel1.paint(jPanel1.getGraphics());
    R_repaint(this.tope, this.arboles);
  }
  
  private void jButton3MousePressed(MouseEvent evt) {
    jPanel1.setBackground(this.jButton3.getBackground());
  }
  
  private void jButton3ActionPerformed(ActionEvent evt) {}
  
  private void jButton2ActionPerformed(ActionEvent evt) {}
  
  private void jButton10ActionPerformed(ActionEvent evt) {}
  
  private void jButton4ActionPerformed(ActionEvent evt) {}
  
  private void jButton5ActionPerformed(ActionEvent evt) {}
  
  private void jButton6ActionPerformed(ActionEvent evt) {}
  
  private void jButton7ActionPerformed(ActionEvent evt) {}
  
  private void jButton8ActionPerformed(ActionEvent evt) {}
  
  private void jButton14ActionPerformed(ActionEvent evt) {
    this.jPanel2.setVisible(false);
  }
  
  private void jMenuItem12ActionPerformed(ActionEvent evt) {
    this.jPanel2.setVisible(true);
  }
  
  private void jButton4MouseReleased(MouseEvent evt) {
    R_repaint(this.tope, this.arboles);
  }
  
  private void jButton4MouseClicked(MouseEvent evt) {}
  
  private void jButton4MousePressed(MouseEvent evt) {
    jPanel1.setBackground(this.jButton4.getBackground());
  }
  
  private void jButton2MousePressed(MouseEvent evt) {
    jPanel1.setBackground(this.jButton2.getBackground());
  }
  
  private void jButton2MouseReleased(MouseEvent evt) {
    R_repaint(this.tope, this.arboles);
  }
  
  private void jButton3MouseReleased(MouseEvent evt) {
    R_repaint(this.tope, this.arboles);
  }
  
  private void jButton10MousePressed(MouseEvent evt) {
    jPanel1.setBackground(this.jButton10.getBackground());
  }
  
  private void jButton10MouseReleased(MouseEvent evt) {
    R_repaint(this.tope, this.arboles);
  }
  
  private void jButton5MousePressed(MouseEvent evt) {
    jPanel1.setBackground(this.jButton5.getBackground());
  }
  
  private void jButton5MouseReleased(MouseEvent evt) {
    R_repaint(this.tope, this.arboles);
  }
  
  private void jButton7MousePressed(MouseEvent evt) {
    jPanel1.setBackground(this.jButton7.getBackground());
  }
  
  private void jButton7MouseReleased(MouseEvent evt) {
    R_repaint(this.tope, this.arboles);
  }
  
  private void jButton8MousePressed(MouseEvent evt) {
    jPanel1.setBackground(this.jButton8.getBackground());
  }
  
  private void jButton8MouseReleased(MouseEvent evt) {
    R_repaint(this.tope, this.arboles);
  }
  
  private void jButton6MousePressed(MouseEvent evt) {
    jPanel1.setBackground(this.jButton6.getBackground());
  }
  
  private void jButton6MouseReleased(MouseEvent evt) {
    R_repaint(this.tope, this.arboles);
  }
  
  private void jButton13MousePressed(MouseEvent evt) {
    jPanel1.setBackground(this.jButton13.getBackground());
  }
  
  private void jButton11MousePressed(MouseEvent evt) {
    jPanel1.setBackground(this.jButton11.getBackground());
  }
  
  private void jButton12MouseReleased(MouseEvent evt) {
    R_repaint(this.tope, this.arboles);
  }
  
  private void jButton9MousePressed(MouseEvent evt) {
    jPanel1.setBackground(this.jButton9.getBackground());
  }
  
  private void jButton12MousePressed(MouseEvent evt) {
    jPanel1.setBackground(this.jButton12.getBackground());
  }
  
  private void jButton11MouseReleased(MouseEvent evt) {
    R_repaint(this.tope, this.arboles);
  }
  
  private void jButton9MouseReleased(MouseEvent evt) {
    R_repaint(this.tope, this.arboles);
  }
  
  private void jButton13MouseReleased(MouseEvent evt) {
    R_repaint(this.tope, this.arboles);
  }
  
  private void jMenuItem13ActionPerformed(ActionEvent evt) {
    if (this.tope >= 2) {
      this.permanente = ingresarNodoOrigen("Ingrese Nodo Origen..", "nodo Origen No existe", this.tope);
      this.nodoFin = ingresarNodoOrigen("Ingrese Nodo Fin..", "nodo fin No existe", this.tope);
      Algoritmo_Dijkstra Dijkstra = new Algoritmo_Dijkstra(this.arboles, this.tope, this.permanente, this.nodoFin);
      Dijkstra.dijkstra();
      this.jtacumulado.setText("" + Dijkstra.getAcumulado());
    } else {
      JOptionPane.showMessageDialog(null, "Se deben de crear mas nodos ... ");
    } 
  }
  
  private void jPanel1MouseClicked(MouseEvent evt) {}
  
  private void jtacumuladoActionPerformed(ActionEvent evt) {}
  
  private void jMenuItem6ActionPerformed(ActionEvent evt) {
    this.jDialog1.setVisible(true);
  }
  
  private void jFileChooser2ActionPerformed(ActionEvent evt) {
    JFileChooser selectorArchios = (JFileChooser)evt.getSource();
    String comando = evt.getActionCommand();
    if (comando.equals("ApproveSelection")) {
      File archiSeleccionado = selectorArchios.getSelectedFile();
      adactarImagen(archiSeleccionado);
      this.jDialog1.setVisible(false);
    } 
  }
  
  public static void main(String[] args) {}
  
  public VentanaPrincipal() {
    this.tope = 0;
    this.n = 0;
    this.nn = 0;
    initComponents();
    this.jPanel2.setVisible(false);
    this.jDialog1.setLocationRelativeTo((Component)null);
  }
}
