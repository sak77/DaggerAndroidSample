package com.example.daggerandroidsample.di

import com.example.daggerandroidsample.UserRepository
import dagger.Component

@Component (modules = [NetworkModule::class, SubcomponentModule::class])
interface ApplicationComponent {
    fun repository(): UserRepository

    fun loginComponent() : LoginComponent.Factory
}