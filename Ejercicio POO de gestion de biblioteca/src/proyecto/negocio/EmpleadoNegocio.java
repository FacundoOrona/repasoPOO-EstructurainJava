package proyecto.negocio;

import proyecto.entidades.Empleado;

import java.util.Scanner;

import proyecto.entidades.Biblioteca;

public class EmpleadoNegocio {

    Scanner sc = new Scanner(System.in);
    Biblioteca biblioteca = new Biblioteca();

    public void registrarEmpleado() {

        Empleado empleado = new Empleado();

        System.out.println("Ingrese los datos para registrar Empleado");
        System.out.println("Nombre:");
        empleado.setNombre(sc.nextLine());
        System.out.println("Email:");
        empleado.setEmail(sc.nextLine());
        System.out.println("DNI:");
        empleado.setDni(sc.nextLine());

        biblioteca.registrarEmpleado(empleado);

        System.out.println("*********************************");
        System.out.println("Empleado registrado correctamente");
        System.out.println("*********************************");
        sc.nextLine();  
    }

    public void listarEmpleados() {
        System.out.println("-*** Lista de empleados ***-");
        biblioteca.listarEmpleados();
    }

}
