package Ventanas;

import Clases.Arboles;
import Clases.Pintar;
import java.awt.EventQueue;
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

public class VentanaArista extends JFrame {
  Pintar pintar;
  
  Arboles arboles;
  
  Frame frame1;
  
  private int i;
  
  private JButton jButton1;
  
  private JLabel jLabel1;
  
  private JLabel jLabel2;
  
  private JLabel jLabel3;
  
  private JTextField n1;
  
  private JTextField n2;
  
  private JPanel panel;
  
  private JTextField tm;
  
  public VentanaArista(Arboles arbole, Pintar pinta, int I, Frame frame) {
    this.i = 0;
    this.pintar = pinta;
    this.arboles = arbole;
    this.i = I;
    this.frame1 = frame;
    initComponents();
  }
  
  private void initComponents() {
    this.panel = new JPanel();
    this.jLabel1 = new JLabel();
    this.jLabel2 = new JLabel();
    this.jLabel3 = new JLabel();
    this.n1 = new JTextField();
    this.n2 = new JTextField();
    this.tm = new JTextField();
    this.jButton1 = new JButton();
    setTitle("::Crear::");
    setResizable(false);
    addWindowListener(new WindowAdapter() {
          public void windowClosed(WindowEvent evt) {
            VentanaArista.this.formWindowClosed(evt);
          }
          
          public void windowClosing(WindowEvent evt) {
            VentanaArista.this.formWindowClosing(evt);
          }
        });
    getContentPane().setLayout((LayoutManager)null);
    this.panel.setBorder(BorderFactory.createTitledBorder("Nueva Arista"));
    this.panel.setLayout((LayoutManager)null);
    this.jLabel1.setText("Digite el Nodo 1");
    this.panel.add(this.jLabel1);
    this.jLabel1.setBounds(10, 30, 90, 14);
    this.jLabel2.setText("Digite el Nodo 2");
    this.panel.add(this.jLabel2);
    this.jLabel2.setBounds(10, 60, 90, 14);
    this.jLabel3.setText("digite el Tema");
    this.panel.add(this.jLabel3);
    this.jLabel3.setBounds(10, 90, 100, 14);
    this.n1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaArista.this.n1ActionPerformed(evt);
          }
        });
    this.n1.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent evt) {
            VentanaArista.this.n1KeyPressed(evt);
          }
          
          public void keyReleased(KeyEvent evt) {
            VentanaArista.this.n1KeyReleased(evt);
          }
        });
    this.panel.add(this.n1);
    this.n1.setBounds(110, 30, 30, 20);
    this.n2.addKeyListener(new KeyAdapter() {
          public void keyReleased(KeyEvent evt) {
            VentanaArista.this.n2KeyReleased(evt);
          }
        });
    this.panel.add(this.n2);
    this.n2.setBounds(110, 60, 30, 20);
    this.tm.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaArista.this.tmActionPerformed(evt);
          }
        });
    this.tm.addKeyListener(new KeyAdapter() {
          public void keyReleased(KeyEvent evt) {
            VentanaArista.this.tmKeyReleased(evt);
          }
        });
    this.panel.add(this.tm);
    this.tm.setBounds(110, 90, 30, 20);
    getContentPane().add(this.panel);
    this.panel.setBounds(10, 10, 150, 130);
    this.jButton1.setText("Trazar");
    this.jButton1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            VentanaArista.this.jButton1ActionPerformed(evt);
          }
        });
    getContentPane().add(this.jButton1);
    this.jButton1.setBounds(40, 140, 90, 23);
    setBounds(60, 150, 183, 209);
  }
  
  private void jButton1ActionPerformed(ActionEvent evt) {
    if (this.n1.getText().length() < 1 || this.n2.getText().length() < 1 || this.tm.getText().length() < 1) {
      JOptionPane.showMessageDialog(null, "Error.. Faltan datos : ");
    } else {
      int x = Integer.parseInt(this.n1.getText());
      int y = Integer.parseInt(this.n2.getText());
      int ta = Integer.parseInt(this.tm.getText());
      if (x == y) {
        JOptionPane.showMessageDialog(null, "Error.. Debe digitar un nodo diferente a : " + y);
      } else if (x < 0 || x >= this.i || y < 0 || y >= this.i) {
        JOptionPane.showMessageDialog(null, "Error.. Nodos No validos ");
      } else {
        this.arboles.setmAdyacencia(x, y, 1);
        this.arboles.setmAdyacencia(y, x, 1);
        this.arboles.setmCoeficiente(x, y, ta);
        this.arboles.setmCoeficiente(y, x, ta);
        this.n1.setText((String)null);
        this.n2.setText((String)null);
        this.tm.setText((String)null);
        Pintar.pintarLinea(VentanaPrincipal.jPanel1.getGraphics(), this.arboles.getCordeX(x), this.arboles.getCordeY(x), this.arboles.getCordeX(y), this.arboles.getCordeY(y), ta);
      } 
    } 
  }
  
  private void n1KeyReleased(KeyEvent evt) {
    String tem = new String(this.n1.getText());
    StringBuffer tem2 = new StringBuffer();
    for (int j = 0; j < tem.length(); j++) {
      if (Character.isDigit(tem.charAt(j)))
        tem2.append(tem.charAt(j)); 
    } 
    this.n1.setText("" + tem2);
  }
  
  private void n1KeyPressed(KeyEvent evt) {}
  
  private void n2KeyReleased(KeyEvent evt) {
    String tem = new String(this.n2.getText());
    StringBuffer tem2 = new StringBuffer();
    for (int j = 0; j < tem.length(); j++) {
      if (Character.isDigit(tem.charAt(j)))
        tem2.append(tem.charAt(j)); 
    } 
    this.n2.setText("" + tem2);
  }
  
  private void tmKeyReleased(KeyEvent evt) {
    String tem = new String(this.tm.getText());
    StringBuffer tem2 = new StringBuffer();
    for (int j = 0; j < tem.length(); j++) {
      if (Character.isDigit(tem.charAt(j)))
        tem2.append(tem.charAt(j)); 
    } 
    this.tm.setText("" + tem2);
  }
  
  private void tmActionPerformed(ActionEvent evt) {}
  
  private void n1ActionPerformed(ActionEvent evt) {}
  
  private void formWindowClosed(WindowEvent evt) {}
  
  private void formWindowClosing(WindowEvent evt) {
    this.frame1.setEnabled(true);
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
      Logger.getLogger(VentanaArista.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(VentanaArista.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(VentanaArista.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (UnsupportedLookAndFeelException ex) {
      Logger.getLogger(VentanaArista.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    EventQueue.invokeLater(new Runnable() {
          public void run() {}
        });
  }
}

