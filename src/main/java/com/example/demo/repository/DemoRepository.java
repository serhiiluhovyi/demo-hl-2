package com.example.demo.repository;

import com.example.demo.entity.Demo;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface DemoRepository extends CrudRepository<Demo, UUID> {
  
}
