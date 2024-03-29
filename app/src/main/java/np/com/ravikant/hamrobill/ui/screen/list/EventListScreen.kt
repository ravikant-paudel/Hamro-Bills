package np.com.ravikant.hamrobill.ui.screen.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import np.com.ravikant.hamrobill.domain.model.Note

@Composable
fun EventListScreen(
    modifier: Modifier = Modifier,
    noteList: List<Note>,
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(noteList.size) { i ->
            ListItem(
                modifier = Modifier.clickable {
                    // no way to get headlineContent and supportingContent here
                },
                headlineContent = {
                    Text(
                        text = noteList[i].title,
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                supportingContent = {
                    Text(
                        text = noteList[i].content,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                },
            )
        }
    }

//    LazyColumn(modifier = modifier) {
//        items(8) { index ->
//            EventRow(index)
//        }
//    }
}

@Composable
fun EventRow(index: Int) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Column(Modifier.padding(all = 16.dp)) {
            Text(text = "${index + 1}.  Sat 16th March - Cost")
            Spacer(modifier = Modifier.height(10.dp))
            Text("Location")
            Spacer(modifier = Modifier.height(10.dp))
            Text("Total")

        }
    }
}