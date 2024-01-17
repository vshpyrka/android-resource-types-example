package com.example.resources.types

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.*
import android.text.Annotation
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.text.HtmlCompat
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_LEGACY
import androidx.core.text.getSpans
import com.example.resources.R
import com.example.resources.databinding.ActivityResourceTypeStringBinding

class ResourceTypeStringActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResourceTypeStringBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.htmlMarkup.setOnClickListener {
            binding.text.text =
                HtmlCompat.fromHtml(getString(R.string.html_markup), FROM_HTML_MODE_LEGACY)
        }

        binding.formattedHtmlMarkup.setOnClickListener {
            val text: String = getString(R.string.html_markup2, "John", 200)
            binding.text.text = HtmlCompat.fromHtml(text, FROM_HTML_MODE_LEGACY)
        }

        binding.encodedHtmlMarkup.setOnClickListener {
            val username = "<john.doe@gmail.com>"
            val escapedUsername: String = TextUtils.htmlEncode(username)
            val text: String = getString(R.string.html_markup3, escapedUsername, 200)
            binding.text.text = HtmlCompat.fromHtml(text, FROM_HTML_MODE_LEGACY)
        }

        binding.spannable.setOnClickListener {
            val text: CharSequence = bold(
                italic("Hello"),
                color(Color.RED, "World")
            )
            binding.text.text = text
        }

        binding.annotation.setOnClickListener {
            // get the text as SpannedString so we can get the spans attached to the text
            val string = getText(R.string.annotation_string) as SpannedString
            val annotations = string.getSpans<Annotation>(0, string.length)

            // create a copy of the title text as a SpannableString.
            // the constructor copies both the text and the spans. so we can add and remove spans
            val spannableString = SpannableString(string)

            for (annotation in annotations) {
                if (annotation.key == "font") {
                    if (annotation.value == "title_emphasis") {
                        val typeface = ResourcesCompat.getFont(this, R.font.roboto_regular)
                        typeface?.let {
                            spannableString.setSpan(
                                CustomTypefaceSpan(
                                    family = "roboto",
                                    type = it,
                                    size = 50f,
                                    color = Color.RED
                                ),
                                string.getSpanStart(annotation),
                                string.getSpanEnd(annotation),
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                            )
                        }
                    }
                }
            }

            binding.text.text = spannableString
        }
    }
}


/**
 * Returns a CharSequence that concatenates the specified array of CharSequence
 * objects and then applies a list of zero or more tags to the entire range.
 *
 * @param content an array of character sequences to apply a style to
 * @param tags the styled span objects to apply to the content
 *        such as android.text.style.StyleSpan
 */
private fun apply(content: Array<out CharSequence>, vararg tags: Any): CharSequence {
    return SpannableStringBuilder().apply {
        openTags(tags)
        content.forEach { charSequence ->
            append(charSequence)
        }
        closeTags(tags)
    }
}

/**
 * Iterates over an array of tags and applies them to the beginning of the specified
 * Spannable object so that future text appended to the text will have the styling
 * applied to it. Do not call this method directly.
 */
private fun Spannable.openTags(tags: Array<out Any>) {
    tags.forEach { tag ->
        setSpan(tag, 0, 0, Spannable.SPAN_MARK_MARK)
    }
}

/**
 * "Closes" the specified tags on a Spannable by updating the spans to be
 * endpoint-exclusive so that future text appended to the end will not take
 * on the same styling. Do not call this method directly.
 */
private fun Spannable.closeTags(tags: Array<out Any>) {
    tags.forEach { tag ->
        if (length > 0) {
            setSpan(tag, 0, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        } else {
            removeSpan(tag)
        }
    }
}

/**
 * Returns a CharSequence that applies boldface to the concatenation
 * of the specified CharSequence objects.
 */
fun bold(vararg content: CharSequence): CharSequence = apply(content, StyleSpan(Typeface.BOLD))

/**
 * Returns a CharSequence that applies italics to the concatenation
 * of the specified CharSequence objects.
 */
fun italic(vararg content: CharSequence): CharSequence = apply(content, StyleSpan(Typeface.ITALIC))

/**
 * Returns a CharSequence that applies a foreground color to the
 * concatenation of the specified CharSequence objects.
 */
fun color(color: Int, vararg content: CharSequence): CharSequence =
    apply(content, ForegroundColorSpan(color))
