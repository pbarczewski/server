package pl.pbarczewski.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.pbarczewski.entites.Segment;
import pl.pbarczewski.repository.SegmentsRepository;

@Service
public class SegmentsService {
	private final SegmentsRepository segmentRepository;

	@Autowired
	public SegmentsService(SegmentsRepository segmentRepository) {
		this.segmentRepository = segmentRepository;
	}
	
	public void saveSagment(Segment segment) {
		if(segment != null) {
		this.segmentRepository.save(segment);
		}
	}
	
	public void deleteSegment(Segment segment) {
		this.segmentRepository.delete(segment);
	}
}
