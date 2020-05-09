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

    const val kotlin = "1.3.61"
    const val androidPlugin = "4.1.0-alpha09"

    const val compose = "0.1.0-dev09"

    const val composeRouter = "0.9.0"

    const val rxRelay = "2.1.1"
    const val rxKotlin = "2.4.0"
    const val rxAndroid = "2.1.1"

    const val okhttp = "4.2.2"
    const val apollo = "1.3.3"
    const val moshi = "1.9.1"

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

    val arch = Architecture

    object Architecture {
        const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
    }

    val compose = UI

    object UI {
        const val composeRuntime = "androidx.compose:compose-runtime:${vers.compose}"
        const val framework = "androidx.ui:ui-framework:${vers.compose}"
        const val layout = "androidx.ui:ui-layout:${vers.compose}"
        const val material = "androidx.ui:ui-material:${vers.compose}"
        const val foundation = "androidx.ui:ui-foundation:${vers.compose}"
        const val animation = "androidx.ui:ui-animation:${vers.compose}"
        const val tooling = "androidx.ui:ui-tooling:${vers.compose}"
        const val icons = "androidx.ui:ui-material-icons-extended:${vers.compose}"
        const val livedata = "androidx.ui:ui-livedata:${vers.compose}"
        const val rx = "androidx.ui:ui-rxjava2:${vers.compose}"
    }

    const val router = "com.github.zsoltk:compose-router:${vers.composeRouter}"

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

    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.4"

    val apollo = Apollo

    object Apollo {
        const val plugin = "com.apollographql.apollo:apollo-gradle-plugin:${vers.apollo}"
        const val core = "com.apollographql.apollo:apollo-runtime:${vers.apollo}"
        const val coroutines = "com.apollographql.apollo:apollo-coroutines-support:${vers.apollo}"
    }

    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
    const val leakSentry = "com.squareup.leakcanary:leaksentry:${Versions.leakCanary}"

    const val timber = "com.jakewharton.timber:timber:${vers.timber}"

    const val junit = "junit:junit:${vers.junit}"
    const val testRunner = "androidx.test:runner:${vers.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${vers.espresso}"
}
