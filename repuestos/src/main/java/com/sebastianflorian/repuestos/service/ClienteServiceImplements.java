package com.sebastianflorian.repuestos.service;

import com.sebastianflorian.repuestos.model.Cliente;
import com.sebastianflorian.repuestos.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImplements implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImplements(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getClienteById(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        if (clienteRepository.existsByNombre(cliente.getNombre())) {
            throw new RuntimeException("El nombre del cliente ya está en uso");
        }
        if (clienteRepository.existsByTelefono(cliente.getTelefono())) {
            throw new RuntimeException("El teléfono ya está en uso");
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Integer id, Cliente cliente) {
        Cliente existingCliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));

        if (clienteRepository.existsByNombreAndIdClienteNot(cliente.getNombre(), id)) {
            throw new RuntimeException("El nombre del cliente ya está en uso por otro cliente");
        }
        if (clienteRepository.existsByTelefonoAndIdClienteNot(cliente.getTelefono(), id)) {
            throw new RuntimeException("El teléfono ya está en uso por otro cliente");
        }

        existingCliente.setNombre(cliente.getNombre());
        existingCliente.setTelefono(cliente.getTelefono());
        return clienteRepository.save(existingCliente);
    }

    @Override
    public void deleteCliente(Integer id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            System.out.println("El cliente con el ID " + id + " fue eliminado correctamente.");
        } else {
            throw new RuntimeException("El id no existe");
        }
    }
}
