package com.sebastianflorian.repuestos.service;

import com.sebastianflorian.repuestos.model.Venta;

import java.util.List;

public interface VentaService {
    List<Venta> getAllVentas();
    Venta getVentaById(Integer id);
    Venta saveVenta(Venta venta);
    Venta updateVenta(Integer id, Venta venta);
    void deleteVenta(Integer id);
}