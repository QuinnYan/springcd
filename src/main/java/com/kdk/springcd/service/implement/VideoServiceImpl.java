package com.kdk.springcd.service.implement;

import com.kdk.springcd.entity.VideoInfo;
import com.kdk.springcd.service.VideoService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public VideoInfo getVideoByID(String video_id){

        VideoInfo videoInfo = new VideoInfo();
        Map<String,Object> map = jdbcTemplate.queryForMap("select * from video_all where video_id = ? " ,video_id);
        videoInfo.setVideoID(map.get("video_id").toString());
        videoInfo.setVideoURL(map.get("video_url").toString());
        videoInfo.setVideoCollection(map.get("video_collection").toString());
        videoInfo.setUserID(map.get("user_id").toString());
        videoInfo.setVideoLike((Integer)map.get("video_like"));

        return videoInfo;
    }

    @Override
    public List<VideoInfo> getRecVideo(Integer video_num){

       String sql = "select * from video_all order by video_like DESC LIMIT 0,?;";
       List<VideoInfo> recVideoList = new ArrayList<>();
       List<Map<String,Object>> objList = jdbcTemplate.queryForList(sql,video_num);
       for(Map<String,Object> map : objList){
           VideoInfo videoInfo = new VideoInfo();
           videoInfo.setVideoID(map.get("video_id").toString());
           videoInfo.setVideoURL(map.get("video_url").toString());
           videoInfo.setVideoCollection(map.get("video_collection").toString());
           videoInfo.setUserID(map.get("user_id").toString());
           videoInfo.setVideoLike((Integer)map.get("video_like"));

           recVideoList.add(videoInfo);
       }
       return recVideoList;

    }

    @Override
    public Boolean likeVideo(String video_id, String user_id) throws Exception{

        try{
            Map<String,Object> map = jdbcTemplate.queryForMap( "select * from video_like_person where video_id = ? AND user_id = ?",video_id,user_id);
            System.out.println("have like already");

        }catch(Exception e){
            System.out.println("no like now");
            // 点赞数增加
            String sql = "update video_all set video_like = video_like + 1 where video_id = ?";
            jdbcTemplate.update(sql,video_id);
            //  在连接表中加入条目
            sql = "insert into video_like_person (video_id, user_id) values(?,?)";
            jdbcTemplate.update(sql,video_id,user_id);
            return true;
        }
        return false;
    }

    @Override
    public Boolean likeVideoCancel(String video_id, String user_id)throws Exception{
        try{
            Map<String,Object> map = jdbcTemplate.queryForMap( "select * from video_like_person where video_id = ? AND user_id = ?",video_id,user_id);
            if(null != map){
                // 点赞数减少
                String sql = "update video_all set video_like = video_like - 1 where video_id = ?";
                jdbcTemplate.update(sql,video_id);
                //  在连接表中去除条目
                sql = "delete from video_like_person where video_id = ? AND user_id = ?";
                jdbcTemplate.update(sql,video_id,user_id);

            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public void collectVideo(String video_id, String user_id){
        // 点赞数增加
        String sql = "update video_all set video_collection = video_collection + 1 where video_id = ?";
        jdbcTemplate.update(sql,video_id);
        //  在连接表中加入条目
        sql = "insert into video_collect_person (video_id, user_id) values(?,?)";
        jdbcTemplate.update(sql,video_id,user_id);
    }
}
