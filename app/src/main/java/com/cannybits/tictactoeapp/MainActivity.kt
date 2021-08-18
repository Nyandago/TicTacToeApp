package com.cannybits.tictactoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.*
import kotlinx.android.synthetic.main.activity_main.*

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

        playGame(cellId, btClicked)
 }
    var activePlayer = 1

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

   private fun playGame(cellId: Int, btClicked: Button){

    if(activePlayer == 1)
    {
        btClicked.text = "X"
        btClicked.setBackgroundResource(R.color.red)
        player1.add(cellId)
        activePlayer = 2
        autoPlay()
    }
    else
    {
        btClicked.text = "O"
        btClicked.setBackgroundResource(R.color.green)
        player2.add(cellId)
        activePlayer = 1
    }
       btClicked.isEnabled = false

       checkWinner()
   }
    private fun checkWinner(){
        var winner:Int = -1

       //row 1
        if(player1.contains(1) && player1.contains(2)&& player1.contains(3)){
        winner = 1
        }
        if(player2.contains(1) && player2.contains(2)&& player2.contains(3)){
            winner = 2
        }

        //row 2
        if(player1.contains(4) && player1.contains(5)&& player1.contains(6)){
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5)&& player2.contains(6)){
            winner = 2
        }

        //row 3
        if(player1.contains(7) && player1.contains(8)&& player1.contains(9)){
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8)&& player2.contains(9)){
            winner = 2
        }

        //column 1
        if(player1.contains(1) && player1.contains(4)&& player1.contains(7)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(4)&& player2.contains(7)){
            winner = 2
        }

        //column 2
        if(player1.contains(2) && player1.contains(5)&& player1.contains(8)){
            winner = 1
        }
        if(player2.contains(2) && player2.contains(5)&& player2.contains(8)){
            winner = 2
        }

        //column3
        if(player1.contains(3) && player1.contains(6)&& player1.contains(9)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(6)&& player2.contains(9)){
            winner = 2
        }

        if(winner == 1){
            Toast.makeText(this, "Canny Won the Game!!",Toast.LENGTH_LONG).show()
        } else if(winner==2){
            Toast.makeText(this, "Hadija Won the Game!!",Toast.LENGTH_LONG).show()
        }
    }

    fun autoPlay(){
        var emptyCells = ArrayList<Int>()

        for(cellId in 1..9)
        {
           if(!player1.contains(cellId)||!player2.contains(cellId)){
               emptyCells.add(cellId)
           }
        }

        val r = Random()
        val randIndex = r.nextInt(emptyCells.size)
        val cellId = emptyCells[randIndex]

        var btClicked: Button?
        btClicked = when(cellId){
            1-> bt1
            2-> bt2
            3-> bt3
            4-> bt4
            5-> bt5
            6-> bt6
            7-> bt7
            8-> bt8
            9-> bt9
            else -> { bt1  }
        }

        playGame( cellId, btClicked)
    }

}