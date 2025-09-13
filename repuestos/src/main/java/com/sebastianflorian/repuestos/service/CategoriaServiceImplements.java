package com.sebastianflorian.repuestos.service;

import com.sebastianflorian.repuestos.model.Categoria;
import com.sebastianflorian.repuestos.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImplements implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImplements(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria getCategoriaById(Integer id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con ID: " + id));
    }

    @Override
    public Categoria saveCategoria(Categoria categoria) {
        if (categoriaRepository.existsByNombre(categoria.getNombre())) {
            throw new RuntimeException("El nombre de la categoría ya está en uso");
        }
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria updateCategoria(Integer id, Categoria categoria) {
        Categoria existingCategoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con ID: " + id));

        if (categoriaRepository.existsByNombreAndIdCategoriaNot(categoria.getNombre(), id)) {
            throw new RuntimeException("El nombre de la categoría ya está en uso por otra categoría");
        }

        existingCategoria.setNombre(categoria.getNombre());
        return categoriaRepository.save(existingCategoria);
    }

    @Override
    public void deleteCategoria(Integer id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            System.out.println("La categoría con el ID " + id + " fue eliminada correctamente.");
        } else {
            throw new RuntimeException("El id no existe");
        }
    }
}
