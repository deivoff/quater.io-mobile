plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("com.apollographql.android")
}

android {
    compileSdkVersion(Versions.compileSdk)
    defaultConfig {
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)
        versionCode = Versions.appVersionCode
        versionName = Versions.appVersionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    androidExtensions {
        isExperimental = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    sourceSets {
        getByName("main").java.srcDir("src/main/kotlin")
    }
}

kapt {
    useBuildCache = true
}

dependencies {
    arrayOf(
        Deps.kotlin,
        Deps.timber,
        Deps.moshi.core,
        Deps.dagger.core,
        Deps.apollo.core
    ).forEach { dependency ->
        implementation(dependency)
    }

    arrayOf(
        Deps.okhttp.core
    ).forEach { dependency ->
        api(dependency)
    }

    arrayOf(
        Deps.dagger.compiler
    ).forEach { dependency ->
        kapt(dependency)
    }
}
