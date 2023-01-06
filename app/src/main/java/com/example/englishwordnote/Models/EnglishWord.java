package com.example.englishwordnote.Models;

public class EnglishWord {
    private int Id;
    private String word;
    private String meanings;
    private String definition;
    private String example;
    private boolean isSaved;

    public EnglishWord(int id, String word, String meanings, String definition, String example, boolean isSaved) {
        Id = id;
        this.word = word;
        this.meanings = meanings;
        this.definition = definition;
        this.example = example;
        this.isSaved = isSaved;
    }

    public int getId() {
        return Id;
    }
    public String getWord() {
        return word;
    }

    public String getMeanings() {
        return meanings;
    }

    public String getDefinition() {
        return definition;
    }

    public String getExample() {
        return example;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public void setSaved(boolean saved) {
        isSaved = saved;
    }
}
