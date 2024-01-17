package com.example.resources

import android.icu.text.Transliterator
import org.junit.Assert.assertEquals
import org.junit.Test

class TransliterationTest {

    @Test
    fun testAnyUpper() {
        val t = Transliterator.getInstance("Any-Upper")
        assertEquals("HELLO WORLD!", t.transliterate("HeLlO WoRlD!"))
        assertEquals("STRASSE", t.transliterate("Straße"))
    }

    @Test
    fun testAnyLower() {
        val t = Transliterator.getInstance("Any-Lower")
        assertEquals("hello world!", t.transliterate("HeLlO WoRlD!"))
    }

    @Test
    fun testGreekLatin() {
        val greek = "Καλημέρα κόσμε!"

        // Transliterate Greek to Latin, then to plain ASCII.
        var t = Transliterator.getInstance("Greek-Latin")
        val latin = t.transliterate(greek)
        t = Transliterator.getInstance("Latin-Ascii")
        val ascii = t.transliterate(latin)
        assertEquals("Kalēméra kósme!", latin)
        assertEquals("Kalemera kosme!", ascii)

        // Use alternative transliteration variants.
        t = Transliterator.getInstance("Greek-Latin/BGN")
        assertEquals("Kaliméra kósme!", t.transliterate(greek))
        t = Transliterator.getInstance("Greek-Latin/UNGEGN")
        assertEquals("Kali̱méra kósme!", t.transliterate(greek))
    }

    @Test
    fun testHanLatin() {
        var t = Transliterator.getInstance("Han-Latin")
        assertEquals("hàn zì/hàn zì", t.transliterate("汉字/漢字"))
        assertEquals("shěn", t.transliterate("\u700b"))
        assertEquals("jiǎ", t.transliterate("\u8d3e"))
        t = Transliterator.getInstance("Han-Latin/Names")
        assertEquals("shěn", t.transliterate("\u6c88"))
        assertEquals("shěn", t.transliterate("\u700b"))
        assertEquals("jiǎ", t.transliterate("\u8d3e"))
        t = Transliterator.getInstance("Han-Latin/Names; Latin-Ascii; Any-Upper")
        assertEquals("SHEN", t.transliterate("\u6c88"))
        assertEquals("SHEN", t.transliterate("\u700b"))
        assertEquals("JIA", t.transliterate("\u8d3e"))
    }
}
