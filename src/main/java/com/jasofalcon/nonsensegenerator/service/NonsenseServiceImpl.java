package com.jasofalcon.nonsensegenerator.service;

import com.jasofalcon.nonsensegenerator.data.WordProvider;
import com.jasofalcon.nonsensegenerator.data.WordsStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class NonsenseServiceImpl implements NonsenseService {
    private static final String SPACE = " ";

    private final WordProvider wordProvider;

    @Autowired
    public NonsenseServiceImpl(WordProvider wordProvider) {
        this.wordProvider = wordProvider;
    }

    @Override
    public String makeNonsense() {

        String subject = createNoun();
        String verb = createVerb();
        String object = createNoun();

        return capitalize(subject + SPACE + verb + SPACE + object + ".");
    }

    private String createNoun() {
        String noun = wordProvider.provide(WordsStore::getNouns);
        String adjective = getPossibleSideWord(WordsStore::getAdjectives);

        return adjective + noun;
    }

    private String createVerb() {
        String verb = wordProvider.provide(WordsStore::getVerbs);
        String adverb = getPossibleSideWord(WordsStore::getAdverbs);

        return adverb + verb;
    }

    private String getPossibleSideWord(Supplier<List<String>> wordSupplier) {
        return Math.random() < 0.4 ? wordProvider.provide(wordSupplier) + SPACE : "";
    }

    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}
