package dev.steelahhh.coreui

import android.graphics.Rect
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable

object WindowInsetsHolder {

    private val rect = BehaviorRelay.create<Rect>()

    fun get(): Rect = rect.value ?: Rect()

    fun observe(): Observable<Rect> = rect.hide()

    fun newInsets(insets: Rect) = rect.accept(insets)
}
