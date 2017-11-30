package com.github.polurival.translator.presentation.mvp.presenter;

import com.github.polurival.translator.business.interactor.TranslatorInteractor;
import com.github.polurival.translator.presentation.mvp.view.MainView$$State;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

/**
 * @author Польщиков Юрий.
 */

@RunWith(RobolectricTestRunner.class)
public class MainPresenterTest {

    @Mock
    TranslatorInteractor translatorInteractorMock;
    @Mock
    MainView$$State mainViewStateMock;

    private MainPresenter mainPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mainPresenter = new MainPresenter();
        mainPresenter.setViewState(mainViewStateMock);
    }

    @Test
    public void onGetTranslate_ShouldShowTranslate() throws Exception {
        // TODO: 30.11.2017 необходимо замокать rx
        /*String languageFrom = "ru";
        String languageTo = "en";
        String word = "апельсин";

        mainPresenter.getTranslate(languageFrom, languageTo, word);

        verify(mainViewStateMock).setTranslate(anyString());*/
    }
}