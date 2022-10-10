package pl.pbarczewski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pbarczewski.entites.Segment;

public interface SegmentsRepository extends JpaRepository<Segment, Integer> {

}
