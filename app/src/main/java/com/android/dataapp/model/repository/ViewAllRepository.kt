package com.example.parkzapp.model.repository

import android.graphics.pdf.PdfDocument.Page
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.parkzapp.model.api.ApiService
import com.example.parkzapp.model.pojo.UserData
import javax.inject.Inject

class ViewAllRepository @Inject constructor(private val apiService: ApiService) {
    private val _isLoading= MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get()=  _isLoading

    private val _userData= MutableLiveData<List<UserData>>()
    private val _access_token= MutableLiveData<String>()

    val userData: LiveData<List<UserData>>
        get() = _userData
    val accessToken: LiveData<String>
        get() = _access_token

    private val _errorData= MutableLiveData<String>()
    val errorData: LiveData<String> get() = _errorData

    suspend fun fetchData( profile_id:String,field:String,limit:Int,offset:Int)
    {
        _isLoading.value=true
        try {
            val response=apiService.fetchViewAll(profile_id,field,limit, offset)
            if(response.isSuccessful && response.body()!=null)
            {
                _isLoading.value=false
                if(response.body()!!.size>0)
                {
                    _userData.value=response.body()!!
                }
                else
                {
                    _errorData.value="No data found"
                }
            }
            else
            {
                _isLoading.value=false
                _errorData.value="some error occurred"
            }
        } catch (e: Exception) {
            _isLoading.value=false
            _errorData.value="some error occurred"
        }
    }

}