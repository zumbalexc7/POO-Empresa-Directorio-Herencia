/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorPersona;
import java.util.Scanner;
import modelo.Cliente;
import modelo.Directivo;
import modelo.Empleado;
import modelo.Persona;

/**
 *
 * @author Alex Zumba
 */
public class VistaPersona {

    public ControladorPersona controladorPersona;
    public Scanner entrada;
    public Class tipo; // Este artibuto, tipo de las clase hija que va a realizar la gestion.

    public VistaPersona(Class tipo) {
        controladorPersona = new ControladorPersona();
        entrada = new Scanner(System.in);
        this.tipo = tipo;
    }

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("\n+++++MENU GESTION DE EMPRESAS+++++");
            System.out.println("1.- Crear");
            System.out.println("2.- Actualizar");
            System.out.println("3.- Buscar");
            System.out.println("4.- Eliminar");
            System.out.println("5.- Listar");
            System.out.println("6.- Salir");
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
                    System.out.println("**Fin del menu**");
                    break;
            }
        } while (opcion < 6);
    }

    public void crear() {
        System.out.print("Ingrese el nombre: ");
        String nombre = entrada.next();
        System.out.print("Ingrese el apellido: ");
        String apellido = entrada.next();
        System.out.print("Ingrese el cedula: ");
        String cedula = entrada.next();
        System.out.print("Ingrese el direccion: ");
        String direccion = entrada.next();
        if (tipo == Cliente.class) {
            System.out.print("Ingrese el telefono: ");
            String telefono = entrada.next();
            System.out.println("Resultado: " + controladorPersona.crearCliente(nombre, apellido, cedula, direccion, telefono));
        } else if (tipo == Empleado.class) {
            System.out.print("Ingrese el sueldo: ");
            double sueldo = entrada.nextDouble();
            System.out.println("Resultado: " + controladorPersona.crearEmpleado(nombre, apellido, cedula, direccion, sueldo));
        } else {
            System.out.print("Ingrese el sueldo: ");
            double sueldo = entrada.nextDouble();
            System.out.print("Ingrese el categoria: ");
            String categoria = entrada.next();
            System.out.println("Resultado: " + controladorPersona.crearDirectivo(nombre, apellido, cedula, direccion, sueldo, categoria));
        }
    }

    public Persona buscar() {
        System.out.print("Ingrese el cedula: ");
        String cedula = entrada.next();
        Persona persona = controladorPersona.buscar(cedula);
        System.out.println(persona);
        return persona;
    }

    public void actualizar() {
        Persona persona = buscar();
        if (persona != null) {
            System.out.print("Ingrese el nombre: ");
            String nombre = entrada.next();
            System.out.print("Ingrese el apellido: ");
            String apellido = entrada.next();
            System.out.print("Ingrese el direccion: ");
            String direccion = entrada.next();
            if (tipo == Cliente.class) {
                System.out.print("Ingrese el telefono: ");
                String telefono = entrada.next();
                System.out.println("Resultado: " + controladorPersona.actualizarCliente(nombre, apellido, persona.getCedula(), direccion, telefono));
            } else if (tipo == Empleado.class) {
                System.out.print("Ingrese el sueldo: ");
                double sueldo = entrada.nextDouble();
                System.out.println("Resultado: " + controladorPersona.actualizarEmpleador(nombre, apellido, persona.getCedula(), direccion, sueldo));
            } else {
                System.out.print("Ingrese el sueldo: ");
                double sueldo = entrada.nextDouble();
                System.out.print("Ingrese el categoria: ");
                String categoria = entrada.next();
                System.out.println("Resultado: " + controladorPersona.actualizarDirectivo(nombre, apellido, persona.getCedula(), direccion, sueldo, categoria));
            }
        }
    }

    public void eliminar() {
        Persona persona = buscar();
        if (persona != null) {
            System.out.println("Resultado: " + controladorPersona.eliminar(persona.getCedula()));
        }
    }

    public void listar() {
        for (Object objeto : controladorPersona.getListaPersona()) {
            if (objeto.getClass() == Empleado.class) {
                Empleado empleado = (Empleado) objeto;
                System.out.println(empleado);
            } else if (objeto.getClass() == Cliente.class) {
                Cliente cliente = (Cliente) objeto;
                System.out.println(cliente);
            } else {
                Directivo directivo = (Directivo) objeto;
                System.out.println(directivo);
            }
        }
    }

    public ControladorPersona getControladorPersona() {
        return controladorPersona;
    }

    public void setControladorPersona(ControladorPersona controladorPersona) {
        this.controladorPersona = controladorPersona;
    }

    public Class getTipo() {
        return tipo;
    }

    public void setTipo(Class tipo) {
        this.tipo = tipo;
    }
}
