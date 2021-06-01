/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Alex Zumba
 */
public class Empleado extends Persona {//Herencia 

    private double sueldoBruto;

    public Empleado() {
    }

    public Empleado(long id, String nombre, String apellido, String cedula, String direccion) {
        super(id, nombre, apellido, cedula, direccion);//Enviando los datos del padre con super

    }

    public Empleado(long id, String nombre, String apellido, String cedula, String direccion, double sueldoBruto) {
        super(id, nombre, apellido, cedula, direccion);//llamamos al padre
        this.sueldoBruto = sueldoBruto;//Asignamos el valor al atributo de Empleado
    }

    public double getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    @Override
    public String toString() {
        return "Empleado: " + "sueldoBruto: " + sueldoBruto + super.toString();
    }

}
