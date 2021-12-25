package com.zhang.jetpacksample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.michael.navSafeargsdemo.SafeargsActivity
import com.michael.navigationbasicdemo.NavBasicMainActivity
import com.michael.navigationuidemo.NavigationuidemoMainActivity
import com.michael.navigationuidemo.bottomnavigationbar.BottomNavigationBarActivity
import com.michael.navigationuidemo.drawerlayout.DrawerLayoutActivity
import com.michael.navigationuimenudemo.NavigationuimenuMainActivity
import com.zhang.jetpacksample.databinding.ActivityRecyclerviewBinding
import java.util.ArrayList

class JetpackMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mBinding = ActivityRecyclerviewBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        val mToolsItems = ArrayList<ToolsItem>()
        mToolsItems.add(ToolsItem("NavActivity", {
            startActivity(Intent(it.context, NavBasicMainActivity::class.java))
        }))
        mToolsItems.add(ToolsItem("SafeargsActivity", {
            startActivity(Intent(it.context, SafeargsActivity::class.java))
        }))
        mToolsItems.add(ToolsItem("NavigationuimenuMainActivity", {
            startActivity(Intent(it.context, NavigationuimenuMainActivity::class.java))
        }))
        mToolsItems.add(ToolsItem("BottomNavigationBarActivity", {
            startActivity(Intent(it.context, BottomNavigationBarActivity::class.java))
        }))
        mToolsItems.add(ToolsItem("DrawerLayoutActivity", {
            startActivity(Intent(it.context, DrawerLayoutActivity::class.java))
        }))
        mToolsItems.add(ToolsItem("NavigationuidemoMainActivity", {
            startActivity(Intent(it.context, NavigationuidemoMainActivity::class.java))
        }))
        mBinding.recyclerView.layoutManager = LinearLayoutManager(this)

        mBinding.recyclerView.setAdapter(ToolsAdapter(mToolsItems, this))
    }
}
