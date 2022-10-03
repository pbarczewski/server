package pl.pbarczewski.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.pbarczewski.entites.Pedb;
import pl.pbarczewski.entites.PedbId;

public interface PedbRepository extends JpaRepository<Pedb, PedbId> {

}
