package com.example.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("email")
public class TodoController {

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	private TodoService todoService;

	@RequestMapping("list-todos")
	public String ListAllTodo(ModelMap model) {
		
		List<Todo> todos = todoService.findByUsername("piyushKanadje");
		model.addAttribute("todos", todos);
		return "list-todos";
	}
	
	@RequestMapping(value="add-todo",method= RequestMethod.GET)
	public String showTodoPage(ModelMap model) {
		String username = (String)model.get("name");
		Todo todo = new Todo(0, username, "", LocalDate.now(), false);
		model.put("todo", todo);
		return "addTodo";
	}
	
	@RequestMapping(value="add-todo",method= RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "addTodo";
		}
		
		String username = (String)model.get("name");
		todoService.addTodo(username, todo.getDescription(), 
			todo.getDate(), false);
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String delete(@RequestParam int id) {
		// get the todo id and check weathere its present in todo list or not id present delete
		//to delete the id we have to make one method in todoService
		
		todoService.deleteTodo(id);
		return "redirect:list-todos"; 

	}
	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id, ModelMap model) {
		Todo  todo = todoService.findById(id);
		model.addAttribute("todo", todo);
		return "update";
	}
	@RequestMapping(value="update-todo",method= RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "addTodo";
		}
		
		String username = (String)model.get("name");
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
}
