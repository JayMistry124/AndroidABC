package com.example.gamediploma.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.gamediploma.R;

public class ShowCharDialog extends Dialog {
    String charShow;

    public ShowCharDialog(@NonNull Context context, String charShow) {
        super(context, R.style.DialogStyle);
        this.charShow = charShow;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);
//        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.DialogStyle);
    }

    @Override
    protected void onStart() {
        super.onStart();
        TextView alphabet_text = findViewById(R.id.alphabet_text);
        alphabet_text.setText(charShow);
    }
}
