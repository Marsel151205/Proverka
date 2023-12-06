package com.marsel.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginTop
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.marsel.presentation.R
import com.marsel.presentation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setupToolbar()
        setupListeners()
    }

    private fun setupToolbar() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navController = navHostFragment.navController
        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
        navController.graph = navGraph

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {

                R.id.numberFragment -> {

                    binding.toolbar.visibility = View.VISIBLE

                    val layoutParams =
                        binding.fragmentContainerView.layoutParams as ViewGroup.MarginLayoutParams
                    layoutParams.topMargin = 25
                    binding.fragmentContainerView.layoutParams = layoutParams
                }

                R.id.bookingFragment -> {
                    binding.tvFragmentName.text = "Бронирование"

                    binding.toolbar.visibility = View.VISIBLE

                    val layoutParams =
                        binding.fragmentContainerView.layoutParams as ViewGroup.MarginLayoutParams
                    layoutParams.topMargin = 25
                    binding.fragmentContainerView.layoutParams = layoutParams
                }

                R.id.paidFragment -> {
                    binding.tvFragmentName.text = "Заказ оплачен"

                    binding.toolbar.visibility = View.VISIBLE

                    val layoutParams =
                        binding.fragmentContainerView.layoutParams as ViewGroup.MarginLayoutParams
                    layoutParams.topMargin = 25
                    binding.fragmentContainerView.layoutParams = layoutParams
                }

                else -> {
                    binding.toolbar.visibility = View.GONE

                    val layoutParams =
                        binding.fragmentContainerView.layoutParams as ViewGroup.MarginLayoutParams

                    val marginTopInPixels = 0
                    layoutParams.topMargin = marginTopInPixels

                    binding.fragmentContainerView.layoutParams = layoutParams
                }
            }
        }
    }

    private fun setupListeners() {
        binding.btnBack.setOnClickListener {
            findNavController(R.id.fragment_container_view).navigateUp()
        }
    }
}