package com.sebastianflorian.repuestos.service;

import com.sebastianflorian.repuestos.model.Repuesto;

import java.util.List;

public interface RepuestoService {
    List<Repuesto> getAllRepuestos();
    Repuesto getRepuestoById(Integer id);
    Repuesto saveRepuesto(Repuesto repuesto);
    Repuesto updateRepuesto(Integer id, Repuesto repuesto);
    void deleteRepuesto(Integer id);
}
