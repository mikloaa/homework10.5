package kz.jusan.homework10

import android.app.ActivityManager.TaskDescription
import android.graphics.Color
import android.graphics.Color.BLACK
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlin.math.PI

const val  CORRECT_PIN = "1567"
const val PIN_LENGTH = 4
class MainActivity : AppCompatActivity() {
    private var pinText  = ""
    lateinit var tvPin: TextView

    var errorColor: Int = Color.BLACK
    var pinTextColor: Int = Color.BLACK
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initTvPin()
        initNumButtons()
        initDeleteButton()
        initOkButton()
        initColors()
    }
    private fun initTvPin(){
        tvPin = findViewById(R.id.tv_pin)
    }

    private fun initDeleteButton(){
        val btnDelete:Button = findViewById(R.id.btn_delete)
        btnDelete.setOnClickListener{
            pinText = pinText.dropLast(1)
            updatePinTextView()
        }

    }

    private fun initColors(){
        errorColor= ContextCompat.getColor(this, R.color.error_color)
        pinTextColor =  ContextCompat.getColor(this, R.color.color_primary)
    }

    private fun initOkButton(){
        val btnOk: Button = findViewById(R.id.btn_OK)
        btnOk.setOnClickListener{checkIfPinIsCorrect() }
    }
    private fun checkIfPinIsCorrect(){
        if (pinText == CORRECT_PIN){
            Toast.makeText(this, R.string.correct, Toast.LENGTH_LONG).show()
        } else {

            tvPin.setTextColor(errorColor)
        }
    }
    private fun initNumButtons(){
        val btnOne: Button = findViewById(R.id.btn_one)
        btnOne.setOnClickListener(this::onNumButtonClick)

        val btnTwo: Button = findViewById(R.id.btn_two)
        btnTwo.setOnClickListener(this::onNumButtonClick)

        val btnThree: Button = findViewById(R.id.btn_three)
        btnThree.setOnClickListener(this::onNumButtonClick)

        val btnFour: Button = findViewById(R.id.btn_four)
        btnFour.setOnClickListener(this::onNumButtonClick)

        val btnFive: Button = findViewById(R.id.btn_five)
        btnFive.setOnClickListener(this::onNumButtonClick)

        val btnSix: Button = findViewById(R.id.btn_six)
        btnSix.setOnClickListener(this::onNumButtonClick)

        val btnSeven: Button = findViewById(R.id.btn_seven)
        btnSeven.setOnClickListener(this::onNumButtonClick)

        val btnEight: Button = findViewById(R.id.btn_eight)
        btnEight.setOnClickListener(this::onNumButtonClick)

        val btnNine: Button = findViewById(R.id.btn_nine)
        btnNine.setOnClickListener(this::onNumButtonClick)

        val btnZero: Button = findViewById(R.id.btn_zero)
        btnZero.setOnClickListener(this::onNumButtonClick)
    }

    private fun onNumButtonClick(view: View) {
        if (view !is Button){
            return
        }

        val  clickedNum = view.text
        pinText += clickedNum

        updatePinTextView()
    }
    private fun updatePinTextView(){
        if (pinText.length> PIN_LENGTH){
            pinText = pinText.substring(0, PIN_LENGTH)
        }
        tvPin.text = pinText
        tvPin.setTextColor(pinTextColor)
    }
}