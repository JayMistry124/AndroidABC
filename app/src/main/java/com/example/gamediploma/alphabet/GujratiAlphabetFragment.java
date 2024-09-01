package com.example.gamediploma.alphabet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gamediploma.R;
import com.example.gamediploma.dialog.ShowCharDialog;

public class GujratiAlphabetFragment extends Fragment {

    ListView lv;
    String alpha[] = {"ક", "ખ", "ગ", "ઘ", "ચ", "છ", "જ", "ઝ", "ટ", "ઠ", "ડ", "ઢ", "ણ", "ત", "થ", "દ", "ધ", "ન", "પ", "ફ", "બ", "ભ", "મ", "ય","ર","લ","ળ","વ","શ","ષ","સ","હ","ળ","ક્ષ","જ્ઞ"};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_alpha, null);

        lv = view.findViewById(R.id.listview);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(requireContext(), R.layout.simple_list_item_1, alpha);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener((adapterView, view1, pos, l) -> {
            ShowCharDialog showCharDialog = new ShowCharDialog(requireContext(), alpha[pos]);
            showCharDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            showCharDialog.show();
        });
        return view;
    }
}
