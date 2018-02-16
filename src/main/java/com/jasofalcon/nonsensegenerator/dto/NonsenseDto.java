package com.jasofalcon.nonsensegenerator.dto;

public class NonsenseDto {
    private final String sentence;

    public NonsenseDto(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }
}
