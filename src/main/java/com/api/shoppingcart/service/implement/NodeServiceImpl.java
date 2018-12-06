package com.api.shoppingcart.service.implement;

import java.util.List;
import java.util.Optional;

import com.api.shoppingcart.dao.NodeDao;
import com.api.shoppingcart.dto.CartDto;
import com.api.shoppingcart.dto.NodeDto;
import com.api.shoppingcart.service.ConverterService;
import com.api.shoppingcart.service.NodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeServiceImpl implements NodeService {
    @Autowired
    private ConverterService converterService;

    @Autowired
    private NodeDao repo;

    /**
     * Add Node to the Data Base
     */
    public NodeDto addNode(NodeDto node, CartDto cart) {
        return converterService.convert(repo.save(converterService.convert(node, converterService.convert(cart))));

    }

    /**
     * Retrive a Node from the Data Base
     */
    public Optional<NodeDto> getNode(long id) {
        return null;
    };

    /**
     * Remove a Node from the Data Base
     */
    public void removeNode(long id) {
    };

    /**
     * Remove all Nodes from a cart
     */
    public void removeAll(long id) {
    };

    /**
     * Retrive all Nodes from a cart
     */
    public List<NodeDto> getAll(long id) {
        return null;
    };

    public boolean exists(Long id) {
        return repo.existsById(id);
    }

    public NodeDto updateNode(NodeDto node) {
        Node n = repo.getOne(node.getNodeId());
        n.setQuantity(node.getQuantity());
        return converterService.convert(repo.save(n));
    }
}