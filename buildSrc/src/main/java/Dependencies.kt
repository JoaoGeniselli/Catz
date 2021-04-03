object Dependencies {

    const val gradleClasspath = "com.android.tools.build:gradle:3.6.2"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:2.28-alpha"

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9"

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:1.3.2"
        const val appCompat = "androidx.appcompat:appcompat:1.2.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.2"
        const val recyclerView = "androidx.recyclerview:recyclerview:1.1.0"

        object Lifecycle {
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:2.2.0"
        }
    }

    const val retrofit = "com.squareup.retrofit2:retrofit:2.8.1"
    const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:2.8.1"

    const val hilt = "com.google.dagger:hilt-android:2.28-alpha"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:2.28-alpha"

    object Test {
        const val jUnit = "junit:junit:4.12"
        const val mockk = "io.mockk:mockk:1.10.5"
        const val androidJUnitExt = "androidx.test.ext:junit:1.1.2"
        const val espresso = "androidx.test.espresso:espresso-core:3.3.0"
    }
}
