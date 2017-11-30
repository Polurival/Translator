package com.github.polurival.translator.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.github.polurival.translator.business.repository.ITranslatorRepository;
import com.github.polurival.translator.data.db.TranslatorDatabase;
import com.github.polurival.translator.data.network.ApiClient;
import com.github.polurival.translator.data.network.YandexTranslatorApiService;
import com.github.polurival.translator.data.repository.TranslatorRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Polurival on 16.11.2017.
 */

@Module
public class DataModule {

    private ApiClient apiClient;

    public DataModule(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Singleton
    @Provides
    public YandexTranslatorApiService provideYandexTranslatorApiService() {
        return apiClient.createService(YandexTranslatorApiService.class);
    }

    @Singleton
    @Provides
    public TranslatorDatabase provideTranslatorDatabase(Context context) {
        return Room.databaseBuilder(context, TranslatorDatabase.class, "translator.db").build();
    }

    @Singleton
    @Provides
    public ITranslatorRepository provideTranslatorRepository() {
        return new TranslatorRepository();
    }
}
