package edu.iu.mbarrant.midtermproject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlin.random.Random

class GameViewModel() : ViewModel() {
    //val dao: ScoreDao

    //Liv edata objects to trigger nav
    private val _navigateToMenu = MutableLiveData<Boolean>()
    val navigateToMenu: LiveData<Boolean>
        get() = _navigateToMenu

    // Method to trigger navigation to the home screen.
    fun onOKClick() {
        Log.d("TEST","CLICKED")
        _navigateToMenu.value = true
    }

    fun onNavigationComplete() {
        _navigateToMenu.value = false
    }

    val userName = MutableLiveData<String>()

    fun setUserName(name: String) {
        userName.value = name
    }

    fun saveUserScore(name: String, score: Int) {
        val user = User(name = name, score = score)
        viewModelScope.launch {
            //dao.insertUser(user)
        }
    }

//    fun addUser(name: String, score: Int) {
//        val user = User(name = name, score = score)
//        viewModelScope.launch {
//            dao.insert(user)
//        }
//    }

}