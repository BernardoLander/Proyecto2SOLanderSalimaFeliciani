/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soproyecto2;

/**
 *
 * @author santi
 */
public class  Nodo<T> {
    private Character elemento;
    private Nodo pNext;

    public Nodo(Character elemento, Nodo pNext) {
        this.elemento = elemento;
        this.pNext = pNext;
    }
    
    public Nodo(Character elemento) {
        this.elemento = elemento;
        this.pNext = null;
    }

    public Character getElemento() {
        return elemento;
    }

    public void setElemento(Character elemento) {
        this.elemento = elemento;
    }

    public Nodo getpNext() {
        return pNext;
    }

    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }
}
