package kuzina.com.data.model

import androidx.annotation.DrawableRes
import kuzina.com.R


sealed class OnboardingModel(
    @DrawableRes val Image : Int,
    val title : Int,
    val description : Int
    ){

    data object FirstPages : OnboardingModel(
        Image = R.drawable.onboarding1,
        title = R.string.first_title,
        description = R.string.first_desc
    )

    data object SecondPages : OnboardingModel(
        Image = R.drawable.onboarding2,
        title = R.string.second_title,
        description = R.string.second_desc
    )

    data object ThirdPages : OnboardingModel(
        Image = R.drawable.onboarding3,
        title = R.string.third_title,
        description = R.string.third_desc
    )



}