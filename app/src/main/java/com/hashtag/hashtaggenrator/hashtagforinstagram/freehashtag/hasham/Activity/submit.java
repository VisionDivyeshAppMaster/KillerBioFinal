package com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAdOptions;
import com.adcolony.sdk.AdColonyAppOptions;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.AdColonyInterstitialListener;
import com.adcolony.sdk.AdColonyZone;
import com.airbnb.lottie.LottieAnimationView;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.R;
import com.mopub.common.MoPub;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.SdkInitializationListener;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubView;

public class submit extends AppCompatActivity {

    LottieAnimationView share,done;
    ImageView edit;
    Button submit;
    TextView biotext;
    EditText bioedit;
    LinearLayout linearLayout;

    // adColony
    private final String APP_ID = "app801b6402e4b741ad8b";
    private final String ZONE_ID = "vza6ef94e4656240dca5";
    private final String TAG = "AdColonyDemo";
    private ProgressBar progress;
    private AdColonyInterstitial ad;
    private AdColonyInterstitialListener listener;
    private AdColonyAdOptions adOptions;
    //MoPub interstitial
    private MoPubInterstitial mInterstitial;

    private static final String TAGB = "main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        // MoPub banner
        SdkConfiguration sdkConfiguration = new SdkConfiguration.Builder("b195f8dd8ded45fe847ad89ed1d016da").build();
        MoPub.initializeSdk(this, sdkConfiguration, initSdkListener());

        MoPubView moPubView = (MoPubView) findViewById(R.id.ad_vew);
        moPubView.setAdUnitId("b195f8dd8ded45fe847ad89ed1d016da"); // Enter your Ad Unit ID from www.mopub.com
        moPubView.loadAd();
        //
        // MoPub banner over


        //MoPub insterstitial

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
                Log.d("TAG", "onInterstitialFailed: ");
            }

            @Override
            public void onInterstitialClicked(MoPubInterstitial moPubInterstitial) {
                Log.d("TAG", "onInterstitialFailed: ");
            }

            @Override
            public void onInterstitialDismissed(MoPubInterstitial moPubInterstitial) {
                Log.d("TAG", "onInterstitialFailed: ");
            }
        });
        mInterstitial.load();
        //
        // MoPub interstitial over

        progress = findViewById(R.id.progress);

        // adColony interstitial
//        ad.show();
        AdColonyAppOptions appOptions = new AdColonyAppOptions()
                .setUserID("unique_user_id")
                .setKeepScreenOn(true);
        AdColony.configure(this, appOptions, APP_ID, ZONE_ID);

        adOptions = new AdColonyAdOptions();

        listener = new AdColonyInterstitialListener() {
            @Override
            public void onRequestFilled(AdColonyInterstitial ad) {
                // Ad passed back in request filled callback, ad can now be shown
                submit.this.ad = ad;
                progress.setVisibility(View.INVISIBLE);
                Log.d(TAG, "onRequestFilled");
            }

            @Override
            public void onRequestNotFilled(AdColonyZone zone) {
                // Ad request was not filled
                progress.setVisibility(View.INVISIBLE);
                Log.d(TAG, "onRequestNotFilled");
            }

            @Override
            public void onOpened(AdColonyInterstitial ad) {

                progress.setVisibility(View.VISIBLE);
                Log.d(TAG, "onOpened");
            }

            @Override
            public void onExpiring(AdColonyInterstitial ad) {
                // Request a new ad if ad is expiring
                progress.setVisibility(View.VISIBLE);
                AdColony.requestInterstitial(ZONE_ID, this, adOptions);
                Log.d(TAG, "onExpiring");
            }
        };

        // adColony interstitial over

        Log.e("sapata","Submit Activity");

        init();

        Toolbar mToolbar;

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

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

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(bioedit.getText().toString().length() == 0 || biotext.getText().toString().length() == 0) {

                    Toast.makeText(com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Activity.submit.this, "Wtite Bio First", Toast.LENGTH_SHORT).show();
                    //hideKeyboard();

                    InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    View view =getCurrentFocus();
                    if (view == null) {
                        view = new View(getApplication());
                    }
                    if (imm != null) {
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    }
                }
                else {

                    Toast.makeText(com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Activity.submit.this, "Hashtag Sumbited ! Check Saved Hashtag", Toast.LENGTH_SHORT).show();
                    donemethod();
                    utils.submiteddbio.add(biotext.getText().toString());
                    utils.shareprefsub(getApplicationContext());
                    biotext.setText("");
                    startActivity(new Intent(getApplicationContext(), SubmitedActivity.class));
                    finish();
                }
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

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
            }
        });
    }

    private SdkInitializationListener initSdkListener() {
        return new SdkInitializationListener() {
            @Override
            public void onInitializationFinished() {

            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();

        // It's somewhat arbitrary when your ad request should be made. Here we are simply making
        // a request if there is no valid ad available onResume, but really this can be done at any
        // reasonable time before you plan on showing an ad.
        if (ad == null || ad.isExpired()) {
            // Optionally update location info in the ad options for each request:
            // LocationManager locationManager =
            //     (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            // Location location =
            //     locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            // adOptions.setUserMetadata(adOptions.getUserMetadata().setUserLocation(location));
            progress.setVisibility(View.VISIBLE);
            AdColony.requestInterstitial(ZONE_ID, listener, adOptions);
        }
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view =getCurrentFocus();
        if (view == null) {
            view = new View(getApplication());
        }
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void donemethod() {
        biotext.setVisibility(View.VISIBLE);
        bioedit.setVisibility(View.GONE);
        edit.setVisibility(View.VISIBLE);
        done.setVisibility(View.GONE);

        String bio = bioedit.getText().toString();
        biotext.setText(bio);

        hideKeyboard();

        utils.editflag= 0;
    }

    private void editmethod() {
        biotext.setVisibility(View.GONE);
        bioedit.setVisibility(View.VISIBLE);
        edit.setVisibility(View.GONE);
        done.setVisibility(View.VISIBLE);

        String bio = biotext.getText().toString();
        bioedit.setText(bio);
    }

    private void init() {
        share = findViewById(R.id.share);
        edit = findViewById(R.id.edit);
        done = findViewById(R.id.done);

        submit = findViewById(R.id.submit);

        bioedit = findViewById(R.id.editbio);
        biotext = findViewById(R.id.biotext);

        linearLayout = findViewById(R.id.mainlayout);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}