package com.joaovictor.controller;

import com.joaovictor.model.Gasto;
import com.joaovictor.repository.GastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired// Esta é a "Injeção de Dependência". Você está dizendo ao Spring:
    // "Ei, pegue aquela interface GastoRepository que eu criei e coloque uma instância dela aqui para eu usar"
    private GastoRepository repository;

    @GetMapping//Define que, quando alguém acessar a URL via método GET, o Spring deve listar todos os gastos.
    public List<Gasto> getAllGastos() {
        return repository.findAll();
    }
    @PostMapping// Define que, quando alguém enviar dados via POST, o Spring deve salvar esses dados no banco.
    public Gasto salvar(@RequestBody Gasto gasto) { // Diz ao Java para transformar o JSON que vem na requisição
        // em um objeto do tipo Gasto automaticamente.
        return repository.save(gasto);
    }
}
