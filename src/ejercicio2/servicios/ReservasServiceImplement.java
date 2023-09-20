package ejercicio2.servicios;

import ejercicio1.servicios.ObjectoSerializable;
import ejercicio2.dto.ReservasDTO;
import ejercicio2.interfaces.IReservas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReservasServiceImplement implements IReservas {
    private List<ReservasDTO> reservas;

    public ReservasServiceImplement() {
        reservas = new ArrayList<>();
    }

    @Override
    public ReservasDTO findById(int id) {
        return reservas.stream()
                .filter(reservasDTO -> reservasDTO.getId()==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<ReservasDTO> findAll() throws IOException, ClassNotFoundException {
        reservas = (List<ReservasDTO>) ObjectoSerializable.readObjectFromFile("reservas.ax");
        return reservas;
    }

    @Override
    public void save(ReservasDTO reserva) throws IOException {
        reservas.add(reserva);
        ObjectoSerializable.writeObjectToFile(reservas,"reservas.ax");
    }

    @Override
    public void update(ReservasDTO reserva) throws IOException {
        ReservasDTO oldReserva = findById(reserva.getId());
        if(oldReserva!=null){
            reservas.remove(oldReserva);
            reservas.add(reserva);
            ObjectoSerializable.writeObjectToFile(reservas,"reservas.ax");
        }
    }

    @Override
    public void delete(ReservasDTO reserva) throws IOException {
        reservas.remove(reserva);
        ObjectoSerializable.writeObjectToFile(reservas,"reservas.ax");
    }
}
