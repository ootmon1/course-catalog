package com.dxn.repository;

import org.springframework.data.repository.CrudRepository;

import com.dxn.model.Topic;

public interface TopicRepository extends CrudRepository<Topic, Long> {

}
