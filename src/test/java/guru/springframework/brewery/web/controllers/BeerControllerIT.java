package guru.springframework.brewery.web.controllers;

import guru.springframework.brewery.web.model.BeerPagedList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

// Integration Test (IT) will bring the real server up and data will come from database
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BeerControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @DisplayName("IT - test list beers - No parameters")
    @Test
    void testListBeers() {
        BeerPagedList beerPagedList = restTemplate.getForObject("/api/v1/beer", BeerPagedList.class);

        assertThat(beerPagedList.getContent()).hasSize(3);
    }
}
