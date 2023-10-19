package edu.iu.mbarrant.midtermproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import edu.iu.mbarrant.midtermproject.databinding.GameScreenBinding
import androidx.navigation.NavController
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController

class GameFragment : Fragment() {

    private lateinit var binding: GameScreenBinding
    private lateinit var viewModel: GameViewModel
    private lateinit var navController: NavController
    private lateinit var attemptsTextView: TextView
    private lateinit var plusButton: ImageButton
    private lateinit var minusButton: ImageButton
    private lateinit var scoreDao: ScoreDao


    private var totalGuesses = 0
    private var playerName = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = GameScreenBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        // Initialize scoreDao here, e.g., using Room database
        //scoreDao = ScoreDatabase.getInstance(requireContext()).playerScoreDao()

        // Create the ViewModel using the factory
//        val viewModelFactory = GameViewModelFactory(scoreDao)
//        viewModel = ViewModelProvider(this, viewModelFactory).get(GameViewModel::class.java)

        //textview
        attemptsTextView = binding.totalGuessesTV

        // Set the ViewModel to the binding variable
        binding.gameViewModel = viewModel

        //image buttons
        plusButton = binding.plusButton
        minusButton = binding.minusButton

        // Set the lifecycle owner for data binding to observe LiveData
        binding.lifecycleOwner = viewLifecycleOwner

        //Edit text listner for the player name
        binding.nameEditText.addTextChangedListener { text ->
            viewModel.setUserName(text.toString())
            playerName = text.toString()

        }
        // for toast
        val toastLow = "Guess to Low"
        val toastHigh = "Guess to High"
        val noGuess = "Enter a guess"

        val duration = Toast.LENGTH_SHORT // or Toast.LENGTH_LONG for a longer duration

        val toast1 = Toast.makeText(context, toastLow, duration) //creating toast
        val toast2 = Toast.makeText(context, toastHigh, duration)
        val toast3 = Toast.makeText(context, noGuess, duration)

        //toast1.show()

        // Generate a random number between 1 and 100
        val randomNumber = (1..100).random()
        // Log the generated number
        Log.d("Number generated", randomNumber.toString())

        //image button listeners
        plusButton.setOnClickListener {
            incrementGuess()
        }
        minusButton.setOnClickListener {
            decrementGuess()
        }


        // Set a click listener for the "OK" button
        binding.okButton.setOnClickListener {
            Log.d("Ok clicked","OK button clicked")
            // Get the user's input guess from the EditText
            val userGuessText = binding.guessEditText.text.toString()

            // Check if the user's guess is correct
            if (userGuessText.isEmpty()) {
                toast3.show()
            } else {
                viewModel.onOKClick()

                totalGuesses++
                val user = User(name = playerName, score = totalGuesses) // Define 'user' here

                attemptsTextView.text = "Number of Attempts: $totalGuesses"
                val userGuess = userGuessText.toInt()
                if (userGuess == randomNumber) {

                    viewModel.saveUserScore(playerName, totalGuesses)

                    findNavController().navigate(R.id.action_gameFragment_to_mainScreen)//return to main menu
                }
                else if(userGuess > randomNumber){
                    toast2.show()
                }
                else if(userGuess < randomNumber){
                    toast1.show()
                }
            }
        }//end of ok button lisnter
        return binding.root
    }

    // Define the increment and decrement methods
    private fun incrementGuess() {
        val currentGuess = binding.guessEditText.text.toString().toIntOrNull() ?: 0
        val newGuess = currentGuess + 1
        binding.guessEditText.setText(newGuess.toString())
    }

    private fun decrementGuess() {
        val currentGuess = binding.guessEditText.text.toString().toIntOrNull() ?: 0
        val newGuess = currentGuess - 1
        if (newGuess >= 0) {
            binding.guessEditText.setText(newGuess.toString())
        }
    }
}