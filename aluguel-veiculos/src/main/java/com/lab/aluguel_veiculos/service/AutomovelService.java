package com.lab.aluguel_veiculos.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import com.lab.aluguel_veiculos.Repository.AutomovelRepository;
import com.lab.aluguel_veiculos.model.Automovel;

@Service
public class AutomovelService {

    @Autowired
    AutomovelRepository automovelRepository;

    @Transactional
    public Automovel saveAutomovel(Automovel automovel){
        return automovelRepository.save(automovel);
    }

    public List<Automovel> findAllAutomoveis(){
        return automovelRepository.findAll();
    }

    public Optional<Automovel> findAutomovelById(Long id){
        return automovelRepository.findById(id);
    }

    @Transactional
    public Automovel updateAutomovel(Long id, Automovel updatedAutomovel){
        Optional<Automovel> existingAutomovel = automovelRepository.findById(id);
        if(existingAutomovel.isPresent()){
            Automovel automovel = existingAutomovel.get();
            automovel.setMatricula(updatedAutomovel.getMatricula());
            automovel.setAno(updatedAutomovel.getAno());
            automovel.setMarca(updatedAutomovel.getMarca());
            automovel.setModelo(updatedAutomovel.getModelo());
            automovel.setPlaca(updatedAutomovel.getPlaca());
            return automovelRepository.save(automovel);
        }else{
            throw new RuntimeException("Automovel com ID " + id + " não encontrado.");
        }
    }

    @Transactional
    public void deleteAutomovelById(Long id){
        if(automovelRepository.existsById(id)){
            automovelRepository.deleteById(id);
        }else {
            throw new RuntimeException("Automovel com ID " + id + " não encontrado.");
        }
    }
}
