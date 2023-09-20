package ejercicio1;

import ejercicio1.dto.CuentasDTO;
import ejercicio1.interfaces.ICuentas;
import ejercicio1.servicios.CuentaServicioImpl;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String opc = "1";
        ICuentas repo = new CuentaServicioImpl();
        do {
            Scanner s = new Scanner(System.in);
            System.out.println("Menu: \n 1.Registrarse \n 2.Consultar Cuentas \n 3.Ingresar Dinero \n 4.Transferir de cuenta a cuenta \n 5.Eliminar cuentas \n 6.Salir");
            opc = s.next();
            switch (opc) {
                case "1" -> {
                    System.out.println("~~~REGISTRARSE~~~");
                    System.out.println("Numero de cuenta: ");
                    Integer numercuenta = Integer.valueOf(s.next());
                    System.out.println("Nombre de la persona");
                    String name = s.next();
                    System.out.println("Cedula :");
                    Integer cedu = Integer.valueOf(s.next());
                    repo.save(new CuentasDTO(numercuenta, name, +0, cedu));
                }
                case "2" -> {
                    System.out.println("~~~CONSULTAR CUENTAS~~~");
                    List<CuentasDTO> cuenta = repo.findAll();
                    if (!cuenta.isEmpty()) {
                        cuenta.forEach(System.out::println);
                    } else {
                        System.out.println("No hay registros");
                    }
                }
                case "3" -> {
                    System.out.println("~~~INGRESAR DINERO~~~");
                    System.out.println("Ingresa el numero de cuenta: ");
                    int nc = Integer.parseInt(s.next());
                    boolean busqueda = repo.findById(nc) == null;
                    if (!busqueda) {
                        System.out.println("Ingrese la cantidad de dinero que quiere transferir:");
                        int dinero = Integer.parseInt(s.next());
                        Integer nuevosald = repo.findById(nc).getSaldo() + dinero;
                        String name = repo.findById(nc).getUsuario();
                        Integer cedu = repo.findById(nc).getCedula();
                        repo.update(new CuentasDTO(nc, name, nuevosald, cedu));
                        System.out.println("Ha transferido exitosamente $" + dinero);
                    } else {
                        System.out.println("Cuenta no encontrada");
                    }
                }
                case "4" -> {
                    System.out.println("~~~TRANSFERIR DE CUENTA A CUENTA~~~");
                    System.out.println("Ingrese el numero de la primera cuenta");
                    int id1 = Integer.parseInt(s.next());
                    String name1 = repo.findById(id1).getUsuario();
                    Integer cedu1 = repo.findById(id1).getCedula();
                    System.out.println("Ingrese el numero de la segunda cuenta");
                    int id2 = Integer.parseInt(s.next());
                    String name2 = repo.findById(id2).getUsuario();
                    Integer cedu2 = repo.findById(id2).getCedula();
                    System.out.println("Ingrese el valor a transferir:");
                    int saldo = Integer.parseInt(s.next());
                    if (repo.findById(id1).getSaldo() >= saldo) {
                        Integer resta = repo.findById(id1).getSaldo() - saldo;
                        Integer suma = repo.findById(id2).getSaldo() + saldo;
                        repo.update(new CuentasDTO(id1, name1, resta, cedu1));
                        repo.update(new CuentasDTO(id2, name2, suma, cedu2));
                        System.out.println("Se han transferido existosamente $" + saldo + " a la cuenta:" + id2 + "Desde la cuenta" + id1);
                    } else {
                        System.out.println("No tienes saldo suficiente para hacer la transferencia");
                    }
                }
                case "5" -> {
                    System.out.println("~~~ELIMINAR~~~");
                    System.out.println("Ingresa el numero de cuenta que quieras eliminar");
                    int cuentica = s.nextInt();
                    repo.delete(repo.findById(cuentica));
                    repo.findAll().forEach(System.out::println);
                }
                case "6" -> {
                    opc = "6";
                }
            }
        }while(!opc.equals("6"));
    }
}
