package ejercicio3.interfaces;

import ejercicio3.dto.EstadisticasDTO;

import java.io.IOException;
import java.util.List;

public interface IEstadisticas {
    EstadisticasDTO findById(int id);
    List<EstadisticasDTO> findAll() throws IOException, ClassNotFoundException;
    void save(EstadisticasDTO estadistica) throws IOException;
    void update(EstadisticasDTO estadistica) throws IOException;
    void delete(EstadisticasDTO estadistica) throws IOException;
}
