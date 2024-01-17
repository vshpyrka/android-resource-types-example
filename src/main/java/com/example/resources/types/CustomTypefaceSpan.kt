package com.example.resources.types

import android.graphics.Paint
import android.graphics.Typeface
import android.text.TextPaint
import android.text.style.TypefaceSpan

/**
 * CustomTypefaceSpan allows for the use of a non-framework font supplied in the
 * assets/fonts directory of the application. Use this class whenever the
 * framework does not contain a needed font.
 */
class CustomTypefaceSpan(
    family: String,
    private val type: Typeface,
    private val size: Float,
    private val color: Int
) : TypefaceSpan(family) {

    override fun updateMeasureState(paint: TextPaint) {
        applyCustomTypeFace(paint, type, size, color)
    }

    override fun updateDrawState(ds: TextPaint) {
        applyCustomTypeFace(ds, type, size, color)
    }

    private fun applyCustomTypeFace(ds: Paint, type: Typeface, size: Float, color: Int) {
        val old = ds.typeface
        val oldStyle = old?.style ?: 0
        val fake = oldStyle and type.style.inv()
        if (fake and Typeface.BOLD != 0) {
            ds.isFakeBoldText = true
        }

        if (fake and Typeface.ITALIC != 0) {
            ds.textSkewX = -0.25f
        }
        ds.textSize = size
        ds.color = color
        ds.typeface = type
    }
}
