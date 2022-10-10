package pl.pbarczewski.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.pbarczewski.entites.File;
import pl.pbarczewski.entites.Segment;
import pl.pbarczewski.service.FilesService;
import pl.pbarczewski.service.SegmentsService;


@RestController
public class SegmentController {
	private final FilesService filesService;
	private SegmentsService segmentsService;
	
	
	@Autowired
	public SegmentController(FilesService filesService, SegmentsService segmentsService) {
		this.filesService = filesService;
		this.segmentsService = segmentsService;
	}

	@DeleteMapping("/segments")
	public void deleteSegment(@RequestBody Segment segment) {
		this.segmentsService.deleteSegment(segment);
	}
	
	@PostMapping("/segments")
	public void createSegment(@RequestBody Segment segment) {
		File file =  this.filesService.findFile(segment.getFileId());
	//	file.getSegments().add(segment);
		this.segmentsService.saveSagment(segment);
		System.out.println(segment.getGuId());
		System.out.println(segment.getFileId());
		System.out.println(file.getSegments().size() + " to jest ");
	}
	
	
}
