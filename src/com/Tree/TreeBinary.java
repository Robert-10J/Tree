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
            //System.out.print(ra.dato);
            JOptionPane.showMessageDialog(null, " " + ra.dato);
            inOrden(ra.childDerech);
        }
    }

    //Recorrer el arbol en PostOrden
    public void postOrden(NodoTree ra) {
        if (ra != null) {
            postOrden(ra.childIzq);
            postOrden(ra.childDerech);
            System.out.println(ra.dato);
        }
    }

    //Recorrer en PreOrden
    public void preOrden(NodoTree ra) {
        if (ra != null) {
            JOptionPane.showMessageDialog(null, ra.dato);
            preOrden(ra.childIzq);
            preOrden(ra.childDerech);
        }
    }

    //Elimiar nodo
    public boolean elimminar(int da) {
        NodoTree aux = raiz;
        NodoTree padre = raiz;
        boolean esChildIzq = true;

        while (aux.dato != da) {
            padre = aux;
            if (da < aux.dato) {
                esChildIzq = true;
                aux = aux.childIzq;
            } else {
                esChildIzq = false;
                aux = aux.childDerech;
            }

            if (aux == null) {
                return false;
            }
        }

        if ( aux.childIzq == null && aux.childDerech == null) {
            if (aux == raiz) {
                raiz = null;
            } else if(esChildIzq) {
                padre.childIzq = null;
            } else {
                padre.childDerech = null;
            }
        } else if(aux.childDerech == null) {
            if (aux == raiz) {
                    raiz = aux.childIzq;
                } else if(esChildIzq) {
                    padre.childIzq = aux.childIzq;
                } else {
                    padre.childDerech = aux.childIzq;
                }
            } else if(aux.childIzq == null) {
                if (aux == raiz) {
                    raiz = aux.childDerech;
                } else if(esChildIzq) {
                    padre.childIzq = aux.childDerech;
                } else {
                    padre.childDerech = aux.childIzq;
                }
            } else {
                NodoTree reemplazo = obtenerNodoReemplazo(aux);
                if(aux == raiz) {
                    raiz = reemplazo;
                } else if (esChildIzq) {
                    padre.childIzq = reemplazo;
                } else {
                    padre.childDerech = reemplazo;
                }
                reemplazo.childIzq = aux.childIzq;
            }
            return true;
        }

    //Devolver el nodoReemplazo
    public NodoTree obtenerNodoReemplazo(NodoTree nodoReem) {
        NodoTree reemplazarPadre = nodoReem;
        NodoTree reemplazo = nodoReem;
        NodoTree aux = nodoReem.childDerech;

        while (aux != null) {
            reemplazarPadre = reemplazo;
            reemplazo = aux;
            aux = aux.childIzq;
        }

        if(reemplazo != nodoReem.childDerech) {
            reemplazarPadre.childIzq = reemplazo.childDerech;
            reemplazo.childDerech = nodoReem.childDerech;
        }

        System.out.println("El nodo reemplazo es: " + reemplazo);
        JOptionPane.showMessageDialog(null, "El nodo reemplazo es: " + reemplazo);
        return reemplazo;
    }
}
