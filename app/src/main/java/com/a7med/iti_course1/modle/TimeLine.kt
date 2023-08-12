package com.a7med.iti_course1.modle

import com.google.gson.annotations.SerializedName

data class TimeLine (
    @SerializedName("first_name")
    var firstname:String,
    @SerializedName("last_name")
    var lastname:String,
    @SerializedName("email")
    var email:String,
    @SerializedName("id")
    var id:Int,
    @SerializedName("avatar")
    var avatar:String){

}