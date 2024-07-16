package com.example.mercadinhosenai

import java.io.Serializable

class Product (var name:String, var description:String, var value:String):Serializable{
    override fun toString(): String {
        return "$name R$:$value"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product

        if (name != other.name) return false
        if (description != other.description) return false
        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + value.hashCode()
        return result
    }

}