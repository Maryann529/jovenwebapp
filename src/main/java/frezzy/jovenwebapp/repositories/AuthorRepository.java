package frezzy.jovenwebapp.repositories;

import frezzy.jovenwebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}

