package com.mauriciomilano.APIdac.Controllers;

import com.mauriciomilano.APIdac.Models.Autor;
import com.mauriciomilano.APIdac.Repository.AutorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController("/autor")
public class AutorController {
    private final AutorRepository autorRepository;

    AutorController(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }

    @PostMapping("/create")
    Autor create(@RequestBody Autor autor){
        return autorRepository.save(autor);
    }
}
