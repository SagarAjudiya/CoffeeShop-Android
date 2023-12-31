package com.simform.coffeeshop.ui.dashboard.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.simform.coffeeshop.R
import com.simform.coffeeshop.databinding.ActivityHomeBinding
import com.simform.coffeeshop.ui.cart.view.CartFragment
import com.simform.coffeeshop.ui.favourite.view.FavouriteFragment
import com.simform.coffeeshop.ui.notification.view.NotificationFragment
import com.simform.coffeeshop.ui.home.view.HomeFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        initViews()
    }

    /**
     * Init Views
     */
    private fun initViews() {
        replaceFragment(HomeFragment())

        // BottomNav Tapped
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.favourite -> replaceFragment(FavouriteFragment())
                R.id.cart -> replaceFragment(CartFragment())
                R.id.notification -> replaceFragment(NotificationFragment())
            }
            true
        }
    }

    /**
     * Replace Fragment In HomeActivity
     */
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit()
    }

}