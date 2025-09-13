package com.sebastianflorian.repuestos.repository;

import com.sebastianflorian.repuestos.model.Repuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepuestoRepository extends JpaRepository<Repuesto, Integer> {
    boolean existsByNombre(String nombre);
    boolean existsByNombreAndIdRepuestoNot(String nombre, Integer idRepuesto);
}
