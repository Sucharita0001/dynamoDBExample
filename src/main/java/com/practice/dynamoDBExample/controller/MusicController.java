package com.practice.dynamoDBExample.controller;

import com.practice.dynamoDBExample.entity.Music;
import com.practice.dynamoDBExample.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MusicController {

    @Autowired
    private MusicRepository musicRepository;

    @PostMapping("/saveMusic")
    public Music saveMusic(@RequestBody Music music){
        return musicRepository.save(music);
    }

    @GetMapping("/getMusic/{artist}/{songTitle}")
    public Music getMusic(@PathVariable("artist") String artist, @PathVariable("songTitle") String songTitle){
        return musicRepository.getMusicById(artist,songTitle);
    }

    @DeleteMapping("/deleteMusic")
    public String deleteMusic(String artist){
        return musicRepository.delete(artist);
    }

    @PutMapping("/updateMusic/{artist}")
    public String updateMusic(@PathVariable("artist") String artist,@RequestBody Music music){
        return musicRepository.update(artist,music);
    }
}
