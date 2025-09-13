package com.sebastianflorian.repuestos.repository;

import com.sebastianflorian.repuestos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    boolean existsByNombre(String nombre);
    boolean existsByNombreAndIdCategoriaNot(String nombre, Integer idCategoria);
}
