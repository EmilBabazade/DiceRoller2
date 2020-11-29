package emil.babazade.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var rollButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var countUpButton: Button
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.result_text)
        rollButton = findViewById(R.id.roll_button)
        countUpButton = findViewById(R.id.count_up_button)
        resetButton = findViewById(R.id.reset_button)

        rollButton.setOnClickListener(::handleRollClick)
        countUpButton.setOnClickListener(::handleCountUpClick)
        resetButton.setOnClickListener(::handleResetClick)
    }

    private fun handleRollClick(view: View) {
        val randomInt = (1..6).random()
        resultTextView.text = randomInt.toString()
    }

    private fun handleCountUpClick(view: View) {
        var lastRoll = try {
            resultTextView.text.toString().toInt()
        } catch (e: NumberFormatException) {
            0
        }

        lastRoll = if(lastRoll == 6) lastRoll else lastRoll + 1

        resultTextView.text = lastRoll.toString()
    }

    private fun handleResetClick(view: View) {
        try {
            resultTextView.text.toString().toInt()
        } catch (e: java.lang.NumberFormatException) {
            return
        }
        resultTextView.text = "0"
    }
}