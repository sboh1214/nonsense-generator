package com.jasofalcon.nonsensegenerator.service;

import com.jasofalcon.nonsensegenerator.data.Conjunctions;
import com.jasofalcon.nonsensegenerator.data.MeloWordProvider;
import com.jasofalcon.nonsensegenerator.data.MeloWordsStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

@Service
public class MeloServiceImpl implements MeloService {
    private static final String SPACE = " ";

    private final MeloWordProvider meloWordProvider;

    @Autowired
    public MeloServiceImpl(@Qualifier("meloWordProviderImpl") MeloWordProvider meloWordProvider) {
        this.meloWordProvider = meloWordProvider;
    }

    @Override
    public String makeNonsense(String keyword) {

        String[] words = {createNoun(), createVerb(), createNoun(), Conjunctions.get(), createNoun(), createVerb(), createNoun()};
        int random = new Random().nextInt(4);
        if (keyword != null) {
            switch (random) {
                case 0:
                    words[0] = keyword;
                    break;
                case 1:
                    words[2] = keyword;
                    break;
                case 2:
                    words[4] = keyword;
                    break;
                case 3:
                    words[6] = keyword;
                    break;
            }
        }
        return capitalize(String.join(SPACE, words) + ".");
    }

    private String createNoun() {
        String noun = meloWordProvider.provide(MeloWordsStore::getNouns);
        String adjective = getPossibleSideWord(MeloWordsStore::getAdjectives);

        return adjective + noun;
    }

    private String createVerb() {
        String verb = meloWordProvider.provide(MeloWordsStore::getVerbs);
        String adverb = getPossibleSideWord(MeloWordsStore::getAdverbs);

        return adverb + verb;
    }

    private String getPossibleSideWord(Supplier<List<String>> wordSupplier) {
        return Math.random() < 0.4 ? meloWordProvider.provide(wordSupplier) + SPACE : "";
    }

    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}
