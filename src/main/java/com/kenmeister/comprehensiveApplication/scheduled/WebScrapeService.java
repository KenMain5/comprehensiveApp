package com.kenmeister.comprehensiveApplication.scheduled;

import com.kenmeister.comprehensiveApplication.entity.JobTargetEntity;
import com.kenmeister.comprehensiveApplication.repository.JobMatchRepository;
import com.kenmeister.comprehensiveApplication.repository.JobTargetRepository;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class WebScrapeService {

    @Value("${custom.target.link}") private String usaaLink;
    private JobTargetRepository jobTargetRepository;
    private JobMatchRepository jobMatchRepository;

    public WebScrapeService(JobTargetRepository jobTargetRepository, JobMatchRepository jobMatchRepository) {
        this.jobTargetRepository = jobTargetRepository;
        this.jobMatchRepository = jobMatchRepository;
    }

    public void checkJobListings() throws IOException {

        List<JobTargetEntity> jobTargetList = jobTargetRepository.findAll();

        Document doc = Jsoup.connect(usaaLink)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Accept-Language", "en-US,en;q=0.9")
                .header("Connection", "keep-alive")
                .header("Referer", "https://www.google.com")
                .header("Upgrade-Insecure-Requests", "1")
                .get();

        //Select elements using CSS Selectors
        Elements links = doc.select("a");

        // Print out all links
        for (Element link : links) {
            System.out.println(link.attr("href") + " - " + link.text());
        }
    }
}
