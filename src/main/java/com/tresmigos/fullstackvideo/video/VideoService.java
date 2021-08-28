package com.tresmigos.fullstackvideo.video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {

    @Autowired
    private VideoRepository repo;

    public VideoService(VideoRepository repository){
        this.repo = repository;
    }

    public Video create(Video video){
        return repo.save(video);
    }

    public Video read(Long id){
        return repo.findById(id).get();
    }

    public List<Video> readAll(){
        Iterable<Video> allVideos = repo.findAll();
        List<Video> result = new ArrayList<>();
        allVideos.forEach(result::add);
        return result;
    }

    public Video update(Long id, Video newVideoData){
        Video original = repo.findById(id).get();
        original.setTitle(newVideoData.getTitle());
        original.setAccountId(newVideoData.getAccountId());
        original.setGenre(newVideoData.getGenre());
        original.setDescription(newVideoData.getDescription());
        return repo.save(original);
    }

    public Video delete(Long id){
        Video deleted = repo.findById(id).get();
        repo.deleteById(id);
        return deleted;
    }

}
