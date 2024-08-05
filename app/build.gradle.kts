plugins {
    id("convention.android.application")
    id("convention.android.hilt")
}

dependencies {
    implementation(libs.androidx.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso)
}