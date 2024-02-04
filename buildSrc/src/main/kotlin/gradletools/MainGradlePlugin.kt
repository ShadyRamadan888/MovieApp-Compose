package gradletools

import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.util.Properties

class MainGradlePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        setProjectConfig(target)
    }

    private fun setProjectConfig(project: Project) {

        project.android().apply {
            compileSdk = ProjectConfig.compileSdk

            defaultConfig {
                minSdk = ProjectConfig.minSdk
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }
            defaultConfig {
                val properties = Properties()
                properties.load(project.rootProject.file("local.properties").inputStream())
                buildConfigField("String", "API_KEY", "\"${properties.getProperty("API_KEY")}\"")
                buildConfigField("String", "BASE_URL", "\"${properties.getProperty("BASE_URL")}\"")
            }
            buildFeatures {
                buildConfig = true
            }
            packaging {
                resources {
                    excludes += "/META-INF/{AL2.0,LGPL2.1}"
                }
            }
        }
    }


    private fun Project.android(): LibraryExtension {
        return extensions.getByType(LibraryExtension::class.java)
    }
}