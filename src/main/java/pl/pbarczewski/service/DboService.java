package pl.pbarczewski.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.pbarczewski.entites.DBO;
import pl.pbarczewski.repository.DBORepository;

@Service
public class DboService {
	private final DBORepository dboRepository;

	@Autowired
	public DboService(DBORepository dboRepository) {
		this.dboRepository = dboRepository;
	}
	
	public List<DBO> getAllDBO() {
		return this.dboRepository.findAll();
	}
	
	public void saveDbo(DBO dbo) throws Exception {
		if(dbo != null)  {
			this.dboRepository.save(dbo);
		} else {
			throw new Exception("Dbo is null");	
		}
	}
}
