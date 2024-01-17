package com.example.resources.types

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.ShareActionProvider
import androidx.core.view.MenuItemCompat
import com.example.resources.R
import com.example.resources.databinding.ActivityResourceTypeMenuBinding

class ResourceTypeMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResourceTypeMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Rotate device to see applied condensed title
        binding.condensedTitle.inflateMenu(R.menu.menu_res_1)

        // Different types of app:showAsAction
        binding.showAsAction.inflateMenu(R.menu.menu_res_2)

        // Search view as menu item
        binding.searchIcon.inflateMenu(R.menu.menu_res_3)
        val menuItem = binding.searchIcon.menu.findItem(R.id.search)
        menuItem.setOnActionExpandListener(
            object : MenuItem.OnActionExpandListener {
                override fun onMenuItemActionExpand(item: MenuItem): Boolean {
                    Toast.makeText(this@ResourceTypeMenuActivity, "Expanded", Toast.LENGTH_SHORT)
                        .show()
                    return true
                }

                override fun onMenuItemActionCollapse(item: MenuItem): Boolean {
                    Toast.makeText(this@ResourceTypeMenuActivity, "Collapsed", Toast.LENGTH_SHORT)
                        .show()
                    return true
                }
            }
        )
        val searchView = menuItem.actionView as SearchView
        searchView.queryHint = "Query Hint"
        searchView.setIconifiedByDefault(false)
        searchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    Toast.makeText(
                        this@ResourceTypeMenuActivity,
                        "Search - $query",
                        Toast.LENGTH_SHORT
                    ).show()
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return true
                }
            }
        )


        // Alphabetic
        binding.alphabetic.inflateMenu(R.menu.menu_res_5)
        binding.alphabetic.menu.findItem(R.id.exit).setOnMenuItemClickListener {
            Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show()
            true
        }

        // Groups
        binding.groups.inflateMenu(R.menu.menu_res_6)

        // Checkable
        binding.checkable.inflateMenu(R.menu.menu_res_7)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_res_4, menu)

        // ShareActionProvider doesn't work in toolbar
        val shareMenuItem = menu.findItem(R.id.share)
        val actionProvider = MenuItemCompat.getActionProvider(shareMenuItem) as ShareActionProvider
        actionProvider.setOnShareTargetSelectedListener { _, _ ->
            Toast.makeText(this, "Share! ", Toast.LENGTH_SHORT).show()
            false
        }
        val shareIntent = Intent()
            .apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
                type = "text/plain"
            }
        actionProvider.setShareIntent(shareIntent)

        return true
    }
}
