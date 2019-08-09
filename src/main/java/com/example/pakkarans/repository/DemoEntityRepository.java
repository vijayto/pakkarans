package com.example.pakkarans.repository;

import com.example.pakkarans.entity.DemoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoEntityRepository extends CrudRepository<DemoEntity, String> {

    DemoEntity findFirstBy();

    DemoEntity findDemoEntityByMessageLike(String message);


}
