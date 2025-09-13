package com.sebastianflorian.repuestos.repository;

import com.sebastianflorian.repuestos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    boolean existsByNombre(String nombre);
    boolean existsByTelefono(String telefono);

    boolean existsByNombreAndIdClienteNot(String nombre, Integer idCliente);
    boolean existsByTelefonoAndIdClienteNot(String telefono, Integer idCliente);
}
