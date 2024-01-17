package com.example.resources.types

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.graphics.Color
import android.graphics.drawable.Animatable
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.updateLayoutParams
import com.example.resources.R
import com.example.resources.databinding.ActivityResourceTypeAnimBinding

/**
 * There are two types of animations:
 *      Property Animation
 *      View Animation
 *
 * 1. Property Animations: ObjectAnimator, ValueAnimator
 *      lives in "res/animator" dir
 *      appears as Animator instance
 *
 * 2. View Animations:
 *      Tween animation: translation, rotation, scale, alpha
 *          lives in "res/anim" dir
 *          appears as Animation instance
 *      Frame animation: sequence of images in order
 *          appears as AnimationDrawable instance
 *
 * Interpolator - affects the rate of change in an animation, lives in "res/anim" dir
 *      "res/my_overshoot_interpolator.xml" overrides default behavior of overshootInterpolator
 */

class ResourceTypeAnimActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResourceTypeAnimBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.propertyAnimation.setOnClickListener {
            (AnimatorInflater.loadAnimator(
                this,
                R.animator.property_animator
            ) as AnimatorSet).apply {
                setTarget(binding.image)
                start()
            }
        }

        binding.tweenAnimation.setOnClickListener {
            val hyperspaceJump: Animation =
                AnimationUtils.loadAnimation(this, R.anim.hyperspace_jump)
            binding.image.startAnimation(hyperspaceJump)
        }

        binding.frameAnimation.setOnClickListener {
            val drawable = ContextCompat.getDrawable(
                this,
                R.drawable.ic_resource_value_frame_animation
            ) as AnimationDrawable

            drawable.setTint(Color.BLACK)
            binding.image.setImageDrawable(null)
            binding.image.background = drawable
            binding.image.updateLayoutParams {
                width = 500
                height = 500
            }
            // or
            // binding.image2.setBackgroundResource(R.drawable.ic_resource_value_frame_animation)
            val animation = binding.image.background
            if (animation is Animatable) {
                animation.start()
            }
        }
    }
}
