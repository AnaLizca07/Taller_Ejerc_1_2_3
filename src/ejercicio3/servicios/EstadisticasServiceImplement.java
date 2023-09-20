package ejercicio3.servicios;

import ejercicio1.servicios.ObjectoSerializable;
import ejercicio3.dto.EstadisticasDTO;
import ejercicio3.interfaces.IEstadisticas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EstadisticasServiceImplement implements IEstadisticas {
    private List<EstadisticasDTO> estadisticas;
    public EstadisticasServiceImplement() throws IOException,ClassNotFoundException{
        estadisticas = new ArrayList<>();
    }

    @Override
    public EstadisticasDTO findById(int id) {
        return estadisticas.stream()
                .filter(estadistica -> estadistica.getId()==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<EstadisticasDTO> findAll() throws IOException, ClassNotFoundException {
        estadisticas = (List<EstadisticasDTO>) ObjectoSerializable.readObjectFromFile("estadisticas.ax");
        return estadisticas;
    }

    @Override
    public void save(EstadisticasDTO estadistica) throws IOException {
        estadisticas.add(estadistica);
        ObjectSerializer.writeObjectToFile(estadisticas,"estadisticas.ax");
    }

    @Override
    public void update(EstadisticasDTO estadistica) throws IOException {
        EstadisticasDTO oldEstadistica = findById(estadistica.getId());
        if(oldEstadistica!=null){
            estadisticas.remove(oldEstadistica);
            estadisticas.add(estadistica);
            ObjectSerializer.writeObjectToFile(estadisticas,"estadisticas.ax");
        }
    }

    @Override
    public void delete(EstadisticasDTO estadistica) throws IOException {
        estadisticas.remove(estadistica);
        ObjectSerializer.writeObjectToFile(estadisticas,"estadisticas.ax");
    }
}
