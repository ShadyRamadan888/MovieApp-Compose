import gradletools.MainGradlePlugin
import org.jetbrains.kotlin.utils.addToStdlib.safeAs

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}
apply<MainGradlePlugin>()
android {
    namespace = "com.movies.feature_home"

    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.koin.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)
    implementation(libs.bundles.lifecycle)
    //design
    implementation(project(Modules.designCore))
    //data
    implementation(project(Modules.dataModel))
    implementation(project(Modules.dataService))
    //domain
    implementation(project(Modules.popularMoviesUseCase))
    implementation(project(Modules.topRatedMoviesUseCase))
    implementation(project(Modules.nowPlayingUseCase))
    implementation(project(Modules.upcomingUseCase))

    implementation(libs.compose.paging)

    //repo
    implementation(project(Modules.dataRepo))
}