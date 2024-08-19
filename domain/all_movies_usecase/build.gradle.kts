import gradletools.MainGradlePlugin

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}
apply<MainGradlePlugin>()
android {
    namespace = "com.example.all_movies_usecase"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.compose.paging)
    implementation(libs.koin)

    //data
    implementation(project(Modules.dataModel))
    implementation(project(Modules.dataRepo))
}