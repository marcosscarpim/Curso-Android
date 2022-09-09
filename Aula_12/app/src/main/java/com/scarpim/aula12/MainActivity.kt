package com.scarpim.aula12

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.scarpim.aula12.ui.theme.Aula12Theme

data class VntTask(val id: Int, val label: String)

private val myTaskList = List(20) { i -> VntTask(i, "Task # $i") }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Aula12Theme {
                val mutableTaskList = remember { myTaskList.toMutableStateList() }
                VntMessageList(mutableTaskList) { task ->
                    mutableTaskList.remove(task)
                }
            }
        }
    }
}

@Composable
fun VntMessageList(
    tasks: List<VntTask>,
    onDismissed: (VntTask) -> Unit
) {
    LazyColumn {
        items(tasks, key = { task -> task.id }) { task ->
            VntMessageItem(taskLabel = task.label) {
                onDismissed(task)
            }
        }
    }
}

@Composable
fun VntMessageItem(
    taskLabel: String,
    onDismiss: () -> Unit
) {
    var isChecked by remember { mutableStateOf(false) }
    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .swipeToDismiss(onDismiss, shouldDismiss = !isChecked),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = taskLabel)
        Checkbox(
            checked = isChecked,
            onCheckedChange = { checked ->
                isChecked = checked
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Aula12Theme {
        VntMessageList(myTaskList) {}
    }
}