package com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Adepter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Activity.BioActivity;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Activity.EyeActivity;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.BuildConfig;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.R;

import java.util.ArrayList;

import static android.content.Context.CLIPBOARD_SERVICE;
import static com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils.Maincontex;
import static com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils.likedbio;
import static com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils.sharepref;
import static com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils.yolo;

public class recyclemodel extends BaseAdapter {

    ArrayList<String> classicbio;
    recyclemodel adapter;
    public recyclemodel(ArrayList<String> classicbio) {
        this.classicbio = classicbio;

    }

    @Override
    public int getCount() {
        return classicbio.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView ==  null) {
            convertView = LayoutInflater.from(Maincontex).inflate(R.layout.recycle_layout, parent, false);
        }
        TextView textView;
        textView = convertView.findViewById(R.id.biotext);

        ImageView heart = convertView.findViewById(R.id.heart);
        ImageView copy = convertView.findViewById(R.id.copy);
        ImageView eye = convertView.findViewById(R.id.eye);
        ImageView share = convertView.findViewById(R.id.share);
        ImageView edit = convertView.findViewById(R.id.edit);
        textView.setText(classicbio.get(position));

        final String bio = textView.getText().toString();

        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(likedbio.size()==0){
                    likedbio.add(bio);
                    sharepref(Maincontex);
                    yolo(Maincontex);
                    Toast.makeText(Maincontex, "Liked !", Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean ans = likedbio.contains(bio);

                    Log.e("sapata","--ans--"+ans);

                    if (ans)
                        Toast.makeText(Maincontex, "ALready Liked !", Toast.LENGTH_SHORT).show();
                    else{
                        likedbio.add(bio);
                        sharepref(Maincontex);
                        yolo(Maincontex);
                        Toast.makeText(Maincontex, "Liked !", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("sapata","copy");

                ClipboardManager clipboard = (ClipboardManager) Maincontex.getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("", bio);
                clipboard.setPrimaryClip(clip);

                Toast.makeText(Maincontex, "Hashtag Copied", Toast.LENGTH_SHORT).show();
            }
        });

        eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Maincontex, EyeActivity.class);
                Log.e("sapata","eye");
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                Maincontex.startActivity(i);
                utils.biotext = bio;
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("sapata","share");

                String shareBody = bio + "\n\n ✨🔥 Killer Hashtag ✨🔥" +"\nThis Hashtag is from\n" + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID;
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                sharingIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Maincontex.startActivity(sharingIntent);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("sapata","edit");
                utils.biotext = bio;
                Intent j = new Intent(Maincontex, BioActivity.class);
                j.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Maincontex.startActivity(j);
                utils.editflag = 1;
            }
        });
        return convertView;
    }
}
