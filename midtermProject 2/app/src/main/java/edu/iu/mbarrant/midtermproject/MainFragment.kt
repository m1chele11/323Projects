package edu.iu.mbarrant.midtermproject

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import edu.iu.mbarrant.midtermproject.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("TEST","START")
        // Inflate the layout using data binding
        binding = MainFragmentBinding.inflate(inflater, container, false)

        // Initialize the ViewModel using the ViewModelProvider
        viewModel = ViewModelProvider(this, MainViewModelFactory()).get(MainViewModel::class.java)

        // Set the ViewModel to the binding variable
        binding.viewModel = viewModel

        // Set the lifecycle owner for data binding to observe LiveData
        binding.lifecycleOwner = viewLifecycleOwner

        // Observe LiveData for navigation
        binding.PlayGameButton.setOnClickListener{
            Log.d("TEST","CLICKED")
            viewModel.onPlayGameClick()
        }

        // Observe LiveData for navigation
        binding.ViewScoresButton.setOnClickListener{
            Log.d("TEST","CLICKED")
            viewModel.onViewHighScoresClick()
        }

        viewModel.navigateToGame.observe(viewLifecycleOwner) { navigateToGame ->
            Log.d("Button play ", "play game clicked")
            if (navigateToGame) {
                // Navigate to the game screen
                findNavController().navigate(R.id.action_mainScreen_to_gameFragment)
                viewModel.onNavigationComplete()
            }
        }

        viewModel.navigateToHighScores.observe(viewLifecycleOwner) { navigateToHighScores ->
            if (navigateToHighScores) {
                // Navigate to the high scores screen
                findNavController().navigate(R.id.action_mainScreen_to_highScoresFragment)
                viewModel.onNavigationComplete()
            }
        }

        // Return the root view of the binding
        return binding.root
    }
}