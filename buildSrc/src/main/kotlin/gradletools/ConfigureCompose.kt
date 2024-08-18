package gradletools

import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.jvm
import java.io.File

class ConfigureCompose : Plugin<Project> {
    override fun apply(target: Project) {
        setComposeConfig(target)
    }

    private fun setComposeConfig(project: Project) {
        project.android().apply {
            buildFeatures {
                compose = true
            }
            composeOptions {
                kotlinCompilerExtensionVersion = "1.4.3"
            }
        }
    }

    private fun Project.android(): LibraryExtension {
        return extensions.getByType(LibraryExtension::class.java)
    }

}