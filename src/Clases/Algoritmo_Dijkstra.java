package Clases;

import Ventanas.VentanaPrincipal;
import java.awt.Color;
import javax.swing.JOptionPane;

public class Algoritmo_Dijkstra {
  private Arboles arboles;
  
  private int subTope;
  
  private Nodo auxi = null;
  
  private int auxAumulado;
  
  private int subAcomulado;
  
  private Nodo[] nodo;
  
  private int tope;
  
  private int permanente;
  
  private int nodoFin;
  
  public Algoritmo_Dijkstra(Arboles arboles, int tope, int permanente, int nodoFin) {
    this.arboles = arboles;
    this.tope = tope;
    this.nodo = new Nodo[tope];
    this.permanente = permanente;
    this.nodoFin = nodoFin;
  }
  
  public int getAcumulado() {
    return this.nodo[this.nodoFin].getAcumulado();
  }
  
  public void dijkstra() {
    for (int i = 0; i < this.tope; i++)
      this.nodo[i] = new Nodo(); 
    if (this.permanente != this.nodoFin) {
      VentanaPrincipal.jPanel1.paint(VentanaPrincipal.jPanel1.getGraphics());
      VentanaPrincipal.R_repaint(this.tope, this.arboles);
      Pintar.clickSobreNodo(VentanaPrincipal.jPanel1.getGraphics(), this.arboles.getCordeX(this.permanente), this.arboles.getCordeY(this.permanente), null, Color.GREEN);
      this.nodo[this.permanente].setVisitado(true);
      this.nodo[this.permanente].setNombre(this.permanente);
      while (true) {
        this.subAcomulado = 0;
        this.auxAumulado = 2000000000;
        this.nodo[this.permanente].setEtiqueta(true);
        for (int j = 0; j < this.tope; j++) {
          if (this.arboles.getmAdyacencia(j, this.permanente) == 1) {
            this.subAcomulado = this.nodo[this.permanente].getAcumulado() + this.arboles.getmCoeficiente(j, this.permanente);
            if (this.subAcomulado <= this.nodo[j].getAcumulado() && this.nodo[j].isVisitado() == true && !this.nodo[j].isEtiqueta()) {
              this.nodo[j].setAcumulado(this.subAcomulado);
              this.nodo[j].setVisitado(true);
              this.nodo[j].setNombre(j);
              this.nodo[j].setPredecesor(this.nodo[this.permanente]);
            } else if (!this.nodo[j].isVisitado()) {
              this.nodo[j].setAcumulado(this.subAcomulado);
              this.nodo[j].setVisitado(true);
              this.nodo[j].setNombre(j);
              this.nodo[j].setPredecesor(this.nodo[this.permanente]);
            } 
          } 
        } 
        for (int k = 0; k < this.tope; k++) {
          if (this.nodo[k].isVisitado() == true && !this.nodo[k].isEtiqueta() && 
            this.nodo[k].getAcumulado() <= this.auxAumulado) {
            this.permanente = this.nodo[k].getNombre();
            this.auxAumulado = this.nodo[k].getAcumulado();
          } 
        } 
        this.subTope++;
        if (this.subTope >= this.tope + 1) {
          this.auxi = this.nodo[this.nodoFin];
          if (this.auxi.getPredecesor() == null)
            JOptionPane.showMessageDialog(null, "No se Pudo LLegar Al Nodo " + this.nodoFin); 
          while (this.auxi.getPredecesor() != null) {
            Pintar.pintarCamino(VentanaPrincipal.jPanel1.getGraphics(), this.arboles.getCordeX(this.auxi.getNombre()), this.arboles.getCordeY(this.auxi.getNombre()), this.arboles.getCordeX(this.auxi.getPredecesor().getNombre()), this.arboles.getCordeY(this.auxi.getPredecesor().getNombre()), Color.GREEN);
            Pintar.clickSobreNodo(VentanaPrincipal.jPanel1.getGraphics(), this.arboles.getCordeX(this.auxi.getNombre()), this.arboles.getCordeY(this.auxi.getNombre()), null, Color.GREEN);
            this.auxi = this.auxi.getPredecesor();
          } 
          Pintar.clickSobreNodo(VentanaPrincipal.jPanel1.getGraphics(), this.arboles.getCordeX(this.nodoFin), this.arboles.getCordeY(this.nodoFin), null, Color.GREEN);
          return;
        } 
      } 
    } 
    Pintar.clickSobreNodo(VentanaPrincipal.jPanel1.getGraphics(), this.arboles.getCordeX(this.nodoFin), this.arboles.getCordeY(this.nodoFin), null, Color.GREEN);
  }
}