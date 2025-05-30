package proyecto.daoArchivos;

import proyecto.entidades.Prestamo;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoPrestamo {
    private static final String ARCHIVO = "prestamos.txt";

    public static void guardarPrestamos(List<Prestamo> prestamos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Prestamo p : prestamos) {
                bw.write(p.toDataString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar préstamos: " + e.getMessage());
        }
    }

    public static List<Prestamo> cargarPrestamos() {
        List<Prestamo> prestamos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Prestamo p = Prestamo.fromDataString(linea);
                if (p != null) {
                    prestamos.add(p);
                }
            }
        } catch (FileNotFoundException e) {
            // El archivo puede no existir al principio, está bien ignorarlo.
        } catch (IOException e) {
            System.out.println("Error al leer préstamos: " + e.getMessage());
        }
        return prestamos;
    }
}
