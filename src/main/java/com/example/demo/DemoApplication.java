package com.example.demo;

import com.example.demo.entity.Demo;
import com.example.demo.repository.DemoRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
  
  @Autowired
  private DemoRepository repository;

  @GetMapping("/doWork")
  public ResponseEntity<Demo> doWork() {

    Demo demo = new Demo();
    demo.setBody("Test");

    Demo saved = repository.save(demo);
    Demo result = repository.findById(saved.getId()).orElseThrow(RuntimeException::new);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

}
