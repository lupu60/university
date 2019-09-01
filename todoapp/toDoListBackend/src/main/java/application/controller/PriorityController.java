package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import application.model.Priority;
import application.service.PriorityService;
@CrossOrigin
@RestController
public class PriorityController {
	@Autowired
	PriorityService priorityService;

	@RequestMapping(value = "/priorities", produces = "application/json")
	public @ResponseBody List<Priority> getAllPriorities() {
		return priorityService.getAllPriorities();
	}
}
