package com.example.gamediploma.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gamediploma.R;
//import com.example.gamediploma.db.model.Contact;

import java.util.ArrayList;

public class RVAdaper extends RecyclerView.Adapter<RVAdaper.myclass> {
    @NonNull
    Context context;
    ArrayList<String> name;
    ArrayList<String> code;
    ArrayList<Integer> image;

    public RVAdaper(Context context, ArrayList<String> name, ArrayList<String> code, ArrayList<Integer> image) {
        this.context = context;
        this.name = name;
        this.code = code;
        this.image = image;
    }

//    public RVAdaper(ProfileActivity context, ArrayList<Contact> arrayList) {
//        this.context = context;
//    }

    public myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom, parent, false);
        return new myclass(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myclass holder, int position) {
//        holder.tv.setText(sno.get(position));
        holder.tv1.setText(name.get(position));
        holder.tv2.setText(code.get(position));
        holder.iv.setImageResource(image.get(position));

        holder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onIntemclick(image.get(position));
            }
        });
    }

    private void onIntemclick(Integer integer) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_img_layout);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ImageView imageView = dialog.findViewById(R.id.image_view);
        imageView.setImageResource(integer);
        dialog.show();
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    class myclass extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv1, tv2;

        public myclass(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.txtcity);
            tv2 = itemView.findViewById(R.id.txtxAlp);
            iv = itemView.findViewById(R.id.valA);
        }
    }
}
