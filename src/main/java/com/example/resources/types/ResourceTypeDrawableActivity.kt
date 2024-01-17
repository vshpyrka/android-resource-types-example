package com.example.resources.types

import android.graphics.Shader
import android.graphics.drawable.*
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.resources.R
import com.example.resources.databinding.ActivityResourceTypeDrawableBinding

class ResourceTypeDrawableActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResourceTypeDrawableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResourceTypeDrawableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gifDrawable = ContextCompat.getDrawable(this, R.drawable.android_google)

        binding.gif.setOnClickListener {
            showViews(image = true)

            binding.image.setImageDrawable(gifDrawable)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                if (gifDrawable is AnimatedImageDrawable) {
                    gifDrawable.start()
                }
            } else {
                TODO("VERSION.SDK_INT < P")
            }
        }

        // Bitmap from raw is not compressed by AAPT
        val originalBitmapDrawable = BitmapDrawable(
            resources,
            resources.openRawResource(R.raw.android_pie)
        )

        binding.raw.setOnClickListener {
            showViews(image = true)

            binding.image.setImageDrawable(originalBitmapDrawable)
        }

        binding.xml.setOnClickListener {
            showViews(image = true)

            binding.image.setImageResource(R.drawable.drawable_bitmap_android_oreo_drawable)
        }

        binding.xmlTile.setOnClickListener {
            showViews(view = true)

            val drawable = ContextCompat.getDrawable(this, R.drawable.ic_android) as BitmapDrawable
            drawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT)
            binding.view.background = drawable
        }

        binding.ninePatch.setOnClickListener {
            showViews(view2 = true)

            val background =
                ContextCompat.getDrawable(this, R.drawable.highlight_selected) as NinePatchDrawable
            binding.view2.background = background
        }

        binding.ninePatchXml.setOnClickListener {
            showViews(view2 = true)

            val background =
                ContextCompat.getDrawable(
                    this,
                    R.drawable.drawable_nine_patch_xml
                ) as NinePatchDrawable
            binding.view2.background = background
        }

        // All drawable items are scaled to fit the size of the containing View, by default.
        // Thus, placing your images in a layer list at different positions might increase
        // the size of the View and some images scale as appropriate.
        binding.layerListDrawable.setOnClickListener {
            showViews(image = true)

            val layerListDrawable =
                ContextCompat.getDrawable(
                    this,
                    R.drawable.drawable_layer_list_drawable
                ) as LayerDrawable

            /*
            val layerListDrawable2 = LayerDrawable(
                arrayOf(ContextCompat.getDrawable(this, R.drawable.ic_android))
            )
             */

            binding.image.setImageDrawable(layerListDrawable)
        }

        binding.layerListBitmap.setOnClickListener {
            showViews(image = true)

            val layerListDrawable =
                ContextCompat.getDrawable(
                    this,
                    R.drawable.drawable_layer_list_bitmap
                ) as LayerDrawable

            /*
            val layerListDrawable2 = LayerDrawable(
                arrayOf(
                    (ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_android
                    ) as BitmapDrawable).apply {
                        gravity = Gravity.CENTER
                    },
                    (ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_android
                    ) as BitmapDrawable).apply {
                        gravity = Gravity.CENTER
                    },
                    (ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_android
                    ) as BitmapDrawable).apply {
                        gravity = Gravity.CENTER
                    }
                )
            )
            layerListDrawable2.setLayerInset(1, 60, 60, 0, 0)
            layerListDrawable2.setLayerInset(2, 120, 120, 0, 0)
             */

            binding.image.setImageDrawable(layerListDrawable)
        }

        binding.stateList.setOnClickListener {
            showViews(button = true)

            val stateListDrawable =
                ContextCompat.getDrawable(this, R.drawable.drawable_selector) as StateListDrawable

            /*
            val pressed = ContextCompat.getDrawable(this, R.drawable.highlight_pressed)
            val disabled = ContextCompat.getDrawable(this, R.drawable.highlight_disabled)
            val selected = ContextCompat.getDrawable(this, R.drawable.highlight_selected)

            val stateListDrawable2 = StateListDrawable()
            stateListDrawable2.addState(
                intArrayOf(android.R.attr.state_pressed),
                pressed
            )
            stateListDrawable2.addState(
                intArrayOf(android.R.attr.state_focused),
                disabled
            )
            stateListDrawable2.addState(
                intArrayOf(android.R.attr.state_hovered),
                disabled
            )
            stateListDrawable2.addState(
                StateSet.WILD_CARD,
                selected
            )
             */

            binding.button.background = stateListDrawable
            binding.button.setOnClickListener {
            }
        }

        binding.levelList.setOnClickListener {
            if (!binding.image.isVisible) {
                showViews(image = true)

                val levelListDrawable = ContextCompat.getDrawable(
                    this,
                    R.drawable.drawable_level_list
                ) as LevelListDrawable
                levelListDrawable.level = 1

                /*
                val levelListDrawable2 = LevelListDrawable()
                levelListDrawable2.addLevel(0, 1 , ContextCompat.getDrawable(this, R.drawable.ic_lockscreen_google_normal))
                levelListDrawable2.addLevel(0, 2 , ContextCompat.getDrawable(this, R.drawable.ic_lockscreen_google_focused))
                levelListDrawable2.addLevel(0, 3 , ContextCompat.getDrawable(this, R.drawable.ic_lockscreen_google_activated))
                levelListDrawable2.level = 1
                 */

                binding.image.setImageDrawable(levelListDrawable)
            } else {
                val drawable = binding.image.drawable
                if (drawable is LevelListDrawable) {
                    if (drawable.level <= 2) { // max == 3
                        drawable.level += 1
                    }
                }
            }
        }

        binding.transition.setOnClickListener {
            showViews(view2 = true)

            // Works only with 2 bitmaps/drawables
            val transitionDrawable = ContextCompat.getDrawable(
                this,
                R.drawable.drawable_transition
            ) as TransitionDrawable

            /*
            val layer1 = ContextCompat.getDrawable(this, R.drawable.ic_lockscreen_google_normal) as BitmapDrawable
            layer1.setTint(Color.parseColor("#208020"))
            val layer2 = ContextCompat.getDrawable(this, R.drawable.ic_lockscreen_google_focused) as BitmapDrawable
            layer2.setTint(Color.parseColor("#208020"))
            val transitionDrawable2 = TransitionDrawable(
                arrayOf(
                    layer1,
                    layer2
                )
            )
             */

            binding.view2.background = transitionDrawable
            transitionDrawable.startTransition(1500)
        }

        binding.inset.setOnClickListener {
            showViews(view2 = true)

            val insetDrawable = ContextCompat.getDrawable(this, R.drawable.drawable_inset)
            binding.view2.background = insetDrawable
        }

        binding.clip.setOnClickListener {
            showViews(view2 = true)
            val layerDrawable =
                ContextCompat.getDrawable(this, R.drawable.drawable_clip) as LayerDrawable
            val progressDrawableClip =
                layerDrawable.findDrawableByLayerId(android.R.id.progress) as ClipDrawable
            val secondaryProgressDrawableClip =
                layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress) as ClipDrawable
            secondaryProgressDrawableClip.level = 8000
            progressDrawableClip.level = 5000
            binding.view2.background = layerDrawable
        }

        binding.scale.setOnClickListener {
            showViews(view2 = true)
            val layerDrawable =
                ContextCompat.getDrawable(this, R.drawable.drawable_scale) as LayerDrawable
            val progressDrawableClip =
                layerDrawable.findDrawableByLayerId(android.R.id.progress) as ScaleDrawable
            val secondaryProgressDrawableClip =
                layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress) as ScaleDrawable
            // Values in xml sets the max available width/height scale properties
            // Values here set the level based on max width/height scale properties
            secondaryProgressDrawableClip.level = 8000
            progressDrawableClip.level = 5000
            binding.view2.background = layerDrawable
        }

        binding.shape.setOnClickListener {
            showViews(view2 = true)

            /*
            val drawable2 = GradientDrawable(
                GradientDrawable.Orientation.BL_TR,
                intArrayOf(
                    Color.parseColor("#0189ff"),
                    Color.parseColor("#01f1fa")
                )
            )
            drawable2.gradientType = GradientDrawable.LINEAR_GRADIENT
            drawable2.setGradientCenter(0f, 0f)
            drawable2.setStroke(5, Color.WHITE)
            drawable2.cornerRadii = floatArrayOf(
                100f,
                100f,
                100f,
                100f,
                40f,
                40f,
                100f,
                100f
            )
             */

            val drawable = ContextCompat.getDrawable(this, R.drawable.drawable_shape)
            binding.view2.background = drawable
        }
    }

    private fun showViews(
        image: Boolean = false,
        view: Boolean = false,
        view2: Boolean = false,
        button: Boolean = false
    ) {
        binding.image.isVisible = image
        binding.view.isVisible = view
        binding.view2.isVisible = view2
        binding.button.isVisible = button
    }
}
