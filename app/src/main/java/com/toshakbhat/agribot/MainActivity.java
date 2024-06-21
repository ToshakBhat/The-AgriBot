package com.toshakbhat.agribot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    void blog(TextView textView, String description, String url, int img){
        SpannableString spannableString = new SpannableString(description);

        // Load your thumbnail drawable
        Drawable thumbnail = ContextCompat.getDrawable(this, img);
        if (thumbnail != null) {
            int parentWidth = getResources().getDisplayMetrics().widthPixels;
            int parentHeight = getResources().getDisplayMetrics().heightPixels;
            thumbnail.setBounds(0, 0, 1050, 550);

            // Create an ImageSpan to display the thumbnail
            ImageSpan imageSpan = new ImageSpan(thumbnail);

            // Set the ImageSpan to the appropriate position in the SpannableString
            spannableString.setSpan(imageSpan, spannableString.length() - 1, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }

        // Create a ClickableSpan to handle the click on the hyperlink
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                // Handle the click action (open a URL, start an activity, etc.)
                openUrl(url);
                //openUrl("https://www.businessideashindi.com/government-subsidy-small-business-india-hindi-%E0%A4%B8%E0%A4%B0%E0%A4%95%E0%A4%BE%E0%A4%B0-%E0%A4%B8%E0%A4%AC%E0%A5%8D%E0%A4%B8%E0%A4%BF%E0%A4%A1%E0%A5%80/");
            }
        };

        // Set the ClickableSpan to the hyperlink text in the SpannableString
        spannableString.setSpan(clickableSpan, 0, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        // Set the SpannableString to the TextView
        textView.setText(spannableString);

        // Make the TextView clickable and handle link clicks
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void openUrl(String url) {
        // Open the URL using an Intent
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        Button b1;
        b1 = findViewById(R.id.Experts);
        boolean l = true;
        if(l == true){
            b1.setVisibility(View.VISIBLE);
        }
        */
        Button b1 = (Button) findViewById(R.id.kisan);
        //Button b2 = (Button) findViewById(R.id.Sarthi);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CaptureImageActivity.class);
                startActivity(intent);
            }
        });
        Button b2 = (Button) findViewById(R.id.kisan1);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ExpertActivity.class);
                startActivity(intent);
            }
        });
        Button b3 = (Button)findViewById(R.id.crop_info);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, duniya.class);
                startActivity(intent);
            }
        });
        Button b4 = findViewById(R.id.kisan3);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FarmerGPT.class);
                startActivity(intent);
            }
        });

/*
        TextView textView = findViewById(R.id.blog1);
        blog(textView,"15 Government Subsidies to know before this season.","https://www.businessideashindi.com/government-subsidy-small-business-india-hindi-%E0%A4%B8%E0%A4%B0%E0%A4%95%E0%A4%BE%E0%A4%B0-%E0%A4%B8%E0%A4%AC%E0%A5%8D%E0%A4%B8%E0%A4%BF%E0%A4%A1%E0%A5%80/",R.drawable.blog1);
        TextView textView2 = findViewById(R.id.blog2);
        blog(textView2,"Natural Farming - Janiye iske faide !","https://navbharattimes.indiatimes.com/business/business-news/know-what-is-natural-farming-by-which-farmers-are-earning-more-and-providing-health-fruits-and-vegetables/articleshow/90293346.cms",R.drawable.organic);
        TextView textView3 = findViewById(R.id.blog3);
        blog(textView3,"गेहूं के 60 प्रतिशत रकबे में जलवायु-प्रतिरोधी किस्मों की खेती का लक्ष्यः श्री तोमर","https://navbharattimes.indiatimes.com/business/business-news/know-what-is-natural-farming-by-which-farmers-are-earning-more-and-providing-health-fruits-and-vegetables/articleshow/90293346.cms",R.drawable.blog3);
        //TextView textView4 = findViewById(R.id.blog4);
        //TextView textView5 = findViewById(R.id.blog5);

*/

        // Create a SpannableString with the text and thumbnail


    }
}