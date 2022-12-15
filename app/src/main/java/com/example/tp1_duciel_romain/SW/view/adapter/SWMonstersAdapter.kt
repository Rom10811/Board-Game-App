package com.example.tp1_duciel_romain.SW.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tp1_duciel_romain.R
import com.example.tp1_duciel_romain.SW.view.model.ObjectDataFooterSW
import com.example.tp1_duciel_romain.SW.view.model.ObjectDataHeaderSW
import com.example.tp1_duciel_romain.SW.view.model.ObjectForUi
import com.example.tp1_duciel_romain.SW.view.model.SWMonstersUi
import com.example.tp1_duciel_romain.databinding.ItemCustomRecyclerFooterBinding
import com.example.tp1_duciel_romain.databinding.ItemCustomRecyclerHeaderBinding
import com.example.tp1_duciel_romain.databinding.ItemSwMonstersBinding

val diffUtils = object : DiffUtil.ItemCallback<ObjectForUi>() {
    override fun areItemsTheSame(oldItem: ObjectForUi, newItem: ObjectForUi): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ObjectForUi, newItem: ObjectForUi): Boolean {
        return oldItem == newItem
    }
}

class SWMonstersAdapter : ListAdapter<ObjectForUi, RecyclerView.ViewHolder>(diffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType) {
            MyItemType.ROW.type -> {
                SWMonstersViewHolder(
                    ItemSwMonstersBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            MyItemType.HEADER.type -> {
                SWTeamHeaderViewHolder(
                    ItemCustomRecyclerHeaderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            MyItemType.FOOTER.type -> {
                SWTeamFooterViewHolder(
                    ItemCustomRecyclerFooterBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> throw RuntimeException("Wrong view type received $viewType")
        }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        when (holder.itemViewType) {
            MyItemType.ROW.type -> (holder as SWMonstersViewHolder).bind(getItem(position) as SWMonstersUi)
            MyItemType.HEADER.type -> (holder as SWTeamHeaderViewHolder).bind(getItem(position) as ObjectDataHeaderSW)
            MyItemType.FOOTER.type -> (holder as SWTeamFooterViewHolder).bind(getItem(position) as ObjectDataFooterSW)
            else -> throw RuntimeException("Wrong view type received ${holder.itemView}")
        }


    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is SWMonstersUi -> MyItemType.ROW.type
            is ObjectDataHeaderSW -> MyItemType.HEADER.type
            is ObjectDataFooterSW -> MyItemType.FOOTER.type
        }
    }
}

class SWMonstersViewHolder(private val binding: ItemSwMonstersBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private lateinit var ui: SWMonstersUi

    fun bind(swMonstersUi: SWMonstersUi) {
        ui = swMonstersUi
        val monsterIcon = "https://swarfarm.com/static/herders/images/monsters/" + swMonstersUi.icon
        Glide.with(itemView.context)
            .load(monsterIcon)
            .placeholder(R.drawable.ic_baseline_wifi_off_24)
            .into(binding.itemSwMonstersIcon)
        binding.itemSwMonstersName.text = swMonstersUi.name
        binding.itemSwMonstersType.text = swMonstersUi.type
    }
}


class SWTeamHeaderViewHolder(private val binding: ItemCustomRecyclerHeaderBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(objectDataHeaderSW: ObjectDataHeaderSW) {
        binding.itemRecyclerViewHeader.text = objectDataHeaderSW.header
    }
}

class SWTeamFooterViewHolder(private val binding: ItemCustomRecyclerFooterBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(objectDataFooterSW: ObjectDataFooterSW) {
        binding.itemRecyclerViewFooter.text = objectDataFooterSW.footer
    }
}

enum class MyItemType(val type: Int) {
    ROW(0),
    HEADER(1),
    FOOTER(2)
}

