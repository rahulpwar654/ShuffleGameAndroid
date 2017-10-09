package com.rahulp.shufflegame.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.rahulp.shufflegame.CustomImageView;
import com.rahulp.shufflegame.R;
import com.rahulp.shufflegame.util.ScalingUtilities;

public class ImagePickerActivity extends AppCompatActivity {
    private Button next;
    private CustomImageView imgmain;
    public static Bitmap mainImageBitmap;
    public static final int PICK_IMAGE = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_picker);
         next    = (Button) findViewById(R.id.next);
         imgmain = (CustomImageView) findViewById(R.id.img_main);


        imgmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pickImage();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               startActivity(new Intent(ImagePickerActivity.this,ShuffleImageActivity.class));
            }
        });



    }

    public void pickImage() {
        Intent intent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        intent.setType("image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("scale", true);
        intent.putExtra("outputX", 256);
        intent.putExtra("outputY", 256);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 1);
    }




    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == PICK_IMAGE) {
            //TODO: action

            final Bundle extras = data.getExtras();
            if (extras != null) {
                try {
                    mainImageBitmap=null;
                    //Get image
                    Bitmap pickedImage = extras.getParcelable("data");

                    mainImageBitmap =ScalingUtilities.createScaledBitmap(pickedImage,imgmain.getEdgeSize(),imgmain.getEdgeSize(), ScalingUtilities.ScalingLogic.FIT);
                    //mainImageBitmap=Bitmap.createBitmap(mainImageBitmap,0,0,imgmain.getEdgeSize(),imgmain.getEdgeSize());
                    imgmain.setImageBitmap(mainImageBitmap);

                    imgmain.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    },2000);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }




    /**
     * function findingNeighbors(myArray, i, j) {
     var rowLimit = myArray.length-1;
     var columnLimit = myArray[0].length-1;

     for(var x = Math.max(0, i-1); x <= Math.min(i+1, rowLimit); x++) {
     for(var y = Math.max(0, j-1); y <= Math.min(j+1, columnLimit); y++) {
     if(x !== i || y !== j) {
     console.log(myArray[x][y]);
     }
     }
     }
     }
     */
}
