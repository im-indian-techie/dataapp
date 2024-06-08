package com.android.dataapp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.android.dataapp.databinding.ViewAllItemBinding
import com.example.parkzapp.model.pojo.UserData

class ViewAllAdapter(val list: List<UserData>,val context: Context,val from:String):BaseAdapter() {
    override fun getCount(): Int {
       return list.size
    }

    override fun getItem(p0: Int): Any {
        return getItem(p0)
    }

    override fun getItemId(p0: Int): Long {
       return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val binding:ViewAllItemBinding
        val itemView: View
       if(p1==null)
       {
          binding= ViewAllItemBinding.inflate(LayoutInflater.from(context),p2,false)
           itemView = binding.root
           itemView.tag = binding
       } else {
           binding = p1.tag as ViewAllItemBinding
           itemView = binding.root
       }
        val item= list[p0]
        if(from.equals("My Data"))
        {
            binding.tvName.visibility=View.GONE
        }
        else
        {
            binding.tvName.visibility=View.VISIBLE
        }
        binding.tvId.text="ID:"+item.id.toString()
        binding.tvName.text="Name:"+item.name.toString()
        return itemView
    }
}