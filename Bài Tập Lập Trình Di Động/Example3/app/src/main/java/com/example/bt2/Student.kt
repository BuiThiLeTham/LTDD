package com.example.bt2

data class Student(var id: Int, var name: String):java.io.Serializable
//Student là một data class có hai thuộc tính id và name, dùng để đại diện cho một sinh viên.
//Kế thừa Serializable giúp Student có thể được truyền qua Intent.