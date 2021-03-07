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
 * Clase que gestiona la lógica del juego.
 * 
 * @author Juan Luis Almahano Leiva
 */
public class Juego {
  /**
   * nombres - Array con los nombres de las imágenes desordenados, cada una aparece 2 veces
   * visibles - Array con que se mostrara, con imagen para mostrar, o con la imagen 0 para ocultar
   * hayBoton - Estado del boton tapar, a 1 se pinta
   * anterior - guarda el último boton/imagen pulsado, -1=ninguno
   */
  private String[] nombres;   
  private String[] visibles;  
  private int hayBoton;    
  private int anterior;   
  private int fallos;
  
  /**
   * Constructor, inicializa variables
   */
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
  
  /**
   * Devuelve estado del boton Tapar.
   * @return - Estado del boton.
   */
  public int getBoton() {
    return hayBoton;
  }
  
  /**
   * Establece boton Tapar.
   * @param n - Estado de boton.
   */
  public void setBoton(int n) {
    hayBoton=n;
  }
  
  /**
   * Devuelve anterior.
   * @return - Último boton pulsado.
   */
  public int getAnterior() {
    return anterior;
  }
  
  /**
   * Establece anterior.
   * @param num - Último pulsado.
   */
  public void setAnterior(int num) {
    anterior=num;
  }
  
  /**
   * Rellena el array de nombres con los nombres de las imagenes.
   */
  public void rellenar() {
    for (int i=0; i<16; i++) {
      if (i<8) {
        nombres[i]="imagenes\\"+"imagen"+(i+1)+".jpg";
      } else {
        nombres[i]="imagenes\\"+"imagen"+(i-7)+".jpg";
      }      
    }
  }
  
  /**
   * Baraja la lista de nombres.
   */
  public void barajar() {  
    List<String> lista = Arrays.asList(nombres);  //paso a lista
    Collections.shuffle(lista);                   //barajo lista
    nombres = (String[]) lista.toArray();         //paso a array
  }
  
  /**
   * Copia el array de nombres en el array de visibles.
   */
  public void copiarTodos() {
    for (int i=0; i<16; i++) {
      visibles[i]=nombres[i];
    }
  } 
  
  /**
   * Rellena el array de visibles con la imagen por defecto de tapado.
   */
  public void taparTodos() {
    for (int i=0; i<16; i++) {
      visibles[i]="imagenes\\"+"imagen0.jpg";
    }
  }
  
  /**
   * Copia un elemento del array de nombres al de visibles.
   * @param i - Posición del elemento.
   */
  public void destaparUna(int i) {
    visibles[i]=nombres[i];
  }
  
  /**
   * Copia la imagen tapada en una posición del array de visibles.
   * @param i - Posición del elemento.
   */
  public void ocultarUna(int i) {
    visibles[i]="imagenes\\"+"imagen0.jpg";
  }
  
  /**
   * Comprueba si un elemento del array visibles está oculto.
   * @param i - Posición del elemento.
   * @return - Si está oculto o no.
   */
  public boolean estaOculta(int i) {
    if (visibles[i].equals("imagenes\\"+"imagen0.jpg")) {
      return true;
    } else {
      return false;
    }
  }
  
  /**
   * Devuelve un elemento de los visibles.
   * @param i - Posición del elemento.
   * @return - Nombre del elemento.
   */
  public String mostrar(int i) {
    return visibles[i];
  }
  
  /**
   * Devuelve un nombre.
   * @param i - Posición del elemento.
   * @return - Nombre del elemento.
   */
  public String getNombre(int i) {
    return nombres[i];
  }
  
  /**
   * Incrementa el numero de fallos.
   */
  public void incFallos() {
    fallos++;
  }
  
  /**
   * Reinicia el numero de fallos.
   */
  public void resetFallos() {
    fallos=0;
  }
  
  /**
   * Obtiene el numero de fallos.
   * @return - Número de fallos.
   */
  public int getFallos() {
    return fallos;
  }
}
