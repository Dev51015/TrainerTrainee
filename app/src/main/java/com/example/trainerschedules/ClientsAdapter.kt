package com.example.trainerschedules

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_client.view.*

class ClientsAdapter(
    var clients: List<Client>
    ): RecyclerView.Adapter<ClientsAdapter.ClientViewHolder>() {
    class ClientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        return ClientViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_client,
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        val currentClient = clients[position]
        when(currentClient.priority?.lowercase()){
            "high" -> holder.itemView.myLayout.setBackgroundColor(Color.parseColor("#F05454"))
            "medium" -> holder.itemView.myLayout.setBackgroundColor(Color.parseColor("#EDC988"))
            else -> holder.itemView.myLayout.setBackgroundColor(Color.parseColor("#00917C"))
        }
        holder.itemView.apply {
                tvClientName.text = currentClient.name
                tvPriority.text = "Priority - " + currentClient.priority
            }

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,ViewAndUpdateClient::class.java)
            intent.putExtra("id",position)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return clients.size
    }
}