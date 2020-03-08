plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "0.1.0-dev05"
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
        Deps.rx.kotlin,
        Deps.compose.framework,
        Deps.compose.layout,
        Deps.compose.material,
        Deps.compose.tooling,
        Deps.compose.icons,
        Deps.rx.relay
    ).forEach { dependency ->
        implementation(dependency)
    }

    arrayOf(
        Deps.material,
        Deps.androidxCore,
        Deps.appcompat,
        Deps.constraint,
        Deps.recyclerView
    ).forEach { dependency ->
        api(dependency)
    }
}
