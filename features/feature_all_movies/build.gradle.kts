import gradletools.ConfigureCompose
import gradletools.MainGradlePlugin

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}
apply<MainGradlePlugin>()
apply<ConfigureCompose>()
android {
    namespace = "com.movies.feature_all_movies"
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
    implementation(project(Modules.allPagingMoviesUseCase))
    //paging
    implementation(libs.compose.paging)
    //repo
    implementation(project(Modules.dataRepo))
}