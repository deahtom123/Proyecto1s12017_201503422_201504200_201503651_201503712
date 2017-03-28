/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.proyecto1;
import java.util.Scanner; 
/**
 *
 * @author Dénilson Argueta
 */
public class EDDProyecto1 {

    /**
     * @param args the command line arguments
     */
    public  static void main(String[] args) {
        // TODO code application logic here
        Ventana prueba=new Ventana();
        prueba.setVisible(true);
//        Btree m=new 
//Btree();
//
//NodoPr fa;
//
//for(int i=0;i<14;i++){
//    
//    
//fa=new NodoPr(i);
//m.Inserta(fa);
//}
//fa=new NodoPr(4);
//m.Eliminar(fa);
//m.InordenIT();
//System.out.println(m.salida);
    }
 

public  static void DemostracionArbolBinarioBusqueda(){ 
//Inicializamos el árbol binario de búsqueda 
ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda(); 
int iOpcion = 0, iDato; 
//Desplegar las instrucciones 
System.out.println("DEMOSTRACION ARBOL DE BUSQUEDA BINARIA "); 
instrucciones();
Scanner in = new Scanner (System.in);
do{
System.out.println("Opcion:");
iOpcion = in.nextInt();
switch(iOpcion){ 
case 1: //Insertar un dato 
System.out.println("Introduce el dato a insetar: ");
iDato = in.nextInt(); 
arbol.insertar(iDato); 
arbol.imprimir(); 
break; 
case 2: //Eliminar un dato 
System.out.println("Introduce el dato a eliminar:");
iDato = in.nextInt(); 
arbol.eliminar(iDato); 
arbol.imprimir(); 
break; 
case 3: //Buscar un dato 
System.out.println("Introduce el dato a buscar");
iDato = in.nextInt(); 
arbol.buscar(iDato); 
break; 
case 4: //Recorrido preorden 
arbol.recorridoPreorden(); 
break; 
case 5: //Recorrido inorden 
arbol.recorridoInorden(); 
break; 
case 6: //Recorrido postorden 
arbol.recorridoPostorden(); 
break; 
case 7: //Vaciar el árbol 
arbol.vaciar(); 
arbol.imprimir(); 
} 
}while(iOpcion != 8); 
} 

private static void instrucciones(){ 
System.out.println(" Elige una opcion "+ 
"1 para insertar un dato "+ 
"2 para eliminar un dato "+ 
"3 para buscar un dato "+ 
"4 para imprimir el recorrido preorden "+ 
"5 para imprimir el recorrido inorden o simetrico "+ 
"6 para imprimir el recorrido postorden "+ 
"7 para vaciar el arbol "+ 
"8 para salir del programa "); 
} 
} 


