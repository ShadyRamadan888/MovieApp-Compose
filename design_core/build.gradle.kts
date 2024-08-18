import gradletools.ConfigureCompose
import gradletools.MainGradlePlugin

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}
apply<MainGradlePlugin>()
apply<ConfigureCompose>()
android {
    namespace = "com.movies.design_core"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.koin.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)

    implementation(project(Modules.dataModel))
    implementation(libs.compose.paging)

    //service
    implementation(project(Modules.dataService))
}