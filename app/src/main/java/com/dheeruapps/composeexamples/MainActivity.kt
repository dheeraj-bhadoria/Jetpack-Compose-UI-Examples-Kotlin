package com.dheeruapps.composeexamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.tooling.preview.Preview
import com.dheeruapps.composeexamples.ui.theme.ComposeExamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExamplesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BadgeBoxDemo()
                }
            }
        }
    }
}


@Composable
fun AlertDialogSample() {
    MaterialTheme {
        Column {
            val openDialog = remember { mutableStateOf(false)  }

            Button(onClick = {
                openDialog.value = true
            }) {
                Text("Click me")
            }

            if (openDialog.value) {

                AlertDialog(
                    onDismissRequest = {
                        openDialog.value = false
                    },
                    title = {
                        Text(text = "Dialog Title Will Show Here")
                    },
                    text = {
                        Text("Here is a description text of the dialog")
                    },
                    confirmButton = {
                        Button(

                            onClick = {
                                openDialog.value = false
                            }) {
                            Text("Confirm Button")
                        }
                    },
                    dismissButton = {
                        Button(

                            onClick = {
                                openDialog.value = false
                            }) {
                            Text("Dismiss Button")
                        }
                    }
                )
            }
        }

    }
}

@Composable
fun BadgeBoxDemo() {
    BottomNavigation {
        BottomNavigationItem(
            icon = {
                BadgedBox(badge = { Badge { Text("8") } }) {
                    Icon(
                        Icons.Filled.Home,
                        contentDescription = "Home"
                    )
                }

            },
            selected = false,
            onClick = {})

        BottomNavigationItem(
            icon = {
                BadgedBox(badge = { Badge { Text("4") } }) {
                    Icon(
                        Icons.Filled.Call,
                        contentDescription = "CALL"
                    )
                }

            },
            selected = false,
            onClick = {})

        BottomNavigationItem(
            icon = {
                BadgedBox(badge = { Badge { Text("8") } }) {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = "Favorite"
                    )
                }

            },
            selected = false,
            onClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeExamplesTheme {
        AlertDialogSample()
    }
}