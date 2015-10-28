package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Phrase;
import project.persistence.entities.PostitNote;
import project.persistence.repositories.PhraseRepository;
import project.persistence.repositories.PostitNoteRepository;
import project.service.PhraseService;
import project.service.PostitNoteService;
import project.service.UtilitiesService;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class PhraseServiceImplementation implements PhraseService {

    // Instance Variables
    PhraseRepository repository;

    // Dependency Injection
    @Autowired
    public PhraseServiceImplementation(PhraseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Phrase add(Phrase phrase) {
        phrase.setUpvotes((long) 1);
        phrase.setDownvotes((long) 0);
        phrase.setHotness(UtilitiesService.hotness(phrase.getUpvotes(),
                phrase.getDownvotes(), new Date()));
        return repository.save(phrase);
    }

    @Override
    public void delete(Phrase phrase) {

    }

    @Override
    public List<Phrase> findAll() {
        return repository.findAll();
    }

    @Override
    public Phrase findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Phrase findByName(String name) {
        return null;
    }
}