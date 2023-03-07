package group.payback.codingchallengeapplication.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import group.payback.codingchallengeapplication.databinding.RowItemBinding
import group.payback.codingchallengeapplication.domain.models.Hit
import group.payback.codingchallengeapplication.util.ItemsDiffUtil

class ImagesAdapter(var clickListner: OnItemClickListner) : RecyclerView.Adapter<ImagesAdapter.MyViewHolder>() {
    private var item = emptyList<Hit>()

    class MyViewHolder(private val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(result: Hit) {
            binding.result = result
            binding.executePendingBindings()//updates the view if changed
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RowItemBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }

        fun initialize(action1: Hit, action: OnItemClickListner) {

            itemView.setOnClickListener {
                action.onItemClick(action1, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentRecipe = item[position]
        holder.bind(currentRecipe)
        holder.initialize(item.get(position), clickListner)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    fun setData(newData: List<Hit>) {
        val itemsDiffUtil = ItemsDiffUtil(item, newData)
        val diffUtilResult = DiffUtil.calculateDiff(itemsDiffUtil)
        item = newData
        diffUtilResult.dispatchUpdatesTo(this)
    }
}

interface OnItemClickListner {
    fun onItemClick(item: Hit, position: Int)
}