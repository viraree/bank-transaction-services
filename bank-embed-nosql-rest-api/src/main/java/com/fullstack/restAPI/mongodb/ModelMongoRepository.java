package com.fullstack.restAPI.mongodb;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ModelMongoRepository extends PagingAndSortingRepository<Model, String> {
}     