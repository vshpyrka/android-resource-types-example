# android-resource-types-example

Example of various Android resources usage

[DrawableLocalizedResourceActivity](https://github.com/vshpyrka/android-resource-types-example/blob/main/src/main/java/com/example/resources/DrawableLocalizedResourceActivity.kt) - Example of how to use drawable resources with the a name and have multiple resource aliases used in different locales to display different resource drawables with the same name.

```
<ImageView
        android:id="@+id/imageView"
        android:layout_width="200dp"
        android:layout_height="200dp"
        app:srcCompat="@drawable/ic_accessibility" />
```
Default _drawable/ic_accessibility_ points to a default vector image
```
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="24dp"
    android:height="24dp"
    android:viewportWidth="24"
    android:viewportHeight="24"
    android:tint="?attr/colorControlNormal">
  <path
      android:fillColor="@android:color/white"
      android:pathData="M12,2c1.1,0 2,0.9 2,2s-0.9,2 -2,2 -2,-0.9 -2,-2 0.9,-2 2,-2zM21,9h-6v13h-2v-6h-2v6L9,22L9,9L3,9L3,7h18v2z"/>
</vector>

```
Separate locale based resource directory _en-rCA/ic_accessibility_ contains resource file that has alias to a different drawable resource but with the same drawable name as default one.
```
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <drawable name="ic_accessibility">@drawable/ic_accessibility_new</drawable>
</resources>
```

[RTLResourceActivity](https://github.com/vshpyrka/android-resource-types-example/blob/main/src/main/java/com/example/resources/RTLResourceActivity.kt) - Example of how to support RTL layouts.
```
/**
 * android:supportsRtl - AndroidManifest.xml flag. Declares whether your application is willing to support right-to-left (RTL) layouts.
 * layout-ldrtl - "layout-direction-right-to-left", default implicit value, generic layout for any other "right-to-left" language (like Persian or Hebrew)
 * layout-ar - specific layout for the Arabic language
 */
```
[ConfigurationChangeActivity](https://github.com/vshpyrka/android-resource-types-example/blob/main/src/main/java/com/example/resources/ConfigurationChangeActivity.kt) - Example of how to override default behavior of configuration change and have own implementation of handling such event.

[InternationalizationResourceActivity](https://github.com/vshpyrka/android-resource-types-example/blob/main/src/main/java/com/example/resources/InternationalizationResourceActivity.kt) - Example of how to use Android [Transliterator](https://developer.android.com/reference/android/icu/text/Transliterator) instance to provide transliterated text.

[ComplexXMLResourceActivity](https://github.com/vshpyrka/android-resource-types-example/blob/main/src/main/java/com/example/resources/ComplexXMLResourceActivity.kt) - Example of how to write single complex and reusable animated vector resource.
```
<?xml version="1.0" encoding="utf-8"?>
<animated-vector xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:aapt="http://schemas.android.com/aapt" >

    <aapt:attr name="android:drawable" >
        <vector
            android:height="64dp"
            android:width="64dp"
            android:viewportHeight="600"
            android:viewportWidth="600" >
            <group
                android:name="rotationGroup"
                android:pivotX="300.0"
                android:pivotY="300.0"
                android:rotation="45.0" >
                <path
                    android:fillColor="#000000"
                    android:pathData="M300,70 l 0,-70 70,70 0,0 -70,70z" />
            </group>
        </vector>
    </aapt:attr>

    <target android:name="rotationGroup">
        <aapt:attr name="android:animation" >
            <objectAnimator
                android:duration="6000"
                android:propertyName="rotation"
                android:valueFrom="0"
                android:valueTo="360" />
        </aapt:attr>
    </target>
</animated-vector>
```

### Resource Types

[ResourceTypeAnimActivity](https://github.com/vshpyrka/android-resource-types-example/blob/main/src/main/java/com/example/resources/types/ResourceTypeAnimActivity.kt) - Example of how View and Property animations with interpolations can be used

https://github.com/vshpyrka/android-resource-types-example/assets/2741602/e0a076a1-fb62-40b2-9287-5d7558e27cb2

[ResourceTypeColorStateListActivity](https://github.com/vshpyrka/android-resource-types-example/blob/main/src/main/java/com/example/resources/types/ResourceTypeColorStateListActivity.kt) - Example of how to use ColorStateList to display different UI representation depending on current view state.

https://github.com/vshpyrka/android-resource-types-example/assets/2741602/5294341a-c624-4bdf-a6c3-f339edf47191

[ResourceTypeDrawableActivity](https://github.com/vshpyrka/android-resource-types-example/blob/main/src/main/java/com/example/resources/types/ResourceTypeDrawableActivity.kt) - Example of how to use Drawable resources.

https://github.com/vshpyrka/android-resource-types-example/assets/2741602/ff53614d-54b7-4225-b30c-15f43bb2879d

[ResourceTypeMenuActivity](https://github.com/vshpyrka/android-resource-types-example/blob/main/src/main/java/com/example/resources/types/ResourceTypeMenuActivity.kt) - Example of how to use Menu and SubMenu elements.

https://github.com/vshpyrka/android-resource-types-example/assets/2741602/8ce12866-757e-4bdd-b6b4-a96e63f3f1b0

[ResourceTypeStringActivity](https://github.com/vshpyrka/android-resource-types-example/blob/main/src/main/java/com/example/resources/types/ResourceTypeStringActivity.kt) - Example of how to use String resources, Spannables, Annotations, HTML markups.

https://github.com/vshpyrka/android-resource-types-example/assets/2741602/2bf6f962-3201-4571-b023-46a92b1a89c0

[ResourceTypeFontActivity](https://github.com/vshpyrka/android-resource-types-example/blob/main/src/main/java/com/example/resources/types/ResourceTypeFontActivity.kt) - Example of how to use Font and Font-Family from font resource specific xml configuration.

Example:
```
<?xml version="1.0" encoding="utf-8"?>
<font-family xmlns:android="http://schemas.android.com/apk/res/android">
    <font
        android:font="@font/roboto_thin_normal"
        android:fontStyle="normal"
        android:fontWeight="400" />
    <font
        android:font="@font/roboto_thin_italic"
        android:fontStyle="italic"
        android:fontWeight="400" />
</font-family>
```

[ResourceTypeMoreActivity](https://github.com/vshpyrka/android-resource-types-example/blob/main/src/main/java/com/example/resources/types/ResourceTypeMoreActivity.kt) - Example of how to read different resource types values

Example:

```
        val booleanValue = resources.getBoolean(R.bool.resource_type_boolean)
        val colorValue = resources.getColor(R.color.resource_type_color, theme)
        val dimenValue = resources.getDimension(R.dimen.resource_type_dimen)
        val idValue = R.id.resource_type_id
        val intValue = resources.getInteger(R.integer.resource_type_integer)
        val intArray = resources.getIntArray(R.array.resource_type_integer_array)
        val typedArrayValue = resources.obtainTypedArray(R.array.resource_type_typed_array)
        val typedArrayDrawable = typedArrayValue.getDrawable(0)
        val typedArrayColor = typedArrayValue.getColor(2, 0)
```



