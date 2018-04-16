package com.hijah.musicoftheworld;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.view.ViewGroup.LayoutParams;
import android.media.MediaPlayer;
import com.hijah.musicoftheworld.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnOpenPopup;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Play = (Button) findViewById(R.id.button_play);
        Button Pause = (Button) findViewById(R.id.buttonpause);
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.ponponpon);
        btnOpenPopup = (Button) findViewById(R.id.buttonEastAsia);
        btnOpenPopup.setOnClickListener(this);
        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });
        Pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();

            }
        });
    }

    @Override
    public void onClick(View view) {
        LayoutInflater layoutInflater
                = (LayoutInflater) getBaseContext()
                .getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.popup, null);
        final PopupWindow popupWindow = new PopupWindow(
                popupView,
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);

        Button btnDismiss = (Button) popupView.findViewById(R.id.dismiss);
        btnDismiss.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        popupWindow.showAsDropDown(btnOpenPopup, 20, 90);
    }
}
