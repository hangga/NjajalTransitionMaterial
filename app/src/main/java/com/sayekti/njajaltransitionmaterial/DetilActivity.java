package com.sayekti.njajaltransitionmaterial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DetilActivity extends AppCompatActivity {

    public static int SLIDE_HORIZONTAL = 0;
    public static int SWIPE_VERTICAL = 1;
    public static int ZOOM = 2;

    private int animType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransitionEnter();
        setContentView(R.layout.activity_detil);
        animType = getIntent().getIntExtra("animType", SLIDE_HORIZONTAL);
        setupOnEnterAnim();

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

    @Override
    public void finish() {
        super.finish();
        setupOnExitAnim();
        //overridePendingTransitionExit();
    }

    @Override
    public void startActivity(Intent intent) {
        setupOnEnterAnim();
        //overridePendingTransitionEnter();
        super.startActivity(intent);
    }

    private void setupOnEnterAnim(){
        if (animType == SLIDE_HORIZONTAL){
            overridePendingTransition(R.anim.sb_anim_slide_from_right, R.anim.sb_anim_slide_to_left);
        } else if (animType == SWIPE_VERTICAL){
            overridePendingTransition(R.anim.sb_anim_slide_from_bottom, R.anim.sb_anim_keep_stay);
        } else if (animType == ZOOM){
            overridePendingTransition(R.anim.sb_anim_zoom_out, R.anim.sb_anim_keep_stay);
        }
    }

    private void setupOnExitAnim(){
        if (animType == SLIDE_HORIZONTAL){
            overridePendingTransition(R.anim.sb_anim_slide_from_left, R.anim.sb_anim_slide_to_right);
        } else if (animType == SWIPE_VERTICAL){
            overridePendingTransition(R.anim.sb_anim_keep_stay, R.anim.sb_anim_slide_from_top);
        }
    }


    /**
     * Overrides the pending Activity transition by performing the "Enter" animation.
     */
    protected void overridePendingTransitionEnter() {
        overridePendingTransition(R.anim.sb_anim_slide_from_right, R.anim.sb_anim_slide_to_left);
        /* overridePendingTransition(animate activity 2, animate activity 1);*/
    }

    /**
     * Overrides the pending Activity transition by performing the "Exit" animation.
     */
    protected void overridePendingTransitionExit() {
        overridePendingTransition(R.anim.sb_anim_slide_from_left, R.anim.sb_anim_slide_to_right);
    }

}
