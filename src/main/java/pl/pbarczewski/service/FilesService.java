package pl.pbarczewski.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.pbarczewski.entites.File;
import pl.pbarczewski.repository.FilesRepository;

@Service
public class FilesService {
	private final FilesRepository filesRepository;

	@Autowired
	public FilesService(FilesRepository filesRepository) {
		this.filesRepository = filesRepository;
	}

	public List<File> getAllFiles() {
		List<File> allFiles = this.filesRepository.findAll();
		return allFiles;
	}
	
	public void deleteFile(File file) {
		if(file != null) {
			this.filesRepository.delete(file);
		}
	}
	
	public void saveFile(File file) {
		if(file != null) {
			this.filesRepository.save(file);
		}
	}
	
	public File findFile(int guId) {
		Optional<File> file = this.filesRepository.findById(guId);
		if(file.isPresent()) {
			return file.get();
		} else {
			return null;
		}
	}
}
