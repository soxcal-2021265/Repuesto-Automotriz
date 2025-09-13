package com.sebastianflorian.repuestos.service;

import com.sebastianflorian.repuestos.model.Venta;
import com.sebastianflorian.repuestos.repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImplements implements VentaService {

    private final VentaRepository ventaRepository;

    public VentaServiceImplements(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta getVentaById(Integer id) {
        return ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con ID: " + id));
    }

    @Override
    public Venta saveVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public Venta updateVenta(Integer id, Venta venta) {
        Venta existingVenta = ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con ID: " + id));

        existingVenta.setFecha(venta.getFecha());
        existingVenta.setCantidad(venta.getCantidad());
        existingVenta.setIdCliente(venta.getIdCliente());
        existingVenta.setIdRepuesto(venta.getIdRepuesto());
        return ventaRepository.save(existingVenta);
    }

    @Override
    public void deleteVenta(Integer id) {
        if (ventaRepository.existsById(id)) {
            ventaRepository.deleteById(id);
            System.out.println("La venta con el ID " + id + " fue eliminada correctamente.");
        } else {
            throw new RuntimeException("El id no existe");
        }
    }
}
