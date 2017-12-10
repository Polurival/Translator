package com.github.polurival.translator.data.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.github.polurival.translator.business.model.TranslateModel;

/**
 * @author Польщиков Юрий.
 */

@Entity
public class Word {

    @ColumnInfo
    @NonNull
    private String language;

    @PrimaryKey
    @ColumnInfo
    @NonNull
    private String word;

    public Word(@NonNull String language, @NonNull String word) {
        this.language = language;
        this.word = word;
    }

    public Word(@NonNull TranslateModel translateModel) {
        this.language = translateModel.getLanguageFrom();
        this.word = translateModel.getText();
    }

    @NonNull
    public String getLanguage() {
        return language;
    }

    public void setLanguage(@NonNull String language) {
        this.language = language;
    }

    @NonNull
    public String getWord() {
        return word;
    }

    public void setWord(@NonNull String word) {
        this.word = word;
    }
}
