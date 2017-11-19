package com.github.polurival.translator.di;

import com.github.polurival.translator.business.interactor.TranslatorInteractor;
import com.github.polurival.translator.data.repository.TranslatorRepository;
import com.github.polurival.translator.di.modules.ApplicationModule;
import com.github.polurival.translator.di.modules.DataModule;
import com.github.polurival.translator.di.modules.InteractorModule;
import com.github.polurival.translator.presentation.mvp.presenter.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Polurival on 16.11.2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class, DataModule.class, InteractorModule.class})
public interface ApplicationComponent {

    void inject(MainPresenter mainPresenter);

    void inject(TranslatorRepository translatorRepository);

    void inject(TranslatorInteractor translatorInteractor);
}
