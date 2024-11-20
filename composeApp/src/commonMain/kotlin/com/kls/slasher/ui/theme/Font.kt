package com.kls.slasher.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import slasher.composeapp.generated.resources.Res
import slasher.composeapp.generated.resources.slasher_font

@OptIn(ExperimentalResourceApi::class)
@Composable
fun SlasherFontFamily() = FontFamily(
    Font(Res.font.slasher_font, weight = FontWeight.Normal)
)