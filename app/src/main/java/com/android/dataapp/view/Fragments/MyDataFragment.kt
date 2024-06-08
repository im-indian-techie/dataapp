package com.android.dataapp.view.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.android.dataapp.R
import com.android.dataapp.databinding.FragmentMyDataBinding
import com.android.dataapp.databinding.FragmentViewAllBinding
import com.android.dataapp.view.adapter.ViewAllAdapter
import com.android.dataapp.viewmodel.MyDataViewModel
import com.android.dataapp.viewmodel.ViewAllViewModel
import com.example.parkzapp.model.pojo.UserData
import dagger.hilt.android.AndroidEntryPoint
import dmax.dialog.SpotsDialog

@AndroidEntryPoint
class MyDataFragment : Fragment() {
    lateinit var binding: FragmentMyDataBinding
    private val viewModel: MyDataViewModel by viewModels()
    private val list:ArrayList<UserData> = ArrayList()
    lateinit var adapter: ViewAllAdapter
    lateinit var progressDialog: SpotsDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentMyDataBinding.inflate(inflater,container,false)
        initUi()
        return binding.root
    }

    private fun initUi() {
        progressDialog= SpotsDialog(requireContext())
        adapter= ViewAllAdapter(list,requireContext(),"My Data")
        binding.lvViewAll.adapter=adapter
        adapter.notifyDataSetChanged()

        viewModel.data.observe(viewLifecycleOwner, Observer {
            if(it.isNotEmpty()) {
                list.clear()
                binding.lvViewAll.visibility=View.VISIBLE
                binding.tvData.visibility=View.GONE

                list.addAll(it)
                adapter.notifyDataSetChanged()
            }
            else
            {
                binding.tvData.visibility=View.VISIBLE
                binding.lvViewAll.visibility=View.GONE
            }
        })
        viewModel.error.observe(viewLifecycleOwner, Observer {
            binding.tvData.visibility=View.VISIBLE
            binding.lvViewAll.visibility=View.GONE
            Toast.makeText(requireContext(),it, Toast.LENGTH_SHORT).show()
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            if (it)
            {
                progressDialog.show()
            }
            else
            {
                progressDialog.dismiss()
            }
        })

        getList()
    }
    private fun getList()
    {
        val profile_id="507127"
        val page_id:String="3899551"
        viewModel.fetchData(profile_id, page_id)
    }

}