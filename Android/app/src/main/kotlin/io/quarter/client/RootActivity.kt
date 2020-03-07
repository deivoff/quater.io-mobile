package io.quarter.client

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import io.quarter.client.util.StatusBarController
import io.quarter.client.util.TranslucentInsetsFrameLayout
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy

class RootActivity : AppCompatActivity() {
    private val rootViewGroup: ViewGroup get() = findViewById(R.id.root)

    private val cd = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_root)
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        cd += StatusBarController.observe()
            .subscribeBy { config ->
                (rootViewGroup as TranslucentInsetsFrameLayout).updateStatusBar(
                    config.height,
                    config.colorDesc,
                    config.visible
                )
            }
    }

    override fun onStop() {
        super.onStop()
        cd.clear()
    }
}
