package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.Phrase;
import project.service.PhraseService;

import java.util.List;

@RestController
@RequestMapping("/phrases")
public class PhraseController {

    // Instance Variables
    private PhraseService phraseService;

    // Dependency Injection
    @Autowired
    public PhraseController(PhraseService phraseService) {
        this.phraseService = phraseService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Phrase> getAllPhrases() {
        return phraseService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Phrase addPhrase(@RequestBody Phrase phrase) {
        return phraseService.add(phrase);
    }

    @RequestMapping(value = "/{phraseId}", method=RequestMethod.GET)
    public Phrase getPhraseById(@PathVariable Long phraseId){
        return phraseService.findOne(phraseId);
    }

    @RequestMapping(value = "/{phraseId}/upvote", method=RequestMethod.POST)
    public void upvotePhraseById(@PathVariable Long phraseId){
        phraseService.upvoteAndUpdateHotness(phraseId);
    }

    @RequestMapping(value = "/{phraseId}/downvote", method=RequestMethod.POST)
    public void downvotePhraseById(@PathVariable Long phraseId){
        phraseService.downvoteAndUpdateHotness(phraseId);
    }

}
