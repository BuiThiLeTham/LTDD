package com.example.a23it206_hoanganhphi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a23it206_hoanganhphi.R
import com.example.a23it206_hoanganhphi.data.HocPhan

class HocPhanAdapter(
    private val onItemClick: (HocPhan) -> Unit,
    private val onDeleteClick: (HocPhan) -> Unit
) : ListAdapter<HocPhan, HocPhanAdapter.HocPhanViewHolder>(HocPhanDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HocPhanViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hoc_phan, parent, false)
        return HocPhanViewHolder(view)
    }

    override fun onBindViewHolder(holder: HocPhanViewHolder, position: Int) {
        val hocPhan = getItem(position)
        holder.bind(hocPhan)
    }

    inner class HocPhanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvMaHocPhan: TextView = itemView.findViewById(R.id.tv_ma_hoc_phan)
        private val tvTenHocPhan: TextView = itemView.findViewById(R.id.tv_ten_hoc_phan)
        private val tvSoTinChi: TextView = itemView.findViewById(R.id.tv_so_tin_chi)
        private val tvHocKy: TextView = itemView.findViewById(R.id.tv_hoc_ky)
        private val btnDelete: ImageButton = itemView.findViewById(R.id.btn_delete)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(getItem(position))
                }
            }

            btnDelete.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onDeleteClick(getItem(position))
                }
            }
        }

        fun bind(hocPhan: HocPhan) {
            tvMaHocPhan.text = "Mã học phần: ${hocPhan.mahocphan}"
            tvTenHocPhan.text = "Tên học phần: ${hocPhan.tenhocphan}"
            tvSoTinChi.text = "Số tín chỉ: ${hocPhan.sotinchi}"
            tvHocKy.text = "Học kỳ: ${hocPhan.hocky}"
        }
    }

    class HocPhanDiffCallback : DiffUtil.ItemCallback<HocPhan>() {
        override fun areItemsTheSame(oldItem: HocPhan, newItem: HocPhan): Boolean {
            return oldItem.mahocphan == newItem.mahocphan
        }

        override fun areContentsTheSame(oldItem: HocPhan, newItem: HocPhan): Boolean {
            return oldItem == newItem
        }
    }
}
