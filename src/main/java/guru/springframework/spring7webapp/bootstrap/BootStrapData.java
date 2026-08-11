package guru.springframework.spring7webapp.bootstrap;

import guru.springframework.spring7webapp.domain.Author;
import guru.springframework.spring7webapp.domain.Book;
import guru.springframework.spring7webapp.domain.Publisher;
import guru.springframework.spring7webapp.repositories.AuthorRepository;
import guru.springframework.spring7webapp.repositories.BookRepository;
import guru.springframework.spring7webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd =  new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEBJ = new Book();
        noEBJ.setTitle("J2EE Development with EJB");
        noEBJ.setIsbn("456789");

        Author rodSaved = authorRepository.save(rod);
        Book noEBJSaved = bookRepository.save(noEBJ);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEBJSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        Publisher macPublishing = new Publisher();
        macPublishing.setPublisherName("Mac Publishing");
        macPublishing.setAddress("7667 Maysweet Dr.");
        macPublishing.setCity("San Francisco");
        macPublishing.setState("CA");
        macPublishing.setZip("90210");

        Publisher macPublishingSaved = publisherRepository.save(macPublishing);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: "  + authorRepository.count());
        System.out.println("Book Count: "  + bookRepository.count());
        System.out.println("Publisher Count: "  + publisherRepository.count());
    }
}
