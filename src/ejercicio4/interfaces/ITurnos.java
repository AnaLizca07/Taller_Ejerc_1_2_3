package ejercicio4.interfaces;

import ejercicio4.dto.TurnosDTO;

import java.io.IOException;
import java.util.List;

public interface ITurnos {

    TurnosDTO findById(Integer id);

    List<TurnosDTO> findAll() throws IOException, ClassNotFoundException; //Listar


    void save (TurnosDTO turno) throws IOException;

    void update (TurnosDTO turno) throws IOException;

    void delete (TurnosDTO turno) throws IOException;

    public int total();
}
