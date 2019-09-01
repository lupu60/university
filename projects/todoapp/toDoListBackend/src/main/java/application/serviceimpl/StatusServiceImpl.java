package application.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Status;
import application.repository.StatusRepository;
import application.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService {

	@Autowired
	StatusRepository statusRepository;

	@Override
	public List<Status> getAllStatuses() {
		return statusRepository.findAll();
	}

}
