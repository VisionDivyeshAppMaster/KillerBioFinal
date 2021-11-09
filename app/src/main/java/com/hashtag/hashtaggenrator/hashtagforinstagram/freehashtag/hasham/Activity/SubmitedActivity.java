package com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAdOptions;
import com.adcolony.sdk.AdColonyAdSize;
import com.adcolony.sdk.AdColonyAdView;
import com.adcolony.sdk.AdColonyAdViewListener;
import com.adcolony.sdk.AdColonyAppOptions;
import com.adcolony.sdk.AdColonyZone;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Adepter.SubmittedAdapter;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.R;

public class SubmitedActivity extends AppCompatActivity {

    // adColony banner ad
    private final String APP_ID = "app801b6402e4b741ad8b";
    private final String ZONE_ID = "vzc8fd799f505d4d4c9c";
    private final String TAG = "AdColonyBannerDemo";

    private AdColonyAdViewListener listener;
    private AdColonyAdOptions adOptions;
    private RelativeLayout adContainer;
    private ProgressBar progressBar;
    private AdColonyAdView adView;
    //

    GridView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submited);

        // adColonu banner
        adContainer = findViewById(R.id.ad_container);
        progressBar = findViewById(R.id.progress);

        if (adContainer.getChildCount() > 0) {
            adContainer.removeView(adView);
        }

        progressBar.setVisibility(View.VISIBLE);


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

        requestBannerAd();
        // adColony banner over
        recyclerView =findViewById(R.id.savedgrid);

        Log.e("sapata","Submitted Activity");

        Toolbar mToolbar;

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        utils.submitedcontex = getApplicationContext();

        recyclerView.setAdapter(new SubmittedAdapter(utils.submiteddbio));
        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                startActivity(new Intent(getApplicationContext(), BioActivity.class));
                utils.biotext = utils.submiteddbio.get(position);
                Log.e("TTTT","Mi---tag>"+position);
            }
        });

    }

    private void resetUI() {
        progressBar.setVisibility(View.GONE);
    }

    private void requestBannerAd() {
        adOptions = new AdColonyAdOptions();
        AdColony.requestAdView(ZONE_ID, listener, AdColonyAdSize.BANNER, adOptions);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
