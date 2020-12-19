package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rollDice()
        var rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()


        }
    }

    private fun rollDice() {
        var dice1 = Dice(6)
        var diceRoll = dice1.roll()
        var diceImage:ImageView = findViewById(R.id.imageView)
        var drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.ic_launcher_foreground
        }
        diceImage.setImageResource(drawableResource)
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}