package com.example.gamediploma;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.gamediploma.alphabet.AlphaActivity;
import com.example.gamediploma.number.NumberActivity;
import com.example.gamediploma.ui.LoginActivity;
import com.example.gamediploma.ui.PlacesActivity;
import com.example.gamediploma.ui.PoemActivity;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button alpha, poem, places, number;
    ImageButton img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alpha = findViewById(R.id.valAlphabet);
        poem = findViewById(R.id.valPoem);
        places = findViewById(R.id.valPlaces);
        number = findViewById(R.id.butNumber);
//        img = findViewById(R.id.img1);

        alpha.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, AlphaActivity.class);
            startActivity(i);
        });

        poem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PoemActivity.class);
                startActivity(i);
            }
        });

        places.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PlacesActivity.class);
                startActivity(i);
            }
        });

        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, NumberActivity.class);
                startActivity(i);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_a, menu);
        return super.onCreateOptionsMenu(menu);
    }

//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId() == R.id.txtsetting) {
//            Toast.makeText(this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
//            return true;
//        } else if (item.getItemId() == R.id.txtlogout) {
//            onItemClick();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    private void onItemClick() {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.activity_logout);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();
        AppCompatButton logout = dialog.findViewById(R.id.logout_button);
        AppCompatButton cancle = dialog.findViewById(R.id.cancel_button);
        cancle.setOnClickListener(view -> {
            dialog.dismiss();
        });
        logout.setOnClickListener(view -> {
            dialog.dismiss();
            FirebaseAuth.getInstance().signOut();
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
        });
    }
}