package com.example.daggerandroidsample

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.daggerandroidsample.di.DaggerApplicationComponent
import javax.inject.Inject

class LoginFragment : Fragment() {

    //We expect Dagger to inject this dependency.
    /*
    Since we have annotated LoginComponent and LoginProxyImpl
    with @ActivityScope. So during LoginComponent scope, we will
    get a unique instance of LoginProxyImpl.
     */
    @Inject
    lateinit var loginProxyImpl: LoginProxyImpl

    override fun onAttach(context: Context) {
        super.onAttach(context)
        /*
            When using fragments, inject Dagger in the fragment's
             onAttach() method. In this case, it can be done before
             or after calling super.onAttach().
         */

        //LoginComponent is derived from ActivityComponent
        val loginComponent = DaggerApplicationComponent.create().loginComponent().create()

        //Request dagger to inject all dependencies required by this fragment
        loginComponent.inject(this)

        //Now LoginProxyImpl is available.
        loginProxyImpl.checkStatus()
    }
}