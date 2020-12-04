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
                                   "Ingrese numero del nodo: "));
                           nombre = JOptionPane.showInputDialog(null,
                                   "Ingresa nombre del nodo: ");
                           tree.agregarNodo(elemento, nombre);
                        break;
                    case 2:
                        if (!tree.vacio()) {
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingrese numero del nodo a eliminar: "));
                            if (tree.elimminar(elemento) == false) {
                                JOptionPane.showMessageDialog(null, "Nodo no encontrado");
                            } else {
                                JOptionPane.showMessageDialog(null,"Nodo eliminado");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "El arbol esta vacio");
                        }
                        break;
                    case 3:
                        if (!tree.vacio()) {
                            tree.subTreeRight(tree.raiz.childDerech);
                        } else {
                            JOptionPane.showMessageDialog(null,"El arbol esta vacio");
                        }
                        break; //8 3 10 14 13 1 6 4 7
                    case 4:
                        if (!tree.vacio()) {
                            tree.subTreeLeft(tree.raiz.childIzq);
                        } else {
                            JOptionPane.showMessageDialog(null,"El arbol esta vacio");
                        }
                        break;
                    case 5:
                           if (!tree.vacio()) {
                               tree.inOrden(tree.raiz);
                           } else {
                               JOptionPane.showMessageDialog(null,
                                       "El arbol esta vacio");
                           }
                        break;
                    case 6:
                            if (){

                            } else {
                                
                            }
                        break;
                    case 7:
                          if (!tree.vacio()) {
                              tree.postOrden(tree.raiz);
                          } else {
                              JOptionPane.showMessageDialog(null,
                                      "El arbol esta vacio");
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
