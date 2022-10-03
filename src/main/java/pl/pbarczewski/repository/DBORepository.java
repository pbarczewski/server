package pl.pbarczewski.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.pbarczewski.entites.DBO;

public interface DBORepository extends JpaRepository<DBO, Integer> {

}
