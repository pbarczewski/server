package pl.pbarczewski.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pbarczewski.entites.Pedb;
import pl.pbarczewski.repository.PedbRepository;

@Service
public class PedbService {
	private final PedbRepository pedbRepository;

	@Autowired
	public PedbService(PedbRepository pedbRepository) {
		this.pedbRepository = pedbRepository;
	}
	
	public List<Pedb> getAllPedb() {
		return this.pedbRepository.findAll();
	}
	
	public void savePedb(Pedb pedb) throws Exception {
		if(pedb != null) {
			this.pedbRepository.save(pedb);
		} else {
			throw new Exception("Pedb is null");
		}
		
	}
}
