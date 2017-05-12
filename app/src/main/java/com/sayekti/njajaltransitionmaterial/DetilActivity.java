package com.sayekti.njajaltransitionmaterial;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;

public class DetilActivity extends AppCompatActivity {

    public static int SLIDE = 0;
    public static int FADE = 1;
    public static int EXPLODE = 2;

    private int animType = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil);
        animType = getIntent().getIntExtra("animType", 0);
        setupAnim(animType);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void setupAnim(int animType){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            if (animType == SLIDE){
                Slide slide = new Slide();
                slide.setDuration(1000);
                getWindow().setExitTransition(slide);
            } else if (animType == FADE){
                Fade fade = new Fade();
                fade.setDuration(1000);
                getWindow().setExitTransition(fade);
            } else if (animType == EXPLODE){
                Explode explode = new Explode();
                explode.setDuration(1000);
                getWindow().setExitTransition(explode);
            }
        }

    }
}
