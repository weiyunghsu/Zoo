package com.weiyung.zoo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.weiyung.zoo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel

        val navController = findNavController(R.id.myNavHostFragment)

        val toolbarLogo = this.binding.toolbarIcon
        val toolbarText = this.binding.textToolbarTitle
        val toolbarBackButton = this.binding.backButton

        setSupportActionBar(binding.toolbarIcon)
        supportActionBar?.title = null
//        binding.toolbarIcon.setNavigationIcon(R.drawable.icons_24px_drawer)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.HomeFragment -> {
                    toolbarText.visibility = View.VISIBLE
                    toolbarLogo.visibility = View.VISIBLE
                    binding.toolbarIcon.visibility = View.VISIBLE
                    binding.backButton.visibility = View.GONE
                }
                R.id.HouseFragment -> {
//                    toolbarText.text = getString(R.string.toolbar_house_title)
                    toolbarText.visibility = View.GONE
                    toolbarLogo.visibility = View.GONE
                    binding.backButton.visibility = View.VISIBLE
                }
                R.id.SpeciesFragment -> {
//                    toolbarText.text = getString(R.string.toolbar_species_title)
                    toolbarText.visibility = View.GONE
                    toolbarLogo.visibility = View.GONE
                    binding.backButton.visibility = View.VISIBLE
                }
            }
        }
    }
}