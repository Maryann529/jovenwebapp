package frezzy.jovenwebapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fastName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    public Author() {
    }

    public Author(String fastName, String lastName) {
        this.fastName = fastName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFastName() {
        return fastName;
    }

    public void setFastName(String fastName) {
        this.fastName = fastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return Objects.equals(id, author.id);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", fastName='" + fastName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

