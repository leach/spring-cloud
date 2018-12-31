package com.anythy.auth.authdata.repository;

import com.anythy.auth.authdata.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("select t from Department t where t.name like :name")
    Page<Department> findByName(@Param("name") String name, Pageable pageRequest);
}
