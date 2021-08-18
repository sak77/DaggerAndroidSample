package com.example.daggerandroidsample

import dagger.Component

@Component (modules = [NetworkModule::class, LoginModule::class])
interface ApplicationComponent {
    fun repository(): UserRepository

    fun loginComponent() : LoginComponent.Factory
}