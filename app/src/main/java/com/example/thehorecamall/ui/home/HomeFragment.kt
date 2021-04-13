package com.example.thehorecamall.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.thehorecamall.R
import com.example.thehorecamall.adapter.ViewPagerAdapter

class HomeFragment : Fragment() {
    private var images = arrayListOf<Int>(R.drawable.firstmainimage,R.drawable.firstmainimage,R.drawable.firstmainimage)
    private var images2 = arrayListOf<Int>(R.drawable.second_main_image,R.drawable.second_main_image,R.drawable.second_main_image)
    private lateinit var viewPager1 : ViewPager
    private lateinit var viewPager2: ViewPager
    private lateinit var imageView_slider_circle_1 : ImageView
    private lateinit var imageView_slider_circle_2 : ImageView
    private lateinit var imageView_slider_circle_3 : ImageView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val viewPagerAdapter1 : ViewPagerAdapter = ViewPagerAdapter(activity,images)
        val viewPagerAdapter2 : ViewPagerAdapter = ViewPagerAdapter(activity,images2)
        viewPager1 = root.findViewById(R.id.viewPager1)
        viewPager2 = root.findViewById(R.id.viewPager2)
        imageView_slider_circle_1 = root.findViewById(R.id.slider_circle_1)
        imageView_slider_circle_2 = root.findViewById(R.id.slider_circle_2)
        imageView_slider_circle_3 = root.findViewById(R.id.slider_circle_3)

        viewPager1.adapter = viewPagerAdapter1
        viewPager2.adapter = viewPagerAdapter2
        return root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onStart() {
        super.onStart()
        
        onPageSliderListener()

    }

    fun onPageSliderListener(){
        viewPager1?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                if(position == 0){
                    imageView_slider_circle_1.setImageResource(R.drawable.circle_filled)
                    imageView_slider_circle_2.setImageResource(R.drawable.circle)
                    imageView_slider_circle_3.setImageResource(R.drawable.circle)
                }

                if(position == 1){
                    imageView_slider_circle_1.setImageResource(R.drawable.circle)
                    imageView_slider_circle_2.setImageResource(R.drawable.circle_filled)
                    imageView_slider_circle_3.setImageResource(R.drawable.circle)
                }

                if(position == 2){
                    imageView_slider_circle_1.setImageResource(R.drawable.circle)
                    imageView_slider_circle_2.setImageResource(R.drawable.circle)
                    imageView_slider_circle_3.setImageResource(R.drawable.circle_filled)
                }
            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })
    }
}