package com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.R;

public class Splashsreen extends AppCompatActivity {

    private ProgressDialog pDialog;


    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashsreen);
         new GetContacts().execute();

    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {

            utils.animationhash();
            utils.beautyhash();
            utils.fashionhash();
            utils.gaminghash();
            utils.gymhash();
            utils.holihash();
            utils.memehash();
            utils.sportsfitnesshash();
            utils.tiktokhash();
            utils.travelhash();
            utils.photographyhash();
            utils.catfill();
            utils.yogahash();
            utils.workhash();
            utils.weddinghash();
            utils.tattooshash();
            utils.summerhash();
            utils.snowhash();
            utils.snapchathash();
            utils.skatinghash();
            utils.shoppinghash();
            utils.selfiehash();
            utils.runninghash();
            utils.readinghash();
            utils.rainhash();
            utils.pubghash();
            utils.photographerhash();
            utils.musichash();
            utils.movieshash();
            utils.motivationhash();
            utils.moneyhash();
            utils.minecrafthash();
            utils.makeuphash();
            utils.instalikehash();
            utils.jewelryhash();
            utils.horseshash();
            utils.hockeyhash();
            utils.hdrhash();
            utils.halloweenhash();
            utils.guitarhash();
            utils.gtavhash();
            utils.golfhash();
            utils.freefirehash();
            utils.fortnitehash();
            utils.footballhash();
            utils.foodhash();
            utils.followhash();
            utils.flowershash();
            utils.familyhash();
            utils.drawinghash();
            utils.dancerhash();
            utils.crickethash();
            utils.comedyhash();
            utils.collegehash();
            utils.coffeehash();
            utils.codinghash();
            utils.clashroyalehash();
            utils.clashofclanshash();
            utils.cityhash();
            utils.christmashash();
            utils.catshash();
            utils.carshash();
            utils.boxinghash();
            utils.bollywoodhash();
            utils.blackandwhitehash();
            utils.birthdayhash();
            utils.bikeshash();
            utils.battlefieldhash();
            utils.basketballhash();
            utils.actorshash();
            utils.babieshash();
            utils.autumnhash();
            utils.architecturehash();
            utils.animeshash();
            utils.animalshash();
            utils.androidhash();
            utils.adventurehash();

            utils.yolo(getApplicationContext());
            utils.yolosub(getApplicationContext());
            utils.yolosave(getApplicationContext());

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

//            if (pDialog.isShowing())
//                pDialog.dismiss();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    //your code here
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    finish();
                }
            }, 2000);

        }
    }

}
