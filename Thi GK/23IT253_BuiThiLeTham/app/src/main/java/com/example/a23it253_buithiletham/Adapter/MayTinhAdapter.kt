package com.example.a23it253_buithiletham.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a23it253_buithiletham.Entity.MayTinh
import com.example.a23it253_buithiletham.R

class MayTinhAdapter(
    private var mayTinhList: List<MayTinh>,
    private val onItemClick: (MayTinh) -> Unit,
    private val onDeleteClick: (MayTinh) -> Unit,
    private val onUpdateClick: (MayTinh) -> Unit
) : RecyclerView.Adapter<MayTinhAdapter.MayTinhViewHolder>() {

    inner class MayTinhViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTenMay: TextView = itemView.findViewById(R.id.tvTenMay)
        private val tvLoaiMay: TextView = itemView.findViewById(R.id.tvLoaiMay)
        private val tvThanhTien: TextView = itemView.findViewById(R.id.tvThanhTien)
        private val btnOptions: View = itemView.findViewById(R.id.btnOptions)

        fun bind(mayTinh: MayTinh) {
            tvTenMay.text = mayTinh.tenmay
            tvLoaiMay.text = mayTinh.loaimay
            tvThanhTien.text = "Thành tiền: ${mayTinh.thanhTien()}"

            itemView.setOnClickListener { onItemClick(mayTinh) }

            btnOptions.setOnClickListener { view ->
                showPopupMenu(view, mayTinh)
            }
        }

        private fun showPopupMenu(view: View, mayTinh: MayTinh) {
            val popup = PopupMenu(view.context, view)
            popup.inflate(R.menu.menu_may_tinh_options)

            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.menu_delete -> {
                        onDeleteClick(mayTinh)
                        true
                    }
                    R.id.menu_update -> {
                        onUpdateClick(mayTinh)
                        true
                    }
                    else -> false
                }
            }
            popup.show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MayTinhViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_may_tinh, parent, false)
        return MayTinhViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MayTinhViewHolder, position: Int) {
        holder.bind(mayTinhList[position])
    }

    override fun getItemCount() = mayTinhList.size

    fun updateList(newList: List<MayTinh>) {
        mayTinhList = newList
        notifyDataSetChanged()
    }
}