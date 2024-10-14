plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.ktlint)
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.android.test) apply false
    alias(libs.plugins.baselineprofile) apply false
    alias(libs.plugins.detekt)
    alias(libs.plugins.roborazzi) apply false
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

subprojects { // TODO 추 후 libs.version.toml 파일에 접근하여 plugin, version 정보 가져오기
    apply(plugin = "io.gitlab.arturbosch.detekt")

    detekt {
        toolVersion = "1.23.6"
        buildUponDefaultConfig = true
        allRules = false
        config.setFrom("$rootDir/config/detekt/detekt.yml")
        ignoreFailures = true // detekt 빌드시 실패 ignore 처리
    }
}
