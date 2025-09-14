package com.example.fitx

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

class GenderSelectActivity : Fragment() {

    private lateinit var maleImage: ImageView
    private lateinit var femaleImage: ImageView
    private lateinit var maleHighlight: View
    private lateinit var femaleHighlight: View
    private lateinit var continueButton: Button
    private var selectedGender: String? = null // To store the selected gender

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.gender_select, container, false)


        // Initialize views
        maleImage = view.findViewById(R.id.maleImage)
        femaleImage = view.findViewById(R.id.femaleImage)
        maleHighlight = view.findViewById(R.id.maleHighlight)
        femaleHighlight = view.findViewById(R.id.femaleHighlight)
        continueButton = view.findViewById(R.id.btnContinue) // Assumes you have a Button with this ID in your XML

        // Set click listeners for the gender images
        maleImage.setOnClickListener {
            setGenderSelection("male")
        }
        femaleImage.setOnClickListener {
            setGenderSelection("female")
        }

        // Set click listener for the continue button
        continueButton.setOnClickListener {
            if (selectedGender != null) {
                // Navigate to the next screen, which is your HomeActivity
                val intent = Intent(activity, HomeActivity::class.java)
                startActivity(intent)
                activity?.finish() // Close the current activity so the user can't go back
            } else {
                // You can add a Toast or a visual cue to tell the user to select a gender
                // Toast.makeText(context, "Please select a gender", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    private fun setGenderSelection(gender: String) {
        // Store the selected gender
        selectedGender = gender

        // Update the UI based on the selection
        if (gender == "male") {
            maleHighlight.visibility = View.VISIBLE
            maleImage.alpha = 1.0f
            femaleHighlight.visibility = View.GONE
            femaleImage.alpha = 0.4f
        } else { // It's "female"
            femaleHighlight.visibility = View.VISIBLE
            femaleImage.alpha = 1.0f
            maleHighlight.visibility = View.GONE
            maleImage.alpha = 0.4f
        }
        // Enable the continue button once a gender is selected
        continueButton.isEnabled = true
    }
}