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
public class Arbol_AVL {
    private Nodo_AVL raiz;
    public void insertar(Comparable x)
    {
        raiz=insertar(x,raiz);
    }
    public  Nodo_AVL insertar(Comparable x, Nodo_AVL t)
    {
        Nodo_AVL aux=new Nodo_AVL(4);
        return aux;
    }
}