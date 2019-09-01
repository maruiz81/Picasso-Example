package com.maruiz.koinexample.presentation.extensions

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import kotlin.time.ExperimentalTime
import kotlin.time.MonoClock

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View =
    LayoutInflater.from(context).inflate(layoutRes, this, false)

@UseExperimental(ExperimentalTime::class)
fun ImageView.loadImage(url: String) {
    val TAG = "ImageLoading"
    totalMark
    val mark = MonoClock.markNow()

    Picasso.get()
        .load(url)
        .into(object : Target {
            override fun onBitmapLoaded(bitmap: Bitmap, from: Picasso.LoadedFrom) {
                this@loadImage.setImageBitmap(bitmap)
                Log.d(TAG, "Elapsed time: ${mark.elapsedNow()} $url")
                Log.d(TAG, "Total time: ${totalMark.elapsedNow()}, $url")
            }

            override fun onBitmapFailed(e: Exception, errorDrawable: Drawable?) {
                // Handle the error drawable.
            }

            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                // Handle the placeholder drawable.
            }
        })

}

@UseExperimental(ExperimentalTime::class)
private val totalMark by lazy { MonoClock.markNow() }