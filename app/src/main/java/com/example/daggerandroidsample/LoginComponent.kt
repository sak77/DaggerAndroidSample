package com.example.daggerandroidsample

import dagger.Subcomponent
import javax.inject.Scope

/**
 * Subcomponent:
 * - inherit from and extend the main component.
 * - Can be tied to lifecycle of an activity/fragment.
 *
 * To create subcomponent we use @Subcomponent annotation. Here LoginComponent is defined
 * as a subcomponent.
 *
 * Next you define a Subcomponent factory interface within the subcomponent which tells the parent
 * Component how to create instance of this subcomponent.
 *
 * Next, define a module for this subcomponent. The module will be included in the list of
 * modules for the parent component.
 *
 * Finally, the parent component creates a method which returns instance of the subcomponent factory
 * class. This way, subcomponent is derived via the main/application component.
 *
 * LoginComponent needs to be tied to ApplicationComponent because it needs instance of
 * UserRepository and its dependent classes, which are part of the application component.
 *
 * In our case LoginComponent is responsible for providing dependencies of LoginActivity.
 *
 * Scope for Subcomponent:
 * Each component can have its own scope/life-cycle that is tied to the lifecycle of an
 * activity, fragment, application or maybe a service.
 *
 * By default Dagger provides @Singleton annotation to define scope of component. Generally,
 * this annotation is used with Application Component.
 *
 * Classes or module members having same scope as the components will only have a single instance
 * during the lifetime of the component.
 *
 * We can define our own annotation to define scope at activity level.
 */

@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class ActivityScope {
}

@ActivityScope
@Subcomponent
interface LoginComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create() : LoginComponent
    }

    // This tells Dagger that LoginActivity requests injection so the graph needs to
    // satisfy all the dependencies of the fields that LoginActivity is requesting.
    fun inject(activity: LoginActivity)

    fun inject(loginFragment: LoginFragment)
}