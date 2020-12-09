package com.Tree;
import javax.swing.*;
public class Main {
    public static void main(String[] args) {

        var opcion = 0;
        int elemento;
        String nombre;
        TreeBinary tree = new TreeBinary();

        while(opcion != 8) {
            try{
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Opciones: \n\n" +
                                "1.- Insertar raíz/nodo \n" +
                                "2.- Eliminar nodo \n" +
                                "3.- Consultar sub arbol derecho \n" +
                                "4.- Consultar sub arbol izquierdo \n" +
                                "5.- Recorrido InOrden \n" +
                                "6.- Recorrido PreOrden \n" +
                                "7.- Recorrido PostOrden \n" +
                                "8.- Salir" + "\n\n"));
                switch (opcion){
                    case 1:
                           elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                   "Ingrese dato al nodo: "));
                           nombre = JOptionPane.showInputDialog(null,
                                   "Ingresa nombre al nodo: ");
                           tree.agregarNodo(elemento, nombre);
                        break;
                    case 2:
                        if (!tree.vacio()) {
                            int eleDele = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingrese elemento a eliminar"));
                            if (tree.eliminar(eleDele) == false) {
                                /*JOptionPane.showMessageDialog(null,
                                        "El elemento no se encuentra en el arbol");*/
                            } else {
                                /*JOptionPane.showMessageDialog(null,
                                        "Se a eliminado el elemento");*/
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio");
                        }
                        break;
                    case 3:
                        if (!tree.vacio()) {
                            System.out.print("\nSubArbol Derecho: \n");
                            tree.subTreeRight(tree.raiz.childDerech);
                        } else {
                            JOptionPane.showMessageDialog(null,"El arbol esta vacio");
                        }
                        break; //8 3 10 14 13 1 6 4 7
                    case 4:
                        if (!tree.vacio()) {
                            System.out.print("\nSubArbol Izquierdo: \n");
                            tree.subTreeLeft(tree.raiz.childIzq);
                        } else {
                            JOptionPane.showMessageDialog(null,"El arbol esta vacio");
                        }
                        break;
                    case 5:
                           if (!tree.vacio()) {
                               System.out.print("\nRecorrido InOrden: \n");
                               tree.inOrden(tree.raiz);
                           } else {
                               JOptionPane.showMessageDialog(null, "El arbol esta vacio");
                           }
                        break;
                    case 6:
                            if (!tree.vacio()){
                                tree.preOrden(tree.raiz);
                            } else {
                                JOptionPane.showMessageDialog(null,"El arbol esta vacio");
                            if (!tree.vacio()) {
                                System.out.print("\nRecorrido PreOrden: \n");
                                tree.preOrden(tree.raiz);
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "El arbol esta vacio");
                            }
                        break;
                    case 7:
                          if (!tree.vacio()) {
                              System.out.print("\nRecorrido PostOrden: \n");
                              tree.postOrden(tree.raiz);
                          } else {
                              JOptionPane.showMessageDialog(null, "El arbol esta vacio");
                          }
                        break;
                    case 8: opcion = 8; break;
                }
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage(),
                        "Opcion no valida", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
