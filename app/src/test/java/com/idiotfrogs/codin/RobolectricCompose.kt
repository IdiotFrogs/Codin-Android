package com.idiotfrogs.codin

import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.GraphicsMode

@GraphicsMode(GraphicsMode.Mode.NATIVE)
@RunWith(RobolectricTestRunner::class)
class RoborazziTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun roborazziTest() {
        composeTestRule.setContent {
            Greeting()
        }

        composeTestRule
            .onNode(hasText("Hello"))
            .assertExists()
    }
}