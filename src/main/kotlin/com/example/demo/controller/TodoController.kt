package com.example.demo.controller

import com.example.demo.model.Greeting
import com.example.demo.model.Todo
import com.example.demo.service.TodoDesrvice
import org.springframework.web.bind.annotation.*
import java.util.concurrent.atomic.AtomicLong


@RestController
@RequestMapping(value = ["/todo"])
class TodoController(val todoService: TodoDesrvice) {

    @GetMapping(value = ["/getAll"])
    fun getAll() = todoService.getAll()

    @PostMapping(value = ["/addNew"])
    fun addNew(@RequestBody todo: Todo) = todoService.addNew(todo)

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Long) = todoService.findById(id)

    @DeleteMapping(value = ["/{id}"])
    fun deletById(@PathVariable id: Long) = todoService.deletById(id)

    @PutMapping(value = ["/{id}"])
    fun updateById(@PathVariable id: Long, @RequestBody todo: Todo): Todo {
        val toUpdate: Todo = todoService.findById(id).orElseThrow { Exception("server error") }
        toUpdate.text = todo.text
        toUpdate.done = todo.done
        return todoService.addNew(toUpdate)
    }


    val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Greeting(counter.incrementAndGet(), "Hello, $name")
}