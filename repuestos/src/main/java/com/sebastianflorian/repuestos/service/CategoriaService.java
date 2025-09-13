package com.sebastianflorian.repuestos.service;

import com.sebastianflorian.repuestos.model.Categoria;

import java.util.List;

public interface CategoriaService {
    List<Categoria> getAllCategorias();
    Categoria getCategoriaById(Integer id);
    Categoria saveCategoria(Categoria categoria);
    Categoria updateCategoria(Integer id, Categoria categoria);
    void deleteCategoria(Integer id);
}
