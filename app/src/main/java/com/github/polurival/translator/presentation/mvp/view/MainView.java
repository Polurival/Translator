package com.github.polurival.translator.presentation.mvp.view;

import com.arellomobile.mvp.MvpView;

/**
 * @author Polurival on 13.11.2017.
 */

public interface MainView extends MvpView {

    void setLanguageFrom(String languageFrom);

    void setLanguageTo(String languageTo);

    void setTranslate(String word);

    void showProgress();
    void hideProgress();
    void showError();
}
