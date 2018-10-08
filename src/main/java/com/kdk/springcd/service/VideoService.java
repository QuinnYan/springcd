package com.kdk.springcd.service;
import com.kdk.springcd.entity.VideoInfo;

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
    void likeVideo(String video_id, String user_id) throws Exception;

    /**
     *取消点赞
     * @param video_id
     * @param user_id
     */
    void likeVideoCancel(String video_id, String user_id)throws Exception;

    /**
     *
     * @param video_id
     * @param user_id
     */
    void collectVideo(String video_id, String user_id);
}
