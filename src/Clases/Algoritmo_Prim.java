package Clases;

import Ventanas.VentanaPrincipal;
import java.awt.Color;

public class Algoritmo_Prim {
  private int cumulado;
  
  private int aristaMenor;
  
  private int fin;
  
  private boolean estaNodo = false;
  
  private boolean aumentaTamano;
  
  private int nodoApuntado;
  
  private int nodoApuntador;
  
  private int tamano;
  
  private int arsitaMayor;
  
  private Arboles arboles;
  
  private int tope;
  
  private int nodoOrigen;
  
  public Algoritmo_Prim(Arboles arbol, int top, int aristaMayor) {
    this.cumulado = 0;
    this.aristaMenor = 0;
    this.fin = 0;
    this.estaNodo = false;
    this.aumentaTamano = false;
    this.nodoApuntado = 0;
    this.nodoApuntador = 0;
    this.tamano = 1;
    this.arsitaMayor = aristaMayor;
    this.arboles = arbol;
    this.tope = top;
  }
  
  public int getCumulado() {
    return this.cumulado;
  }
  
  public void prim() {
    this.nodoOrigen = VentanaPrincipal.ingresarNodoOrigen("Ingrese Nodo Origen..", "nodo Origen No existe", this.tope);
    VentanaPrincipal.jPanel1.paint(VentanaPrincipal.jPanel1.getGraphics());
    VentanaPrincipal.R_repaint(this.tope, this.arboles);
    this.arboles.crearEnArbol(this.tope);
    this.arboles.setEnArbol(0, this.nodoOrigen);
    do {
      this.aristaMenor = this.arsitaMayor;
      this.fin = 2;
      for (int j = 0; j < this.tamano; j++) {
        for (int k = 0; k < this.tope; k++) {
          if (this.arboles.getmAdyacencia(k, this.arboles.getEnArbol(j)) == 1) {
            for (int h = 0; h < this.tamano; h++) {
              if (this.arboles.getEnArbol(h) == k) {
                this.estaNodo = true;
                break;
              } 
            } 
            if (!this.estaNodo && 
              this.arboles.getmCoeficiente(k, this.arboles.getEnArbol(j)) <= this.aristaMenor && this.arboles.getmCoeficiente(k, this.arboles.getEnArbol(j)) > 0) {
              this.aristaMenor = this.arboles.getmCoeficiente(k, this.arboles.getEnArbol(j));
              this.nodoApuntado = k;
              this.aumentaTamano = true;
              this.nodoApuntador = this.arboles.getEnArbol(j);
              this.fin = 1;
            } 
            this.estaNodo = false;
          } 
        } 
      } 
      if (this.aumentaTamano != true)
        continue; 
      Pintar.pintarCamino(VentanaPrincipal.jPanel1.getGraphics(), this.arboles.getCordeX(this.nodoApuntador), this.arboles.getCordeY(this.nodoApuntador), this.arboles.getCordeX(this.nodoApuntado), this.arboles.getCordeY(this.nodoApuntado), Color.red);
      Pintar.clickSobreNodo(VentanaPrincipal.jPanel1.getGraphics(), this.arboles.getCordeX(this.nodoApuntador), this.arboles.getCordeY(this.nodoApuntador), null, Color.red);
      Pintar.clickSobreNodo(VentanaPrincipal.jPanel1.getGraphics(), this.arboles.getCordeX(this.nodoApuntado), this.arboles.getCordeY(this.nodoApuntado), null, Color.red);
      this.arboles.setEnArbol(this.tamano, this.nodoApuntado);
      this.tamano++;
      this.aumentaTamano = false;
      this.cumulado += this.aristaMenor;
    } while (this.fin < 2);
  }
}
