package ejercicio6;

import ejercicio6.dto.CitasDTO;
import ejercicio6.interfaces.ICitas;
import ejercicio6.service.CitasService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainCitas {
    public static void main(String[] args)  throws IOException, ClassNotFoundException {
        String opc = "1";
        ICitas repo = new CitasService();
        do {
            Scanner s = new Scanner(System.in);
            System.out.print("Menu \n 1. Programar cita  \n 2. Ver citas programadas \n 3. Cancelar cita \n 4. Salir");
            opc = s.next();
            switch (opc) {
                case "1": {
                    System.out.println("Ingrese su nombre");
                    String nom = s.next();
                    System.out.println("Ingrese su cedula");
                    Integer ced = s.nextInt();
                    System.out.println("Fecha de la cita");
                    String fec = s.next();
                    System.out.println("Nombre del medico");
                    String med = s.next();
                    repo.save(new CitasDTO(nom,ced, fec, med));
                    break;
                }
                case "2": {
                    List<CitasDTO> citas = repo.findAll();
                    if(!citas.isEmpty()){
                        citas.forEach(System.out::println);
                    }else{
                        System.out.println("No hay citas");
                    }
                    break;

                }
                case "3": {
                    System.out.println("Cancelar cita");
                    System.out.print("Ingrese su cedula para cancelar la cita ");
                    Integer ced = s.nextInt();
                    repo.delete(repo.findById(ced));
                    repo.findAll().forEach(System.out::println);
                    break;
                }
                case "4": {
                    opc = "4";
                    break;
                }
            }
        } while (opc != "4");
    }
}
