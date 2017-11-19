package com.github.polurival.translator.presentation.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.github.polurival.translator.TranslatorApplication;
import com.github.polurival.translator.business.interactor.TranslatorInteractor;
import com.github.polurival.translator.business.model.TranslateModel;
import com.github.polurival.translator.business.model.YandexTranslateResponseModel;
import com.github.polurival.translator.presentation.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Polurival on 13.11.2017.
 */

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    @Inject
    TranslatorInteractor translatorInteractor;

    public MainPresenter() {
        TranslatorApplication.getApplicationComponent().inject(this);
    }

    /**
     * Загрузить переводы из кэша или интерактора и засетить в адаптер списка
     */
    public void getTranslate(String languageFrom, String languageTo, String word) {

        translatorInteractor.getTranslate(new TranslateModel(languageFrom, languageTo, word))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onTranslateLoaded);
    }

    /**
     * Передать слово запроса на сохранение в интерактор
     */
    public void saveWord(String languageFrom, String word) {

    }

    /**
     * Загрузить историю запросов из интерактора и засетить в адаптер для автоподстановки
     */
    public void loadWords(String languageFrom) {

    }

    private void onTranslateLoaded(YandexTranslateResponseModel translateModel) {
        getViewState().setTranslate(prepareText(translateModel.getText()));
    }

    private String prepareText(List<String> words) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            stringBuilder.append(word).append("\n");
        }
        return stringBuilder.toString();
    }
}
