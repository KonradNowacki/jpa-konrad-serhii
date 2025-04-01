package com.jpacourse.service;

import com.jpacourse.dto.AddressTO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    @Test
    @Transactional
    public void testShouldFindAddressById() {
        // given
        final long id = 909L;

        // when
        final AddressTO result = addressService.findById(id);

        // then
        assertThat(result.getAddressLine1()).isEqualTo("ul. Piłsudskiego 9");
        assertThat(result.getCity()).isEqualTo("Lublin");
    }

}
