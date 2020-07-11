package com.example.demo.entity.idgenerator;

import static java.util.Objects.isNull;

import com.example.demo.entity.Demo;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DemoIdGenerator implements ApplicationListener<BeforeSaveEvent> {

  @Override
  public void onApplicationEvent(BeforeSaveEvent event) {
    if (event.getEntity() instanceof Demo) {
      Demo entity = ((Demo) event.getEntity());
      log.trace("Checking if Demo requires ID generation");
      if (isNull(entity.getId())) {
        log.debug("Generating an ID for Demo {}", entity);
        entity.setId(UUID.randomUUID());
      }
    }
  }
}
