/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorEmpresa;
import java.util.Scanner;
import modelo.Cliente;
import modelo.Directivo;
import modelo.Empleado;
import modelo.Empresa;

/**
 *
 * @author Alex Zumba
 */
public class VistaEmpresa {

    private ControladorEmpresa controladorEmpresa;
    private VistaPersona vistaPersona;
    private Scanner entrada;

    public VistaEmpresa() {
        controladorEmpresa = new ControladorEmpresa();
        entrada = new Scanner(System.in);
    }

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("\n/////MENU EMPRESA/////");
            System.out.println("1.- Crear");
            System.out.println("2.- Actualizar");
            System.out.println("3.- Buscar");
            System.out.println("4.- Eliminar");
            System.out.println("5.- Listar");
            System.out.println("6.- Gestionar cliente");
            System.out.println("7.- Gestionar empleado");
            System.out.println("8.- Gestionar directivo");
            System.out.println("9.- Salir");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    crear();
                    break;
                case 2:
                    actualizar();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    eliminar();
                    break;
                case 5:
                    listar();
                    break;
                case 6:
                    cliente();
                    break;
                case 7:
                    empleado();
                    break;
                case 8:
                    directivo();
                    break;
                case 9:
                    System.out.println("---Ha finalizado el menu Empresa---");
                    break;
            }
        } while (opcion < 9);
    }

    public void crear() {
        System.out.print("Ingrese el nombre: ");
        String nombre = entrada.next();
        System.out.println("Resultado: " + controladorEmpresa.crear(nombre));
    }

    public Empresa buscar() {
        System.out.print("Ingrese el nombre de la empresa: ");
        String nombre = entrada.next();
        Empresa empresa = controladorEmpresa.buscar(nombre);
        controladorEmpresa.setSeleccionado(empresa);
        System.out.println(empresa);
        return empresa;
    }

    public void actualizar() {
        Empresa empresa = buscar();
        System.out.print("Ingrese nombre nuevo: ");
        String nombreNuevo = entrada.next();
        System.out.println("Resultado: " + controladorEmpresa.actualizar(empresa.getNombre(), nombreNuevo));
    }

    public void eliminar() {
        Empresa empresa = buscar();
        System.out.println("Resultado: " + controladorEmpresa.eliminar(empresa.getNombre()));
    }

    public void listar() {
        for (Empresa empresa : controladorEmpresa.getListaEmpresa()) {
            System.out.println(empresa);
        }
    }

    public void cliente() {
        Empresa empresa = buscar();
        if (empresa != null) {
            this.vistaPersona = new VistaPersona(Cliente.class);
            vistaPersona.menu();
        }
    }

    public void empleado() {
        Empresa empresa = buscar();
        if (empresa != null) {
            this.vistaPersona = new VistaPersona(Empleado.class);
            vistaPersona.menu();
        }
    }

    public void directivo() {
        Empresa empresa = buscar();
        if (empresa != null) {
            this.vistaPersona = new VistaPersona(Directivo.class);
            vistaPersona.menu();
        }
    }
}
