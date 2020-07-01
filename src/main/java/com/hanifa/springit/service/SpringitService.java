package com.hanifa.springit.service;

import com.hanifa.springit.domain.Link;
import com.hanifa.springit.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpringitService {
    @Autowired
    LinkRepository linkRepository;

    public Optional<Link> getLinkDetailsById(Long linkId) {
        return linkRepository.findById(linkId);
    }

    public List<Link> getLinks() {
        return linkRepository.findAll();
    }

    public boolean createLink(Link link){
         linkRepository.save(link);
         return true;
    }
}
