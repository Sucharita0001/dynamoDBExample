package com.practice.dynamoDBExample.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "Music")
public class Music {

    @DynamoDBHashKey(attributeName = "Artist")
    private String artist;

    @DynamoDBRangeKey(attributeName = "SongTitle")
    private String songTitle;

    @DynamoDBAttribute(attributeName = "TimeInMS")
    private long timeInMs;
}
