package com.kdk.springcd.controller;

import com.kdk.springcd.entity.VideoInfo;
import com.kdk.springcd.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = "getVideoByName", method = RequestMethod.GET)
    public List<VideoInfo> getVideoByName(String name){
        List<VideoInfo> videoList = videoService.getVideoByName(name);
        if(videoList.isEmpty()){
            return null;
        }
        else{
            return videoList;
        }

    }

    @RequestMapping(value = "likeVideo", method = RequestMethod.POST)
    public void likeVideo(@RequestParam String user_id, @RequestParam String video_id) throws Exception {
        if (videoService.likeVideo(video_id, user_id));
        else
            videoService.likeVideoCancel(video_id, user_id);
    }

    @RequestMapping(value = "collectVideo", method = RequestMethod.POST)
    public void collectVideo(@RequestParam String user_id, @RequestParam String video_id){
        videoService.collectVideo(video_id, user_id);
    }

    @RequestMapping(value = "uploadVideo", method = RequestMethod.POST)
    public String upLoadVideo(@RequestParam("file") MultipartFile file,@RequestParam String video_description,@RequestParam String user_id){
        String contentType = file.getContentType();   //文件类型
        String fileName = file.getOriginalFilename();  //文件名

        //文件存放路径
        String filePath = "E:\\springcd\\data";

        //将文件写入指定位置
        try {
            videoService.uploadVideo(file.getBytes(), filePath, fileName, video_description, user_id);
        } catch (Exception e) {
            // TODO: handle exception
        }

        // 返回图片的存放路径
        return filePath;
    }
}
