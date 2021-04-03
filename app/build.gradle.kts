plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(Versions.Sdk.compile)
    buildToolsVersion(Versions.Sdk.buildTools)

    defaultConfig {
        applicationId = "com.learning.catz"
        minSdkVersion(Versions.Sdk.minimum)
        targetSdkVersion(Versions.Sdk.target)
        versionCode = Versions.App.code
        versionName = Versions.App.name

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    viewBinding {
        isEnabled = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Dependencies.kotlin)
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.constraintLayout)
    implementation(Dependencies.AndroidX.Lifecycle.viewModel)
    implementation(Dependencies.AndroidX.Lifecycle.runtime)
    implementation(Dependencies.AndroidX.recyclerView)
    implementation(Dependencies.coroutines)
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofitConverterGson)
    implementation(Dependencies.hilt)

    kapt(Dependencies.hiltCompiler)

    testImplementation(Dependencies.Test.jUnit)
    testImplementation(Dependencies.Test.mockk)

    androidTestImplementation(Dependencies.Test.androidJUnitExt)
    androidTestImplementation(Dependencies.Test.espresso)
}
