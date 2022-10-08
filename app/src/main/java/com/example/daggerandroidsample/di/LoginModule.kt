package com.example.daggerandroidsample.di

import dagger.Module

/**
 * This module provides subcomponents to the ApplicationComponent.
 */
@Module (subcomponents = [LoginComponent::class])
interface LoginModule {
}