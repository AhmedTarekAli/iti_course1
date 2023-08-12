package com.a7med.iti_course1.modle

import com.google.gson.annotations.SerializedName

data class ResponsDataList(
   @SerializedName ("page")
    var page:Int,
   @SerializedName ("per_page")
    var perpage:Int,
   @SerializedName ("total")
    var total:Int,
   @SerializedName ("total_pages")
    var totalpage:Int,
   @SerializedName ("data")
    var data:List<TimeLine>,
   @SerializedName ("support")
    var support:Support
){}
