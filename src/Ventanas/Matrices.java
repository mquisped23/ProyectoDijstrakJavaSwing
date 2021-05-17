package Ventanas;

import Clases.Arboles;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Matrices extends JFrame {
  Arboles arbol;
  
  Frame frame;
  
  int i;
  
  private JPanel jPanel1;
  
  private JScrollPane jScrollPane1;
  
  private JTextArea jTextArea1;
  
  public Matrices(int i, Arboles arboles, int matriz, Frame frame) {
    this.i = i;
    this.arbol = arboles;
    this.frame = frame;
    initComponents();
    if (matriz == 1)
      for (int j = 0; j < i; j++) {
        for (int k = 0; k < i; k++)
          this.jTextArea1.append("" + this.arbol.getmAdyacencia(j, k) + "\t"); 
        this.jTextArea1.append("\n");
      }  
    if (matriz == 2)
      for (int j = 0; j < i; j++) {
        for (int k = 0; k < i; k++)
          this.jTextArea1.append("" + this.arbol.getmCoeficiente(j, k) + "\t"); 
        this.jTextArea1.append("\n");
      }  
  }
  
  private void initComponents() {
    this.jPanel1 = new JPanel();
    this.jScrollPane1 = new JScrollPane();
    this.jTextArea1 = new JTextArea();
    setResizable(false);
    addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent evt) {
            Matrices.this.formWindowClosing(evt);
          }
        });
    getContentPane().setLayout((LayoutManager)null);
    this.jPanel1.setBorder(BorderFactory.createTitledBorder(":::::Matriz::::"));
    this.jPanel1.setLayout((LayoutManager)null);
    this.jTextArea1.setEditable(false);
    this.jTextArea1.setColumns(20);
    this.jTextArea1.setFont(new Font("Monospaced", 1, 12));
    this.jTextArea1.setRows(5);
    this.jScrollPane1.setViewportView(this.jTextArea1);
    this.jPanel1.add(this.jScrollPane1);
    this.jScrollPane1.setBounds(16, 16, 560, 400);
    getContentPane().add(this.jPanel1);
    this.jPanel1.setBounds(10, 10, 600, 430);
    setSize(new Dimension(635, 494));
    setLocationRelativeTo((Component)null);
  }
  
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
      Logger.getLogger(Matrices.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(Matrices.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(Matrices.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (UnsupportedLookAndFeelException ex) {
      Logger.getLogger(Matrices.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    EventQueue.invokeLater(new Runnable() {
          public void run() {}
        });
  }
}