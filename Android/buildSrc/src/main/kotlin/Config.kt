object ApplicationID {
    const val default = "io.quarter.client"
    const val develop = "io.quarter.client.develop"
}

object Modules {
    const val app = ":app"
    const val core = ":core"
    const val coreui = ":coreui"
    const val data = ":data"
}

object Versions {
    const val minSdk = 21
    const val targetSdk = 29
    const val compileSdk = 29
    const val appVersionCode = 1000
    const val appVersionName = "0.0.1"

    const val kotlin = "1.3.50"
    const val androidPlugin = "3.6.0-beta05"

    const val rxRelay = "2.1.0"
    const val rxBinding = "3.0.0-alpha2"
    const val rxKotlin = "2.2.0"
    const val rxAndroid = "2.0.2"

    const val okhttp = "4.2.2"

    const val leakCanary = "2.0-alpha-2"

    const val klock = "1.4.0"
    const val dagger = "2.25.2"
    const val moshi = "1.9.1"
    const val retrofit = "2.4.0"
    const val timber = "4.7.1"
    const val junit = "4.12"
    const val testRunner = "1.1.0"
    const val espresso = "3.1.0"
    const val googleServices = "4.3.1"
}

object Deps {
    val vers = Versions

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    const val appcompat = "androidx.appcompat:appcompat:1.1.0"
    const val androidxCore = "androidx.core:core-ktx:1.1.0"
    const val recyclerView = "androidx.recyclerview:recyclerview:1.1.0-rc01"
    const val material = "com.google.android.material:material:1.2.0-alpha01"
    const val constraint = "androidx.constraintlayout:constraintlayout:1.1.3"

    const val multidex = "com.android.support:multidex:1.0.3"

    val dagger = Dagger

    object Dagger {
        const val core = "com.google.dagger:dagger:${vers.dagger}"
        const val compiler = "com.google.dagger:dagger-compiler:${vers.dagger}"
    }

    val rx = Rx

    object Rx {
        const val relay = "com.jakewharton.rxrelay2:rxrelay:${vers.rxRelay}"
        const val kotlin = "io.reactivex.rxjava2:rxkotlin:${vers.rxKotlin}"
        const val android = "io.reactivex.rxjava2:rxandroid:${vers.rxAndroid}"
    }

    val klock = Klock

    object Klock {
        const val core = "com.soywiz:klock-metadata:${vers.klock}"
        const val jvm = "com.soywiz:klock-jvm:${vers.klock}"
        const val android = "com.soywiz:klock-android:${vers.klock}"
    }

    val moshi = Moshi

    object Moshi {
        const val core = "com.squareup.moshi:moshi:${vers.moshi}"
        const val codegen = "com.squareup.moshi:moshi-kotlin-codegen:${vers.moshi}"
    }

    val retrofit = Retrofit

    object Retrofit {
        const val core = "com.squareup.retrofit2:retrofit:${vers.retrofit}"
        const val moshi = "com.squareup.retrofit2:converter-moshi:${vers.retrofit}"
        const val rxjava = "com.squareup.retrofit2:adapter-rxjava2:${vers.retrofit}"
    }

    val okhttp = OkHttp

    object OkHttp {
        const val core = "com.squareup.okhttp3:okhttp:${vers.okhttp}"
    }

    val rxBinding = RxBinding

    object RxBinding {
        const val core = "com.jakewharton.rxbinding3:rxbinding-core:${vers.rxBinding}"
        const val appCompat = "com.jakewharton.rxbinding3:rxbinding-appcompat:${vers.rxBinding}"
        const val leanBack = "com.jakewharton.rxbinding3:rxbinding-leanback:${vers.rxBinding}"
        const val recycler = "com.jakewharton.rxbinding3:rxbinding-recyclerview:${vers.rxBinding}"
        const val viewPager = "com.jakewharton.rxbinding3:rxbinding-viewpager:${vers.rxBinding}"
        const val material = "com.jakewharton.rxbinding3:rxbinding-material:${vers.rxBinding}"
    }

    val firebase = Firebase

    object Firebase {
        const val core = "com.google.firebase:firebase-core:17.1.0"
        const val crashlytics = "com.crashlytics.sdk.android:crashlytics:2.10.1"
    }

    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
    const val leakSentry = "com.squareup.leakcanary:leaksentry:${Versions.leakCanary}"

    const val timber = "com.jakewharton.timber:timber:${vers.timber}"

    const val junit = "junit:junit:${vers.junit}"
    const val testRunner = "androidx.test:runner:${vers.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${vers.espresso}"
}
