package com.example.daggerandroidsample

import androidx.lifecycle.ViewModel
import javax.inject.Inject

/**
 * To create a ViewModel class, we also need to provide a lifecycle owner instance.
 * The ViewModel will bind itself to the lifecycle of this instance. To do so, we
 * use the ViewModelProvider class. Which accepts the LifecycleOwner as one of the
 * arguments. And provides a default ViewModel instance.
 *
 * If we need to pass a parameter to the ViewModel constructor, we must create
 * our own ViewModel Factory class, which is passed as a parameter to
 * the ViewModelProvider class. This factory will then be responsible for
 * creating instance of ViewModel class with the required constructor parameters.
 *
 * So with Dagger2, it is not possible, to use constructor injection out-of-the-box
 * with ViewModel class. Because creation of ViewModel depends on ViewModelProvider
 * and ViewModel factory classes.
 *
 * Instead one must user Dagger2 to provide instance of the ViewModelFactory class.
 * Then pass this instance to the ViewModelProvider.
 *
 * Here i have used @Inject for LoginViewModel and LoginViewModelFactory classes.
 * Next, using field injection, i supply instance of LoginViewModelFactory to
 * ViewModelProvider delegate in LoginFragment. This is how i get LoginViewModel instance
 * using Dagger2.
 *
 * I have heard that it is much easier with Hilt to inject ViewModels..
 */
class LoginViewModel @Inject constructor (val userRepository: UserRepository) : ViewModel() {

    /*
    It's a good practice to place ViewModel
    factories in their ViewModel file for
    better context, readability, and easier discovery.
    The same ViewModel factory can be used for multiple
    ViewModels when they share dependencies

    But since i need to use @Inject to LoginViewModelFactory constructor,
    so i have moved this code to a separate class instead.
     */
    /*
    companion object {
        val Factory = object:ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val userLocalDataSource = UserLocalDataSource()
                val userRemoteDataSource = UserRemoteDataSource()
                return LoginViewModel(UserRepository(userLocalDataSource, userRemoteDataSource)) as T
            }
        }
    }
     */

    fun authenticateUser() {
        println("Authenticating User....")
    }
}