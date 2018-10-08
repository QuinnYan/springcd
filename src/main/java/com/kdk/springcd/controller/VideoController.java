package com.kdk.springcd.controller;

import com.kdk.springcd.entity.VideoInfo;
import com.kdk.springcd.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideoController {

    @Autowired
    VideoService videoService;

    @RequestMapping(value = "getRecVideo", method = RequestMethod.GET)
    public List<VideoInfo> getRecVideo(){
        int length_of_video = 10;
        List<VideoInfo> RecVideoList = videoService.getRecVideo(length_of_video);

        return RecVideoList;
    }
    @RequestMapping(value = "likeVideo", method = RequestMethod.POST)
    public void likeVideo(String user_id, String video_id) throws Exception {
        videoService.likeVideo(video_id, user_id);
    }
    @RequestMapping(value = "collectVideo", method = RequestMethod.POST)
    public void collectVideo(String user_id, String video_id){
        videoService.collectVideo(video_id, user_id);
    }
}
