package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() , View.OnClickListener {
    lateinit var board: Array<Array<Button>>                            //contains all id
    var Player = true                                                 //player1
    var count = 0                                                    //total steps
    var boardstatus = Array(3){IntArray(3)}                //kon jeet raha , depending ki o,1 kiska jeet hua
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
                boardstatus[i][j]=-1
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
    }

    private fun updateValue(row: Int, coloumn: Int, Pl: Boolean) {
        val text:String = if(Pl) "X" else "0"
        val value:Int =  if(Pl) 1 else 0

        board[row][coloumn].isEnabled = false
        board[row][coloumn].text = text
        boardstatus[row][coloumn]=value
    }
}