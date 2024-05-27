package com.example.kycdemo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kycdemo.databinding.ActivityMainBinding
import com.example.kycdemo.di.WalletConnectionUtils.initialWalletConnection
import com.ondato.sdk.Ondato
import com.ondato.sdk.OndatoConfig
import com.ondato.sdk.OndatoError
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialWalletConnection(this)

        binding.btnStartKyc.setOnClickListener {
            startIdentification()
        }

        binding.btnInit.setOnClickListener {
            initSdk(binding.edtId.text.toString().trim())
        }


    }

    private fun initSdk(id: String) {
        val config = OndatoConfig.Builder()
            .setIdentityVerificationId(id)
            .showSplashScreen(true)
            .showStartScreen(true)
            .showSuccessScreen(true)
            .setMode(OndatoConfig.Mode.TEST)
            .setLanguage("en")
            .build()

        Ondato.init(config)
    }

    private fun startIdentification() {
        Ondato.startIdentification(applicationContext, object : Ondato.ResultListener {
            override fun onSuccess(identificationId: String?) {
                // findViewById<TextView>(R.id.result_text_view)?.text = "Success"
                Log.e("KYC_SUCCESS", "onSuccess: ${identificationId}")
                binding.txtSuccessId.text = identificationId
                Toast.makeText(this@MainActivity, "Success ", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(identificationId: String?, error: OndatoError) {
                Toast.makeText(this@MainActivity, "Failed", Toast.LENGTH_SHORT).show()

            }
        })
    }

}