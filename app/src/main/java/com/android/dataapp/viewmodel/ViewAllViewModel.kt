package com.android.dataapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parkzapp.model.pojo.UserData
import com.example.parkzapp.model.repository.ViewAllRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewAllViewModel @Inject constructor(private val repository: ViewAllRepository):ViewModel() {
    val data: LiveData<List<UserData>> get() =repository.userData
    val error: LiveData<String> get()= repository.errorData
    val isLoading: LiveData<Boolean> get() = repository.isLoading
    val accessToken:LiveData<String> get()=repository.accessToken


    fun fetchData(profile_id:String,field:String,limit:Int,offset:Int) {
        viewModelScope.launch(Dispatchers.Main) {
            repository.fetchData(profile_id, field, limit, offset)
        }
    }
}