package com.alanhughes.composeui

import android.os.Bundle
import androidx.activity.compose.setContent
import com.alanhughes.composeui.navigation.RootNode
import com.alanhughes.composeui.ui.theme.ComposeUITheme
import com.bumble.appyx.core.integration.NodeHost
import com.bumble.appyx.core.integrationpoint.NodeActivity

class MainActivity : NodeActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUITheme {
                NodeHost(integrationPoint = integrationPoint) {
                    RootNode(it)
                }
            }
        }
    }
}