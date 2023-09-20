package ejercicio1.interfaces;

import ejercicio1.dto.CuentasDTO;

import java.io.IOException;
import java.util.List;

public interface ICuentas {
    CuentasDTO findById(int id);
    List<CuentasDTO> findAll() throws IOException, ClassNotFoundException;
    void save(CuentasDTO cuenta) throws IOException;
    void update(CuentasDTO cuenta) throws IOException;
    void delete(CuentasDTO cuenta) throws IOException;
}
