package com.rahulp.shufflegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
}
