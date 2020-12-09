package com.Tree;
public class TreeBinary {
    NodoTree raiz;

    public TreeBinary() { raiz = null; }

    public void AgregarNodo(int d, String nomb) {
        NodoTree nuevo = new NodoTree(d, nomb);
        if (raiz == null) {
            raiz = nuevo;
            System.out.println("La raiz ha sido creada");
        } else {
            NodoTree auxiliar = raiz;//nodo auxiliar de tipo nodoarbol, se apunta a la raiz
            NodoTree padre;//nodo padre de tipo nodoarbol, no apunta a nada

            while (true) {
                padre = auxiliar;//padre se apunta a auxiliar, o sease que padre apunta tambien raiz
                if (d < auxiliar.dato) {//si el dato ingresado es < que auxiliar de dato
                    auxiliar = auxiliar.childIzq;

                    if (auxiliar == null) {//si aux==null, ya llego al final
                        padre.childIzq = nuevo;
                        System.out.println("Nodo agregado");
                        return;//finaliza la ejecucion del metodo
                    }
                }else {
                    auxiliar = auxiliar.childDerech;
                    if (auxiliar == null) {
                        padre.childDerech = nuevo;
                        System.out.println("Nodo agregado");
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
            System.out.print(childLeft.dato + " ");
            preOrden(childLeft.childIzq);
        }
    }

    //Print subTree right
    public void subTreeRight(NodoTree childRight) {
        if (childRight != null) {
            System.out.print(childRight.dato + " ");
            preOrden(childRight.childDerech);
        }
    }

    public boolean Eliminar(int d) {
        NodoTree aux = raiz;
        NodoTree padre = raiz;
        boolean eshijoizq = true;

        //para ver si existe el dato
        while (aux.dato != d) {
            padre = aux;
            if (d < aux.dato) {//si es menor
                eshijoizq = true;//hara recorrido hacia la izquierda
                aux = aux.childIzq;
            } else {//si no(es xke es >o= y hara el recorrido por la derecha
                eshijoizq = false;
                aux = aux.childDerech;
            }
            if (aux == null) {//llego hasta el final y no encontro el dato
                return false;//termina, no existe el dato
            }
        }

        if (aux.childIzq == null && aux.childDerech == null) {
            if (aux == raiz) {
                System.out.print("\nNo se puede eliminar el nodo (raiz)" + raiz + "\n");
            }else if (eshijoizq) {
                System.out.print("\nEl nodo " + padre.childIzq + " ha sido eliminado" + "\n");
                padre.childIzq = null;
            } else {
                System.out.print("\nEl nodo " + padre.childDerech + " ha sido eliminado" + "\n");
                padre.childDerech = null;
            }
        }else if (aux.childDerech == null) {
            if (aux == raiz) {
                System.out.print("\nNo es posible eliminar el nodo (raiz) " + aux + "\n");
            }else if (eshijoizq) {//si es hijoizq (padreizq)
                System.out.print("\nNo es posible eliminar el nodo padre " + aux + "\n");
            } else {//si no (va ser padre derecho)
                System.out.print("\nNo es posible eliminar el nodo raiz padre " + aux + "\n");
            }
        }else if (aux.childIzq == null) {//sub-arbol derecho
            if (aux == raiz) {
                System.out.print("\nNo es posible eliminar el nodo (raiz) " + aux + "\n");
            } else if (eshijoizq) {
                System.out.print("\nNo es posible eliminar el nodo padre " + aux + "\n");
            }else {
                System.out.print("\nNo es posible eliminar el nodo padre " + aux + "\n");
            }
        } else {
            System.out.print("\nNo es posible eliminar el nodo (raiz/padre) " + aux + "\n");
        }
        return true;
    }
}