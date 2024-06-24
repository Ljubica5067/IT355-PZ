package org.example.it355pz.repository;


import org.example.it355pz.entity.Repertoar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepertoarRepository extends JpaRepository<Repertoar, Long> {
}
