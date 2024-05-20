package com.example.daggerandroidsample

import com.example.daggerandroidsample.di.ActivityScope
import javax.inject.Inject

/*
A regular class that acts like a viewmodel..because it is not easy
to inject viewmodel dependencies using constructor injection via Dagger2.
Refer comments in LoginViewModel class for more details.
 */

/*
Using custom scope, a unique instance of LoginProxyImpl
is used during the life-time of the LoginComponent.
 */
@ActivityScope
class LoginProxyImpl @Inject constructor(val userRepository: UserRepository) {

    init {
    }

    fun checkStatus() {
        println("LoginProxyImple checking status...")
    }
}