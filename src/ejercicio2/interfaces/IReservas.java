package ejercicio2.interfaces;

import ejercicio2.dto.ReservasDTO;

import java.io.IOException;
import java.util.List;

public interface IReservas {
    ReservasDTO findById(int id);
    List<ReservasDTO> findAll() throws IOException, ClassNotFoundException;
    void save(ReservasDTO reserva) throws IOException;
    void update(ReservasDTO reserva) throws IOException;
    void delete(ReservasDTO reserva) throws IOException;
}
