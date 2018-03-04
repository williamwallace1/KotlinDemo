package com.williamwallae.kotlin.beans

data class EntityBean(val msg: List<Entity>) {
    data class Entity(val field_name : String, val schema_id : String, val field_val : String, val field_desc : String)
}