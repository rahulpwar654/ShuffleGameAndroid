package com.rahulp.shufflegame.activity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.rahulp.shufflegame.R;

import java.util.ArrayList;

public class ShuffleImageActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    RecyclerView.LayoutManager mLayoutManager ;
    public static ArrayList<Bitmap> albumList;
    ShuffleImageAdapter shuffleImageAdapter;
    public static String ShuffleImage="ShuffleImage";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shuffle_image);

        Log.e(ShuffleImage," in oncreate  ");
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        splitImages(9);

        //recyclerView.setAdapter(adapter);
    }

    private void splitImages(int smallimage_Numbers) {
        if(ImagePickerActivity.mainImageBitmap!=null)
        {
            try {

                Log.e(ShuffleImage," in function  "+smallimage_Numbers);
            //For the number of rows and columns of the grid to be displayed
            int rows,cols;
            //For height and width of the small image smallimage_s
            int smallimage_Height,smallimage_Width;



            //To store all the small image smallimage_s in bitmap format in this list



            //Getting the scaled bitmap of the source image

            //BitmapDrawable mydrawable = (BitmapDrawable) image.getDrawable();
           // Bitmap bitmap = mydrawable.getBitmap();

            //Bitmap scaledBitmap = Bitmap.createScaledBitmap(ImagePickerActivity.mainImageBitmap, ImagePickerActivity.mainImageBitmap, bitmap.getHeight(), true);



            rows = cols = (int) Math.sqrt(smallimage_Numbers);

            smallimage_Height = ImagePickerActivity.mainImageBitmap.getHeight()/rows;

            smallimage_Width = ImagePickerActivity.mainImageBitmap.getWidth()/cols;

                albumList=new ArrayList<>(9);

            //xCo and yCo are the pixel positions of the image smallimage_s

            int yCo = 0;

            for(int x=0; x<rows; x++){

                int xCo = 0;

                for(int y=0; y<cols; y++){

                    albumList.add(Bitmap.createBitmap(ImagePickerActivity.mainImageBitmap, xCo, yCo, smallimage_Width, smallimage_Height));

                    xCo += smallimage_Width;

                }

                yCo+= smallimage_Height;

            }

            albumList.remove((albumList.size()-2));
                Log.e(ShuffleImage," in albumList  "+albumList.size());
            shuffleImageAdapter=new ShuffleImageAdapter(this);
            recyclerView.setAdapter(shuffleImageAdapter);

            }catch (Exception e){e.printStackTrace();}
        }

    }



    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}
