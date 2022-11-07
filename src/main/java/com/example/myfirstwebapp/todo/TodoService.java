package com.example.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class TodoService {
  private static List<Todo> todos = new ArrayList<>();
  
  static {
	  
	  todos.add(new Todo(0, "piyushKandje", "learn SpringBoot", LocalDate.now().plusYears(1), false));
	  todos.add(new Todo(1, "piyushKandje", "learn DOCKER", LocalDate.now().plusYears(2), false));
	  todos.add(new Todo(2, "piyushKandje", "learn DevOps", LocalDate.now().plusYears(3), false));
	  
  }
  
  public  List<Todo> findByUsername(String username){
	  return todos;
  }
}
