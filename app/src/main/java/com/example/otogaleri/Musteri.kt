package com.example.otogaleri

class Musteri {
    var adres: String = ""
    var adsoyad: String = ""
    var email: String = ""
    var tc: Int = 0
    var telefon: Int = 0

    constructor() // Varsayılan yapıcı yöntemi ekleyin

    constructor(adres: String, adsoyad: String, email: String, tc: Int, telefon: Int) {
        this.adres = adres
        this.adsoyad = adsoyad
        this.email = email
        this.tc = tc
        this.telefon = telefon
    }
}

