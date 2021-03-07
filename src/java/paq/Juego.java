/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Juan Luis Almahano Leiva
 */
public class Juego {
  private String[] nombres;   //array con los nombres de las imagenes desordenados, cada una aparece 2 veces
  private String[] visibles;  //array con lo que se mostrara: con imagen (para mostrar) o con la 0 (para ocultar)
  private int hayBoton;    //estado del boton tapar (a 1 lo pinta)
  private int anterior;   //guarda el ultimo boton/imagen pulsado (-1=ninguno)
  private int fallos;
  
  public Juego() {
    nombres = new String[16];
    visibles = new String[16];
    rellenar();
    barajar();
    copiarTodos();
    hayBoton=1;
    anterior=-1;
    fallos=0;
  }
  
  public int getBoton() {
    return hayBoton;
  }
  
  public void setBoton(int n) {
    hayBoton=n;
  }
  
  public int getAnterior() {
    return anterior;
  }
  
  public void setAnterior(int num) {
    anterior=num;
  }
  
  public void rellenar() {
    for (int i=0; i<16; i++) {
      if (i<8) {
        nombres[i]="imagenes\\"+"imagen"+(i+1)+".jpg";
      } else {
        nombres[i]="imagenes\\"+"imagen"+(i-7)+".jpg";
      }      
    }
  }
  
  public void barajar() {  
    List<String> lista = Arrays.asList(nombres);  //paso a lista
    Collections.shuffle(lista);                   //barajo lista
    nombres = (String[]) lista.toArray();         //paso a array
  }
  
  public void copiarTodos() {
    for (int i=0; i<16; i++) {
      visibles[i]=nombres[i];
    }
  } 
  
  public void taparTodos() {
    for (int i=0; i<16; i++) {
      visibles[i]="imagenes\\"+"imagen0.jpg";
    }
  }
  
  public void destaparUna(int i) {
    visibles[i]=nombres[i];
  }
  
  public void ocultarUna(int i) {
    visibles[i]="imagenes\\"+"imagen0.jpg";
  }
  
  public boolean estaOculta(int i) {
    if (visibles[i].equals("imagenes\\"+"imagen0.jpg")) {
      return true;
    } else {
      return false;
    }
  }
  
  public String mostrar(int i) {
    return visibles[i];
  }
  
  public String getNombre(int i) {
    return nombres[i];
  }
  
  public void incFallos() {
    fallos++;
  }
  
  public void resetFallos() {
    fallos=0;
  }
  
  public int getFallos() {
    return fallos;
  }
}
