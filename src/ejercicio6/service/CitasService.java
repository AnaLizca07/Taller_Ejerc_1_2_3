package ejercicio6.service;

import ejercicio5.service.ObjectSerializer;
import ejercicio6.dto.CitasDTO;
import ejercicio6.interfaces.ICitas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CitasService  implements ICitas {
    private List<CitasDTO> citas;

    public CitasService() throws IOException, ClassNotFoundException {
        citas = new ArrayList<>();
    }


    @Override
    public CitasDTO findById(int id) {
        return citas.stream()
                .filter(cita -> cita.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<CitasDTO> findAll() throws IOException, ClassNotFoundException {
        citas = (List<CitasDTO>) ObjectSerializer.readObjetFromFile("Citas.ax");
        return citas;
    }

    @Override
    public void save(CitasDTO cita) throws IOException {
        citas.add(cita);
        ObjectSerializer.writeObjectToFile(citas, "Citas.ax");
    }

    @Override
    public void update(CitasDTO cita) throws IOException {
        CitasDTO oldCita = findById(cita.getId());
        if (oldCita != null) {
            citas.remove(oldCita);
            citas.add(cita);
            ObjectSerializer.writeObjectToFile(citas, "Citas.ax");
        }
    }

    @Override
    public void delete(CitasDTO cita) throws IOException {
        citas.remove(cita);
        ObjectSerializer.writeObjectToFile(citas, "Citas.ax");
    }
}
