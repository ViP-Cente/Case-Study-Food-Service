package com.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.model.Moderator;

@Repository
public interface ModeratorRepository extends JpaRepository<Moderator, Integer>{
}
