package fr.upjv.ccm.tp1.view

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.java.projet_android_restoy_duciel.Boardgame.view.model.BoardgameUI
import com.java.projet_android_restoy_duciel.Boardgame.view.model.ObjectDataFooterBoardgame
import com.java.projet_android_restoy_duciel.Boardgame.view.model.ObjectDataHeaderBoardgame
import com.java.projet_android_restoy_duciel.Boardgame.view.model.ObjectForUi
import com.java.projet_android_restoy_duciel.R
import com.java.projet_android_restoy_duciel.databinding.ItemCustomRecyclerBinding
import com.java.projet_android_restoy_duciel.databinding.ItemCustomRecyclerHeaderBinding
import java.lang.RuntimeException

private val diffItemUtils = object : DiffUtil.ItemCallback<ObjectForUi>() {

    override fun areItemsTheSame(oldItem: ObjectForUi, newItem: ObjectForUi): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ObjectForUi, newItem: ObjectForUi): Boolean {
        return oldItem == newItem
    }
}

class BoardgameAdapter(
    private val onItemClick: (quoteUi: BoardgameUI, view: View) -> Unit,
) : ListAdapter<ObjectForUi, RecyclerView.ViewHolder>(diffItemUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType) {
            MyItemType.ROW.type -> {
                BoardgameViewHolder(
                    ItemCustomRecyclerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ), onItemClick
                )
            }
            MyItemType.HEADER.type -> {
                BoardgameHeaderViewHolder(
                    ItemCustomRecyclerHeaderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            MyItemType.FOOTER.type -> {
                BoardgameFooterViewHolder(
                    ItemCustomRecyclerHeaderBinding.inflate(
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
            MyItemType.ROW.type -> (holder as BoardgameViewHolder).bind(getItem(position) as BoardgameUI)
            MyItemType.HEADER.type -> (holder as BoardgameHeaderViewHolder).bind(getItem(position) as ObjectDataHeaderBoardgame)
            MyItemType.FOOTER.type -> (holder as BoardgameFooterViewHolder).bind(getItem(position) as ObjectDataFooterBoardgame)

            else -> throw RuntimeException("Wrong view type received ${holder.itemView}")
        }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is BoardgameUI -> MyItemType.ROW.type
            is ObjectDataHeaderBoardgame -> MyItemType.HEADER.type
            is ObjectDataFooterBoardgame -> MyItemType.FOOTER.type
        }
    }
}

class BoardgameViewHolder(
    private val binding: ItemCustomRecyclerBinding,
    onItemClick: (boardgameUi: BoardgameUI, view: View) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var ui: BoardgameUI


    init {
        binding.root.setOnLongClickListener() {
            onItemClick(ui, itemView)
            true
        }
    }

    fun bind(boardgameUi: BoardgameUI) {
        ui = boardgameUi
        binding.itemRecyclerViewName.text = boardgameUi.name
        binding.itemRecyclerViewPrice.text = "${boardgameUi.price}" + "€"
        binding.itemRecyclerViewDescription.text = Html.fromHtml(boardgameUi.desc)
        Glide.with(itemView.context)
            .load(boardgameUi.image)
            .placeholder(R.drawable.sea)
            .into(binding.imageView)
    }
}

class BoardgameHeaderViewHolder(
    private val binding: ItemCustomRecyclerHeaderBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(category: ObjectDataHeaderBoardgame) {
        binding.itemRecyclerViewHeader.text = category.header
    }
}

class BoardgameFooterViewHolder(
    private val binding: ItemCustomRecyclerHeaderBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(footer: ObjectDataFooterBoardgame) {
        binding.itemRecyclerViewHeader.text = "${footer.footer} Boardgames"
    }
}

enum class MyItemType(val type: Int) {
    ROW(0),
    HEADER(1),
    FOOTER(2)
}

