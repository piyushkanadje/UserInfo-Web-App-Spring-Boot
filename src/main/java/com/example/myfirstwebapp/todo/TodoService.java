package com.example.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	static int todoCount = 0;
	static {

		todos.add(new Todo(0, "piyushKandje", "learn SpringBoot", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todoCount, "piyushKandje", "learn DOCKER", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todoCount, "piyushKandje", "learn DevOps", LocalDate.now().plusYears(3), false));

	}

	public List<Todo> findByUsername(String username) {
		return todos;
	}

	public void addTodo(String email, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todoCount, email, description, targetDate, done);
		todos.add(todo);
	}

	public String deleteTodo(int id) {

		Predicate<? super Todo> predicate = todos -> todos.getId() == id; //function to check id present or not
		todos.removeIf(predicate); // we have created predicate because we want to check is the id is present or
									// not
		return "redirect:list-todos";
	}

	public Todo findById(int  id) {
		Predicate<? super Todo> predicate = todos -> todos.getId() == id; //function to check id present or not
		
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		deleteTodo(todo.getId());
		todos.add(todo);	
	}
}
