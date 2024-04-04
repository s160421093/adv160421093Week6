package com.ubaya.adv160421093week6.view
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.adv160421093week6.databinding.LaptopListItemBinding
import com.ubaya.adv160421093week6.model.Laptop

class LaptopListAdapter(val LaptopList:ArrayList<Laptop>)
    : RecyclerView.Adapter<LaptopListAdapter.LaptopViewHolder>()
{
    class LaptopViewHolder(var binding: LaptopListItemBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaptopViewHolder {
        val binding = LaptopListItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return LaptopViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return LaptopList.size
    }

    override fun onBindViewHolder(holder: LaptopViewHolder, position: Int) {
        holder.binding.txtID.text = LaptopList[position].id
        holder.binding.txtBrand.text = LaptopList[position].brand
        holder.binding.txtModel.text = LaptopList[position].model
        holder.binding.txtProcessor.text = LaptopList[position].processor
        holder.binding.txtRam.text = LaptopList[position].ram
        holder.binding.txtStorage.text = LaptopList[position].storage
        holder.binding.txtFeatures.text = LaptopList[position].features.toString()
        holder.binding.txtPorts.text = LaptopList[position].ports.toString()
    }
    fun updateLaptopList(newLaptopList: ArrayList<Laptop>) {
        LaptopList.clear()
        LaptopList.addAll(newLaptopList)
        notifyDataSetChanged()
    }


}