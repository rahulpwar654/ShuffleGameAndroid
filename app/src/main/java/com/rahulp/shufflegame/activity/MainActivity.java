package com.rahulp.shufflegame.activity;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.rahulp.shufflegame.R;

import java.util.Arrays;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    TextView tvTitle;
    GridView gridView;
    Button restart;

    Button next;

    String[] numbers={"1","2","3","4","5","6","7","8","--"};
    String[] actual={"1","2","3","4","5","6","7","8","--"};

    int blankpos=8,movecount=0;

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle=(TextView)findViewById(R.id.tvTitle);
        gridView=(GridView)findViewById(R.id.gridView);
        restart=(Button)findViewById(R.id.restart);
        next=(Button)findViewById(R.id.btn_next);


        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                movecount=0;
                shuffleArray(numbers);
                adapter.notifyDataSetChanged();
                tvTitle.setText("Move Count=="+movecount);

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ImagePickerActivity.class));

            }
        });

        shuffleArray(numbers);

       adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,numbers);
       gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(blankpos)
                {
                    case 0:
                            if(position==1||position==3)
                            {
                                updateData(0,position);
                            }
                            else
                            {
                                makeTo("Wrong Move");
                            }
                    break;
                    case 1:
                            if(position==0||position==4||position==2)
                            {
                                updateData(1,position);
                            }
                            else
                            {
                                makeTo("Wrong Move");
                            }
                    break;
                    case 2:
                            if(position==1||position==5)
                            {
                                    updateData(2,position);
                            }
                            else
                            {
                                    makeTo("Wrong Move");
                            }

                    break;
                    case 3:
                            if(position==0||position==4||position==6)
                            {
                                updateData(3,position);
                            }
                            else
                            {
                                makeTo("Wrong Move");
                            }

                    break;
                    case 4:
                            if(position==1||position==3||position==5||position==7)
                            {
                                   updateData(4,position);
                            }
                            else
                            {
                                makeTo("Wrong Move");
                            }
                    break;
                    case 5:
                            if(position==2||position==4||position==8)
                            {
                                updateData(5,position);
                            }
                            else
                            {
                                makeTo("Wrong Move");
                            }
                    break;
                    case 6:
                            if(position==3||position==7)
                            {
                                updateData(6,position);
                            }
                            else
                            {
                                makeTo("Wrong Move");
                            }
                    break;
                    case 7:
                            if(position==4||position==6||position==8)
                            {
                                updateData(7,position);
                            }
                            else
                            {
                                makeTo("Wrong Move");
                            }
                    break;
                    case 8:
                            if(position==5||position==7)
                            {
                                updateData(8,position);
                            }
                            else
                            {
                                makeTo("Wrong Move");
                            }
                    break;
                    default:
                        break;

                }


            }
        });

    }


public void updateData(int caseNo,int pos)
        {
            String temp=numbers[pos];
            numbers[pos]=numbers[caseNo];
            numbers[caseNo]=temp;


            blankpos=pos;


            tvTitle.setText("Move Count=="+(++movecount));

            adapter.notifyDataSetChanged();

            if(Arrays.equals(actual,numbers))
            {
                makeTo("----You Won----  \n Now you can go HOme");

            }

        }
    void shuffleArray(String[] numbers)
    {
        Random rnd = new Random();
        for (int i = numbers.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // swap
            String a = numbers[index];
            numbers[index] = numbers[i];
            numbers[i] = a;
        }

        for (int i=numbers.length-1;i>0;i--)
        {
            if (numbers[i].equals("--"))
                blankpos=i;
        }
    }





    public  void makeTo(String text)
    {
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();

    }
	
	
	
	 /**

     * Splits the source image and show them all into a grid in a new activity

     * @param image The source image to split

     * @param smallimage_Numbers The target number of small image smallimage_s to be formed from the source image

     */

	  /**
            private void splitImage(ImageView image, int smallimage_Numbers) {      

                       

                        //For the number of rows and columns of the grid to be displayed

                        int rows,cols;

                       

                            //For height and width of the small image smallimage_s

                        int smallimage_Height,smallimage_Width;

                       

                        //To store all the small image smallimage_s in bitmap format in this list

                        ArrayList<Bitmap> smallimages = new ArrayList<Bitmap>(smallimage_Numbers);

                       

                        //Getting the scaled bitmap of the source image

                        BitmapDrawable mydrawable = (BitmapDrawable) image.getDrawable();

                        Bitmap bitmap = mydrawable.getBitmap();

                        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), true);

                       

                        rows = cols = (int) Math.sqrt(smallimage_Numbers);

                        smallimage_Height = bitmap.getHeight()/rows;

                        smallimage_Width = bitmap.getWidth()/cols;

                       

                        //xCo and yCo are the pixel positions of the image smallimage_s

                        int yCo = 0;

                        for(int x=0; x<rows; x++){

                                    int xCo = 0;

                                    for(int y=0; y<cols; y++){

                                                smallimages.add(Bitmap.createBitmap(scaledBitmap, xCo, yCo, smallimage_Width, smallimage_Height));

                                                xCo += smallimage_Width;

                                    }

                                    yCo+= smallimage_Height;

                        }

                       

                        //Start a new activity to show these smallimage_s into a grid

                        Intent intent = new Intent(VincentImageActivity.this, SmallImageActivity.class);

                        intent.putParcelableArrayListExtra("small images", smallimages);

                        startActivity(intent);

            }

}

 */
}
