package com.globant.bootcamp.service;

import com.globant.bootcamp.model.Node;

public interface NodeService {
    public Node add(Node node);

    public Node update(Node node,int q);

    public void remove(Node node);

}