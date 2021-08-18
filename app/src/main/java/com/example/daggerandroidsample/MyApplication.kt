package com.example.daggerandroidsample

import android.app.Application

class MyApplication : Application() {

    val applicationComponent = DaggerApplicationComponent.create()

}