package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // It's a lambda function
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
}

// --- (07-07-2024)

// Stack trash shown the function call made to reached a certain line of code.

// Step over:- it tells the debugger to execute the next line of code, if there is
// other break point it goes to that break point.

// Step into:- it will step into the function where break point is set (it will dig dip
// and show you what will execute when the function calls where the break point was set).

// Step out:- it is the opposite of step into.


@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)                      // It's a new way to align content
    )
}

// child composable uses the parent modifies object, and at the time of
// calling we have to pass a new modifier object

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    // The modifier argument ensures that the composables in the Column() function adhere
    // to the constraints called on the modifier instance.

    // The remember composable requires a function to be passed.
    // Composable functions can store an object in memory using the remember
    // composable.

    // The mutableStateOf() function returns an observable. You learn more
    // about observables later, but for now this basically means that when
    // the value of the result variable changes, a recomposition is triggered,
    // the value of the result is reflected, and the UI refreshes.
//    var result by remember { mutableStateOf(1) }
//    val imageResource = when (result) {
//        1 -> R.drawable.dice_1
//        2 -> R.drawable.dice_2
//        3 -> R.drawable.dice_3
//        4 -> R.drawable.dice_4
//        5 -> R.drawable.dice_5
//        else -> R.drawable.dice_6
//    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(imageResource),
            contentDescription = imageResource.toString()
        )

        Spacer(modifier = Modifier.height(16.dp))           // new learning

        Button(onClick = { result = (1..6).random() }) {        // new
            Text(text = stringResource(id = R.string.roll))
        }
    }
}







