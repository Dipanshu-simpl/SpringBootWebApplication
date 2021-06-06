package com.magoo.springboot.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.magoo.springboot.model.Todo;

@Service
public class TodoService {
	
	private static List<Todo> todos=new ArrayList<Todo>();
	
	private static int todoCount=3;
	
	static
	{
		todos.add(new Todo(1,"in28Minutes","Learn SpringMVC",new Date(),false));
		todos.add(new Todo(2,"in28Minutes","Learn ReactJs",new Date(),false));
		todos.add(new Todo(3,"in28Minutes","Learn Hibernate",new Date(),false));
		
	}
	
	
	public List<Todo> retriveTodos(String user)
	{
		List<Todo> filteredTodo =new ArrayList<>();
		for(Todo todo:todos)
		{
			if(todo.getUser().equals(user))
			{
				filteredTodo.add(todo);
			}
		}
		
		return filteredTodo;
	}
	
	
	
	public void addTodo(String name,String desc,Date targetDate,boolean isDone)
	{
		todos.add(new Todo(++todoCount,name,desc,targetDate,isDone));
	}
	
	
	public void deleteTodo(int id)
	{
		Iterator<Todo> it=todos.iterator();
		while(it.hasNext())
		{
			Todo todo=it.next();
			if(todo.getId()==id)
			{
				it.remove();
			}
			
		}
	}
	
	
	// Retrieve a Todo
	
	public Todo retrieveTodo(int id)
	{
		List<Todo> fiteredTodos=new ArrayList<>();
		for(Todo todo:todos)
		{
			if(todo.getId()==id)
			{
				return todo;
			}
		}
		
		return null;
	}
	
	
	public void updateTodo(Todo todo)
	{
		todos.remove(todo);
		
		todos.add(todo);
	}

}
