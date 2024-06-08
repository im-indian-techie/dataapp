package com.android.dataapp.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.ViewModelProvider
import com.android.dataapp.databinding.ActivitySplashBinding
import com.android.dataapp.viewmodel.ViewAllViewModel
import com.example.parkzapp.model.api.APIConstants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    val activity=this
    lateinit var binding: ActivitySplashBinding
    lateinit var viewModel:ViewAllViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
    }

    private fun initUi() {
        viewModel= ViewModelProvider(this)[ViewAllViewModel::class.java]
        Handler().postDelayed(Runnable {
            startActivity(Intent(activity, MainActivity::class.java))
        },2000)
//        getAccessToken()
//        viewModel.accessToken.observe(this,Observer{
//            if (it.isNotEmpty())
//            {
//
//            }
//        })

    }
//    fun getAccessToken()
//    {
//        val map= HashMap<String,String>()
//        map["grant_type"]="urn:ietf:params:oauth:grant-type:jwt-bearer"
//        map["assertion"]=APIConstants.JWT
//        map["client_id"]=APIConstants.CLIENT_ID
//        map["client_secret"]=APIConstants.CLIENT_SECRET
//        map["username"]="ashindaschandroth97@gmail.com"
//        map["password"]="Ashin1997#"
//        map["server_id"]="User"
//
//
//        viewModel.getAccessToken(map)
//    }
}