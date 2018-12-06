package com.api.shoppingcart.service;

import java.util.List;
import java.util.Optional;

import com.api.shoppingcart.CartDto;
import com.api.shoppingcart.NodeDto;

public interface NodeService {
    /**
     * Add Node to the Data Base
     */
    public NodeDto addNode(NodeDto node, CartDto cart);

    public NodeDto updateNode(NodeDto node);

    /**
     * Retrive a Node from the Data Base
     */
    public Optional<NodeDto> getNode(long id);

    /**
     * Remove a Node from the Data Base
     */
    public void removeNode(long id);

    /**
     * Remove all Nodes from a cart
     */
    public void removeAll(long id);

    /**
     * Retrive all Nodes from a cart
     */
    public List<NodeDto> getAll(long id);

    public boolean exists(Long id);
}