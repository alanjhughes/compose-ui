package com.alanhughes.composeui.navigation

import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alanhughes.composeui.ui.screens.canvas.CanvasNode
import com.alanhughes.composeui.ui.screens.landing.LandingNode
import com.bumble.appyx.core.composable.Children
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node
import com.bumble.appyx.core.node.ParentNode
import com.bumble.appyx.navmodel.backstack.BackStack
import com.bumble.appyx.navmodel.backstack.transitionhandler.rememberBackstackFader
import kotlinx.parcelize.Parcelize

class RootNode(
    buildContext: BuildContext, private val backStack: BackStack<Routing> = BackStack(
        initialElement = Routing.Landing,
        savedStateMap = buildContext.savedStateMap
    )
) :
    ParentNode<RootNode.Routing>(navModel = backStack, buildContext = buildContext) {

    sealed class Routing : Parcelable {
        @Parcelize
        object Landing : Routing()

        @Parcelize
        object Canvas : Routing()
    }

    override fun resolve(routing: Routing, buildContext: BuildContext): Node =
        when (routing) {
            Routing.Landing -> LandingNode(buildContext, backStack)
            Routing.Canvas -> CanvasNode(buildContext)
        }

    @Composable
    override fun View(modifier: Modifier) {
        Children(
            navModel = backStack,
            transitionHandler = rememberBackstackFader()
        )
    }
}