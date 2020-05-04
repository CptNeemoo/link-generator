package com.cptneemoo.linkgenerator.repository;

import com.cptneemoo.linkgenerator.entity.RequestResult;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestResultRepository extends CrudRepository<RequestResult, Long> {
}
