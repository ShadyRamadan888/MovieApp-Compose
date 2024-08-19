plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.movies.watch"
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        applicationId = ProjectConfig.appId
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
        versionCode = ProjectConfig.versionCode
        versionName = ProjectConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
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
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)

    implementation(libs.koin)

    implementation(libs.koin.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)

    implementation(project(Modules.dataModel))
    implementation(project(Modules.dataService))
    implementation(project(Modules.dataRepo))

    //domain
    implementation(project(Modules.popularMoviesUseCase))
    implementation(project(Modules.topRatedMoviesUseCase))
    implementation(project(Modules.nowPlayingUseCase))
    implementation(project(Modules.upcomingUseCase))
    implementation(project(Modules.allPagingMoviesUseCase))

    //features
    implementation(project(Modules.featureHome))
    implementation(project(Modules.featureAllMovies))

    //design
    implementation(project(Modules.designCore))

    //slf4j
    implementation(libs.slf4j)
    implementation(libs.compose.paging)

    //repo
    implementation(project(Modules.dataRepo))
}