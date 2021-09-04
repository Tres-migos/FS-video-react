package com.tresmigos.fullstackvideo.repository;

import com.tresmigos.fullstackvideo.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

    @Query(value = "SELECT * FROM video v WHERE v.acc_key = :accountId",nativeQuery = true )
    List<Video> findByUser(@Param("accountId") Long accountId);

}
