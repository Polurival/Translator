package com.github.polurival.translator.presentation.ui.activity;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.github.polurival.translator.R;
import com.github.polurival.translator.presentation.mvp.presenter.MainPresenter;
import com.github.polurival.translator.presentation.mvp.view.MainView;
import com.github.polurival.translator.presentation.ui.adapter.WordAdapter;

/**
 * @author Polurival on 13.11.2017.
 */

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter presenter;

    private AutoCompleteTextView wordsForTranslateView;
    private Button translateButton;
    TextView translatedWordsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordsForTranslateView = findViewById(R.id.autoCompleteTextView);
        // TODO: 30.11.2017 посмотреть как подгружать данные в адаптер с помощью rx
        wordsForTranslateView.setAdapter(new WordAdapter(getApplicationContext()));
        translatedWordsView = findViewById(R.id.textView);

        translateButton = findViewById(R.id.button);
        translateButton.setOnClickListener((view) -> {
            presenter.getTranslate("ru", "en", wordsForTranslateView.getText().toString());
        });
    }

    @Override
    public void setLanguageFrom(String languageFrom) {

    }

    @Override
    public void setLanguageTo(String languageTo) {

    }

    @Override
    public void setTranslate(String word) {
        translatedWordsView.setText(word);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError() {

    }
}
