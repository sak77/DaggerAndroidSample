package com.example.daggerandroidsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject
import kotlin.math.log

/**
 * Because certain Android framework classes such as activities and fragments are instantiated by
 * the system, Dagger can't create them for you.
 *
 * For example, in Activity, all initialization code goes in onCreate() method which Dagger cannot
 * create for you. So instead of using constructor injection, we should use field injection.
 *
 * NOTE: Field injection should only be used in Android framework classes where constructor injection
 * cannot be used.
 */
class LoginActivity : AppCompatActivity() {

    // You want Dagger to provide an instance of LoginProxyImpl from the graph
    @Inject
    lateinit var loginProxyImpl: LoginProxyImpl

    override fun onCreate(savedInstanceState: Bundle?) {

        /*
            When using activities, inject Dagger in the activity's onCreate() method before calling
            super.onCreate() to avoid issues with fragment restoration.
         */

        /*
        LoginComponent is derived from the ApplicationComponent, since it is its subcomponent.
         */
        val loginComponent = (applicationContext as MyApplication).applicationComponent.loginComponent().create()

        loginComponent.inject(this)

        //Now LoginProxyImpl class is available..
        super.onCreate(savedInstanceState)

        loginProxyImpl.checkStatus()

    }
}