package ejercicio6.interfaces;

import ejercicio6.dto.CitasDTO;

import java.io.IOException;
import java.util.List;

public interface ICitas {

    CitasDTO findById (int id);

    List<CitasDTO> findAll() throws IOException, ClassNotFoundException;

    void save (CitasDTO cita) throws IOException;

    void update (CitasDTO cita) throws IOException;

    void delete (CitasDTO cita) throws  IOException;
}
