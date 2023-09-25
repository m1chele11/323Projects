package edu.iu.mbarrant.project5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize text views
        val translationTV = findViewById<TextView>(R.id.translatedTextView)
        val userInputTV = findViewById<EditText>(R.id.editText)

        //initialize strings for language value holders
        var selectedLanguage = ""
        var selectedLanguageTo = ""

        //initialize radio groups
        val ogLang = findViewById<RadioGroup>(R.id.ogRadioGroup)
        val langTo = findViewById<RadioGroup>(R.id.transToRadioGroup)


        //radio group for the original Language "ogLang"
        ogLang.setOnCheckedChangeListener { _, checkedId ->
            // Handle language click
            when (checkedId) {
                R.id.ogEnglish -> {
                    // english selected
                    selectedLanguage = "English"
                    Log.d("origin Lang Activity", "Button Clicked: English")
                }
                R.id.ogSpanish -> {
                    // spanish selected
                    selectedLanguage = "Spanish"
                    Log.d("origin Lang Activity", "Button Clicked: Spanish")
                }
                R.id.ogGerman -> {
                    // german selected
                    selectedLanguage = "German"
                    Log.d("origin Lang Activity", "Button Clicked: German")
                }
            }
        }

        //radio group for the language to translate to
        langTo.setOnCheckedChangeListener { _, checkedId ->
            // Handle language button click
            when (checkedId) {
                R.id.startEnglish -> {
                    // english selected
                    selectedLanguageTo = "English"
                    Log.d("Translate to Activity", "Button Clicked: English")
                }
                R.id.startSpanish -> {
                    // spanish selected
                    selectedLanguageTo = "Spanish"
                    Log.d("Translate to Activity", "Button Clicked: Spanish")
                }
                R.id.startGerman -> {
                    // german selected
                    selectedLanguageTo = "German"
                    Log.d("Translate to Activity", "Button Clicked: German")
                }
            }
        }



    }
}