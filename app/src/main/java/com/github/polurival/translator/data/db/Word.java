package com.github.polurival.translator.data.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.github.polurival.translator.business.model.TranslateModel;

/**
 * @author Польщиков Юрий.
 */

@Entity
public class Word {

    @PrimaryKey
    private int id;

    @ColumnInfo
    private String language;

    @ColumnInfo
    private String word;

    public Word(String language, String word) {
        this.language = language;
        this.word = word;
    }

    public Word(TranslateModel translateModel) {
        this.language = translateModel.getLanguageFrom();
        this.word = translateModel.getText();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
