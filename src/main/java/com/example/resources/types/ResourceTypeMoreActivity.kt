package com.example.resources.types

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.resources.R

class ResourceTypeMoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource_type_more)

        val booleanValue = resources.getBoolean(R.bool.resource_type_boolean)
        val colorValue = resources.getColor(R.color.resource_type_color, theme)
        val dimenValue = resources.getDimension(R.dimen.resource_type_dimen)
        val idValue = R.id.resource_type_id
        val intValue = resources.getInteger(R.integer.resource_type_integer)
        val intArray = resources.getIntArray(R.array.resource_type_integer_array)
        val typedArrayValue = resources.obtainTypedArray(R.array.resource_type_typed_array)
        val typedArrayDrawable = typedArrayValue.getDrawable(0)
        val typedArrayColor = typedArrayValue.getColor(2, 0)
        typedArrayValue.recycle()

        val text = with(StringBuilder()) {
            append("booleanValue $booleanValue \n")
            append("colorValue $colorValue \n")
            append("dimenValue $dimenValue \n")
            append("idValue $idValue \n")
            append("intValue $intValue \n")
            append("intArray $intArray \n")
            append("typedArrayDrawable $typedArrayDrawable \n")
            append("typedArrayColor $typedArrayColor \n")
        }
        findViewById<TextView>(R.id.text).text = text.toString()
    }
}
