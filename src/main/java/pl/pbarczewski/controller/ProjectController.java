package pl.pbarczewski.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.pbarczewski.entites.DBO;
import pl.pbarczewski.entites.Pedb;
import pl.pbarczewski.service.DboService;
import pl.pbarczewski.service.PedbService;

@RestController
public class ProjectController {
	private final DboService dboService;
	private final PedbService pedbService;
	
	@Autowired
	public ProjectController(DboService dboService, PedbService pedbService) {
		this.dboService = dboService;
		this.pedbService = pedbService;
	}

	@GetMapping("/projects")
	public List<Pedb> projects() {
		return pedbService.getAllPedb();
	}
	
	@PostMapping("/projects") 
	public void createObjects(@RequestBody Pedb pedb) throws Exception {
		System.out.println(pedb.getLanguages());
		System.out.println(pedb.getDbo());
		this.dboService.saveDbo(pedb.getDbo());
		this.pedbService.savePedb(pedb);
	}

}
