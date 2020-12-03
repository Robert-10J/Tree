package com.Tree;
public class NodoTree {

    int dato;
    String nombre;
    NodoTree childIzq, childDerech;

    public NodoTree(int da, String nomb) {
        this.dato = da;
        this.nombre = nomb;
        this.childDerech = null;
        this.childIzq = null;
    }

    public String toString() {
        return nombre + " El dato es " + dato;
    }
}
