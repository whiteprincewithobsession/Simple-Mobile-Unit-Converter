package com.example.simpleconverter.android

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                ConverterApp()
            }
        }
    }
}

@Composable
fun ConverterApp(premiumFeatures: PremiumFeatures = PremiumFeaturesImpl()) {
    val viewModel: ConverterViewModel = viewModel()
    val orientation = LocalConfiguration.current.orientation

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                DataScreen(
                    viewModel = viewModel,
                    premiumFeatures = premiumFeatures,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                )
                NumPadScreen(
                    viewModel = viewModel,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
            }
        } else {
            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                DataScreen(
                    viewModel = viewModel,
                    premiumFeatures = premiumFeatures,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                )
                NumPadScreen(
                    viewModel = viewModel,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                )
            }
        }
    }
}