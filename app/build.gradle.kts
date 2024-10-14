plugins {
    id("convention.android.application")
    id("convention.android.hilt")
    alias(libs.plugins.baselineprofile)
    alias(libs.plugins.roborazzi)
}

dependencies {
    implementation(libs.androidx.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso)
    baselineProfile(project(":baselineprofile"))
    implementation(libs.androidx.profileinstaller)
}