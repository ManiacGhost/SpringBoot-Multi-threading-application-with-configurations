package com.example.threadScheduler.Repository;

import com.example.threadScheduler.Entity.InternalOrderEntityV1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternalOrderRepositoryV1 extends JpaRepository<InternalOrderEntityV1, String> {
}