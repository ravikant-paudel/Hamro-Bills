package np.com.ravikant.hamrobill

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import np.com.ravikant.hamrobill.ui.screen.add_event.addEventGraph


@Composable
fun HamroBillApp() {
    val rootController = rememberNavController()
//    val navigationBarController = rememberNavController()

    NavHost(
        navController = rootController,
        startDestination = MAIN_GRAPH_ROUTE,
    ) {
        mainGraph(navController = rootController)
        addEventGraph(navController = rootController)
    }


}
