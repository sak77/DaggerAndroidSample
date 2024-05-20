package com.example.daggerandroidsample.di

import com.example.daggerandroidsample.LoginActivity
import com.example.daggerandroidsample.LoginFragment
import dagger.Subcomponent
import javax.inject.Scope

/**
 * Generally, Dagger components are instantiated in the Application class. So instances provided
 * by them are alive during the life-time of the application.
 *
 * But some cases we may require a class instance for lifetime of certain Activity or fragment.
 * Eg. In case of App Login, there may be more than one classes involved and they may
 * require single instance of LoginViewModel class (not actual viewmodel but similar class).
 *
 * In such case using @Singleton will not work, since although it provides a unique instance,
 * but since it is provided by ApplicationComponent, its instance is in memory for lifetime
 * of the application.
 *
 * Plus, we require a new instance of LoginViewModel each time user logs in. But having
 * @Singleton instance of LoginViewmodel will hold earlier instance.
 *
 * In such cases it will require a component (LoginComponent) which is there only for
 * the particular use-case. Also the classes provided by this component can have dependencies
 * to classes from the ApplicationComponent.
 *
 * To make ApplicationComponent classes accessible to LoginComponent it can be made a
 * sub-component of the ApplicationComponent.
 *
 * Subcomponent:
 * - inherits from and extends object graph from the parent component. Thus all objects
 * provided by parent component are provided by the sub-component too.
 * - Can be tied to lifecycle of an activity/fragment instead of ApplicationComponent
 * which holds instances throughout lifetime of the app.
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

/*
Scope has to be named based on the lifecycle during which it
exists.
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

    /*
    When using constructor injection, one defines some getter methods in the Component
    class which returns instance of the required classes.

    But in case of field injection, one has to use @Inject annotation to request Dagger
    to provide instance of the required class. As it is done here in LoginActivity for eg.
    But for it to work, Dagger has to prepare dependencies required by LoginActivity.
    So that is why one has to declare an inject function in the component class and
    pass instance of the requesting class (LoginActivity). This will tell Dagger that
    LoginActivity will request some instances via @Inject and so it has to prepare these
    in its dependency graph.
     */
    fun inject(activity: LoginActivity)

    /*
    Instead of using field injection, same result can also be obtained via providing a
    getter method here in the component which can be used in the LoginActivity.
    But commenting out for now.
     */
    //fun getLonginProxyInstance(): LoginProxyImpl

    fun inject(loginFragment: LoginFragment)
}