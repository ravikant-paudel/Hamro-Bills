package np.com.ravikant.hamrobill

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController


@Composable
fun HamroBillApp() {
    val rootController = rememberNavController()
    val navigationBarController = rememberNavController()

    NavHost(
        navController = rootController,
        startDestination = MAIN_GRAPH_ROUTE,
    ) {
        mainGraph(navController = rootController)
        addEventGraph(navController = rootController)

    }


}
