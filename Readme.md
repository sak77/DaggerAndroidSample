In SampleDaggerApp we looked at basics of Dagger in Android. 

Here, we look at Subcomponents and field injection. This is second 
in series of apps which look at using Dagger in Android.

Field injections can be used to provide dependencies inside 
Android framework classes such as Activity or Fragment. 

Framework classes are instantiated by the Framework. There is no 
constructor which you can define to create their instance. 
For example, Activity only provides onCreate() which allows you 
to instantiate the activity. But you cannot use constructor 
injection to pass its dependencies. 

In such cases one can consider using Field injection.

Field injection uses @Inject on class instances used inside 
onCreate() of an Activity. It implies that Dagger is expected to 
provide instance of the annotated class when creating the Activity. 

But for Dagger to provide such instance, it is also has to 
be informed that a certain Activity or Fragment depends on it 
to instantiate them. 

So in the @Component class one has to define inject fun which 
takes instance of the Activity as its parameter. This way 
Dagger will know that it is expected to add dependencies of 
the particular activity to its graph.

Sub-components are components which extend from the application 
component but are tied to lifecycle of an Activity or Fragment. 
So each time the activity/fragment exists, it has a unique instance 
of the requested class. We also need to define a custom scope for 
the sub-component (ActivityScope in this case). And all classes 
annotated with this scope will be unique during lifecycle of the 
scope. 


