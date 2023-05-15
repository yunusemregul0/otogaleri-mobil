package com.example.otogaleri

class arac {
    var aracno: Int = 0
    var fiyat: Int = 0
    var hasar: String = ""
    var marka: String = ""
    var renk: String = ""
    var vites: String = ""
    var yakit: String = ""
    var yil: Int = 0


    constructor()

    constructor(aracno: Int, fiyat: Int,  hasar: String,marka: String, renk: String, vites: String, yakit: String, yil: Int)
    {
        this.aracno= aracno
        this.fiyat= fiyat
        this.hasar= hasar
        this.marka= marka
        this.renk= renk
        this.vites= vites
        this.yakit= yakit
        this.yil= yil
    }
}