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
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Polurival on 13.11.2017.
 */

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    @Inject
    TranslatorInteractor translatorInteractor;

    private final CompositeDisposable disposable = new CompositeDisposable();

    public MainPresenter() {
        TranslatorApplication.getApplicationComponent().inject(this);
    }

    /**
     * Загрузить переводы из кэша или интерактора и засетить в адаптер списка
     */
    public void getTranslate(TranslateModel translateModel) {
        getViewState().showProgress();
        disposable.add(translatorInteractor.getTranslate(translateModel)
                .doOnSuccess(model -> translatorInteractor.saveWord(translateModel))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onTranslateLoaded, this::onTranslateError));
    }

    /**
     * Загрузить историю запросов из интерактора и засетить в адаптер для автоподстановки
     */
    public void subscribeWordsLoading(String languageFrom) {
        disposable.add(translatorInteractor.getSavedWords(languageFrom)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(words -> getViewState().updateAdapter(words)));
    }

    public void unsubscribeWordsLoading() {
        disposable.clear();
    }

    private void onTranslateLoaded(YandexTranslateResponseModel translateModel) {
        getViewState().hideProgress();
        getViewState().setTranslate(prepareText(translateModel.getText()));
    }

    private void onTranslateError(Throwable error) {
        getViewState().hideProgress();
        getViewState().showError(error.getMessage());
    }

    private String prepareText(List<String> words) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            stringBuilder.append(word).append("\n");
        }
        return stringBuilder.toString();
    }
}
