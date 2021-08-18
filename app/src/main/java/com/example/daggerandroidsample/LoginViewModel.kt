package com.example.daggerandroidsample

import androidx.lifecycle.ViewModel

/**
 * To create a ViewModel class, we also need to provide a lifecycle owner instance.
 * The ViewModel will bind itself to the lifecycle of this instance. To do so, we
 * use the ViewModelProvider class. Which accepts the LifecycleOwner as one of the
 * arguments. And prvoides a default ViewModel instance.
 *
 * If we need to pass a parameter to the ViewModel constructor, we must create
 * our own ViewModel Factory class, which is passed as one more parameter to
 * the ViewModelProvider class. This factory will then be responsible for
 * creating instance of ViewModel class with the required constructor parameters.
 *
 * So it is not possible, to use constructor injection out-of-the-box with ViewModel class.
 * Because creation of ViewModel depends on ViewModelProvider and ViewModel factory classes.
 *
 * Hence we have to Dagger Multi-bindings as a workaround for ViewModel injection...
 */
class LoginViewModel (val userRepository: UserRepository) : ViewModel() {

}