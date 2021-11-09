package com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAdOptions;
import com.adcolony.sdk.AdColonyAdSize;
import com.adcolony.sdk.AdColonyAdView;
import com.adcolony.sdk.AdColonyAdViewListener;
import com.adcolony.sdk.AdColonyAppOptions;
import com.adcolony.sdk.AdColonyZone;
import com.airbnb.lottie.LottieAnimationView;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.R;

import static com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils.heartconterx;
import static com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils.likedbio;
import static com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils.savedbio;
import static com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils.savedcontex;
import static com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils.sharepref;
import static com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils.shareprefsave;
import static com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils.yolo;

public class BioActivity extends AppCompatActivity {

    // adColony banner
    private final String APP_ID = "app801b6402e4b741ad8b";
    private final String ZONE_ID = "vzc8fd799f505d4d4c9c";
    private final String TAG = "AdColonyBannerDemo";

    private AdColonyAdViewListener listener;
    private AdColonyAdOptions adOptions;
    private RelativeLayout adContainer;
    private ProgressBar progressBar;
    private Button buttonLoad;
    private AdColonyAdView adView;
    // adColony banner over


    LottieAnimationView heart,copy,eye,share,edit;
    ImageView done,saved;
    TextView biotext;
    EditText bioedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);


        adContainer = findViewById(R.id.ad_container);
        progressBar = findViewById(R.id.progress);

        if (adContainer.getChildCount() > 0) {
            adContainer.removeView(adView);
        }

        progressBar.setVisibility(View.VISIBLE);
        buttonLoad.setEnabled(false);
        buttonLoad.setAlpha(0.5f);

        requestBannerAd();

        AdColonyAppOptions appOptions = new AdColonyAppOptions();
        AdColony.configure(this, appOptions, APP_ID, ZONE_ID);

        listener = new AdColonyAdViewListener() {
            @Override
            public void onRequestFilled(AdColonyAdView adColonyAdView) {
                Log.d(TAG, "onRequestFilled");
                resetUI();
                adContainer.addView(adColonyAdView);
                adView = adColonyAdView;
            }

            @Override
            public void onRequestNotFilled(AdColonyZone zone) {
                super.onRequestNotFilled(zone);
                Log.d(TAG, "onRequestNotFilled");
                resetUI();
            }

            @Override
            public void onOpened(AdColonyAdView ad) {
                super.onOpened(ad);
                Log.d(TAG, "onOpened");
            }

            @Override
            public void onClosed(AdColonyAdView ad) {
                super.onClosed(ad);
                Log.d(TAG, "onClosed");
            }

            @Override
            public void onClicked(AdColonyAdView ad) {
                super.onClicked(ad);
                Log.d(TAG, "onClicked");
            }

            @Override
            public void onLeftApplication(AdColonyAdView ad) {
                super.onLeftApplication(ad);
                Log.d(TAG, "onLeftApplication");
            }
        };

        // adColony banner over

        Log.e("sapata","Hashtag Activity");

        init();

        Toolbar mToolbar;

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        if(utils.editflag == 1) {
            editmethod();
        }


        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String bio = biotext.getText().toString();

                if(likedbio.size()==0){
                    likedbio.add(bio);
                    sharepref(heartconterx);
                    yolo(heartconterx);
                    Toast.makeText(getApplicationContext(), "Liked !", Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean ans = likedbio.contains(bio);

                    if (ans)
                        Toast.makeText(getApplicationContext(), "Liked !", Toast.LENGTH_SHORT).show();
                    else{
                        likedbio.add(bio);
                        sharepref(heartconterx);
                        yolo(heartconterx);
                        Toast.makeText(getApplicationContext(), "Liked !", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                donemethod();
                String bio = biotext.getText().toString();


                if(savedbio.size()==0){
                    savedbio.add(bio);
                    shareprefsave(savedcontex);
                    //yolosave(getApplicationContext());
                    Toast.makeText(getApplicationContext(), "Saved !", Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean ans = savedbio.contains(bio);

                    if (ans)
                        Toast.makeText(getApplicationContext(), "ALready Saved !", Toast.LENGTH_SHORT).show();
                    else{
                        savedbio.add(bio);
                        shareprefsave(savedcontex);
                        //yolosave(getApplicationContext());

//                        adapter.notifyDataSetChanged();
                        Toast.makeText(getApplicationContext(), "Saved !", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("", biotext.getText());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(BioActivity.this, "Hashtag Copied", Toast.LENGTH_SHORT).show();

            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editmethod();


            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                donemethod();

            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String shareBody = biotext.getText().toString();
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share Hashtag Using"));

            }
        });

        eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bio = biotext.getText().toString();

                startActivity(new Intent(getApplicationContext(), EyeActivity.class));
                utils.biotext = bio;

            }
        });


    }

    private void requestBannerAd() {

        adOptions = new AdColonyAdOptions();
        AdColony.requestAdView(ZONE_ID, listener, AdColonyAdSize.BANNER, adOptions);
    }

    private void resetUI() {
        progressBar.setVisibility(View.GONE);
        buttonLoad.setEnabled(true);
        buttonLoad.setAlpha(1.0f);
    }



    private void donemethod() {
        biotext.setVisibility(View.VISIBLE);
        bioedit.setVisibility(View.GONE);
        edit.setVisibility(View.VISIBLE);
        done.setVisibility(View.GONE);

        String bio = bioedit.getText().toString();
        biotext.setText(bio);

        utils.editflag= 0;
    }

    private void editmethod() {

        heart.setVisibility(View.GONE);
        saved.setVisibility(View.VISIBLE);

        biotext.setVisibility(View.GONE);
        bioedit.setVisibility(View.VISIBLE);
        edit.setVisibility(View.GONE);
        done.setVisibility(View.VISIBLE);

        String bio = biotext.getText().toString();
        bioedit.setText(bio);
    }



    private void init () {
        biotext = findViewById(R.id.biotext);
        heart = findViewById(R.id.heart);
        copy = findViewById(R.id.copy);
        eye = findViewById(R.id.eye);
        share = findViewById(R.id.share);
        edit = findViewById(R.id.edit);
        done = findViewById(R.id.done);
        saved = findViewById(R.id.saved);

        bioedit = findViewById(R.id.editbio);
        biotext.setText(utils.biotext);

        heart.setVisibility(View.VISIBLE);
        saved.setVisibility(View.GONE);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}