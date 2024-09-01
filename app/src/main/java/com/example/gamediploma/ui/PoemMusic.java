package com.example.gamediploma.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gamediploma.R;

import java.util.Objects;

public class PoemMusic extends AppCompatActivity {
    int[] poem_audio = {R.raw.barish_aayi_cham_cham_cham, R.raw.chanda_mama_door_ke,
            R.raw.hum_chote_chote_ache_hain_rhyme, R.raw.lakdi_ki_kathi, R.raw.nani_teri_morni_ko_mor_le_gaye,
            R.raw.ek_mota_hathi_hindi_rhyme_poems, R.raw.gadi_aayi_gadi_aayi_chuk_chuk, R.raw.titli_udi_bus_me_chadhi};
    String[] musicName = {};
    int pos = 0;
    MediaPlayer mp = null;
    TextView poem_name, txtSongStartTime, txtSongEndTime;
    ImageView imageView;
    ImageButton imageButton, previousButton, nextBtn;
    SeekBar seekBar;
    private final Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poem_music);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Music");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        musicName = getResources().getStringArray(R.array.songs);
        poem_name = findViewById(R.id.txt_music);
        txtSongStartTime = findViewById(R.id.music_start);
        txtSongEndTime = findViewById(R.id.music_stop);

        seekBar = findViewById(R.id.music_seek);

        imageView = findViewById(R.id.img_music);

        nextBtn = findViewById(R.id.nextbtn);
        imageButton = findViewById(R.id.playbtn);
        nextBtn = findViewById(R.id.nextbtn);
        previousButton = findViewById(R.id.previousbtn);

        Intent i = getIntent();
        pos = i.getIntExtra("key2", 0);
        poem_name.setText(musicName[pos]);
        poem_name.setSelected(true);
    }

    @Override
    protected void onStart() {
        super.onStart();

        setMediaPlayer();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mp != null) {
                    int progress = mp.getCurrentPosition();
                    seekBar.setProgress(progress);

                    String currentTime = createTime(mp.getCurrentPosition());
                    txtSongStartTime.setText(currentTime);

                    mHandler.postDelayed(this, 100);
                }
            }
        }, 100);

        seekBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.MULTIPLY);
        seekBar.getThumb().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mp.seekTo(seekBar.getProgress());
            }
        });

        imageButton.setOnClickListener(view -> {
            if (mp.isPlaying()) {
                imageButton.setImageResource(R.drawable.ic_pause);
                mp.pause();
            } else {
                imageButton.setImageResource(R.drawable.ic_play);
                mp.start();
            }
        });

        nextBtn.setOnClickListener(view -> {
            playNextSong();
        });

        previousButton.setOnClickListener(view -> {
            startAnimation(-360f);
            if (mp.isPlaying()) {
                mp.pause();
            }
            pos = pos - 1;
            if (pos < 0) {
                pos = poem_audio.length - 1;
            }
            setMediaPlayer();
        });
    }

    void setMediaPlayer() {
        mp = MediaPlayer.create(PoemMusic.this, poem_audio[pos]);
        mp.start();
        mp.setOnCompletionListener(mediaPlayer -> playNextSong());
        seekBar.setMax(mp.getDuration());
        poem_name.setText(musicName[pos]);
        if (mp.isPlaying()) {
            imageButton.setImageResource(R.drawable.ic_play);
        } else {
            imageButton.setImageResource(R.drawable.ic_pause);
        }
        txtSongEndTime.setText(createTime(mp.getDuration()));
    }

    private void playNextSong() {
        startAnimation(360f);
        if (mp.isPlaying()) {
            mp.pause();
        }
        pos = pos + 1;
        if (pos >= poem_audio.length) {
            pos = 0;
        }
        setMediaPlayer();
    }

    public void startAnimation(Float degree) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "rotation", 0f, degree);
        animator.setDuration(1000);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator);
        animatorSet.start();
    }

    public String createTime(int duration) {
        String time = "";
        int min = duration / 1000 / 60;
        int sec = duration / 1000 % 60;

        time = time + min + ":";
        if (sec < 10) {
            time += "0";
        }
        time += sec;
        return time;
    }

    protected void onPause() {
        mp.release();
        mHandler.removeCallbacksAndMessages(null); // Remove callbacks to avoid memory leaks
        super.onPause();

    }

    @Override
    public void onBackPressed() {
        mp.release();
        mHandler.removeCallbacksAndMessages(null); // Remove callbacks to avoid memory leaks
        super.onBackPressed();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}