package com.CJpaAli.jpa.resource.repo;

import com.CJpaAli.jpa.resource.child.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepo extends JpaRepository<Video, Integer> {
}
