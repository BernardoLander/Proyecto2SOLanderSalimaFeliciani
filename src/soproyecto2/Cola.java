/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soproyecto2;

/**
 *
 * @author lander
 */
public class Cola<T> {
    private Nodo<T> pFirst;
    private Nodo<T> pLast;
    private int size;

    public Cola(){
        pFirst = null;
        pLast = null;
        size = 0;
    }
    
    public boolean esVacia() {
        return size == 0;
    }
    

    public void destructor() {
        while(pFirst!= null) {
            pFirst = pFirst.getpNext();
        }
    }
    

    public void encolar(Character valor) {
        Nodo<T> pNew = new Nodo(valor);
        if (pFirst == null) {
            pFirst = pNew;
        } else {
            pLast.setpNext(pNew);
        }
        pLast = pNew;
        size ++; 
    }

    public void desencolar() {
        pFirst = pFirst.getpNext();
        size --;
        if (pFirst == null) {
            pLast = null;
        }
    }
    

    public Character leerCabeza() {
        return pFirst.getElemento();
    }
    
    public void borrar(Character C) {
        if (esVacia()) {
            System.out.println("Cola vacia");
            return;
        }

        
        if (leerCabeza() == C) {
            pFirst = pFirst.getpNext();
            if (pFirst == null) {
                pLast = null;
            }
            System.out.println("Luchador " + C.getName() + " eliminado");
            size--;
            return;
        }

        Nodo actual = pFirst;
        Nodo anterior = null;

        while (actual != null && actual.getElemento() != C) {
            anterior = actual;
            actual = actual.getpNext();
        }

        if (actual != null) {
            anterior.setpNext(actual.getpNext());
            if (actual == pLast) {
                pLast = anterior;
            }
            System.out.println("Luchador " + C.getName() + " eliminado");
            size--;
        } else {
            System.out.println("Elemento no encontrado");
        }
    }
    
    public Character[] ObtenerCola(){
        
        Character[] resultado = new Character[4];
        int count = 0;
        Nodo pAux = getpFirst();
        
        while (pAux != null && count < 4){
            
            resultado[count] = pAux.getElemento();
            pAux = pAux.getpNext();
            count ++;
        }
        
        return resultado; //Este array esta al reves
    }
    
    public void ImprimirCola() {
        
        Nodo pAux = getpFirst();
        
        while (pAux != null){
            System.out.println(pAux.getElemento().getID()+ ":" +pAux.getElemento().getName()+ ",");
            pAux = pAux.getpNext();
        }
    }
    
    public String ColaInformation() {
        
        Cola Aux = new Cola();
        
        Nodo pAux = getpFirst();
         
        String result = "";
        
        while (pAux != null){
            
            result = result + pAux.getElemento().getID() + ": " + pAux.getElemento().getName() + ";";
            pAux = pAux.getpNext();
            
        }
        
        return result;
    }
    

    public Nodo<T> getpFirst() {
        return pFirst;
    }

    
    public void setpFirst(Nodo<T> pFirst) {
        this.pFirst = pFirst;
    }


    public Nodo<T> getpLast() {
        return pLast;
    }


    public void setpLast(Nodo<T> pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}


