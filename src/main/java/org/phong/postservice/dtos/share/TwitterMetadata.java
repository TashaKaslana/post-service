package org.phong.postservice.dtos.share;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TwitterMetadata implements MetadataInterface {
    private List<String> hashtags;
    private Integer retweetCount;
    private Integer likeCount;
}
