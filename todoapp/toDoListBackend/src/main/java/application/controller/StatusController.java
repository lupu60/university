package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.model.Status;
import application.service.StatusService;
@CrossOrigin
@RestController
public class StatusController {

	@Autowired
	StatusService statusService;

	@RequestMapping(value = "/statuses", produces = "application/json")
	public List<Status> getAllStatuses() {
		return statusService.getAllStatuses();
	}
}
