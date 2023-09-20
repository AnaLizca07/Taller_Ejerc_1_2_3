package ejercicio3;

import ejercicio2.dto.ReservasDTO;
import ejercicio3.dto.EstadisticasDTO;
import ejercicio3.interfaces.IEstadisticas;
import ejercicio3.servicios.EstadisticasServiceImplement;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String opc = "1";
        IEstadisticas repo = new EstadisticasServiceImplement();
        do {
            Scanner s = new Scanner(System.in);
            System.out.println("~~Atencion al cliente~~");
            System.out.println("Ingrese su cedula o TI:");
            Integer id = Integer.valueOf(s.next());
            System.out.println("""
                    Selecciona el tipo de atencion que requieras:\s
                     1.Telefonica\s
                     2.Asesoria Estudiante\s
                     3.Asesoria Directivo\s
                     4.Consultar estadisticas\s
                     5.Salir""");
            String elect = s.next();
            switch (elect) {
                case "1" -> {
                    String tip = "telefonica";
                    System.out.println("~~~TELEFONICA~~~");
                    repo.save(new EstadisticasDTO(id,tip));
                    System.out.println("Muchas gracias por preferirnos");
                }
                case "2" -> {
                    String tip = "estudiantes";
                    System.out.println("~~~Asesoria Estudiantes~~~");
                    repo.save(new EstadisticasDTO(id,tip));
                    System.out.println("Desea cambiarse a servicio telefonico?");
                    String descicion = s.next().toLowerCase();
                    if(!descicion.equals("no")){
                        String tipo = "Atencion diferente";
                        repo.update(new EstadisticasDTO(id,tipo));
                        System.out.println("Cambio exitoso!");
                    }else{
                        System.out.println("Muchas gracias por preferirnos");
                    }
                }
                case "3" ->{
                    String tip = "directivos";
                    System.out.println("~~~Asesoria Directivos~~~");
                    repo.save(new EstadisticasDTO(id,tip));
                    System.out.println("Desea cambiarse a servicio telefonico?");
                    String descicion = s.next().toLowerCase();
                    if(!descicion.equals("no")){
                        String tipo = "Atencion diferente";
                        repo.update(new EstadisticasDTO(id,tipo));
                        System.out.println("Cambio exitoso!");
                    }else{
                        System.out.println("Muchas gracias por preferirnos");
                    }
                }
                case "4"->{
                    List<EstadisticasDTO> a = repo.findAll();
                    List<EstadisticasDTO> b= new ArrayList<>();
                    List<EstadisticasDTO> c= new ArrayList<>();
                    List<EstadisticasDTO> d= new ArrayList<>();
                    List<EstadisticasDTO> e= new ArrayList<>();
                    b = a.stream().filter(x -> x.getTipAtencion().equalsIgnoreCase("estudiantes")).toList();
                    c = a.stream().filter(x -> x.getTipAtencion().equalsIgnoreCase("directivos")).toList();
                    e = a.stream().filter(x -> x.getTipAtencion().equalsIgnoreCase("telefonica")).toList();
                    d = a.stream().filter(x -> x.getTipAtencion().equalsIgnoreCase("Atencion diferente")).toList();
                    int estud = b.size();
                    int direc = c.size();
                    int atdif = d.size();
                    int tel = e.size();
                    int total = estud+direc+atdif+tel;
                    System.out.println("~~Estadisticas~~" +
                            "\nTelefonica:"+tel+"\nEstudiantes:"+estud+"\nDirectivos:"+direc+"\nAtencion diferente:"+atdif+"\nTotal:"+
                            total);
                }
                case "5" -> {
                    opc = "5";
                }
            }
        }while (!opc.equals("5")) ;
    }
}