package com.github.polurival.translator.business.model;

/**
 * @author Polurival on 16.11.2017.
 */

public class TranslateModel {

    private String languageFrom;
    private String languageTo;
    private String text;

    public TranslateModel(String languageFrom, String languageTo, String text) {
        this.languageFrom = languageFrom;
        this.languageTo = languageTo;
        this.text = text;
    }

    public String getLanguageFrom() {
        return languageFrom;
    }

    public String getLanguageTo() {
        return languageTo;
    }

    public String getText() {
        return text;
    }

    public String getFromLanguageTo() {
        return languageFrom + "-" + languageTo;
    }
}
