package com.zhang.jetpacksample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zhang.jetpacksample.ToolsAdapter.ToolsViewHolder

class ToolsAdapter  constructor(
        toolsItems: List<ToolsItem>, context: Context
) : RecyclerView.Adapter<ToolsViewHolder>() {
    private val mToolsItems: List<ToolsItem>?
    private val mContext: Context
    override fun onCreateViewHolder(
            parent: ViewGroup, viewType: Int
    ): ToolsViewHolder {
        return ToolsViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_tools, parent, false))
    }

    override fun onBindViewHolder(
            holder: ToolsViewHolder, position: Int
    ) {
        val toolsItem = mToolsItems!![position]
        (holder.itemView as TextView).text = toolsItem.title
        holder.itemView.setTag(toolsItem)
    }

    override fun getItemCount(): Int {
        return mToolsItems?.size ?: 0
    }

   open class ToolsViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener { v: View ->
                val tag = v.getTag() as ToolsItem
                tag.callBack(v)
            }
        }
    }

    init {
        mToolsItems = toolsItems
        mContext = context
    }
}