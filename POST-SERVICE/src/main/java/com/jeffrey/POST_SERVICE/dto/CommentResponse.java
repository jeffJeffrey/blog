package com.jeffrey.POST_SERVICE.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CommentResponse extends BaseModelDTO {
    private Long id;
    private String content;
    private Long post_id;
    private Long user_id;

}
