package com.example.daggerandroidsample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

/**
 * To inject ViewModel via Dagger2, one must inject ViewModelFactory instance.
 * This instance is passed to the ViewModelProvider when creating instance of ViewModel.
 */
class LoginViewModelFactory @Inject constructor(private val loginViewModel: LoginViewModel) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return loginViewModel as T
    }
}