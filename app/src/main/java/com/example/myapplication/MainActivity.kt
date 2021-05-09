package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() , View.OnClickListener {
    lateinit var board: Array<Array<Button>>
    //contains all id
    var Player = true                                                 //player1
    var count = 0                                                    //total steps
    var boardstatus = Array(3){IntArray(3)}                //kon jeet raha , depending ki o,1 kiska jeet hua
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      //  val txtView = findViewById<TextView>(R.id.status)
        val button1 = findViewById<Button>(R.id.Button1)
        val button2 = findViewById<Button>(R.id.Button2)
        val button3 = findViewById<Button>(R.id.Button3)
        val button4 = findViewById<Button>(R.id.Button4)
        val button5 = findViewById<Button>(R.id.Button5)
        val button6 = findViewById<Button>(R.id.Button6)
        val button7 = findViewById<Button>(R.id.Button7)
        val button8 = findViewById<Button>(R.id.Button8)
        val button9 = findViewById<Button>(R.id.Button9)
        val reset = findViewById<Button>(R.id.reset)
        board = arrayOf(                                //stores id
            arrayOf(button1,button2,button3),
            arrayOf(button4,button5,button6),
            arrayOf(button7,button8,button9)
        )

        for (i:Array<Button> in  board){                    //traversing all the id of the buttons
            for(button:Button in i){
                button.setOnClickListener(this)
            }
        }
        initializeboardStatus()
        reset.setOnClickListener{

        }
    }

    private fun initializeboardStatus() {
        for(i in 0..2){
            for(j in 0..2){
                boardstatus[i][j]=-1                  //i , j = 0, 0 rakha
                board[i][j].isEnabled=true
                board[i][j].text = ""
            }
        }
    }

    override fun onClick(view: View) {
        when(view.id){     //when is like switch statement
            R.id.Button1 ->{
                    updateValue(row=0,coloumn=0,Pl=Player)
            }
            R.id.Button2 ->{
                updateValue(row=0,coloumn=1,Pl=Player)
            }
            R.id.Button3 ->{
                updateValue(row=0,coloumn=2,Pl=Player)
            }
            R.id.Button4 ->{
                updateValue(row=1,coloumn=0,Pl=Player)
            }
            R.id.Button5 ->{
                updateValue(row=1,coloumn=1,Pl=Player)
            }
            R.id.Button6 ->{
                updateValue(row=1,coloumn=2,Pl=Player)
            }
            R.id.Button7 ->{
                updateValue(row=2,coloumn=0,Pl=Player)
            }
            R.id.Button8 ->{
                updateValue(row=2,coloumn=1,Pl=Player)
            }
            R.id.Button9 ->{
                updateValue(row=2,coloumn=2,Pl=Player)
            }
        }
        count++;
        Player = !Player
        if(Player){
            upadateDisplay("Player X Turn")
        }
        else{
            upadateDisplay("Player 0 Turn")
        }
        if(count==9){
            upadateDisplay("Game Draw")
        }

        checkWinner()
    }

    private fun checkWinner() {
        for (i in 0..2) {
            if (boardstatus[i][0] == boardstatus[i][1] && boardstatus[i][0] == boardstatus[i][2]) {
                if (boardstatus[i][0] == 1) {
                    upadateDisplay("Player x is winner")
                    break
                } else if (boardstatus[i][0] == 0) {
                    upadateDisplay("Player 0 is winner")
                    break
                }
            }
        }

                ////

        for (i in 0..2) {
            if (boardstatus[0][i] == boardstatus[1][i] && boardstatus[1][i] == boardstatus[2][i]) {
                if (boardstatus[0][i] == 1) {
                    upadateDisplay("Player x is winner")
                    break
                } else if (boardstatus[0][i] == 0) {
                    upadateDisplay("Player 0 is winner")
                    break
                }
            }
        }

        for (i in 0..2) {
            if (boardstatus[1][1] == boardstatus[2][2] && boardstatus[0][0] == boardstatus[2][2]) {
                if (boardstatus[0][0] == 1) {
                    upadateDisplay("Player x is winner")
                    break
                } else if (boardstatus[0][0] == 0) {
                    upadateDisplay("Player 0 is winner")
                    break
                }
            }
        }
        for (i in 0..2) {
            if (boardstatus[0][2] == boardstatus[2][0] && boardstatus[2][0] == boardstatus[1][1]) {
                if (boardstatus[1][1] == 1) {
                    upadateDisplay("Player x is winner")
                    break
                } else if (boardstatus[1][1] == 0) {
                    upadateDisplay("Player 0 is winner")
                    break
                }
            }
        }
    }

    private fun upadateDisplay(s: String) {
        val txtsview=findViewById<TextView>(R.id.status)
        txtsview.setText(s)

        if(s.contains("winner")){
            disableButton()
        }

    }

    private fun disableButton() {
        for (i:Array<Button> in  board){                    //traversing all the id of the buttons
            for(button:Button in i){
                button.isEnabled = false
            }
        }
    }


    private fun updateValue(row: Int, coloumn: Int, Pl: Boolean) {
        val text:String = if(Pl) "X" else "0"
        val value:Int =  if(Pl) 1 else 0

        board[row][coloumn].isEnabled = false
        board[row][coloumn].text = text
        boardstatus[row][coloumn]=value
    }
}