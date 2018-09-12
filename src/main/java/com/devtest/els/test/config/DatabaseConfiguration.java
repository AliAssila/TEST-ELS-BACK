package com.devtest.els.test.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configurable
@EnableMongoRepositories("com.devtest.els.repository")
@Import(value = MongoAutoConfiguration.class)
public class DatabaseConfiguration {
}
