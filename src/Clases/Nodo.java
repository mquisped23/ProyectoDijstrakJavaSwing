package Clases;

public class Nodo {
  private int nombre = -1;
  
  private boolean visitado = false;
  
  private boolean etiqueta = false;
  
  private Nodo Predecesor = null;
  
  private int acumulado = 0;
  
  public int getNombre() {
    return this.nombre;
  }
  
  public boolean isVisitado() {
    return this.visitado;
  }
  
  public boolean isEtiqueta() {
    return this.etiqueta;
  }
  
  public int getAcumulado() {
    return this.acumulado;
  }
  
  public Nodo getPredecesor() {
    return this.Predecesor;
  }
  
  public void setNombre(int nombre) {
    this.nombre = nombre;
  }
  
  public void setVisitado(boolean visitado) {
    this.visitado = visitado;
  }
  
  public void setEtiqueta(boolean etiqueta) {
    this.etiqueta = etiqueta;
  }
  
  public void setAcumulado(int acomulado) {
    this.acumulado = acomulado;
  }
  
  public void setPredecesor(Nodo Predecesor) {
    this.Predecesor = Predecesor;
  }
}