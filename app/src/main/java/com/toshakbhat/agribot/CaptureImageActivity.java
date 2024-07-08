package com.toshakbhat.agribot;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CaptureImageActivity extends AppCompatActivity {
    private ImageView imgView;

    private ImageView imgView2;
    private Bitmap image;
    private static final int SELECT_IMAGE_REQUEST = 1;
    private Button btnChange;
    private Button send_to_expert;
    private Uri imageUri;
    private ActivityResultLauncher<Uri> contract = registerForActivityResult(
            new ActivityResultContracts.TakePicture(),
            new ActivityResultCallback<Boolean>() {
                @Override
                public void onActivityResult(Boolean result) {
                    if (result) {
                        imgView.setImageURI(null);
                        imgView.setImageURI(imageUri);
                    }
                }
            }
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture_image);

        //Intent i = getIntent();
        //int userName = i.getIntExtra("name",0);
        //String val = getIntent().getStringExtra('Image');
        ProgressBar progress = findViewById(R.id.progressBarAI);
        progress.setVisibility(View.GONE);
        imgView2 = findViewById(R.id.source);
        imgView2.setImageResource(R.drawable.agribot_logo);
        imgView = findViewById(R.id.imageView);
        btnChange = findViewById(R.id.captureButton);
        send_to_expert = findViewById(R.id.send_to_expert);
        GeminiPro model = new GeminiPro();
        //imageUri = createImageUri();

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //takePicture();
                //imgView.setImageURI(imageUri);
                Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,SELECT_IMAGE_REQUEST);

            }
        });
        send_to_expert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress.setVisibility(View.VISIBLE);
                model.getResponse("Find the possible disease of plant in the image and give the description as well as treatments in short. If there is no plant,show null.",image,new ResponseCallback(){

                    @Override
                    public void onResponse(String response) {
                        Intent intent = new Intent(CaptureImageActivity.this,SuccessActivity.class);
                        intent.putExtra("response",response);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        Toast.makeText(CaptureImageActivity.this,"Error accessing Gemini",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SELECT_IMAGE_REQUEST && resultCode == RESULT_OK && data != null){
            Uri imageUri = data.getData();
            try{
                Bitmap originalImage = MediaStore.Images.Media.getBitmap(this.getContentResolver(),imageUri);

                int OriginalWidth = originalImage.getWidth();
                int OriginalHeight = originalImage.getHeight();

                int targetWidth = (int) (OriginalWidth * 0.5);
                int targetHeight = (int) (OriginalHeight * 0.5);

                image = Bitmap.createScaledBitmap(originalImage,targetWidth,targetHeight,false);
                imgView.setImageBitmap(originalImage);
                send_to_expert.setVisibility(View.VISIBLE);

            } catch (Exception e) {
                e.printStackTrace();

            }
        }
/*
    private void takePicture() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        contract.launch(imageUri);
    }

    private Uri createImageUri() {
        File imageFile = new File(getApplicationContext().getFilesDir(), "camera_photo.png");
        return FileProvider.getUriForFile(
                getApplicationContext(),
                "com.example.kisansarthi.fileprovider",
                imageFile
        );
    }

 */
}}
