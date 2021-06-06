package com.magoo.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.magoo.springboot.model.Todo;
import com.magoo.springboot.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	// injecting dependency
	
	@Autowired
	private TodoService service;
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/YYYY");
		
		binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,false));
	}
	
	
	@RequestMapping(value="/list-todos" , method=RequestMethod.GET)
	public String showTodoList(ModelMap model)
	{
		String name=(String) model.get("name");
		model.put("todos", service.retriveTodos(name));
		return "list-todos";
	}
	
	
	// Functionality for adding a new Todo
	
	@RequestMapping(value="/add-todo" , method=RequestMethod.GET)
	public String showAddTodoPage(ModelMap model)
	{
		model.addAttribute("todo",new Todo(0,(String) model.get("name"),"",new Date(),false));
		return "todo";
	}
	
	@RequestMapping(value="/add-todo" ,  method=RequestMethod.POST)
	public String addTodo(ModelMap model,  Todo todo)
	{
		service.addTodo((String)model.get("name"), todo.getDesc(), todo.getTargetDate(), false);
		return "redirect:/list-todos";
	}
	

	@RequestMapping(value="/delete-todo"   , method=RequestMethod.GET)
	public String deleteTodo(@RequestParam int id)
	{
		//service.
		if(id==1)
		{
			throw new RuntimeException("Something went Wrong");
		}
		
		service.deleteTodo(id);
		return "redirect:/list-todos";
	}
	
	
	
	@RequestMapping(value="/update-todo", method=RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id,ModelMap model)
	{
		Todo todo=service.retrieveTodo(id);
		model.put("todo", todo);
		return "todo";
	}
	
	
	@RequestMapping(value="/update-todo", method=RequestMethod.POST)
	public String updateTodo(Todo todo,ModelMap model)
	{
		todo.setUser((String) model.get("name"));
		service.updateTodo(todo);
		return "redirect:/list-todos";
	}
}
