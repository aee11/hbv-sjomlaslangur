package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
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

    @Modifying
    @Transactional
    @Query(value = "UPDATE Phrase p SET p.upvotes = p.upvotes+1, p.hotness = sign(p.upvotes+1 - p.downvotes) * log(greatest(abs(p.upvotes+1 - p.downvotes), 1)) + (date_part('epoch', p.created) - 1134028003) / 45000.0 WHERE p.id = :phraseId")
    void incrementUpvotesAndUpdateHotness(@Param("phraseId") Long phraseId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Phrase p SET p.downvotes = p.downvotes+1, p.hotness = sign(p.upvotes - p.downvotes+1) * log(greatest(abs(p.upvotes - p.downvotes+1), 1)) + (date_part('epoch', p.created) - 1134028003) / 45000.0 WHERE p.id = :phraseId")
    void incrementDownvotesAndUpdateHotness(@Param("phraseId") Long phraseId);

//    round(cast(sign(p.upvotes - p.downvotes) * log(greatest(abs(p.upvotes - p.downvotes), 1)) + (date_part('epoch', p.created) - 1134028003) / 45000.0 AS numeric, 7))
}
