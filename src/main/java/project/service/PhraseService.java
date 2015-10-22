package project.service;

import project.persistence.entities.Phrase;

import java.util.List;

public interface PhraseService {
    Phrase add(Phrase phrase);
    void delete(Phrase phrase);

    List<Phrase> findAll();

    Phrase findOne(Long id);
    Phrase findByName(String name);

}
