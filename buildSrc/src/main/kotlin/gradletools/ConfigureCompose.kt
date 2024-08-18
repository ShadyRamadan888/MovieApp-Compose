package gradletools

import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

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