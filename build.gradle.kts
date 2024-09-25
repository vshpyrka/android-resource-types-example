plugins {
    alias(pluginLibs.plugins.android.library)
    alias(pluginLibs.plugins.kotlin.android)
}

android {
    namespace = "com.example.resources"
    compileSdk = sdk.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = sdk.versions.minSdk.get().toInt()
        targetSdk = sdk.versions.targetSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        // https://developer.android.com/guide/topics/resources/multilingual-support#specify-the-languages-your-app-supports
        resourceConfigurations.addAll(listOf("en", "en-rCA", "fr-rCA", "uk"))
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.activity.ktx)
    implementation(libs.fragment.ktx)
    implementation(libs.constraintlayout)
    implementation(libs.material)

    // Looks like this library is used also in tests, not sure which exact
    // library is missing that pulls that tracing lib
    implementation(libs.tracing)

    androidTestImplementation(testLibs.core.ktx)
    androidTestImplementation(testLibs.android.junit.ktx)
    androidTestImplementation(testLibs.espresso)
    androidTestImplementation(testLibs.espresso.device)
    androidTestImplementation(testLibs.uiautomator)
    androidTestImplementation(testLibs.truth)

    implementation("com.google.guava:guava:32.0.1-jre")
    implementation("com.google.guava:listenablefuture:9999.0-empty-to-avoid-conflict-with-guava")
}
