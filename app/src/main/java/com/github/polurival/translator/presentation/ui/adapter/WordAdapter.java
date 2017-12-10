package com.github.polurival.translator.presentation.ui.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.github.polurival.translator.business.model.TranslateModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Польщиков Юрий.
 */

public class WordAdapter extends ArrayAdapter<String> {

    @LayoutRes
    private static final int DROPDOWN_LAYOUT = android.R.layout.simple_dropdown_item_1line;

    public void setWords(List<TranslateModel> translateModels) {
        clear();
        addAll(mapTranslateModelToString(translateModels));
    }

    public WordAdapter(@NonNull Context context) {
        super(context, DROPDOWN_LAYOUT);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(DROPDOWN_LAYOUT, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.suggestionTextView.setText(getItem(position));

        return convertView;
    }

    private List<String> mapTranslateModelToString(List<TranslateModel> translateModels) {
        List<String> words = new ArrayList<>(translateModels.size());
        for (TranslateModel model : translateModels) {
            words.add(model.getText());
        }
        return words;
    }

    private static class ViewHolder {

        TextView suggestionTextView;

        ViewHolder(View convertView) {
            suggestionTextView = convertView.findViewById(android.R.id.text1);
        }
    }
}
