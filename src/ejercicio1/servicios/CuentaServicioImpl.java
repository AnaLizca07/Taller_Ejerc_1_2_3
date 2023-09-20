package ejercicio1.servicios;

import ejercicio1.dto.CuentasDTO;
import ejercicio1.interfaces.ICuentas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CuentaServicioImpl implements ICuentas {
    private List<CuentasDTO> cuentas;

    public CuentaServicioImpl() throws IOException, ClassNotFoundException {
        cuentas = new ArrayList<>();
    }

    @Override
    public CuentasDTO findById(int id) {
        return cuentas.stream()
                .filter(cuentas -> cuentas.getId()==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<CuentasDTO> findAll() throws IOException, ClassNotFoundException {
        cuentas = (List<CuentasDTO>) ObjectoSerializable.readObjectFromFile("cuentas.ax");
        return cuentas;
    }

    @Override
    public void save(CuentasDTO cuenta) throws IOException {
        cuentas.add(cuenta);
        ObjectoSerializable.writeObjectToFile(cuentas,"cuentas.ax");
    }

    @Override
    public void update(CuentasDTO cuenta) throws IOException {
        CuentasDTO cuentaVieja = findById(cuenta.getId());
        if(cuentaVieja!=null){
            cuentas.remove(cuentaVieja);
            cuentas.add(cuenta);
            ObjectoSerializable.writeObjectToFile(cuentas,"cuentas.ax");
        }
    }
    public void delete(CuentasDTO cuenta) throws IOException{
        cuentas.remove(cuenta);
        ObjectoSerializable.writeObjectToFile(cuentas,"cuentas.ax");
    }

}
