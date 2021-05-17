package Ventanas;

import Clases.Arboles;
import Clases.Pintar;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class EliminarAristas extends JFrame {
  int i;
  
  Pintar pintar;
  
  Arboles arboles;
  
  Frame frame;
  
  private JButton jButton1;
  
  private JLabel jLabel1;
  
  private JLabel jLabel2;
  
  private JPanel jPanel1;
  
  private JTextField n1;
  
  private JTextField n2;
  
  public void R_repaint() {
    int j;
    for (j = 0; j < this.i; j++) {
      for (int k = 0; k < this.i; k++) {
        if (this.arboles.getmAdyacencia(j, k) == 1)
          Pintar.pintarLinea(VentanaPrincipal.jPanel1.getGraphics(), this.arboles.getCordeX(j), this.arboles.getCordeY(j), this.arboles.getCordeX(k), this.arboles.getCordeY(k), this.arboles.getmCoeficiente(j, k)); 
      } 
    } 
    for (j = 0; j < this.i; j++)
      Pintar.pintarCirculo(VentanaPrincipal.jPanel1.getGraphics(), this.arboles.getCordeX(j), this.arboles.getCordeY(j), String.valueOf(this.arboles.getNombre(j))); 
  }
  
  public EliminarAristas(Pintar pinta, Arboles arbole, int ii, Frame fram) {
    initComponents();
    this.i = ii;
    this.pintar = pinta;
    this.arboles = arbole;
    this.frame = fram;
  }
  
  private void initComponents() {
    this.jPanel1 = new JPanel();
    this.n1 = new JTextField();
    this.n2 = new JTextField();
    this.jLabel1 = new JLabel();
    this.jLabel2 = new JLabel();
    this.jButton1 = new JButton();
    setTitle(":Eliminr:");
    setPreferredSize(new Dimension(159, 343));
    setResizable(false);
    addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent evt) {
            EliminarAristas.this.formWindowClosing(evt);
          }
        });
    getContentPane().setLayout((LayoutManager)null);
    this.jPanel1.setBorder(BorderFactory.createTitledBorder("Eliminar Arista"));
    this.jPanel1.setLayout((LayoutManager)null);
    this.n1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            EliminarAristas.this.n1ActionPerformed(evt);
          }
        });
    this.n1.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent evt) {
            EliminarAristas.this.n1KeyPressed(evt);
          }
          
          public void keyReleased(KeyEvent evt) {
            EliminarAristas.this.n1KeyReleased(evt);
          }
        });
    this.jPanel1.add(this.n1);
    this.n1.setBounds(100, 30, 30, 20);
    this.n2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            EliminarAristas.this.n2ActionPerformed(evt);
          }
        });
    this.n2.addKeyListener(new KeyAdapter() {
          public void keyReleased(KeyEvent evt) {
            EliminarAristas.this.n2KeyReleased(evt);
          }
        });
    this.jPanel1.add(this.n2);
    this.n2.setBounds(100, 60, 30, 20);
    this.jLabel1.setText("Digite el Nodo 1");
    this.jPanel1.add(this.jLabel1);
    this.jLabel1.setBounds(10, 30, 110, 14);
    this.jLabel2.setText("Digite el nodo 2");
    this.jPanel1.add(this.jLabel2);
    this.jLabel2.setBounds(10, 60, 100, 14);
    getContentPane().add(this.jPanel1);
    this.jPanel1.setBounds(10, 10, 150, 90);
    this.jButton1.setText("Eliminar");
    this.jButton1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            EliminarAristas.this.jButton1ActionPerformed(evt);
          }
        });
    getContentPane().add(this.jButton1);
    this.jButton1.setBounds(30, 110, 90, 23);
    setBounds(60, 130, 182, 179);
  }
  
  private void n1ActionPerformed(ActionEvent evt) {}
  
  private void n1KeyPressed(KeyEvent evt) {}
  
  private void n1KeyReleased(KeyEvent evt) {
    String tem = new String(this.n1.getText());
    StringBuffer tem2 = new StringBuffer();
    for (int j = 0; j < tem.length(); j++) {
      if (Character.isDigit(tem.charAt(j)))
        tem2.append(tem.charAt(j)); 
    } 
    this.n1.setText("" + tem2);
  }
  
  private void n2KeyReleased(KeyEvent evt) {
    String tem = new String(this.n2.getText());
    StringBuffer tem2 = new StringBuffer();
    for (int j = 0; j < tem.length(); j++) {
      if (Character.isDigit(tem.charAt(j)))
        tem2.append(tem.charAt(j)); 
    } 
    this.n2.setText("" + tem2);
  }
  
  private void jButton1ActionPerformed(ActionEvent evt) {
    if (this.n1.getText().length() < 1 || this.n2.getText().length() < 1) {
      JOptionPane.showMessageDialog(null, "Error.. Faltan datos : ");
    } else {
      int x = Integer.parseInt(this.n1.getText());
      int y = Integer.parseInt(this.n2.getText());
      if (x == y) {
        JOptionPane.showMessageDialog(null, "Error.. Debe digitar un nodo diferente a : " + y);
      } else if (x < 0 || x >= this.i || y < 0 || y >= this.i) {
        JOptionPane.showMessageDialog(null, "Error.. Nodos No validos ");
      } else {
        this.arboles.setmAdyacencia(x, y, 0);
        this.arboles.setmAdyacencia(y, x, 0);
        this.arboles.setmCoeficiente(x, y, 0);
        this.arboles.setmCoeficiente(y, x, 0);
        this.n1.setText((String)null);
        this.n2.setText((String)null);
        VentanaPrincipal.jPanel1.paint(VentanaPrincipal.jPanel1.getGraphics());
        R_repaint();
      } 
    } 
  }
  
  private void n2ActionPerformed(ActionEvent evt) {}
  
  private void formWindowClosing(WindowEvent evt) {
    this.frame.setEnabled(true);
  }
  
  public static void main(String[] args) {
    try {
      for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        } 
      } 
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(EliminarAristas.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(EliminarAristas.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(EliminarAristas.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (UnsupportedLookAndFeelException ex) {
      Logger.getLogger(EliminarAristas.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
  }
}
