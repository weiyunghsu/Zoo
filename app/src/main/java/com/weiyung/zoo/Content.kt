package com.weiyung.zoo

data class Content(
    val _id: Int,
    val E_no: Int,
    val E_Category: String,
    val E_Name: String,
    val E_Pic_URL:String,
    val E_Info:String,
    val E_Memo:String,
    val E_Geo:String,
    val E_URL:String,
)

data class Animal(
    val  _id: Int,
    val A_Name_Ch:String,
    val A_Name_Latin:String,
    val A_AlsoKnown:String,
    val A_Habitat:String,
    val A_Feature:String,
    val A_Behavior:String,
)

