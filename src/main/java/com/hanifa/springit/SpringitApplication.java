package com.hanifa.springit;

import com.hanifa.springit.config.SpringitProperties;
import com.hanifa.springit.domain.Comment;
import com.hanifa.springit.domain.Link;
import com.hanifa.springit.repository.CommentRepository;
import com.hanifa.springit.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableJpaAuditing
public class SpringitApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
        return args -> {
            /*Link link1 = new Link("Getting Started with SpringBoot 2", "https://hanifa.com");
            linkRepository.save(link1);

            Comment comment = new Comment("This springboot link", link1);
            commentRepository.save(comment);

            link1.addComment(comment);

            Link firstLink = linkRepository.findByTitle("Getting Started with SpringBoot 2");
            System.out.println("Link "+firstLink);*/

            /*List<String> result = linkRepository.findAll()
                    .stream()
                    .filter((lnk) -> "first link".equals(lnk.getTitle()))
                    .findAny()
                    .orElse(null);*/
        };
    }
}
