package com.android.dataapp.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.android.dataapp.R
import com.android.dataapp.databinding.ActivityMainBinding
import com.android.dataapp.viewmodel.ViewAllViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val activity=this
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
    }

    private fun initUi() {
        navController=findNavController(R.id.nav_host_fragment)
        binding.bottomNav.setupWithNavController(navController)
        navController.addOnDestinationChangedListener(object : NavController.OnDestinationChangedListener{
            override fun onDestinationChanged(
                controller: NavController,
                destination: NavDestination,
                arguments: Bundle?
            ) {
                when(destination.id)
                {
                    R.id.viewAllFragment ->
                    {
                        binding.lltoolbar.tvTitle.text="View All"
                    }
                    R.id.myDataFragment ->
                    {
                        binding.lltoolbar.tvTitle.text="My Data"
                    }
                }
            }

        })
    }

}