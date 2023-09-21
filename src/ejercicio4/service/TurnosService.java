package ejercicio4.service;

import ejercicio4.dto.TurnosDTO;
import ejercicio4.interfaces.ITurnos;
import ejercicio5.service.ObjectSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TurnosService implements ITurnos {

    private List<TurnosDTO> turnos;

    public TurnosService() throws IOException, ClassNotFoundException {
        turnos = new ArrayList<>();
    }


    @Override
    public TurnosDTO findById(Integer id) {
        TurnosDTO resultado = null;
        for (TurnosDTO mas: turnos) {
            if (mas.getTurno() != null && mas.getTurno().equals(id)) {
                resultado = mas;
                break;
            }
        }
        return resultado;
    }

    @Override
    public List<TurnosDTO> findAll() throws IOException, ClassNotFoundException {
        turnos = (List<TurnosDTO>) ObjectSerializer.readObjetFromFile("Turnos.ax");
        return turnos;
    }

    @Override
    public void save(TurnosDTO turno) throws IOException {
        turnos.add(turno);
        ObjectSerializer.writeObjectToFile(turnos, "Turnos.ax");
    }

    @Override
    public void update(TurnosDTO turno) throws IOException {
        TurnosDTO oldTurno = findById(turno.getTurno());
        if (oldTurno != null) {
            turnos.remove(oldTurno);
            turnos.add(turno);
            ObjectSerializer.writeObjectToFile(turnos, "Turnos.ax");
        }
    }

    @Override
    public void delete(TurnosDTO turno) throws IOException {
        turnos.remove(turno);
        ObjectSerializer.writeObjectToFile(turnos, "Turnos.ax");
    }

    @Override
    public int total() {
        return this.turnos.size();
    }
}
