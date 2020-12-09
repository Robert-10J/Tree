package com.Tree;
import javax.swing.*;
public class TreeBinary {
    NodoTree raiz;

    public TreeBinary() { raiz = null; }

    public void agregarNodo(int da, String nomb) {
        NodoTree nuev = new NodoTree(da, nomb);
        if (raiz == null) {
            raiz = nuev;
        } else {
            NodoTree aux = raiz;
            NodoTree padre;
            while (true) {
                padre = aux;
                if (da < aux.dato) {
                    aux = aux.childIzq;
                    if (aux == null) {
                        padre.childIzq = nuev;
                        return;
                    }
                } else {
                    aux = aux.childDerech;
                    if (aux == null) {
                        padre.childDerech = nuev;
                        return;
                    }
                }
            }
        }
    }

    //Saber cuando el metodo esta vacio
    public boolean vacio() {
        return raiz == null;
    }

    //Recorrer el arbol InOrden
    public void inOrden(NodoTree ra) {
        if (ra != null) {
            inOrden(ra.childIzq);
            System.out.print(ra.dato + " ");
            inOrden(ra.childDerech);
        }
    }

    //Recorrer el arbol en PostOrden
    public void postOrden(NodoTree ra) {
        if (ra != null) {
            postOrden(ra.childIzq);
            postOrden(ra.childDerech);
            System.out.print(ra.dato + " ");
        }
    }

    //Recorrer en PreOrden
    public void preOrden(NodoTree ra) {
        if (ra != null) {
            System.out.print(ra.dato + " ");
            preOrden(ra.childIzq);
            preOrden(ra.childDerech);
        }
    }

    //Imprimir subTree left
    public void subTreeLeft(NodoTree childLeft){
        if (childLeft != null) {
            subTreeLeft(childLeft.childIzq);
            subTreeLeft(childLeft.childDerech);
            System.out.println(childLeft + " ");
        }
    }

    //Print subTree right
    public void subTreeRight(NodoTree childRight) {
        if (childRight != null) {
            subTreeRight(childRight.childDerech);
            subTreeRight(childRight.childIzq);
            System.out.println(childRight + " ");
        }
    }

    public boolean eliminar(int da) {
        NodoTree aux = raiz;
        NodoTree padre = raiz;
        boolean esHijoIzq = true;

        //Ayuda a saber si el nodo se encuentra o no dentro del arbol
        while (aux.dato != da) {
            if (da < aux.dato) {
                esHijoIzq = true;
                aux = aux.childIzq;
            } else {
                esHijoIzq = false;
                aux = aux.childDerech;
            }

            if (aux == null) {
                return false;
            }
        }

        if (aux.childIzq == null && aux.childDerech == null) {
            if (aux == raiz) {
                System.out.println("No es posible eliminar el nodo de la raiz " + raiz);
            } else if (esHijoIzq) {
                System.out.print("El nodo " + padre.childIzq + " se elimino");
                padre.childIzq = null;
            } else {
                System.out.println("El nodo " + padre.childDerech + " se elimino");
                padre.childDerech = null;
            }
        } else if (aux.childDerech == null) {
            if (aux == raiz) {
                System.out.print("No es posible eliminar la nodo (raiz) " + aux);
            } else if(esHijoIzq) {
                System.out.print("No es posible eliminar el nodo padre " + aux);
            } else {
                System.out.print("No es posible eliminar el nodo raiz padre " + aux);
            }
        } else if (aux.childIzq == null) {
            if (aux == raiz) {
                System.out.print("No es posible eliminar la raiz " + aux);
            } else if (esHijoIzq) {
                System.out.print("No es posible eliminar el nodo padre " + aux);
            } else {
                System.out.print("No es posible eliminar el nodo padre " + aux);
            }
        } else {
            System.out.print("No es posible eliminar el nodo raiz/padre " + aux + "\n");
        }

        return true;
    }
}