package com.globant.bootcamp.dao;

import com.globant.bootcamp.model.Node;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeDao extends JpaRepository<Node, Long> {

}