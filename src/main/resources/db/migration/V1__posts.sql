CREATE TABLE post_interactions
(
    id               UUID         NOT NULL,
    created_at       TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at       TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    user_id          UUID         NOT NULL,
    interaction_type VARCHAR(255) NOT NULL,
    post_id          UUID         NOT NULL,
    CONSTRAINT pk_post_interactions PRIMARY KEY (id)
);

CREATE TABLE posts
(
    id          UUID         NOT NULL,
    created_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    author_id   UUID         NOT NULL,
    title       VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    post_type   VARCHAR(255) NOT NULL,
    visibility  VARCHAR(255) DEFAULT 'PUBLIC',
    metadata    JSONB,
    CONSTRAINT pk_posts PRIMARY KEY (id)
);

CREATE UNIQUE INDEX unique_interaction_per_user ON post_interactions (post_id, user_id);

ALTER TABLE post_interactions
    ADD CONSTRAINT FK_POST_INTERACTIONS_ON_POST FOREIGN KEY (post_id) REFERENCES posts (id);