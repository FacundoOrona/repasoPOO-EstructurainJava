package proyecto.daoArchivos;

import java.io.*;
import java.util.*;
import proyecto.entidades.Cliente;

public class ArchivoCliente {

    private static final String ARCHIVO = "clientes.txt";

    public static void guardarCliente(Cliente cliente) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            bw.write(cliente.toString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar cliente: " + e.getMessage());
        }
    }

    public static List<Cliente> cargarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                clientes.add(Cliente.fromString(linea));
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            System.out.println("Error al leer clientes: " + e.getMessage());
        }
        return clientes;
    }

    public static void guardarListaCompleta(List<Cliente> clientes) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Cliente cliente : clientes) {
                bw.write(cliente.getNombre() + " | " + cliente.getDni() + " | " + cliente.getEmail());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al sobrescribir el archivo de clientes: " + e.getMessage());
        }
    }

}
