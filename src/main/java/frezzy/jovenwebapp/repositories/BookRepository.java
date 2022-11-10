package frezzy.jovenwebapp.repositories;

import frezzy.jovenwebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
