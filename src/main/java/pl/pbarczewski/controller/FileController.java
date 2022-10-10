package pl.pbarczewski.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.pbarczewski.entites.File;
import pl.pbarczewski.service.FilesService;
import pl.pbarczewski.service.SegmentsService;


@RestController
public class FileController {
	private final FilesService filesService;
	private SegmentsService segmentsService;
	
	
	@Autowired
	public FileController(FilesService filesService, SegmentsService segmentsService) {
		this.filesService = filesService;
		this.segmentsService = segmentsService;
	}

	@GetMapping("/files")
	public List<File> getFiles() {
		return this.filesService.getAllFiles();
	}
	
	@DeleteMapping("/files")
	public void deleteFile(@RequestBody File file) {
		this.filesService.deleteFile(file);
	}
	
	@PostMapping("/files") 
	public void createFile(@Valid @RequestBody File file) throws Exception {
		this.filesService.saveFile(file);
		System.out.println(file.getFileName());
		System.out.println(file.getAddedOn());
	}
	
	
	
	
}
