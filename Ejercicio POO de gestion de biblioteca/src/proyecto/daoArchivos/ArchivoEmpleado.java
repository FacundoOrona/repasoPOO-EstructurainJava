package proyecto.daoArchivos;

import java.io.*;
import java.util.*;
import proyecto.entidades.Empleado;

public class ArchivoEmpleado {

    private static final String ARCHIVO = "empleados.txt";

    public static void guardarEmpleado(Empleado empleado) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            bw.write(empleado.toString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar empleado: " + e.getMessage());
        }
    }

    public static List<Empleado> cargarEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                empleados.add(Empleado.fromString(linea));
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            System.out.println("Error al leer empleados: " + e.getMessage());
        }
        return empleados;
    }
}

