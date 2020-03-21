package com.example.demo.service

import com.example.demo.model.Todo
import com.example.demo.repository.TodoRepository
import org.springframework.stereotype.Service


@Service
class TodoDesrvice(val todoRepository: TodoRepository) {

    fun getAll() = todoRepository.findAll()

    fun addNew(todo: Todo) = todoRepository.save(todo)

    fun findById(id: Long) = todoRepository.findById(id)

    fun deletById(id: Long) = todoRepository.deleteById(id)

    fun updateById(id: Long, todo: Todo): Todo {
        val toUpdate: Todo = todoRepository.findById(id).orElseThrow { Exception("server error") }
        toUpdate.text = todo.text
        toUpdate.done = todo.done
        return todoRepository.save(toUpdate)
    }
}