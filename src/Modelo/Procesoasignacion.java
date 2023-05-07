/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.InOut;
import java.util.ArrayList;
import Modelo.Caracteristicas;

public class Procesoasignacion {

    InOut ob = new InOut();
    ArrayList<Caracteristicas> Sala1 = new ArrayList<Caracteristicas>();
    ArrayList<Caracteristicas> Sala2 = new ArrayList<Caracteristicas>();
    ArrayList<Caracteristicas> equipos_dañados = new ArrayList<Caracteristicas>();
    ArrayList<Caracteristicas> equipostotal = new ArrayList<Caracteristicas>();
    int tam = 0;

    public void llenardatos() {
        int id = 0, opcion = 0;
        Caracteristicas equipo = new Caracteristicas();
        String mar = "";
        String proce = "";
        String dis = "";
        String ram = "";
        String lin = "\nJava" + "\nPHP" + "\nC++" + "\nPython";
        String win = "\nWord" + "\nPowerpoint" + "\nExcel" + "\nPublisher";
        String con = "";
        String comp = "linux";
        String comp1 = "windows";

        tam = ob.pedirentero("¿Cuantos equipos desea registrar?");
        while (tam < 5) {
            ob.mostrar("\nInformacion invalida, recuerde que el minimo de equipos a registrar es de 5");
            tam = ob.pedirentero("¿Cuantos equipos desea ingresar?");
        }
        for (int i = 0; i < tam; i++) {
            
            mar = ob.pedircaracter("Ingrese la marca del equipo" + (i + 1));
            equipo.setMarca(mar);
            ram = ob.pedircaracter("Ingrese el tamaño de la memoria ram");
            equipo.setRam(ram);
            proce = ob.pedircaracter("Ingrese la frecuencia del procesador");
            equipo.setProcesador(proce);
            dis = ob.pedircaracter("Ingrese el tamaño del disco duro");
            equipo.setDisco(dis);
            id = ob.pedirentero("Ingrese el id del equipo");
            while (validarequipo(id) || id < 0) {

                ob.mostrar("Error");
                id = ob.pedirentero("ingrese el id del equipo");
            }
            equipo.setId(id);

            con = ob.pedircaracter("Digite el S.O, ya sea windows o linux");

            while (( con.equalsIgnoreCase(comp) || con.equalsIgnoreCase(comp1)) == false) {
                ob.mostrar("Error, vuelva a digitar");
                con = ob.pedircaracter("Digite el S.O, ya sea windows o linux");
            }
            equipo.setCon(con);

            if (con.equalsIgnoreCase(comp)) {
                ob.mostrar("Los software instalados son:");
                ob.mostrar(lin);
                opcion = ob.pedirentero("\nIngrese opción : \n1. Añadir equipo a las sala 1. \n2. Añadir equipo a la sala 2. \n3. Reportar como dañado.");
                switch (opcion) {

                    case 1:
                        Sala1.add(equipo);
                        ob.mostrar("Equipo añadido a la sala 1");
                        break;

                    case 2:
                        Sala2.add(equipo);
                        ob.mostrar("Equipo añadido a la sala 2");
                        break;
                    case 3:
                        equipos_dañados.add(equipo);
                        ob.mostrar("Equipo Reportado como dañado");
                        break;
                    default:
                        ob.mostrar("La opcion no esta en el menu");
                        break;
                }

            } else if (con.equalsIgnoreCase(comp1)) {
                ob.mostrar("Los software instalados son:");
                ob.mostrar(win);

                opcion = ob.pedirentero("Ingrese 1 para añadir equipo a las sala 1, 2 para añadir a la sala 2, 3 para reportar como dañado");
                switch (opcion) {

                    case 1:
                        Sala1.add(equipo);
                        ob.mostrar("Equipo añadido a la sala 1");
                        break;

                    case 2:
                        Sala2.add(equipo);
                        ob.mostrar("Equipo añadido a la sala 2");
                        break;
                    case 3:
                        equipos_dañados.add(equipo);
                        ob.mostrar("Equipo Reportado como dañado");
                        break;
                    default:
                        ob.mostrar("Ea opcion no esta en el menu");

                        break;
                }
            }

            equipostotal.add(equipo);

        }

    }

    public void mostrarsala1() {
        ob.mostrar("Datos de la sala 1");
        for (int i = 0; i < Sala1.size(); i++) {

            ob.mostrar("Las caracteristicas de los equipos son :\n" + "\nmarca: " + Sala1.get(i).getMarca() + "\ntamaño de memoria ram: " + Sala1.get(i).getRam() + "\nTamaño del procesador: " + Sala1.get(i).getProcesador() + "\nTamaño del disco duro: " + Sala1.get(i).getDisco() + "\nId: " + Sala1.get(i).getId() + "\nSistema operativo: " + Sala1.get(i).getCon());
        }
    }

    public void mostrarsala2() {
        ob.mostrar("Datos de la sala 2: ");
        for (int i = 0; i < Sala2.size(); i++) {
            ob.mostrar("Las caracteristicas de los equipos son :\n" + "\nmarca: " + Sala2.get(i).getMarca() + "\ntamaño de memoria ram: " + Sala2.get(i).getRam() + "\nTamaño del procesador: " + Sala2.get(i).getProcesador() + "\nTamaño del disco duro: " + Sala2.get(i).getDisco() + "\nId: " + Sala2.get(i).getId() + "\nSistema operativo: " + Sala2.get(i).getCon());
        }
    }

    public void mostrardañados() {
        ob.mostrar("Datos de los equipos dañados: ");
        for (int i = 0; i < equipos_dañados.size(); i++) {
            ob.mostrar("Las caracteristicas de los equipos son :\n" + "\nmarca: " + equipos_dañados.get(i).getMarca() + "\ntamaño de memoria ram: " + equipos_dañados.get(i).getRam() + "\nTamaño del procesador: " + equipos_dañados.get(i).getProcesador() + "\nTamaño del disco duro: " + equipos_dañados.get(i).getDisco() + "\nId: " + equipos_dañados.get(i).getId() + "\nSistema operativo: " + equipos_dañados.get(i).getCon());
        }

    }

    public boolean buscarequipo(int id) {
        int a = 0;
        for (int i = 0; i < equipostotal.size(); i++) {
            if (equipostotal.get(i).getId() == id) {
                ob.mostrar("Las caracteristicas del  equipo son :\n" + "\nmarca:" + equipostotal.get(i).getMarca() + "\ntamaño de memoria ram:" + equipostotal.get(i).getRam() + "\nTamaño del procesador:" + equipostotal.get(i).getProcesador() + "\nTamaño del disco duro:" + equipostotal.get(i).getDisco() + "\nId:" + equipostotal.get(i).getId() + "\nSistema operativo:" + equipostotal.get(i).getCon());
                a = 1;
            }

        }

        if (a == 1) {
            return true;
        } else {
            ob.mostrar("El equipo no se encuentra registrado.");
            return false;
        }
    }

    public boolean validarequipo(int id) {
        int a = 0;
        for (int i = 0; i < equipostotal.size(); i++) {
            if (equipostotal.get(i).getId() == id) {
                ob.mostrar(id + "==" + equipostotal.get(i).getId());
                a = 1;
            }
        }
        if (a == 1) {
            return true;
        } else {
            return false;
        }
    }
}
