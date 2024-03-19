package np.com.ravikant.hamrobill

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


const val ADD_EVENT_ROUTE = "add-event"

fun NavController.navigateToAddEventPage() {
    this.navigate(ADD_EVENT_ROUTE)
}

fun NavGraphBuilder.addEventGraph(navController: NavController) {
    composable(ADD_EVENT_ROUTE) {
        AddEventPage(navController = navController)
    }
}

@Composable
fun AddEventPage(navController: NavController) {
    Scaffold(topBar = {
        HamroBillAppBar(
            title = {
                Text("Add Event")
            }, navigateUp = {
                navController.navigateUp()
            }
        )
    }) {
        Text("I am here at AddEvent Screen-- P", modifier = Modifier.padding(it))
    }

}