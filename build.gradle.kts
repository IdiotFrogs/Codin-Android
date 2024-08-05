plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.ktlint)
    alias(libs.plugins.compose.compiler) apply false
}

allprojects {
    tasks.withType(org.jetbrains.kotlin.gradle.dsl.KotlinCompile::class.java).configureEach {
        kotlinOptions {
            if (project.findProperty("enableMultiModuleComposeReports") == "true") {
                freeCompilerArgs +=
                    listOf(
                        "-P",
                        "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=" +
                                rootProject.buildDir.absolutePath + "/compose_metrics/",
                    )

                freeCompilerArgs +=
                    listOf(
                        "-P",
                        "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=" +
                                rootProject.buildDir.absolutePath + "/compose_metrics/",
                    )
            }
        }
    }
}