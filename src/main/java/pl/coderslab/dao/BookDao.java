package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book book) {
        entityManager.persist(book);
    }

    public Book findById(Long id) {
        //return entityManager.find(Book.class, id);
        Query query =
                entityManager.createQuery("select distinct b from Book b left join fetch b.publisher left join fetch b.authors where b.id = :id");
        query.setParameter("id", id);
        return (Book) query.getSingleResult();
    }

    public List<Book> findAll() {
        Query query = entityManager.createQuery("select distinct b from Book b left join fetch b.publisher left join fetch b.authors"); // select * from books
        return query.getResultList();
    }

    public List<Book> findByRating(int rating) {
        Query query = entityManager.createQuery("select distinct b from Book b left join fetch b.publisher left join fetch b.authors where b.rating = :ala");
        query.setParameter("ala", rating);
        return query.getResultList();
    }

    public List<Book> findByPublisherIsNotNull() {
        Query query = entityManager.createQuery("select b from Book b join fetch b.publisher left join fetch b.authors");
        return query.getResultList();
    }

    public List<Book> findByPublisher(Publisher publisher) {
        return entityManager
                .createQuery("select b from Book b left join fetch b.publisher left join fetch b.authors where b.publisher = :publisher")
                .setParameter("publisher", publisher)
                .getResultList();
    }

    public List<Book> findByAuthor(Author author) {
        return entityManager
                .createQuery("select b from Book b left join fetch b.publisher left join fetch b.authors where :author member of b.authors")
                .setParameter("author", author)
                .getResultList();
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void deleteById(Long id) {
        Book book = findById(id);
        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
    }
}
