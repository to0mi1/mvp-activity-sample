package org.animato99.sampleapplication.informationlist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.animato99.sampleapplication.R
import org.animato99.sampleapplication.data.TrainInformation

class InformationListAdapter(
        private var itemList: List<TrainInformation>
) : RecyclerView.Adapter<InformationListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InformationListHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.information_list_row, parent, false)
        return InformationListHolder(inflate)
    }

    override fun onBindViewHolder(holder: InformationListHolder, position: Int) {
        holder.lineNameText.text = itemList[position].railway
        holder.statusText.text = itemList[position].trainInformationText
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun replaceData(info: List<TrainInformation>) {
        itemList = info
        notifyDataSetChanged()
    }
}

class InformationListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val lineNameText: TextView by lazy { itemView.findViewById<TextView>(R.id.lineNameText) }
    val statusText: TextView by lazy { itemView.findViewById<TextView>(R.id.statusText) }
}