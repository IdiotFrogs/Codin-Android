import com.example.architecture_test.configureComposeAndroid

plugins {
    id("convention.android.library")
    kotlin("plugin.compose")
}

android {
    configureComposeAndroid(this)
}