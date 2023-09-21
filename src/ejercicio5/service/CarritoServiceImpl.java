package ejercicio5.service;

import ejercicio5.dto.CarritoDTO;
import ejercicio5.interfaces.ICarrito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarritoServiceImpl implements ICarrito {

    private List<CarritoDTO> carrito;

    public CarritoServiceImpl () throws IOException, ClassNotFoundException {
        carrito = new ArrayList<>();
    }


    @Override
    public CarritoDTO findById(int id) {
        return carrito.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);

    }

    @Override
    public List<CarritoDTO> findall() throws IOException, ClassNotFoundException {
        carrito = (List<CarritoDTO>) ObjectSerializer.readObjetFromFile("Carrito.ax");
        return carrito;
    }

    @Override
    public void save(CarritoDTO producto) throws IOException {
        carrito.add(producto);
        ObjectSerializer.writeObjectToFile(carrito, "Carrito.ax");
    }

    @Override
    public void update(CarritoDTO producto) throws IOException {
        CarritoDTO oldProducto = findById(producto.getId());
        if (oldProducto != null) {
            carrito.remove(oldProducto);
            carrito.add(producto);
            ObjectSerializer.writeObjectToFile(carrito, "Carrito.ax");
        }
    }

    @Override
    public void delete(CarritoDTO producto) throws IOException {
        carrito.remove(producto);
        ObjectSerializer.writeObjectToFile(carrito, "Carrito.ax");
    }
}
