package proyecto.negocio;

import proyecto.entidades.Empleado;

import java.util.Scanner;

import proyecto.entidades.Biblioteca;

public class EmpleadoNegocio {

    private Biblioteca biblioteca;

    public EmpleadoNegocio(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    Scanner sc = new Scanner(System.in);

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
        System.out.println("******************************* Lista de empleados *******************************");
        biblioteca.listarEmpleados();
    }

    public void eliminarEmpleado() {
        System.out.println("Ingrese el DNI del empleado que desea eliminar:");
        String dni = sc.nextLine();

        if (biblioteca.eliminarEmpleado(dni)) {
            System.out.println("*********************************");
            System.out.println("Empleado eliminado correctamente");
            System.out.println("*********************************");
        } else {
            System.out.println("No se encontró un empleado con ese DNI.");
        }

        sc.nextLine(); // Espera a que el usuario presione Enter
    }

    public void editarEmpleado() {
        System.out.println("Ingrese el DNI del empleado que desea editar:");
        String dni = sc.nextLine();

        Empleado empleado = biblioteca.buscarEmpleadoPorDni(dni);

        if (empleado != null) {
            System.out.println("Empleado encontrado: ");
            System.out.println(empleado);

            System.out.println("Nuevo nombre:");
            empleado.setNombre(sc.nextLine());

            System.out.println("Nuevo email:");
            empleado.setEmail(sc.nextLine());

            biblioteca.actualizarArchivoEmpleados(); // persistir cambios

            System.out.println("*********************************");
            System.out.println("Empleado editado correctamente");
            System.out.println("*********************************");
        } else {
            System.out.println("No se encontró un empleado con ese DNI.");
        }

        sc.nextLine();
    }

}
