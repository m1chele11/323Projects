package edu.iu.mbarrant.midtermproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider



class GameViewModelFactory() : ViewModelProvider.Factory {
    //private val dao: ScoreDao
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameViewModel::class.java)) {
            //return GameViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}