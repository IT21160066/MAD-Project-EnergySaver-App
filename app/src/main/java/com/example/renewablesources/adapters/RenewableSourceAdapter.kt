package com.example.renewablesources.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.renewablesources.R
import com.example.renewablesources.models.RenewableSourceModel

class RenewableSourceAdapter(private val rnSourceList: ArrayList<RenewableSourceModel>) :
        RecyclerView.Adapter<RenewableSourceAdapter.ViewHolder>(){

        private lateinit var mListener: OnItemClickListener

        interface OnItemClickListener{
                fun onItemClick(position: Int)
        }

        fun setOnItemClickListener(clickListener: OnItemClickListener){
                mListener = clickListener
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.source_list_item,parent, false)
                return ViewHolder(itemView, mListener)

        }

        override fun onBindViewHolder(holder: RenewableSourceAdapter.ViewHolder, position: Int) {
                val currentRnSource = rnSourceList[position]
                holder.rnSourceName.text = currentRnSource.sourceName
        }

        override fun getItemCount(): Int {
                return rnSourceList.size
        }

        class ViewHolder(itemView: View, clickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){

                val rnSourceName  : TextView = itemView.findViewById(R.id.rnSourceName)

                init{
                        itemView.setOnClickListener{
                                clickListener.onItemClick(adapterPosition)
                        }
                }

        }

}
