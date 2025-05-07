package com.mynic.menulateral

//Estructura de los datos
data class User(val id: Int, val nombre: String, val email: String)

//Definimos la lista

var listaUsuarios = mutableListOf(
    User(1,"Juan Lopez", "jp@yahoo.es")
    , User(2,"Maria Mendoza", "mm@yahoo.es")
    ,User(3,"Oscar Flete", "of@yahoo.es")
)

