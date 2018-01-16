package com.interticket.smartcity.presentation

import com.interticket.smartcity.BasePresenter
import javax.inject.Inject

class MainPresenter @Inject constructor() : BasePresenter<MainPresenter.ViewModel>() {

    sealed class ViewModel {
        data class Idle(val title: String) : ViewModel()
    }
}
