package guru.springframework.spring7webapp.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity //maps this class to a database table
public class Author {

    @Id //defines the primary key of a database entry
    @GeneratedValue(strategy = GenerationType.AUTO) //how the primary key should be automatically generated
    private Long id; //used to persist author objects into database
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors") //mapped by the authors property of books
    private Set<Book> books; //create Set of books (no duplicates + no order)

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;

        Author author = (Author) o;

        return getId() != null ? getId().equals(author.getId()) : author.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}







