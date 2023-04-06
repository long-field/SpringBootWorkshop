package com.example.springshop.repositories;

import com.example.springshop.domain.WorkshopUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Sql("/testdata.sql")
class WorkshopUserRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private static final String WORSHOPUSERS = "workshopusers";
    @Autowired
    private WorkshopUserRepository workshopUserRepository;
    private long idTestUser() {
        return jdbcTemplate.queryForObject( "select id from workshopusers where voornaam = 'MiroTEST'", Long.class);
    }
    @Test
    void saveWorkshopUser(){
        var wsUser = new WorkshopUser("Dikke","Bertha","db@db.com",12);
        workshopUserRepository.save(wsUser);
        var id = wsUser.getId();
        assertThat(id).isPositive();
        assertThat(countRowsInTableWhere(WORSHOPUSERS,"id = " + id)).isOne();
    }



}
