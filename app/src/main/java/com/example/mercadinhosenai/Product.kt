package com.example.mercadinhosenai

import java.io.Serializable

class Product (var name:String, var description:String, var value:String):Serializable{
    override fun toString(): String {
        return "$name R$:$value"
    }
}