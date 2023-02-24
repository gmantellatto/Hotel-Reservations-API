CREATE TABLE HOTEL_ROOM
(
    ROOM_ID     BIGINT                      NOT NULL    AUTO_INCREMENT,
    NAME        VARCHAR(100)                NOT NULL,
    FLOOR       INTEGER                     NOT NULL,
    NUMBER      INTEGER                     NOT NULL,
    STATUS      INTEGER         DEFAULT 0   NOT NULL,

    PRIMARY KEY(ROOM_ID)
);