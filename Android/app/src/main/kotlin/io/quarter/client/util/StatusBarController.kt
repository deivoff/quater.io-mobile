package io.quarter.client.util

import android.annotation.SuppressLint
import com.jakewharton.rxrelay2.BehaviorRelay
import dev.steelahhh.coreui.ColorDesc
import dev.steelahhh.coreui.WindowInsetsHolder
import io.quarter.client.R
import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy

@SuppressLint("CheckResult")
object StatusBarController {

    private val configurationRelay = BehaviorRelay.create<Configuration>()

    private val configuration: Configuration? get() = configurationRelay.value

    init {
        WindowInsetsHolder.observe()
            .map { insets ->
                configuration?.copy(height = insets.top) ?: Configuration(
                    insets.top
                )
            }
            .subscribeBy {
                configurationRelay.accept(it)
            }
    }

    fun observe(): Observable<Configuration> = configurationRelay.hide()

    fun newColor(colorDesc: ColorDesc) = configurationRelay.accept(
        configuration?.copy(colorDesc = colorDesc) ?: Configuration(
            colorDesc = colorDesc
        )
    )

    fun newVisibility(visible: Boolean) = configurationRelay.accept(
        configuration?.copy(visible = visible) ?: Configuration(
            visible = visible
        )
    )

    fun getHeight() = configuration?.height ?: 0

    data class Configuration(
        val height: Int = 0,
        val colorDesc: ColorDesc = ColorDesc.Resource(R.color.white),
        val visible: Boolean = true
    )
}
