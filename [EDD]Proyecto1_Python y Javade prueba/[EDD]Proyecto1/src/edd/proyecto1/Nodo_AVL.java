/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.proyecto1;

/**
 *
 * @author Dénilson Argueta
 */
public class Nodo_AVL {
    public Nodo_AVL izquierda;
    public Nodo_AVL derecha;
    public int altura;
    public Comparable dato;
    public Nodo_AVL(Comparable dato)
    {
        this(dato,null,null);
    }
    public Nodo_AVL(Comparable dato,Nodo_AVL izquierda, Nodo_AVL derecha)
    {
        this.dato=dato;
        this.izquierda=izquierda;
        this.derecha=derecha;
        altura=0;
    }
    
}
