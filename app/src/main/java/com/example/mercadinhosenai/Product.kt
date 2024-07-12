package com.example.mercadinhosenai

class Product (var name:String, var description:String, var value:Double){
    override fun toString(): String {
        return "$name R$:$value"
    }
}