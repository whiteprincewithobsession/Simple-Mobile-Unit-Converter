package com.example.simpleconverter.android

class PremiumFeaturesImpl : PremiumFeatures {
    override val isPremium: Boolean = BuildConfig.IS_PREMIUM
}