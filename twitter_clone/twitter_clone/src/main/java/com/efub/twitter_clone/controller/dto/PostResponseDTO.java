package com.efub.twitter_clone.controller.dto;

// 응답

import com.efub.twitter_clone.domain.entity.Post;
import com.efub.twitter_clone.domain.entity.User;

import lombok.*;


import java.time.LocalDateTime;

import java.sql.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostResponseDTO {
    private Long post_id;
    private String contents;
    private Date post_date;
    private Long user_num;
    private String nickname;
    private User user;

    public Post toEntity()
    {

        Post build = Post.builder()
                .contents(contents)
                .user(user)
                .build();
        return build;
    }
    
    @Builder
    public PostResponseDTO(Post entity){
        this.post_id = entity.getPost_id();
        this.user_num = entity.getUser().getUser_num();
        this.contents = entity.getContents();
        this.nickname = entity.getUser().getNickname();
    }
}
