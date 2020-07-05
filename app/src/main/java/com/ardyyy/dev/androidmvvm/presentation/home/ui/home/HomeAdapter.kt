package com.ardyyy.dev.androidmvvm.presentation.home.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.ardyyy.dev.androidmvvm.R
import com.ardyyy.dev.androidmvvm.data.local.entity.User
import com.ardyyy.dev.androidmvvm.utils.createCircularProgress
import kotlinx.android.synthetic.main.list_item_user.view.*

class HomeAdapter(private val obj: List<User>, private var onClick: (User) -> Unit) :
    RecyclerView.Adapter<HomeAdapter.ContentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        return ContentViewHolder(inflater.inflate(R.layout.list_item_user, parent, false))
    }

    override fun getItemCount(): Int {
        return obj.size
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.bind(obj[position], holder.itemView.context)
    }

    inner class ContentViewHolder(mView: View) :
        RecyclerView.ViewHolder(mView) {

        fun bind(
            item: User,
            mContext: Context
        ) {
            itemView.apply {
                iv_avatar.load(item.avatar) {
                    crossfade(true)
                    placeholder(createCircularProgress(mContext))
                }
                tv_nama.text = "${item.firstName} ${item.lastName}"
                tv_email.text = item.email
                card_useritem.setOnClickListener {
                    onClick.invoke(item)
                }
            }
        }
    }
}