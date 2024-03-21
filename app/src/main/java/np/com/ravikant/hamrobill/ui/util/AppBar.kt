package np.com.ravikant.hamrobill.ui.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import np.com.ravikant.hamrobill.R


/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@Composable
fun HamroBillAppBar(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,
    canNavigateBack: Boolean = false,
    navigateUp: (() -> Unit)? = null,
) {
    TopAppBar(
        title = title,
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = { navigateUp?.invoke() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}