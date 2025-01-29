package com.example.simpleconverter.android

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.simpleconverter.models.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString

@Composable
fun DataScreen(viewModel: ConverterViewModel, modifier: Modifier = Modifier, premiumFeatures: PremiumFeatures,) {
    val clipboardManager = LocalClipboardManager.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    UnitCategory.values().forEach { category ->
                        Button(
                            onClick = { viewModel.changeCategory(category) },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (category == viewModel.currentCategory)
                                    MaterialTheme.colorScheme.primary
                                else
                                    MaterialTheme.colorScheme.secondary
                            )
                        ) {
                            Text(category.name)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                )
                {
                    Column {
                        Text("From:", style = MaterialTheme.typography.bodyLarge)
                        UnitsDropdownMenu(
                            currentUnit = viewModel.fromUnit,
                            category = viewModel.currentCategory,
                            onUnitSelected = { viewModel.changeFromUnit(it) }
                        )
                    }

                    Column {
                        Text("To:", style = MaterialTheme.typography.bodyLarge)
                        UnitsDropdownMenu(
                            currentUnit = viewModel.toUnit,
                            category = viewModel.currentCategory,
                            onUnitSelected = { viewModel.changeToUnit(it) }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                /*Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Input: ",
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Text(
                        text = viewModel.inputValue,
                        style = MaterialTheme.typography.headlineMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(
                        onClick = {
                            clipboardManager.setText(AnnotatedString(viewModel.inputValue))
                        },
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_copy),
                            contentDescription = "Copy Input"
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Result: ",
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Text(
                        text = viewModel.convertedValue,
                        style = MaterialTheme.typography.headlineMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(
                        onClick = {
                            clipboardManager.setText(AnnotatedString(viewModel.convertedValue))
                        },
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_copy),
                            contentDescription = "Copy Result"
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    IconButton(onClick = { viewModel.switchUnits() }, Modifier
                        .size(32.dp)
                        .clip(RectangleShape)) {
                        Icon(
                            painter = painterResource(R.drawable.ic_swap),
                            contentDescription = "Swap",
                            Modifier.size(48.dp)
                        )
                    }
                }
            }
        }
    }
}*/
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Input: ",
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Text(
                        text = viewModel.inputValue,
                        style = MaterialTheme.typography.headlineMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    if (premiumFeatures.isPremium) {
                        IconButton(
                            onClick = {
                                clipboardManager.setText(AnnotatedString(viewModel.inputValue))
                            },
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_copy),
                                contentDescription = "Copy Input"
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Result: ",
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Text(
                        text = viewModel.convertedValue,
                        style = MaterialTheme.typography.headlineMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    if (premiumFeatures.isPremium) {
                        IconButton(
                            onClick = {
                                clipboardManager.setText(AnnotatedString(viewModel.convertedValue))
                            },
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_copy),
                                contentDescription = "Copy Result"
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                if (premiumFeatures.isPremium) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        IconButton(
                            onClick = { viewModel.switchUnits() },
                            Modifier
                                .size(32.dp)
                                .clip(RectangleShape)
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_swap),
                                contentDescription = "Swap",
                                Modifier.size(48.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun UnitsDropdownMenu(
    currentUnit: Enum<*>,
    category: UnitCategory,
    onUnitSelected: (Enum<*>) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        Button(onClick = { expanded = true }) {
            Text(currentUnit.name)
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            val units = when (category) {
                UnitCategory.DISTANCE -> DistanceUnit.values()
                UnitCategory.WEIGHT -> WeightUnit.values()
                UnitCategory.VOLUME -> VolumeUnit.values()
            }

            units.forEach { unit ->
                DropdownMenuItem(
                    text = { Text(unit.name) },
                    onClick = {
                        onUnitSelected(unit)
                        expanded = false
                    }
                )
            }
        }
    }
}