package np.com.ravikant.hamrobill

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import np.com.ravikant.hamrobill.ui.screen.add_event.navigateToAddEventPage
import np.com.ravikant.hamrobill.ui.screen.list.EventListScreen
import np.com.ravikant.hamrobill.ui.screen.list.EventListViewModel
import np.com.ravikant.hamrobill.ui.util.HamroBillAppBar


const val MAIN_GRAPH_ROUTE = "main-graph"

fun NavGraphBuilder.mainGraph(navController: NavController) {
    composable(MAIN_GRAPH_ROUTE) {
        MainScreen(navController = navController)
    }

}

@Composable
fun MainScreen(navController: NavController) {
    Scaffold(topBar = {
        HamroBillAppBar(title = {
            Text("Hamro Bill")
        }) { }
    }, floatingActionButton = {
        FloatingActionButton(onClick = {
            navController.navigateToAddEventPage()
        }, shape = CircleShape) {
            Icon(Icons.Default.Add, contentDescription = "Add")
        }
    }) { innerPadding ->
        val viewModel = hiltViewModel<EventListViewModel>()
        val noteList by viewModel.noteList.collectAsStateWithLifecycle()
        EventListScreen(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            noteList = noteList,
        )
    }
}
