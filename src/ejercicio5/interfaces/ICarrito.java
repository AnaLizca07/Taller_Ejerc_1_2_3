package ejercicio5.interfaces;

import ejercicio5.dto.CarritoDTO;

import java.io.IOException;
import java.util.List;

public interface ICarrito {

    CarritoDTO findById (int id);

    List<CarritoDTO> findall() throws IOException, ClassNotFoundException;

    void save (CarritoDTO producto) throws IOException;

    void update (CarritoDTO producto) throws IOException;

    void delete (CarritoDTO producto) throws IOException;

}
