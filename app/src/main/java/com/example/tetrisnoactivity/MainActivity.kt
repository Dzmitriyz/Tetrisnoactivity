package com.example.tetrisnoactivity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tetrisnoactivity.storage.AppPreferences
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private var highScore: TextView? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateHighScore()
        init()

    }

    private fun init(){

        supportActionBar?.hide()
        val btnNewGame =findViewById<Button>(R.id.b_new_game)
        val btnResetScore = findViewById<Button>(R.id.b_reset_score)
        val btnExit = findViewById<Button>(R.id.b_exit)
        highScore = findViewById(R.id.scoreTv)
        btnNewGame.setOnClickListener {
            onBtnNewGameClick()
        }
        btnResetScore.setOnClickListener {
            onBtnResetScoreClick(it) }
        btnExit.setOnClickListener {
            onBtnExitClick()
        }
    }



    private fun onBtnNewGameClick(){
        val intent = Intent(MainActivity@this, GameActiviy::class.java)
        startActivity(intent)
        Log.e("MyTest","mylog trololo")
    }
    private fun onBtnResetScoreClick(view: View ){
        val preferences = AppPreferences(this)
        preferences.clearHighScore()
        Snackbar.make(view,"Score successfully rest",Snackbar.LENGTH_SHORT).show()
        highScore?.text = "High score: ${preferences.getHighScore()}"

    }
    private fun onBtnExitClick(){
        System.exit(0)
    }
    @SuppressLint("SetTextI18n")
    fun updateHighScore(){
        val preferences = AppPreferences(this)
        highScore?.text = "High score: ${preferences.getHighScore()} + xxx"
        Log.e("MyTest","yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy")
    }
}