package com.example.simpleconverter.android

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NumPadScreen(viewModel: ConverterViewModel, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(9) { index ->
                NumPadButton(
                    text = (index + 1).toString(),
                    onClick = { viewModel.appendInput(it) }
                )
            }
            item { NumPadButton(text = ".", onClick = { viewModel.appendInput(it) }) }
            item { NumPadButton(text = "0", onClick = { viewModel.appendInput(it) }) }
            item { NumPadButton(text = "C", onClick = { viewModel.clearInput() }) }
        }
    }
}

@Composable
fun NumPadButton(text: String, onClick: (String) -> Unit) {
    Button(
        onClick = { onClick(text) },
        modifier = Modifier
            .size(85.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent, contentColor = Color.DarkGray)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.displayMedium

        )
    }
}