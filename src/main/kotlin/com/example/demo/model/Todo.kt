package com.example.demo.model

import java.time.Instant
import javax.persistence.*


@Entity
@Table(name = "todo")
data class Todo(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        var text: String = "",
        var done: Boolean = false,
        val createdAt: Instant = Instant.now())
