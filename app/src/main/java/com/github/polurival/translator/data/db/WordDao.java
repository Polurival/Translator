package com.github.polurival.translator.data.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;

/**
 * @author Польщиков Юрий.
 */

@Dao
public interface WordDao {

    @Query("SELECT * FROM word WHERE language = ':lang'")
    Flowable<List<Word>> loadWordsByLanguage(String lang);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Word... words);
}
