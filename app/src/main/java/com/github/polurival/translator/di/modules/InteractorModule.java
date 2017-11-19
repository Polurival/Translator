package com.github.polurival.translator.di.modules;

import com.github.polurival.translator.business.interactor.TranslatorInteractor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Polurival on 19.11.2017.
 */

@Module
public class InteractorModule {

    @Singleton
    @Provides
    TranslatorInteractor provideTranslatorInteractor() {
        return new TranslatorInteractor();
    }
}
