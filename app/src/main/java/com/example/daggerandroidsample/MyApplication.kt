package com.example.daggerandroidsample

import android.app.Application
import com.example.daggerandroidsample.di.ApplicationComponent
import com.example.daggerandroidsample.di.DaggerApplicationComponent

class MyApplication : Application() {

    val applicationComponent: ApplicationComponent = DaggerApplicationComponent.create()

}