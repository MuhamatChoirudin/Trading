package com.bootcamp.sti.wall.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.sti.wall.model.StatusType;
public interface StatusTypeRepository extends JpaRepository<StatusType, String>  {

}
