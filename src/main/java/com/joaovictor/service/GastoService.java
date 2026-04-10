package com.joaovictor.service;

import com.joaovictor.model.Gasto;
import com.joaovictor.repository.GastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GastoService {

    @Autowired
    private GastoRepository repository;

    public List<Gasto> listarTodos(){
        return  repository.findAll();
    }

    public Gasto salvarGasto(Gasto gasto){
        return repository.save(gasto);
    }

    public void excluir(Long id){
        Gasto gasto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gasto não encontrado"));
        gasto.setAtivo(false);
        repository.save(gasto);
    }

    public List<Gasto> listarAtivos(){
        return repository.findAll().stream()
                .filter(Gasto::isAtivo)
                .toList();
    }
}
