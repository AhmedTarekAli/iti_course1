package com.a7med.iti_course1.modle

import com.google.gson.annotations.SerializedName

data class Support(
  @SerializedName ("url")
    var url:String,
  @SerializedName ("text")
    var text:String){}
