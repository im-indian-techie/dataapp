package com.example.parkzapp.model.pojo

import com.google.gson.annotations.SerializedName

data class UserData (

    @SerializedName("id"          ) var id          : Int?         = null,
    @SerializedName("name"        ) var name        : String?      = null,
    @SerializedName("permissions" ) var permissions : Permissions? = Permissions()






){
    data class Permissions (

        @SerializedName("modify"  ) var modify  : Boolean? = null,
        @SerializedName("view"    ) var view    : Boolean? = null,
        @SerializedName("collect" ) var collect : Boolean? = null

    )
}
