package np.com.ravikant.hamrobill

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

/**
 * enum values that represent the screens in the app
 */
enum class BillScreen(@StringRes val title: Int) {
    Main(title = R.string.app_name),
    List(title = R.string.app_name),
    Add(title = R.string.add_event),
    Submit(title = R.string.submit_event)
}

/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@Composable
fun BillAppBar(
    currentScreen: BillScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun HamroBillApp(
//    viewModel: OrderViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = BillScreen.valueOf(
        backStackEntry?.destination?.route ?: BillScreen.List.name
    )
    NavHost(
        navController = navController,
        startDestination = BillScreen.Main.name,
    ) {

        composable(route = BillScreen.Main.name) {
            MainScreen(
                navController = navController, currentScreen = currentScreen,
            )
        }
        composable(route = BillScreen.List.name) {
            EventListScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dimensionResource(R.dimen.padding_medium))
            )
        }
        composable(route = BillScreen.Add.name) {
            AddEventScreenList(
                onNextButtonClicked = { navController.navigate(BillScreen.Add.name) },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dimensionResource(R.dimen.padding_medium))
            )
        }

    }


}

@Composable
fun MainScreen(navController: NavHostController, currentScreen: BillScreen, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            BillAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(BillScreen.Add.name)
            }, shape = CircleShape) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        EventListScreen(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )

    }
}
