package com.example.parkzapp.model.api

import com.example.parkzapp.model.pojo.AccessTokenResponse
import com.example.parkzapp.model.pojo.UserData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET(APIConstants.FETCH_DATA)
    suspend fun fetchViewAll(@Path("profile_id") profile_id:String,
                              @Query("fields") fields: String,
                              @Query("limit") limit: Int,
                              @Query("offset") offset: Int): Response<List<UserData>>
    @GET(APIConstants.MY_DATA)
    suspend fun fetchMyData(@Path("profile_id") profile_id:String,
                             @Path("pageid") pageid: String): Response<List<UserData>>

    @POST(APIConstants.ACCESS_TOKEN)
    suspend fun getAccessToken(@Body map: HashMap<String, String>):Response<AccessTokenResponse>
}