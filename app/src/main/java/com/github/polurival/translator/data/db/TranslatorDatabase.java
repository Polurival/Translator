package com.github.polurival.translator.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * @author Польщиков Юрий.
 */

@Database(entities = {Word.class}, version = 1)
public abstract class TranslatorDatabase extends RoomDatabase {

    public abstract WordDao wordDao();
}
