package edu.iu.mbarrant.midtermproject


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {

    //Liv edata objects to trigger nav
    private val _navigateToGame = MutableLiveData<Boolean>()
    val navigateToGame: LiveData<Boolean>
        get() = _navigateToGame

    private val _navigateToHighScores = MutableLiveData<Boolean>()
    val navigateToHighScores: LiveData<Boolean>
        get() = _navigateToHighScores

    // Method to trigger navigation to the game screen.
    fun onPlayGameClick() {
        Log.d("TEST","CLICKED")
        _navigateToGame.value = true
    }

    fun onViewHighScoresClick() {
        // Execute the navigation action to the high scores screen
        _navigateToHighScores.value = true
    }

    fun onNavigationComplete() {
        _navigateToGame.value = false
        _navigateToHighScores.value = false
    }

}