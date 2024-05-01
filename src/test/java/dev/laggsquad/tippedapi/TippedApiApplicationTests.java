package dev.laggsquad.tippedapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
    properties = {
      "spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults=false",
      "spring.jpa.hibernate.ddl-auto=none"
    })
class TippedApiApplicationTests {

  @Test
  void contextLoads() {}
}
