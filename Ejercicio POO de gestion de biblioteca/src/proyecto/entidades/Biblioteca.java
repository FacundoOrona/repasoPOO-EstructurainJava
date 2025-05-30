package proyecto.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import proyecto.daoArchivos.ArchivoEmpleado;
import proyecto.daoArchivos.ArchivoLibro;
import proyecto.daoArchivos.ArchivoPrestamo;
import proyecto.daoArchivos.ArchivoCliente;

public class Biblioteca {
    private List<Libro> libros;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;
    private List<Empleado> empleados;
    private List<Cliente> clientes;

    private Scanner sc = new Scanner(System.in);

    public Biblioteca() {
        libros = ArchivoLibro.cargarLibros();
        usuarios = new ArrayList<>();
        prestamos = ArchivoPrestamo.cargarPrestamos();
        empleados = ArchivoEmpleado.cargarEmpleados();
        clientes = ArchivoCliente.cargarClientes();
    }

    public void registrarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        ArchivoEmpleado.guardarEmpleado(empleado);
    }

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
        ArchivoCliente.guardarCliente(cliente);
    }

    public void registrarLibro(Libro libro) {
        libros.add(libro);
        ArchivoLibro.guardarLibro(libro);
    }

    public boolean eliminarEmpleado(String dni) {
        Iterator<Empleado> iterator = empleados.iterator();
        while (iterator.hasNext()) {
            Empleado empleado = iterator.next();
            if (empleado.getDni().equals(dni)) {
                iterator.remove(); // forma segura
                ArchivoEmpleado.guardarListaCompleta(empleados); // actualizar archivo
                System.out.println("Empleado " + empleado.getNombre() + " eliminado correctamente.");
                return true;
            }
        }
        return false;
    }

    public boolean eliminarCliente(String dni) {
        Iterator<Cliente> iterator = clientes.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getDni().equals(dni)) {
                iterator.remove(); // ✅ eliminar de forma segura
                ArchivoCliente.guardarListaCompleta(clientes); // ✅ actualiza archivo
                System.out.println("Cliente " + cliente.getNombre() + " eliminado correctamente.");
                return true;
            }
        }
        return false;
    }

    public boolean eliminarLibro(int id) {
        Iterator<Libro> iterador = libros.iterator();
        while (iterador.hasNext()) {
            Libro libro = iterador.next();
            if (libro.getId() == id) {
                iterador.remove(); // elimina de la lista
                ArchivoLibro.guardarListaCompleta(libros); // actualiza archivo
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("=== Libros ===\n");
        for (Libro l : libros) {
            sb.append(l).append("\n");
        }

        sb.append("\n=== Usuarios ===\n");
        for (Usuario u : usuarios) {
            sb.append(u).append("\n");
        }

        sb.append("\n=== Préstamos ===\n");
        for (Prestamo p : prestamos) {
            sb.append(p).append("\n");
        }

        return sb.toString();
    }

    public void listarClientes() {
        for (Cliente c : clientes) {
            System.out.println(c.toString());
            System.out.println("------------------------------------------------------------------------------");
        }
        System.out.println("****************************************************************************************");
        System.out.println("|| Presione una tecla para continuar ||");
        sc.nextLine();
    }

    public void listarEmpleados() {
        for (Empleado e : empleados) {
            System.out.println(e.toString());
            System.out.println("------------------------------------------------------------------------------");
        }
        System.out.println("****************************************************************************************");
        System.out.println("|| Presione una tecla para continuar ||");
        sc.nextLine();
    }

    public void prestarLibro(Cliente cliente, Libro libro) {
        Prestamo p = new Prestamo(libro, cliente, new Date());
        prestamos.add(p);

        System.out.println(
                "Préstamo realizado correctamente del libro " + libro.getTitulo() + " al Usuario "
                        + cliente.getNombre());
        System.out.println("********************************************************");
        System.out.println("|| Presione una tecla para continuar ||");
        sc.nextLine();
    }

    public Cliente encontrarCliente(String dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                System.out.println("Cliente encontrado: " + cliente.toString());
                return cliente;
            }
        }
        System.out.println("Cliente no encontrado.");
        return null;
    }

    public Libro encontrarLibro(int id) {
        for (Libro libro : libros) {
            if (libro.getId() == id && libro.getDisponible() == true) {
                System.out.println("Libro encontrado: " + libro.toString());
                return libro;
            }
        }
        return null;
    }

    public Libro encontrarLibroPrestado(int id) {
        for (Libro libro : libros) {
            if (libro.getId() == id && libro.getDisponible() == false) {
                System.out.println("Libro prestado encontrado" + libro.toString());
                return libro;
            }
        }
        return null;
    }

    public Prestamo encontrarPrestamo(int idLibro) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getLibro().getId() == idLibro) {
                System.out.println("Prestamo existente \n " + prestamo.toString());
                return prestamo;
            }
        }
        return null;
    }

    public void devolverLibro(int idLibro) {

    }

    public void mostrarPrestamosActivos() {
        for (Prestamo p : prestamos) {
            if (p.isActivo()) {
                System.out.println(p.toString());
                System.out.println("------------------------------------------------------------------------------");
            }
        }
        System.out.println("****************************************************************************************");
        System.out.println("|| Presione una tecla para continuar ||");
        sc.nextLine();
    }

    public Libro buscarLibroPorTitulo(String titulo) {
        Libro libro = new Libro();
        libro = libro.encontrarLibroPorTitulo(titulo, libros);
        if (libro == null) {
            return null;
        } else {
            return libro;
        }
    }

    public void listarLibros() {
        for (Libro libro : libros) {
            System.out.println(libro.toString());
            System.out.println("------------------------------------------------------------------------------");
        }
        System.out.println("****************************************************************************************");
        System.out.println("|| Presione una tecla para continuar ||");
        sc.nextLine();
    }

    public Empleado buscarEmpleadoPorDni(String dni) {
        for (Empleado e : empleados) {
            if (e.getDni().equals(dni))
                return e;
        }
        return null;
    }

    public Cliente buscarClientePorDni(String dni) {
        for (Cliente c : clientes) {
            if (c.getDni().equals(dni))
                return c;
        }
        return null;
    }

    public void actualizarArchivoEmpleados() {
        ArchivoEmpleado.guardarListaCompleta(empleados);
    }

    public void actualizarArchivoClientes() {
        ArchivoCliente.guardarListaCompleta(clientes);
    }

    public Libro buscarLibroPorId(int id) {
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    public void actualizarLibro(Libro libroEditado) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId() == libroEditado.getId()) {
                libros.set(i, libroEditado); // Reemplaza en la lista
                break;
            }
        }
        ArchivoLibro.guardarListaCompleta(libros); // Sobrescribe archivo con lista actualizada
    }

}
