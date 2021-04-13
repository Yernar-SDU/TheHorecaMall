package com.example.thehorecamall
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter


class ImageAdapter internal constructor(context: Context) : PagerAdapter() {
    private val context: Context
    private val GalImages = intArrayOf(
        R.drawable.firstmainimage, R.drawable.firstmainimage, R.drawable.firstmainimage)

    override fun getCount(): Int {
        return GalImages.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView = ImageView(context)
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER)
        imageView.setImageResource(GalImages[position])
        container.addView(imageView, 0)
        return imageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ImageView)
    }

    init {
        this.context = context
    }
}