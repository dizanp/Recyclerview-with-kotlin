package com.dicoding.recyleviewkotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dicoding.recyleviewkotlin.R.id.image
import com.dicoding.recyleviewkotlin.R.id.name
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list.*

/**
 * Created by Mr Dizan on 10/16/2018.
 */

class RecyclerViewAdapter(private val context: Context, private val items: List<Item>, private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

        class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
                LayoutContainer {

            fun bindItem(items: Item, listener: (Item) -> Unit) {
                name.text = items.name
                items.image?.let { Picasso.get().load(it).into(image) }
                containerView.setOnClickListener { listener(items) }
            }
        }
    }
