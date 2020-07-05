package com.ardyyy.dev.androidmvvm.presentation.home.ui.profile

import android.os.Bundle
import android.view.*
import com.ardyyy.dev.androidmvvm.R
import com.ardyyy.dev.androidmvvm.presentation.base.BaseFragment
import com.ardyyy.dev.androidmvvm.utils.setEnable
import kotlinx.android.synthetic.main.fragment_profile.*
import org.koin.android.viewmodel.ext.android.viewModel

class ProfileFragment : BaseFragment() {

    private val profileViewModel: ProfileViewModel by viewModel()
    private var editMode = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        setHasOptionsMenu(true)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bindData()
    }

    private fun bindData() {
        val mUser = profileViewModel.getUserPref()
        with(mUser) {
            tie_firstname.setText(firstName)
            tie_lastname.setText(lastName)
            tie_email.setText(email)
            rb_male.isChecked = gender!!
            rb_female.isChecked = !gender
        }
        til_firstname.isEnabled = false
        til_lastname.isEnabled = false
        til_email.isEnabled = false
        rg_gender.setEnable(false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.findItem(R.id.menu_edit).isVisible = !editMode
        menu.findItem(R.id.menu_finish).isVisible = editMode
        super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        activity?.invalidateOptionsMenu()
        return when (item.itemId) {
            R.id.menu_edit -> {
                setEditModeOn()
                true
            }
            R.id.menu_finish -> {
                setEditModeOff()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setEditModeOn() {
        editMode = true
        til_firstname.isEnabled = true
        til_lastname.isEnabled = true
        til_email.isEnabled = true
        rg_gender.setEnable(true)
    }

    private fun setEditModeOff() {
        editMode = false
        saveData()
        bindData()
    }

    private fun saveData() {
        val a = tie_firstname.text.toString()
        val b = tie_lastname.text.toString()
        val c = tie_email.text.toString()
        val d = rg_gender.checkedRadioButtonId == R.id.rb_male
        profileViewModel.saveUserPref(firstname = a, lastname = b, email = c, isMale = d)
    }
}