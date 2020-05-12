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
    kotlinCompilerExtensionVersion = Versions.compose
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
    Deps.UI.foundation,
    Deps.UI.framework,
    Deps.UI.layout,
    Deps.UI.material,
    Deps.UI.animation,
    Deps.UI.tooling,
    Deps.UI.livedata,
    Deps.simpleStack
  ).forEach { dependency ->
    implementation(dependency)
  }
}
