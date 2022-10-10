package pl.pbarczewski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pbarczewski.entites.File;

public interface FilesRepository extends JpaRepository<File, Integer> {

}
