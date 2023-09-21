package ejercicio5;

import ejercicio5.dto.CarritoDTO;
import ejercicio5.interfaces.ICarrito;
import ejercicio5.service.CarritoServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainCarrito {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String opc = "1";
        ICarrito repo = new CarritoServiceImpl();

        do {
            Scanner s = new Scanner(System.in);
            System.out.println("Menu \n 1. Agregar \n 2. Listar \n 3. Total de compra \n 4. Eliminar \n 5. Salir");

            opc = s.next();
            switch (opc) {

                case "1": {
                    System.out.println("Id producto: ");
                    Integer id = s.nextInt();
                    System.out.println("Nombre producto: ");
                    String nom = s.next();
                    System.out.println("Precio ");
                    Integer p = s.nextInt();
                    System.out.println("cantidad: ");
                    double ca = s.nextDouble();
                    repo.save(new CarritoDTO(id, nom, p, ca ));
                    break;

                }
                case "2": {
                    List<CarritoDTO> carrito = repo.findall();
                    if (!carrito.isEmpty()) {
                        carrito.forEach(System.out::println);
                    } else {
                        System.out.println("No hay productos en el carrito");
                    }
                    break;
                }
                case "3": {

                    double total = repo.findall().stream().mapToDouble(CarritoDTO::getPrecio).sum();
                    System.out.println("Total de compra:" + total);

                    break;
                }
                case "4": {
                    System.out.println("Eliminar producto del carrito");
                    System.out.println("Ingrese el id del producto a eliminar");
                    Integer id = s.nextInt();
                    repo.delete(repo.findById(id));
                    repo.findall().forEach(System.out::println);
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
