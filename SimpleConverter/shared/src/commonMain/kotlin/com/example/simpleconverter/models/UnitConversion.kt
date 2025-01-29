package com.example.simpleconverter.models

enum class UnitCategory {
    DISTANCE, WEIGHT, VOLUME
}

enum class DistanceUnit(val multiplier: Double) {
    METER(1.0), KILOMETER(1000.0), MILE(1609.34)
}

enum class WeightUnit(val multiplier: Double) {
    GRAM(1.0), KILOGRAM(1000.0), POUND(453.592)
}

enum class VolumeUnit(val multiplier: Double) {
    LITER(1.0), MILLILITER(0.001), GALLON(3.78541)
}