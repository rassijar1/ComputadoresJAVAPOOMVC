/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Vista.InOut;
import Modelo.Procesoasignacion;

public class Ejecutar {

    public static void main(String[] args) {
        InOut ob = new InOut();
        Procesoasignacion ob1 = new Procesoasignacion();
        int op =0;
        do {
            op = ob.pedirentero("\nIngrese opcion: \n1. Agregar equipos. \n2. Mostrar los equipos de la sala 1. \n3. Mostrar los equipos de la sala 2. \n4. Mostrar los equipos dañados. \n5. Buscar un equipo. \n6. Salir");
            switch (op) {
                case 1:
                    ob1.llenardatos();
                    break;
                case 2:
                    ob1.mostrarsala1();
                    break;
                case 3:
                    ob1.mostrarsala2();
                    break;
                case 4:
                    ob1.mostrardañados();
                    break;
                case 5: {
                    int id = ob.pedirentero("Ingrese el ID del equipo a buscar");
                    ob1.buscarequipo(id);
                    break;
                }

            }
        } while (op != 6);
           ob.mostrar("Gracias por registrar los equipos");
    }
}
