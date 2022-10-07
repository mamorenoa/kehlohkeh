package com.equinox.kehlokeeh.view

import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.canhub.cropper.CropImageContract
import com.canhub.cropper.CropImageView
import com.canhub.cropper.options
import com.equinox.kehlokeeh.databinding.ActivityHomeBinding
import com.equinox.kehlokeeh.viewmodel.WhatsViewModel
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.Text
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions

class HomeActivity : AppCompatActivity() {

    private val whatsViewModel: WhatsViewModel by viewModels()
    private lateinit var binding: ActivityHomeBinding

    private val cropImage = registerForActivityResult(CropImageContract()) { result ->
        if (result.isSuccessful) {
            val uriContent = result.uriContent
            val photo = MediaStore.Images.Media.getBitmap(this.contentResolver, uriContent)
            runTextRecognition(photo)

        } else {
            binding.tvPlaceholder.isVisible = true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonScan.setOnClickListener {
            binding.tvPlaceholder.isVisible = false
            cropImage()
        }
        observeWhatChanges()
        observeLoadingChanges()
    }

    private fun observeWhatChanges() {
        whatsViewModel.productLiveData.observe(this) { whatResponse ->
            binding.layoutInfo.isVisible = true
            binding.tvEnterprise.text = whatResponse.rn.productData.enterpriseName
            binding.tvAddress.text = whatResponse.rn.productData.address
            binding.tvCity.text = whatResponse.rn.productData.city
            binding.tvTown.text = whatResponse.rn.productData.province
            Log.d("DEBUG", whatResponse.toString())
        }
    }

    private fun observeLoadingChanges() {
        whatsViewModel.isLoading.observe(this) { isLoading ->
            binding.pbLoading.isVisible = isLoading
        }
    }

    private fun cropImage() {
        cropImage.launch(
            options {
                setGuidelines(CropImageView.Guidelines.ON)
            }
        )
    }

    private fun runTextRecognition(photo: Bitmap) {
        val image = InputImage.fromBitmap(photo, 0)
        val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
        recognizer.process(image)
            .addOnSuccessListener { texts ->
                processTextRecognitionResult(texts)
            }
            .addOnFailureListener { e ->
                e.printStackTrace()
            }
    }

    private fun processTextRecognitionResult(texts: Text) {
        val blocks = texts.textBlocks
        if (blocks.size == 0) {
            showToast("No text found")
            whatsViewModel.getProduct("12.00528/S")
            return
        }
        Log.d("DEBUG", "text recognized ${blocks[0].text}")
        val textProcessed = processText(blocks[0].text)
        showToast(textProcessed)
        whatsViewModel.getProduct(textProcessed)
    }

    private fun processText(inputText: String): String {
        val normalized = inputText
            .split("\n")
            .filter { it.contains(".") }[0]
            .replace("[()]".toRegex(), "")
            .replace(" ", "")


        Log.d("DEBUG", "text final: $normalized")
        return normalized
    }

    private fun showToast(message: String?) {
        message?.let {
            Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
        }
    }
}