package ejercicio4;

import ejercicio4.dto.TurnosDTO;
import ejercicio4.interfaces.ITurnos;
import ejercicio4.service.TurnosService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainTurnos {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String opc = "1";
        ITurnos repo = new TurnosService();
        do {
            Scanner s = new Scanner(System.in);
            System.out.println("Menu \n 1. Toma turno \n 2. Listar \n 3. Llamar a un cliente  \n 4. Contar \n 5. Salir");
            opc = s.next();
            switch (opc) {
                case "1": {
                    System.out.println("Ingrese su nombre para el turno");
                    String nom = s.next();
                    System.out.println("Ingrese su cedula");
                    Integer ced = s.nextInt();
                    repo.save(new TurnosDTO(nom, ced));
                    break;
                }
                case "2": {
                    List<TurnosDTO> turnos = repo.findAll();
                    turnos.forEach(System.out::println);
                    break;
                }
                case "3": {
                    System.out.println("Ingrese su cedula");
                    Integer ced = s.nextInt();
                    repo.delete(repo.findById(ced));
                    repo.findAll().forEach(System.out::println);
                    break;
                }
                case "4": {
                    System.out.print("Turnos totales: " + repo.total() );
                    break;
                }
                case "5": {
                    opc = "5";
                    break;
                }
            }
        } while (opc != "5");

    }
}
