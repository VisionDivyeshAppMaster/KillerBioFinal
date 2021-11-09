package com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Adepter.SavedAdapter;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.R;
import com.mopub.common.MoPub;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.SdkInitializationListener;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;

public class saved extends AppCompatActivity {

    GridView recyclerView;
    private MoPubInterstitial mInterstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

    // MoPub interstitial
        SdkConfiguration sdkConfigurationInterstitals = new SdkConfiguration.Builder("24534e1901884e398f1253216226017e").build();
        MoPub.initializeSdk(this, sdkConfigurationInterstitals, initSdkListener());

        mInterstitial = new MoPubInterstitial(this, "24534e1901884e398f1253216226017e");
        mInterstitial.setInterstitialAdListener(new MoPubInterstitial.InterstitialAdListener() {
            @Override
            public void onInterstitialLoaded(MoPubInterstitial moPubInterstitial) {
                moPubInterstitial.show();
                mInterstitial = moPubInterstitial;
                Log.d("TAG", "onInterstitialLoaded: ");
            }

            @Override
            public void onInterstitialFailed(MoPubInterstitial moPubInterstitial, MoPubErrorCode moPubErrorCode) {
                Log.d("TAG", "onInterstitialFailed: ");
            }

            @Override
            public void onInterstitialShown(MoPubInterstitial moPubInterstitial) {
                Log.d("TAG", "onInterstitialShown: ");
            }

            @Override
            public void onInterstitialClicked(MoPubInterstitial moPubInterstitial) {
                Log.d("TAG", "onInterstitialClicked: ");
            }

            @Override
            public void onInterstitialDismissed(MoPubInterstitial moPubInterstitial) {
                Log.d("TAG", "onInterstitialDismissed: ");
            }
        });
        mInterstitial.load();
        //
        // MoPub interstitial over


        Log.e("sapata","Saved Activity");

        Toolbar mToolbar;

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        utils.savedcontex = getApplicationContext();
        recyclerView =findViewById(R.id.savedbiogrid);

        recyclerView.setAdapter(new SavedAdapter(utils.savedbio));
        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                startActivity(new Intent(getApplicationContext(), BioActivity.class));
                utils.biotext = utils.savedbio.get(position);
                Log.e("TTTT","Mi---saved>"+position);
            }
        });

    }

    private SdkInitializationListener initSdkListener() {
        return new SdkInitializationListener() {
            @Override
            public void onInitializationFinished() {
           /* MoPub SDK initialized.
           Check if you should show the consent dialog here, and make your ad requests. */
            }
        };
    }

    @Override
public boolean onSupportNavigateUp() {
    onBackPressed();
    return true;
}
}
