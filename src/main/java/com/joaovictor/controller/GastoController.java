package com.joaovictor.controller;

import com.joaovictor.model.Gasto;
import com.joaovictor.service.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Diz ao Spring que esta classe é uma controladora de recursos
// e que o retorno dos métodos deve ser enviado diretamente no corpo da resposta
@RequestMapping("/gastos") // Define a URL base para todos os métodos desta classe.
// Ou seja, acessará tudo através de http://localhost:8080/gastos
public class GastoController {

    @Autowired
    private GastoService service;

    @GetMapping
    public List<Gasto> getAllGastos() {
        return service.listarTodos();
    }
    @PostMapping
    public Gasto salvar(@RequestBody Gasto gasto) {
        return service.salvarGasto(gasto);
    }
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
