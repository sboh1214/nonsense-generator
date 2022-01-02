package com.jasofalcon.nonsensegenerator.data;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

@Repository
public class MeloWordProviderImpl implements MeloWordProvider {

    public String provide(Supplier<List<String>> getWords) {
        List<String> words = getWords.get();
        Random r = new Random();
        return words.get(r.nextInt(words.size()));
    }

}
