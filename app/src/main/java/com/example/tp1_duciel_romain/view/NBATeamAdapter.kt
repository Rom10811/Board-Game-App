package com.example.tp1_duciel_romain.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tp1_duciel_romain.R
import com.example.tp1_duciel_romain.databinding.ItemCustomRecyclerBinding
import com.example.tp1_duciel_romain.databinding.ItemCustomRecyclerFooterBinding
import com.example.tp1_duciel_romain.databinding.ItemCustomRecyclerHeaderBinding
import com.example.tp1_duciel_romain.view.model.ObjectDataHeaderSample
import com.example.tp1_duciel_romain.view.model.MyObjectForRecyclerView
import com.example.tp1_duciel_romain.view.model.ObjectDataFooterSample
import com.example.tp1_duciel_romain.view.model.RecyclerViewData

private val diffItemUtils = object : DiffUtil.ItemCallback<MyObjectForRecyclerView>() {


    override fun areItemsTheSame(
        oldItem: MyObjectForRecyclerView,
        newItem: MyObjectForRecyclerView
    ): Boolean {
        return oldItem == newItem
    }


    override fun areContentsTheSame(
        oldItem: MyObjectForRecyclerView,
        newItem: MyObjectForRecyclerView
    ): Boolean {
        return oldItem == newItem
    }
}

class NBATeamAdapter(private val onItemClick: (quoteUI: RecyclerViewData, view: View) -> Unit,) :
    ListAdapter<MyObjectForRecyclerView, RecyclerView.ViewHolder>(diffItemUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType) {
            MyItemType.ROW.type -> {
                NBATeamViewHolder(
                    ItemCustomRecyclerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ), onItemClick
                )
            }

            MyItemType.HEADER.type -> {
                NBATeamHeaderViewHolder(
                    ItemCustomRecyclerHeaderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            MyItemType.FOOTER.type -> {
                NBATeamFooterViewHolder(
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
            MyItemType.ROW.type -> (holder as NBATeamViewHolder).bind(getItem(position) as RecyclerViewData)


            MyItemType.HEADER.type -> (holder as NBATeamHeaderViewHolder).bind(
                getItem(
                    position
                ) as ObjectDataHeaderSample
            )


            MyItemType.FOOTER.type -> (holder as NBATeamFooterViewHolder).bind(
                getItem(
                    position
                ) as ObjectDataFooterSample
            )


            else -> throw RuntimeException("Wrong view type received ${holder.itemView}")
        }


    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is RecyclerViewData -> MyItemType.ROW.type
            is ObjectDataHeaderSample -> MyItemType.HEADER.type
            is ObjectDataFooterSample -> MyItemType.FOOTER.type
        }
    }

}


class NBATeamViewHolder(private val binding: ItemCustomRecyclerBinding, onItemClick: (recyclerViewData: RecyclerViewData, view: View)->Unit) : RecyclerView.ViewHolder(binding.root) {
    private lateinit var ui: RecyclerViewData

    init {
        binding.root.setOnClickListener{
            onItemClick(ui,itemView)
        }
    }


    fun bind(recyclerDataSample: RecyclerViewData) {
        ui = recyclerDataSample
        binding.itemRecyclerViewTeamName.text = recyclerDataSample.teamName
        binding.itemRecyclerViewTeamRank.text = recyclerDataSample.teamRank
        Glide.with(itemView.context)
            .load(recyclerDataSample.teamLogo)
            .placeholder(R.drawable.ic_baseline_sports_basketball_24)
            .into(binding.itemRecyclerViewTeamLogo)
    }
}


class NBATeamHeaderViewHolder(private val binding: ItemCustomRecyclerHeaderBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(objectDataHeaderSample: ObjectDataHeaderSample) {
        binding.itemRecyclerViewHeader.text = objectDataHeaderSample.header
    }
}

class NBATeamFooterViewHolder(private val binding: ItemCustomRecyclerFooterBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(objectDataFooterSample: ObjectDataFooterSample) {
        binding.itemRecyclerViewFooter.text = objectDataFooterSample.footer
    }
}

enum class MyItemType(val type: Int) {
    ROW(0),
    HEADER(1),
    FOOTER(2)
}

