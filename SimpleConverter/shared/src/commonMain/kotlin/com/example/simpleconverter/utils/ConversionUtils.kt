package com.example.simpleconverter.utils

import com.example.simpleconverter.models.*

fun convert(value: Double, fromUnit: Enum<*>, toUnit: Enum<*>): Double {
    val fromMultiplier = (fromUnit as? DistanceUnit)?.multiplier
        ?: (fromUnit as? WeightUnit)?.multiplier
        ?: (fromUnit as? VolumeUnit)?.multiplier
        ?: 1.0

    val toMultiplier = (toUnit as? DistanceUnit)?.multiplier
        ?: (toUnit as? WeightUnit)?.multiplier
        ?: (toUnit as? VolumeUnit)?.multiplier
        ?: 1.0

    return value * fromMultiplier / toMultiplier
}