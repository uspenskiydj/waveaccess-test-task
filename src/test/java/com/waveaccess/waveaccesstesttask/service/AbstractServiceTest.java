package com.waveaccess.waveaccesstesttask.service;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

@SpringBootTest(properties = {"spring.datasource.url=jdbc:hsqldb:mem:test"})
@Sql(scripts = "classpath:db/data.sql", config = @SqlConfig(encoding = "UTF-8"))
public abstract class AbstractServiceTest {
}