package com.example.demo.repository

import com.example.demo.model.Todo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface TodoRepository: JpaRepository<Todo, Long> {

}