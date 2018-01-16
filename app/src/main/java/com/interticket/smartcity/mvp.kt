package com.interticket.smartcity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.processors.BehaviorProcessor

interface Presenter {
    val viewModels: Observable<out Any>
}

abstract class BasePresenter<M : Any> : Presenter {
    protected val viewModelSubject: BehaviorProcessor<M> = BehaviorProcessor.create<M>()
    override val viewModels get(): Observable<out M> = viewModelSubject.toObservable()
}

class HeadlessFragment : Fragment() {
    var presenter: Presenter? = null

    init {
        retainInstance = true
    }
}

inline fun <reified P : Presenter> AppCompatActivity.presenterOf(fromComponent: Any): P = presenterOf(fromComponent, supportFragmentManager)

inline fun <reified P : Presenter> Fragment.presenterOf(fromComponent: Any): P = presenterOf(fromComponent, fragmentManager!!)

inline fun <reified P : Presenter> presenterOf(component: Any, supportFragmentManager: FragmentManager): P {
    val tag = "Presenter(${P::class.java.name})"
    var fragment = supportFragmentManager.findFragmentByTag(tag) as HeadlessFragment?
    if (fragment == null) {
        fragment = HeadlessFragment()

        // Querying the Dagger Component for the presenter of type P
        val presenter = component.javaClass.methods.first { method -> method.returnType == P::class.java }.invoke(component) as P

        fragment.presenter = presenter
        supportFragmentManager.beginTransaction()
                .add(fragment, tag)
                .commit()
    }
    return fragment.presenter as P
}

