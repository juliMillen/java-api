package com.application.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.rest.entity.Maker;


@Repository
public interface IMakerRepository extends CrudRepository<Maker, Long> {

}
