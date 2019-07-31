package com.pivovarit.movies.infrastructure;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
class GoogleHealthIndicator implements HealthIndicator {

    public static final RestTemplate REST_TEMPLATE = new RestTemplate();

    @Override
    public Health health() {
        ResponseEntity<Void> result = REST_TEMPLATE.getForEntity("http://www.google.com", Void.class);

        if (result.getStatusCode().is2xxSuccessful()) {
            return Health.up()
              .status(Status.UP)
              .withDetail("foo", "wszystko ok")
              .build();
        } else {
            return Health.down()
              .build();
        }
    }
}
