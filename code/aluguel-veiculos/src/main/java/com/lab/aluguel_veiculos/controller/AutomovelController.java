package com.lab.aluguel_veiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lab.aluguel_veiculos.model.Automovel;
import com.lab.aluguel_veiculos.service.AutomovelService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/automoveis")
public class AutomovelController {

    @Autowired
    private AutomovelService automovelService;

    @GetMapping
    public List<Automovel> getAllAutomoveis(){
        return automovelService.findAllAutomoveis();
    }
    
    @GetMapping("/{id}")
    public Optional<Automovel> findAutomovelById(@PathVariable Long id){
        return automovelService.findAutomovelById(id);
    }

    @PostMapping
    public Automovel createAutomovel(@RequestBody Automovel automovel){
        return automovelService.saveAutomovel(automovel);
    }

    @PutMapping("/{id}")
    public Automovel updateAutomovel(@PathVariable Long id, @RequestBody Automovel updatedAutomovel){
        return automovelService.updateAutomovel(id, updatedAutomovel);
    }

    @DeleteMapping("/{id}")
    public void deleteAutomovel(@PathVariable Long id){
        automovelService.deleteAutomovelById(id);
    }
}
