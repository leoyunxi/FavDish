package com.tutorials.eu.favdish.view.activities

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tutorials.eu.favdish.R
import com.tutorials.eu.favdish.databinding.ActivityAddUpdateDishBinding
import com.tutorials.eu.favdish.databinding.DialogCustomImageSelectionBinding

/**
 * A screen where we can add and update the dishes.
 */
class AddUpdateDishActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mBinding: ActivityAddUpdateDishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityAddUpdateDishBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setupActionBar()

        mBinding.ivAddDishImage.setOnClickListener(this@AddUpdateDishActivity)
    }

    override fun onClick(v: View) {

        when (v.id) {

            R.id.iv_add_dish_image -> {

                // TODO Step 6: Replace the Toast Message with the custom dialog.
                // START
                customImageSelectionDialog()
                // END
                return
            }
        }
    }

    /**
     * A function for ActionBar setup.
     */
    private fun setupActionBar() {
        setSupportActionBar(mBinding.toolbarAddDishActivity)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back)

        mBinding.toolbarAddDishActivity.setNavigationOnClickListener { onBackPressed() }
    }


    // TODO Step 5: Create a function to launch the custom dialog.
    // START
    /**
     * A function to launch the custom image selection dialog.
     */
    private fun customImageSelectionDialog() {
       val dialog = Dialog(this@AddUpdateDishActivity)

        val binding: DialogCustomImageSelectionBinding = DialogCustomImageSelectionBinding.inflate(layoutInflater)

        /*Set the screen content from a layout resource.
        The resource will be inflated, adding all top-level views to the screen.*/
        dialog.setContentView(binding.root)

        // TODO Step 7: Assign the click for Camera and Gallery. Show the Toast message for now.
        // START
         binding.tvCamera.setOnClickListener {
             Toast.makeText(this@AddUpdateDishActivity, "You have clicked on the Camera.", Toast.LENGTH_SHORT).show()
             dialog.dismiss()
         }

         binding.tvGallery.setOnClickListener {
             Toast.makeText(this@AddUpdateDishActivity, "You have clicked on the Gallery.", Toast.LENGTH_SHORT).show()
             dialog.dismiss()
         }
        // END

        //Start the dialog and display it on screen.
        dialog.show()
    }
    // END
}