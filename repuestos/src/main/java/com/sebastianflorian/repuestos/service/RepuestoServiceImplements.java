package com.sebastianflorian.repuestos.service;

import com.sebastianflorian.repuestos.model.Repuesto;
import com.sebastianflorian.repuestos.repository.RepuestoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepuestoServiceImplements implements RepuestoService {

    private final RepuestoRepository repuestoRepository;

    public RepuestoServiceImplements(RepuestoRepository repuestoRepository) {
        this.repuestoRepository = repuestoRepository;
    }

    @Override
    public List<Repuesto> getAllRepuestos() {
        return repuestoRepository.findAll();
    }

    @Override
    public Repuesto getRepuestoById(Integer id) {
        return repuestoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Repuesto no encontrado con ID: " + id));
    }

    @Override
    public Repuesto saveRepuesto(Repuesto repuesto) {
        if (repuestoRepository.existsByNombre(repuesto.getNombre())) {
            throw new RuntimeException("El nombre del repuesto ya está en uso");
        }
        return repuestoRepository.save(repuesto);
    }

    @Override
    public Repuesto updateRepuesto(Integer id, Repuesto repuesto) {
        Repuesto existingRepuesto = repuestoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Repuesto no encontrado con ID: " + id));

        if (repuestoRepository.existsByNombreAndIdRepuestoNot(repuesto.getNombre(), id)) {
            throw new RuntimeException("El nombre del repuesto ya está en uso por otro repuesto");
        }

        existingRepuesto.setNombre(repuesto.getNombre());
        existingRepuesto.setPrecio(repuesto.getPrecio());
        existingRepuesto.setCategoria(repuesto.getCategoria());
        return repuestoRepository.save(existingRepuesto);
    }

    @Override
    public void deleteRepuesto(Integer id) {
        if (repuestoRepository.existsById(id)) {
            repuestoRepository.deleteById(id);
            System.out.println("El repuesto con el ID " + id + " fue eliminado correctamente.");
        } else {
            throw new RuntimeException("El id no existe");
        }
    }
}
