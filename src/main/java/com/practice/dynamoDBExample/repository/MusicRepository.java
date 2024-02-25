package com.practice.dynamoDBExample.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.practice.dynamoDBExample.entity.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MusicRepository{

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Music save(Music music){
        dynamoDBMapper.save(music);
        return music;
    }

    public Music getMusicById(String artist, String songTitle){
        return dynamoDBMapper.load(Music.class, artist, songTitle);
    }

    public String delete(String artist){
        Music music=dynamoDBMapper.load(Music.class,artist);
        dynamoDBMapper.delete(music);
        return "Music deleted.";
    }

    public String update(String artist, Music music){
        dynamoDBMapper.save(music,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("artist",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(artist)
                                )));
        return artist;
    }
}
