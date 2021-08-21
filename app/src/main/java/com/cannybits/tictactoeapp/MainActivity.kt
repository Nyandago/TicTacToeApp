package com.cannybits.tictactoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Timer
import kotlin.concurrent.schedule


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }



  fun btClick(view: View){
try {
    val btClicked = view as Button
    var cellId = 0
    when (btClicked.id) {
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
} catch(ex: Exception){
    Handler(Looper.getMainLooper()).post {
        Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
    }
}

 }
    var activePlayer = 1

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

     fun playGame(cellId: Int, btClicked: Button){
 try {

     if (activePlayer == 1) {
         btClicked.text = "X"
         btClicked.setBackgroundResource(R.color.red)
         player1.add(cellId)
         activePlayer = 2
        // Timer().schedule(1000) {

             autoPlay()
       //  }
     } else {
         btClicked.text = "O"
         btClicked.setBackgroundResource(R.color.green)
         player2.add(cellId)
         activePlayer = 1
     }
     btClicked.isEnabled = false

     checkWinner()
 } catch(ex: Exception){
     Handler(Looper.getMainLooper()).post {
         Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
     }
 }
   }
    fun checkWinner(){
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
            player1wins += 1
            Toast.makeText(this, "Player 1 Won the Game!!",Toast.LENGTH_LONG).show()
          //  delay(2000)
          //  Timer().schedule(2000) {
                restartGame()
           //}
        } else if(winner==2){
            player2wins += 1
            Toast.makeText(this, "Player 2 Won the Game!!",Toast.LENGTH_LONG).show()
        //   delay(2000)
        //  Timer().schedule(2000) {
                restartGame()
         //   }
        }
    }

   fun autoPlay(){
       try{
        var emptyCells = ArrayList<Int>()

        for(cellId in 1..9)
        {
           if(!player1.contains(cellId)||!player2.contains(cellId)){
               emptyCells.add(cellId)
           }
        }

        if(emptyCells.size == 0) {
            restartGame()
        }

        val r = Random()
        val randIndex = r.nextInt(emptyCells.size)
        val cellId = emptyCells[randIndex]

    var btClicked: Button?
    btClicked = when (cellId) {
        1 -> bt1
        2 -> bt2
        3 -> bt3
        4 -> bt4
        5 -> bt5
        6 -> bt6
        7 -> bt7
        8 -> bt8
        9 -> bt9
        else -> {
            bt1
        }
    }
    //    delay(2000)
    playGame(cellId, btClicked)
} catch(ex: Exception){
    Handler(Looper.getMainLooper()).post {
        Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
    }
}
    }

    var player1wins = 0
    var player2wins = 0

    fun restartGame(){
        try{

Thread(Runnable {
            activePlayer = 1
            player1.clear()
            player2.clear()
            for (cellId in 1..9) {
                val btClicked: Button? = when (cellId) {
                    1 -> bt1
                    2 -> bt2
                    3 -> bt3
                    4 -> bt4
                    5 -> bt5
                    6 -> bt6
                    7 -> bt7
                    8 -> bt8
                    9 -> bt9
                    else -> {
                        bt1
                    }
                }
                this@MainActivity.runOnUiThread(java.lang.Runnable {
                    btClicked!!.text = ""
                    btClicked!!.setBackgroundResource(R.color.white)
                    btClicked!!.isEnabled = true
                })


            }

         })

        } catch(ex: Exception) {
            Handler(Looper.getMainLooper()).post {
                Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
           }
        }
    }

}