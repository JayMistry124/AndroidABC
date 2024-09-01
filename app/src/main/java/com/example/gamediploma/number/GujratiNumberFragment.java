package com.example.gamediploma.number;

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

public class GujratiNumberFragment extends Fragment {

    ListView lv;
    String num[] = {"૦", "૧", "૨", "૩", "૪", "૫", "૬", "૭", "૮", "૯"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_alpha, null);

        lv = view.findViewById(R.id.listview);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(requireContext(), R.layout.simple_list_item_1, num);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener((adapterView, view1, pos, l) -> {
            ShowCharDialog showCharDialog = new ShowCharDialog(requireContext(), num[pos]);
            showCharDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            showCharDialog.show();
        });
        return view;
    }
}
