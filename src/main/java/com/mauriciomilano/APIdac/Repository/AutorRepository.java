package com.mauriciomilano.APIdac.Repository;
import org.springframework.data.repository.CrudRepository;
import com.mauriciomilano.APIdac.Models.Autor;

public interface AutorRepository extends CrudRepository<Autor, Long> {
    Autor save(Autor autor);
}
