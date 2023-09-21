CREATE SEQUENCE IF NOT EXISTS post_comment_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS post_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS revinfo_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE post
(
    id      BIGINT NOT NULL,
    title   VARCHAR(255),
    slug    VARCHAR(255),
    version BIGINT,
    CONSTRAINT pk_post PRIMARY KEY (id)
);

CREATE TABLE post_aud
(
    rev     INTEGER NOT NULL,
    revtype SMALLINT,
    id      BIGINT  NOT NULL,
    title   VARCHAR(255),
    slug    VARCHAR(255),
    CONSTRAINT pk_post_aud PRIMARY KEY (rev, id)
);

CREATE TABLE post_comment
(
    id      BIGINT NOT NULL,
    review  VARCHAR(255),
    version BIGINT,
    post_id BIGINT,
    CONSTRAINT pk_postcomment PRIMARY KEY (id)
);

CREATE TABLE post_comment_aud
(
    rev     INTEGER NOT NULL,
    revtype SMALLINT,
    id      BIGINT  NOT NULL,
    review  VARCHAR(255),
    post_id BIGINT,
    CONSTRAINT pk_postcomment_aud PRIMARY KEY (rev, id)
);

CREATE TABLE revinfo
(
    rev      INTEGER NOT NULL,
    revtstmp BIGINT,
    CONSTRAINT pk_revinfo PRIMARY KEY (rev)
);

ALTER TABLE post
    ADD CONSTRAINT uc_post_slug UNIQUE (slug);

ALTER TABLE post_comment_aud
    ADD CONSTRAINT FK_POSTCOMMENT_AUD_ON_REV FOREIGN KEY (rev) REFERENCES revinfo (rev);

ALTER TABLE post_comment
    ADD CONSTRAINT FK_POSTCOMMENT_ON_POST FOREIGN KEY (post_id) REFERENCES post (id);

ALTER TABLE post_aud
    ADD CONSTRAINT FK_POST_AUD_ON_REV FOREIGN KEY (rev) REFERENCES revinfo (rev);