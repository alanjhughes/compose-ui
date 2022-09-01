object Versions {
    const val compose = "1.3.0-beta01"
    const val nav = "2.5.1"
    const val appyx = "1.0-alpha06"
}

object Deps {
    val androidXcore by lazy { "androidx.core:core-ktx:1.8.0" }
    val activityCompose by lazy { "androidx.activity:activity-compose:1.5.1" }
    val appCompat by lazy { "androidx.appcompat:appcompat:1.3.1" }
    val composeUi by lazy { "androidx.compose.ui:ui:${Versions.compose}" }
    val composeMaterial by lazy { "androidx.compose.material:material:${Versions.compose}" }
    val appyxNav by lazy { "com.bumble.appyx:core:${Versions.appyx}" }
    val composeMaterialExtended by lazy { "androidx.compose.material:material-icons-extended:${Versions.compose}" }
    val composeTooling by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.compose}" }
    val composeNav by lazy { "androidx.navigation:navigation-compose:${Versions.nav}" }
    val lifecycleRuntime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1" }
    val meterial by lazy { "com.google.android.material:material:1.4.0" }
    val junit by lazy { "junit:junit:4.13.2" }
    val androidXTestExt by lazy { "androidx.test.ext:junit:1.1.3" }
    val espresso by lazy { "androidx.test.espresso:espresso-core:3.4.0" }
    val composeJunit by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.compose}" }
    val composeToolingTest by lazy { "androidx.compose.ui:ui-tooling:${Versions.compose}" }
    val composeUiTest by lazy { "androidx.compose.ui:ui-test-manifest:${Versions.compose}" }
}
