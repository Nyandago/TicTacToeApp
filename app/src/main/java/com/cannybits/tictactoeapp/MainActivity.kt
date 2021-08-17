package com.cannybits.tictactoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

 fun btClick(view: View){

     val btClicked = view as Button
     var cellId = 0
     when(btClicked.id){
         R.id.bt1 -> cellId = 1
         R.id.bt2 -> cellId = 2
         R.id.bt3 -> cellId = 3
         R.id.bt4 -> cellId = 4
         R.id.bt5 -> cellId = 5
         R.id.bt6 -> cellId = 6
         R.id.bt7 -> cellId = 7
         R.id.bt8 -> cellId = 8
         R.id.bt9 -> cellId = 9
     }
     Log.d("btClick",btClicked.id.toString())
     Log.d("btClick",cellId.toString())
 }
}