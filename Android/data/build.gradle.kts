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
}

apollo {
  generateKotlinModels.set(true)
}

kapt {
  useBuildCache = true
}

dependencies {
  arrayOf(
    Deps.kotlin,
    Deps.timber,
    Deps.Moshi.core,
    Deps.apollo.core,
    Deps.apollo.coroutines,
    Deps.coroutines
  ).forEach { dependency ->
    implementation(dependency)
  }

  compileOnly("org.jetbrains:annotations:13.0")
  testCompileOnly("org.jetbrains:annotations:13.0")

  arrayOf(
    Deps.okhttp.core
  ).forEach { dependency ->
    api(dependency)
  }
}
