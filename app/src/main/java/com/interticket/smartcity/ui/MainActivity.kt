package com.interticket.smartcity.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.interticket.smartcity.R
import com.interticket.smartcity.app
import com.interticket.smartcity.di.components.ActivityComponent
import com.interticket.smartcity.di.modules.ActivityModule
import com.interticket.smartcity.presentation.MainPresenter
import com.interticket.smartcity.presentation.MainPresenter.ViewModel
import com.interticket.smartcity.presenterOf
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private val component: ActivityComponent by lazy { app.applicationComponent.activityComponent(ActivityModule()) }
    private val disposables = CompositeDisposable()
    private val presenter: MainPresenter by lazy { presenterOf<MainPresenter>(fromComponent = component) }

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.d("-> onCreate")
        super.onCreate(savedInstanceState)
        component.inject(this)
        setContentView(R.layout.activity_main)
        disposables += presenter.viewModels.subscribeBy(onNext = ::render)
        Timber.d("<- onCreate")
    }

    private fun render(viewModel: ViewModel) {
        Timber.d("-> render(%s)", viewModel)
        when (viewModel) {
            is ViewModel.Idle -> {

            }
        }
        Timber.d("<- render")
    }

    override fun onDestroy() {
        Timber.d("-> onDestroy")
        super.onDestroy()
        disposables.dispose()
        Timber.d("<- onDestroy")
    }
}
