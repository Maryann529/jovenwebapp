package frezzy.jovenwebapp.bootstrap;

import frezzy.jovenwebapp.domain.Author;
import frezzy.jovenwebapp.domain.Book;
import frezzy.jovenwebapp.domain.Publisher;
import frezzy.jovenwebapp.repositories.AuthorRepository;
import frezzy.jovenwebapp.repositories.BookRepository;
import frezzy.jovenwebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");
        publisher.setAddressLine("20 mark north");
        publisher.setZip("2345");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author matt = new Author("Jim", "Mark");
        Book dpd = new Book("Domain Project Design", "17570");
        matt.getBooks().add(dpd);
        dpd.getAuthors().add(matt);

        dpd.setPublisher(publisher);
        publisher.getBooks().add(dpd);

        authorRepository.save(matt);
        bookRepository.save(dpd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "152030527");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());

    }
}
