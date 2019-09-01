package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.model.Category;
import application.service.CategoryService;
@CrossOrigin
@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "/categories", produces = "application/json")
	public List<Category> getAllCategories() {
		return categoryService.getAllCategories();
	}
}
