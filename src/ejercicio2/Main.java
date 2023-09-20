package ejercicio2;

import ejercicio2.dto.ReservasDTO;
import ejercicio2.interfaces.IReservas;
import ejercicio2.servicios.ReservasServiceImplement;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String opc = "1";
        IReservas repo = new ReservasServiceImplement();

        do {
            Scanner s = new Scanner(System.in);
            System.out.println("""
                    Menu:\s
                     1.Reservar\s
                     2.Consultar reservas\s
                     3.Editar reserva
                     4.Eliminar reserva\s
                     5.Ver cantidad de huespedes en el hotel\s
                     6.Salir""");
            opc = s.next();
            switch (opc) {
                case "1" -> {
                    System.out.println("~~~RESERVAR~~~");
                    System.out.println("Ingresa tu numero de id");
                    int id = Integer.parseInt(s.next());
                    System.out.println("Cual es tu nombre?");
                    String name = s.next();
                    System.out.println("Ingresa tu pais de origen:");
                    String pais = s.next();
                    System.out.println("Cuantas personas son?");
                    int numPersonas = Integer.parseInt(s.next());
                    System.out.println("Cuantos dias se van a hospedar?");
                    Integer dias = Integer.valueOf(s.next());
                    System.out.println("Traes mascota?\n" +
                            "Si tienes mascotas debes saber que solo se aceptan en habitaciones Familiares");
                    String pet = s.next();
                    System.out.println("Fumas?");
                    String fuma = s.next();
                    System.out.println("Tipo de habitacion: \n 1.Individual(2 personas) \n 2.Doble(4 personas) \n 3.Familiar(6 personas & mascota)");
                    int hab = Integer.parseInt(s.next());

                    if (hab == 1 && numPersonas <= 2 && Objects.equals(pet, "no")) {
                        String tipHab = "Individual";
                        repo.save(new ReservasDTO(id, tipHab, name, pais, numPersonas, dias, pet, fuma));
                        System.out.println("Reserva exisota: " + repo.findById(id));
                    } else if ((hab == 2) && (numPersonas <= 4) && Objects.equals(pet, "no")) {
                        String tipHab = "Doble";
                        repo.save(new ReservasDTO(id, tipHab, name, pais, numPersonas, dias, pet, fuma));
                        System.out.println("Reserva exisota: " + repo.findById(id));
                    } else if (hab == 3 && numPersonas <= 6) {
                        String tipHab = "Familiar";
                        repo.save(new ReservasDTO(id, tipHab, name, pais, numPersonas, dias, pet, fuma));
                        System.out.println("Reserva exisota: " + repo.findById(id));
                    } else {
                        System.out.println("Reserva invalida, ingresa datos validos");
                    }
                }
                case "2" -> {
                    System.out.println("~~~MOSTRAR RESERVAS~~~");
                    List<ReservasDTO> reservas = repo.findAll();
                    if (!reservas.isEmpty()) {
                        reservas.forEach(System.out::println);
                    } else {
                        System.out.println("No hay reservas");
                    }
                }
                case "3" -> {
                    System.out.println("~~~EDITAR RESERVAS~~~");
                    System.out.println("Ingrese el numedo de id");
                    int id = Integer.parseInt(s.next());
                    boolean busqueda = repo.findById(id) == null;
                    if (!busqueda) {
                        System.out.println("Cual es tu nombre?");
                        String name = s.next();
                        System.out.println("Ingresa tu pais de origen:");
                        String pais = s.next();
                        System.out.println("Cuantas personas son?");
                        int numPersonas = Integer.parseInt(s.next());
                        System.out.println("Cuantos dias se van a hospedar?");
                        Integer dias = Integer.valueOf(s.next());
                        System.out.println("Traes mascota?");
                        String pet = s.next();
                        System.out.println("Fumas?");
                        String fuma = s.next();
                        System.out.println("Tipo de habitacion: \n 1.Individual(2 personas) \n 2.Doble(4 personas) \n 3.Familiar(6 personas & mascota)");
                        int hab = Integer.parseInt(s.next());

                        if (hab == 1 && numPersonas <= 2 && Objects.equals(pet, "no")) {
                            String tipHab = "Individual";
                            repo.update(new ReservasDTO(id, tipHab, name, pais, numPersonas, dias, pet, fuma));
                            System.out.println("Reserva exisota: " + repo.findById(id));
                        } else if ((hab == 2) && (numPersonas <= 4) && Objects.equals(pet, "no")) {
                            String tipHab = "Doble";
                            repo.update(new ReservasDTO(id, tipHab, name, pais, numPersonas, dias, pet, fuma));
                            System.out.println("Reserva exisota: " + repo.findById(id));
                        } else if (hab == 3 && numPersonas <= 6) {
                            String tipHab = "Familiar";
                            repo.update(new ReservasDTO(id, tipHab, name, pais, numPersonas, dias, pet, fuma));
                            System.out.println("Reserva exisota: " + repo.findById(id));
                        } else {
                            System.out.println("Reserva invalida, ingrese bien los datos");
                        }
                    } else {
                        System.out.println("Registro no encontrado");
                    }
                }
                case "4" -> {
                    System.out.println("~~~ELIMINAR RESERVA~~~");
                    System.out.println("Ingresa el numero de id: ");
                    int id = Integer.parseInt(s.next());
                    boolean busqueda = repo.findById(id) == null;
                    if (!busqueda) {
                        System.out.println("Se eliminará la siguiente reserva:\n "+ repo.findById(id));
                        repo.delete(repo.findById(id));
                        System.out.println("Reserva eliiminada exitosamente");
                    } else {
                        System.out.println("Reserva no encontrada");
                    }
                }
                case "5" -> {
                    int huespedestot = repo.findAll().stream().mapToInt(ReservasDTO::getNumberOfPerson).sum();
                    System.out.println("En el hotel se encuentran "+ huespedestot+" Huespedes");
                }
                case "6"->{
                    opc = "6";
                }
            }
        }while (!opc.equals("6")) ;
    }
}
