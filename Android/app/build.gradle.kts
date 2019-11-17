plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Versions.compileSdk)
    defaultConfig {
        applicationId = ApplicationID.default
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)
        versionCode = Versions.appVersionCode
        versionName = Versions.appVersionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    androidExtensions {
        isExperimental = true
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
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
        "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}",
        Deps.material,
        Deps.androidxCore,
        Deps.appcompat,
        Deps.moshi.core,
        Deps.constraint,
        Deps.recyclerView,
        Deps.retrofit.core,
        Deps.retrofit.moshi,
        Deps.retrofit.rxjava,
        Deps.timber,
        Deps.dagger.core
    ).forEach { dependency ->
        implementation(dependency)
    }

    arrayOf(
        Deps.moshi.codegen,
        Deps.dagger.compiler
    ).forEach { dependency ->
        kapt(dependency)
    }
}
