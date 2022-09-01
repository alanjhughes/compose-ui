plugins {
    id("com.android.application")
    id("kotlin-parcelize")
    kotlin("android")
}


android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = ConfigData.applicationId
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
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
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Deps.androidXcore)
    implementation(Deps.appCompat)
    //compose
    implementation(Deps.composeUi)
    implementation(Deps.composeMaterial)
    implementation(Deps.composeMaterialExtended)
    implementation(Deps.composeTooling)
    implementation(Deps.activityCompose)
    //lifecycle
    implementation(Deps.lifecycleRuntime)
    //nav
    implementation(Deps.composeNav)
    implementation(Deps.appyxNav)

    implementation(Deps.meterial)

    testImplementation(Deps.junit)
    androidTestImplementation(Deps.androidXTestExt)
    androidTestImplementation(Deps.espresso)
    androidTestImplementation(Deps.composeJunit)
    debugImplementation(Deps.composeToolingTest)
    debugImplementation(Deps.composeUiTest)
}