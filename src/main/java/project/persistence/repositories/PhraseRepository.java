package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.Phrase;
import project.persistence.entities.PostitNote;

import java.util.List;

/**
 * By extending the {@link org.springframework.data.jpa.repository.JpaRepository} we have access to powerful methods.
 * For detailed information, see:
 * http://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 * http://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
 *
 */
public interface PhraseRepository extends JpaRepository<Phrase, Long> {
    List<Phrase> findAll();
    Phrase save(Phrase phrase);
    Phrase findOne(Long id);
}
