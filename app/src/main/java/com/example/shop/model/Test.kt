package com.example.shop.model

import androidx.room.*

@Entity
data class Test(
    //autoGenerate는 null을 받으면 ID 값을 자동으로 할당
    @PrimaryKey(autoGenerate = true)
    var id : Int?,

    @ColumnInfo(name ="title")
    var title: String,

    @ColumnInfo(name="description")
    var description: String,

    @ColumnInfo(name="imageUrl")
    var imageUrl: String
){
    constructor() : this(null,"","","")
}