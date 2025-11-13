package kuzina.com.ui.screens.onboardings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kuzina.com.R

@Composable
fun IndicatorUI(
    PageSize : Int,
    currentPage : Int,
    selectedColor: Color = colorResource(id = R.color.primaryColor),
    unselectedColor: Color =colorResource(id = R.color.unselected)
){

    Row(horizontalArrangement = Arrangement.SpaceBetween){
        repeat(PageSize){
            Spacer(modifier = Modifier.size(10.dp))

            Box( modifier = Modifier
                .height(12.dp)
                .width(width =  12.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(color = if (it == currentPage) selectedColor else unselectedColor),
            )

            Spacer(modifier = Modifier.size(10.dp))

        }


    }

}

@Preview(showBackground = true)
@Composable
fun IndicatorUIPreview1(){
    IndicatorUI(3,0)
}
@Preview(showBackground = true)
@Composable
fun IndicatorUIPreview2(){
    IndicatorUI(3,1)

}
@Preview(showBackground = true)
@Composable
fun IndicatorUIPreview3(){
    IndicatorUI(3,2)

}