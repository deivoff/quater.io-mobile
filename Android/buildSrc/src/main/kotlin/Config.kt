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

    const val kotlin = "1.3.60"
    const val androidPlugin = "3.6.0-beta05"

    const val rxRelay = "2.1.1"
    const val rxKotlin = "2.4.0"
    const val rxAndroid = "2.1.1"

    const val okhttp = "4.2.2"
    const val apollo = "1.2.2"
    const val moshi = "1.9.1"

    const val ribs = "0.9.0"

    const val leakCanary = "2.0"

    const val klock = "1.4.0"
    const val dagger = "2.25.2"
    const val timber = "4.7.1"
    const val junit = "4.12"
    const val testRunner = "1.1.0"
    const val espresso = "3.1.0"
}

object Deps {
    val vers = Versions

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    const val appcompat = "androidx.appcompat:appcompat:1.1.0"
    const val androidxCore = "androidx.core:core-ktx:1.1.0"
    const val recyclerView = "androidx.recyclerview:recyclerview:1.1.0"
    const val material = "com.google.android.material:material:1.2.0-alpha02"
    const val constraint = "androidx.constraintlayout:constraintlayout:1.1.3"

    val dagger = Dagger

    object Dagger {
        const val core = "com.google.dagger:dagger:${vers.dagger}"
        const val compiler = "com.google.dagger:dagger-compiler:${vers.dagger}"
    }

    val ribs = "com.github.badoo.RIBs:rib-android:${vers.ribs}"

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

    val okhttp = OkHttp

    object OkHttp {
        const val core = "com.squareup.okhttp3:okhttp:${vers.okhttp}"
    }

    val apollo = Apollo

    object Apollo {
        const val plugin = "com.apollographql.apollo:apollo-gradle-plugin:${vers.apollo}"
        const val core = "com.apollographql.apollo:apollo-gradle-plugin:${vers.apollo}"
    }

    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
    const val leakSentry = "com.squareup.leakcanary:leaksentry:${Versions.leakCanary}"

    const val timber = "com.jakewharton.timber:timber:${vers.timber}"

    const val junit = "junit:junit:${vers.junit}"
    const val testRunner = "androidx.test:runner:${vers.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${vers.espresso}"
}
