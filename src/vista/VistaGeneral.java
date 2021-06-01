/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Scanner;

/**
 *
 * @author Alex Zumba
 */
public class VistaGeneral {

    private Scanner entrada;
    private VistaEmpresa vistaEmpresa;

    public VistaGeneral() {
        vistaEmpresa = new VistaEmpresa();
        entrada = new Scanner(System.in);
    }

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("\n*****MENU PRINCIPAL*****");
            System.out.println("1.- Empresas");
            System.out.println("2.- Salir");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    vistaEmpresa.menu();
                    break;
                case 2:
                    System.out.println("HA FINALIZADO EL PROGRAMA");
                    break;
            }
        } while (opcion < 2);
    }
}
