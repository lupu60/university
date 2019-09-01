package application.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Priority;
import application.repository.PriorityRepository;
import application.service.PriorityService;

@Service
public class PriorityServiceImpl implements PriorityService {

	@Autowired
	PriorityRepository priorityRepository;
	
	@Override
	public List<Priority> getAllPriorities() {
		return priorityRepository.findAll();
	}

}
