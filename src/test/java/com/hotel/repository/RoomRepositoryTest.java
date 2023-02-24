package com.hotel.repository;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import com.hotel.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class RoomRepositoryTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private RoomRepository roomRepository;

    @Test
    public void injectedComponentsShouldNotBeNull() {
        assertNotNull(roomRepository);
    }

    @Test
    @Sql("sql/RoomRepository/find-room-by-id.sql")
    public void shouldFindRoomByUniqueId() {
        final Long expectedId = 1L;

        final Room result = roomRepository.findByUniqueID(expectedId);

        assertNotNull(result);
        assertEquals(result.getUniqueID(), expectedId);
    }


}
