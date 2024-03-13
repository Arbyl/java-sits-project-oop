
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Main implements Serializable {

    public boolean existeCliente(int pId, ArrayList<Asistente> pAssist) {
        boolean existe = false;
        for (int i = 0; i < pAssist.size(); i++) {
            int evalAsistente = pAssist.get(i).getId();

            if (pId == evalAsistente) {
                existe = true;
            }
        }
        return existe;
    }

    public boolean asientoDisponible(int pFila, int pColumna, char[][] pAsientos) {
        boolean disponible = false;
        if (pAsientos[pFila][pColumna] == 'D') {
            disponible = true;
        }
        return disponible;
    }

    public static void main(String[] args) {
        char asientos[][] = new char[10][10];
        ArrayList<Asistente> mAsistentes = new ArrayList<>();
        Main main = new Main();

        boolean active = true;
        // inicializar el sistema con todos los asientos disponibles
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                asientos[i][j] = 'D';
            }
        }

        Scanner lector = new Scanner(System.in);
        // ejecucion del loop
        do {
            System.out.println("Bienvenido al sistema de asignacion de asientos");

            System.out.println("1. Comprar asiento");
            System.out.println("2. Registar nuevo cliente");
            System.out.println("3. Ver asientos disponibles");
            System.out.println("4. Ver lista de asistentes");
            System.out.println("5. Guardar");
            System.out.println("6. Cargar");
            System.out.println("7. Salir");

            switch (lector.nextInt()) {
                case 1:

                    System.out.println("Seleccione el asiento de su preferencia");
                    System.out.println("Ingrese la fila");
                    int filaC1 = lector.nextInt();
                    System.out.println("Ingrese la columna");
                    int columnaC1 = lector.nextInt();
                    System.out.println("Ingrese el id del cliente");
                    int idC1 = lector.nextInt();
                    System.out.println("Costo del asiento");
                    int costoDeAsiento = lector.nextInt();

                    if (main.asientoDisponible(filaC1, columnaC1, asientos) && main.existeCliente(idC1, mAsistentes)) {
                        for (int i = 0; i < mAsistentes.size(); i++) {
                            Asistente asistenteActual = mAsistentes.get(i);
                            if (asistenteActual.getDineroActual() < costoDeAsiento) {
                                System.out.println("El cliente no tiene suficiente dinero para comprar el asiento");
                            } else {
                                asistenteActual
                                        .setDineroActual(asistenteActual.getDineroActual() - costoDeAsiento);
                                asientos[filaC1][columnaC1] = 'X';
                                System.out.println("***********************");

                                System.out.println("El cliente " + mAsistentes.get(i).getNombre()
                                        + " ha comprado el asiento " + filaC1 + " " + columnaC1);
                                System.out.println("Se ha descontado " + costoDeAsiento + " de su cuenta");
                                System.out.println("***********************");
                            }
                        }
                        break;

                    } else {
                        System.out.println("El cliente no existe, desea crear un nuevo cliente? (s/n)");
                        String respuesta = lector.next();
                        if (!respuesta.equalsIgnoreCase("s")) {
                            break;
                        }

                    }

                case 2:
                    System.out.println("*****Se encuentra en el registro de clientes*****");

                    System.out.println("Ingrese el nombre del cliente");
                    String nombre = lector.next();
                    System.out.println("Ingrese el id del cliente");
                    int id = lector.nextInt();
                    System.out.println("Ingrese la edad del cliente");
                    int edad = lector.nextInt();
                    System.out.println("Ingrese el dinero a recargar del cliente");
                    int dinero = lector.nextInt();

                    if (!main.existeCliente(id, mAsistentes)) {
                        Asistente newAsistente = new Asistente(nombre, id, edad, dinero);
                        mAsistentes.add(newAsistente);
                    }
                    break;
                case 3:
                    System.out.println("*****Asientos disponibles*****");
                    System.out.println("    ----|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|----");
                    System.out.println("    ----|        S C R E E N          |----");
                    System.out.println("    ----|_____________________________|----");

                    String fila = "ABCDEFGHIJ";
                    System.out.println("     1   2   3   4   5   6   7   8   9   10");
                    System.out.println("    ___ ___ ___ ___ ___ ___ ___ ___ ___ ___");
                    for (int i = 0; i < asientos.length; i++) {
                        String filaActual = fila.charAt(i) + "|  ";
                        for (int j = 0; j < asientos.length; j++) {
                            filaActual += "["+asientos[i][j] + "] ";
                        }
                        System.out.println(filaActual);
                    }
                    System.out.println(" \n ");

                    break;
                case 4:
                    System.out.println("Lista de asistentes");
                    for (int i = 0; i < mAsistentes.size(); i++) {
                        System.out.println("Nombre: " + mAsistentes.get(i).getNombre());
                        System.out.println("Id: " + mAsistentes.get(i).getId() + "\n");
                    }
                    break;
                case 5:
                    
                    break;
                case 6:
                   
                    break;
                case 7:
                    active = false;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;

            }
        } while (active == true);
        lector.close();
    }
}
