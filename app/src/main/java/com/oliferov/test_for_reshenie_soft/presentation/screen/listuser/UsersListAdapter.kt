package com.oliferov.test_for_reshenie_soft.presentation.screen.listuser

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.oliferov.test_for_reshenie_soft.databinding.UserItemBinding
import com.oliferov.test_for_reshenie_soft.domain.model.User

class UsersListAdapter : ListAdapter<User, UsersListViewHolder>(UserListDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersListViewHolder {
        val binding = UserItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UsersListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersListViewHolder, position: Int) {
        val user = getItem(position)
        with(user) {
            with(holder.binding) {
                tvName.text = name
                tvUsername.text = username
                tvEmail.text = email
                tvAddressStreet.text = street
                tvAddressSuite.text = suite
                tvAddressZipcode.text = zipcode
                tvAddressGeoLat.text = geoLat
                tvAddressGeoLng.text = geoLng
                tvPhone.text = phone
                tvWebsite.text = website
                tvCompanyName.text = companyName
                tvCompanyCatchphrase.text = companyCatchPhrase
                tvCompanyBs.text = companyBs
            }
        }
    }
}

class UsersListViewHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root)

class UserListDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}