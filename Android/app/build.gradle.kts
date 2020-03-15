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
        Modules.data,
        Modules.core,
        Modules.coreui
    ).forEach { dependency ->
        implementation(project(dependency))
    }

    arrayOf(
        Deps.kotlin,
        Deps.timber,
        Deps.rx.kotlin,
        Deps.rx.relay,
        Deps.rx.android,
        Deps.arch.viewmodel,
        Deps.router,
        Deps.compose.framework,
        Deps.compose.atext,
        Deps.compose.layout,
        Deps.compose.material,
        Deps.compose.tooling,
        Deps.compose.icons
    ).forEach { dependency ->
        implementation(dependency)
    }
}
