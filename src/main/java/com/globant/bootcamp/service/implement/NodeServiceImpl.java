package com.globant.bootcamp.service.implement;

import com.globant.bootcamp.dao.NodeDao;
import com.globant.bootcamp.model.Node;
import com.globant.bootcamp.service.NodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class NodeServiceImpl implements NodeService {
    @Autowired
    private NodeDao repo;

    @Override
    public Node add(Node node) {
        return repo.save(node);
    }

    @Override
    public Node update(Node node, int q) {
        Node n = repo.getOne(node.getnodeId());
        n.setQuantity(q);
        return repo.save(n);
    }

    @Override
    public void remove(Node node) {
        repo.delete(node);
    }

    @Override
    public boolean exists(Long id) {
        return repo.existsById(id);
    }

}