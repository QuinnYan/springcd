package com.kdk.springcd.service;
import com.kdk.springcd.entity.VideoInfo;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.sound.sampled.BooleanControl;
import java.util.List;


public interface VideoService {
    /**
     *
     * @param video_id
     * @return
     */
    VideoInfo getVideoByID(String video_id);

    /**
     *
     * @return
     */
    List<VideoInfo> getRecVideo(Integer video_num);

//    /**
//     *
//     * @param video_id
//     * @param user_id
//     * @return
//     */
//    VideoInfo getLike(String video_id, String user_id);
    /**
     * 点赞视频
     * @param video_id
     * @param user_id
     */
    Boolean likeVideo(String video_id, String user_id) throws Exception;

    /**
     *取消点赞
     * @param video_id
     * @param user_id
     */
    Boolean likeVideoCancel(String video_id, String user_id)throws Exception;

    /**
     *
     * @param video_id
     * @param user_id
     */
    void collectVideo(String video_id, String user_id);

    /**
     *
     * @param video_name
     * @return
     */
    List<VideoInfo> getVideoByName(String video_name);

    /**
     *
     * @param file
     * @param filePath
     * @param fileName
     * @param video_description
     * @param user_ID
     * @throws Exception
     */
    void uploadVideo(byte[] file, String filePath, String fileName, String video_description, String user_ID) throws Exception;
}
