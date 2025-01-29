package com.example.simpleconverter.android

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.simpleconverter.models.*
import com.example.simpleconverter.utils.convert

class ConverterViewModel : ViewModel() {
    private val _inputValue = mutableStateOf("")
    val inputValue: String get() = _inputValue.value

    private val _convertedValue = mutableStateOf("")
    val convertedValue: String get() = _convertedValue.value

    private val _currentCategory = mutableStateOf(UnitCategory.DISTANCE)
    val currentCategory: UnitCategory get() = _currentCategory.value

    private val _fromUnit = mutableStateOf<Enum<*>>(DistanceUnit.METER)
    val fromUnit: Enum<*> get() = _fromUnit.value

    private val _toUnit = mutableStateOf<Enum<*>>(DistanceUnit.KILOMETER)
    val toUnit: Enum<*> get() = _toUnit.value

    fun appendInput(value: String) {
        if (value == "." && _inputValue.value.contains(".")) return
        if (_inputValue.value.length < 12) {
            _inputValue.value = _inputValue.value + value
            updateConversion()
        }
    }

    fun clearInput() {
        _inputValue.value = ""
        _convertedValue.value = ""
    }

    fun switchUnits() {
        var temp = _fromUnit.value
        _fromUnit.value = _toUnit.value
        _toUnit.value = temp
        var temp2 = _inputValue.value
        _inputValue.value = _convertedValue.value
        _convertedValue.value = temp2
        updateConversion()
    }

    fun changeCategory(category: UnitCategory) {
        _currentCategory.value = category
        when (category) {
            UnitCategory.DISTANCE -> {
                _fromUnit.value = DistanceUnit.METER
                _toUnit.value = DistanceUnit.KILOMETER
            }
            UnitCategory.WEIGHT -> {
                _fromUnit.value = WeightUnit.GRAM
                _toUnit.value = WeightUnit.KILOGRAM
            }
            UnitCategory.VOLUME -> {
                _fromUnit.value = VolumeUnit.LITER
                _toUnit.value = VolumeUnit.MILLILITER
            }
        }
        updateConversion()
    }

    fun changeFromUnit(unit: Enum<*>) {
        _fromUnit.value = unit
        updateConversion()
    }

    fun changeToUnit(unit: Enum<*>) {
        _toUnit.value = unit
        updateConversion()
    }

    private fun updateConversion() {
        if (_inputValue.value.isEmpty()) {
            _convertedValue.value = ""
            return
        }

        try {
            val inputDouble = _inputValue.value.toDouble()
            val result = convert(inputDouble, _fromUnit.value, _toUnit.value)
            _convertedValue.value = trimTrailingZeros(String.format("%.4f", result))
        } catch (e: NumberFormatException) {
            _convertedValue.value = "Error"
        }
    }

    private fun trimTrailingZeros(value: String): String {
        return if (value.contains(".")) {
            value.trimEnd('0').trimEnd('.')
        } else {
            value
        }
    }
}