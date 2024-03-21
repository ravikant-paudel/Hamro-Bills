package np.com.ravikant.hamrobill.ui.screen.add_event

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import np.com.ravikant.hamrobill.ui.util.HamroBillAppBar


const val ADD_EVENT_ROUTE = "add-event"

fun NavController.navigateToAddEventPage() {
    this.navigate(ADD_EVENT_ROUTE)
}

fun NavGraphBuilder.addEventGraph(navController: NavController) {
    composable(ADD_EVENT_ROUTE) {

        val viewModel = hiltViewModel<NoteViewModel>()
        val state by viewModel.state.collectAsStateWithLifecycle()
        AddEventPage(
            navController = navController,
            state = state,
            onEvent = viewModel::onEvent,
        )
    }
}

@Composable
fun AddEventPage(
    navController: NavController,
    state: NoteState,
    onEvent: (NoteEvent) -> Unit
) {

    Scaffold(topBar = {
        HamroBillAppBar(
            title = {
                Text("Add Event")
            },
            navigateUp = {
                navController.navigateUp()
            },
            canNavigateBack = true,
        )
    }) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(
                    horizontal = 20.dp,
                    vertical = 15.dp
                ),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            OutlinedTextField(
                value = state.title,
                onValueChange = {
                    onEvent(NoteEvent.TitleChange(it))
                },
                placeholder = {
                    Text(text = "Title")
                }
            )
            OutlinedTextField(
                value = state.content,
                onValueChange = {
                    onEvent(NoteEvent.ContentChange(it))
                },
                placeholder = {
                    Text(text = "Content")
                }
            )

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                        onEvent(NoteEvent.Save)
                    },
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    Text(text = "Save")
                }
            }
        }
    }

}