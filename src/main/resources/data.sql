INSERT INTO BAND(ID, NAME) VALUES (1000, 'Band1');
INSERT INTO BAND(ID, NAME) VALUES (1001, 'Band2');
INSERT INTO BAND(ID, NAME) VALUES (1002, 'Band3');
INSERT INTO BAND(ID, NAME) VALUES (1003, 'Band4');
INSERT INTO BAND(ID, NAME) VALUES (1004, 'Band5');
INSERT INTO BAND(ID, NAME) VALUES (1005, 'Band6');
INSERT INTO BAND(ID, NAME) VALUES (1006, 'Band7');
INSERT INTO BAND(ID, NAME) VALUES (1007, 'Band8');
INSERT INTO BAND(ID, NAME) VALUES (1008, 'Band9');
INSERT INTO BAND(ID, NAME) VALUES (1009, 'Band10');

INSERT INTO MEMBER(ID, NAME) VALUES (1001,'Member1');
INSERT INTO MEMBER(ID, NAME) VALUES (1002,'Member2');
INSERT INTO MEMBER(ID, NAME) VALUES (1003,'Member3');
INSERT INTO MEMBER(ID, NAME) VALUES (1004,'Member4');
INSERT INTO MEMBER(ID, NAME) VALUES (1005,'Member5');
INSERT INTO MEMBER(ID, NAME) VALUES (1006,'Member6');
INSERT INTO MEMBER(ID, NAME) VALUES (1007,'Member7');
INSERT INTO MEMBER(ID, NAME) VALUES (1008,'Member8');
INSERT INTO MEMBER(ID, NAME) VALUES (1009,'Member9');
INSERT INTO MEMBER(ID, NAME) VALUES (1010,'Member10');
INSERT INTO MEMBER(ID, NAME) VALUES (1011,'Member11');
INSERT INTO MEMBER(ID, NAME) VALUES (1012,'Member12');
INSERT INTO MEMBER(ID, NAME) VALUES (1013,'Member13');
INSERT INTO MEMBER(ID, NAME) VALUES (1014,'Member14');
INSERT INTO MEMBER(ID, NAME) VALUES (1015,'Member15');
INSERT INTO MEMBER(ID, NAME) VALUES (1016,'Member16');
INSERT INTO MEMBER(ID, NAME) VALUES (1017,'Member17');
INSERT INTO MEMBER(ID, NAME) VALUES (1018,'Member18');
INSERT INTO MEMBER(ID, NAME) VALUES (1019,'Member19');
INSERT INTO MEMBER(ID, NAME) VALUES (1020,'Member20');
INSERT INTO MEMBER(ID, NAME) VALUES (1021,'Member21');
INSERT INTO MEMBER(ID, NAME) VALUES (1022,'Member22');
INSERT INTO MEMBER(ID, NAME) VALUES (1023,'Member23');
INSERT INTO MEMBER(ID, NAME) VALUES (1024,'Member24');
INSERT INTO MEMBER(ID, NAME) VALUES (1025,'Member25');
INSERT INTO MEMBER(ID, NAME) VALUES (1026,'Member26');
INSERT INTO MEMBER(ID, NAME) VALUES (1027,'Member27');
INSERT INTO MEMBER(ID, NAME) VALUES (1028,'Member28');
INSERT INTO MEMBER(ID, NAME) VALUES (1029,'Member29');
INSERT INTO MEMBER(ID, NAME) VALUES (1030,'Member30');

INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1000,1001);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1000,1002);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1000,1003);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1000,1004);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1000,1005);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1000,1006);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1001,1007);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1001,1008);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1001,1009);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1002,1010);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1002,1011);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1002,1012);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1002,1013);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1003,1014);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1004,1015);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1004,1016);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1005,1017);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1005,1018);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1005,1019);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1006,1020);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1006,1021);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1006,1022);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1006,1023);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1007,1024);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1008,1025);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1008,1026);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1008,1027);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1008,1028);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1009,1029);
INSERT INTO BAND_MEMBERS(BAND_ID, MEMBERS_ID) VALUES (1009,1030);

INSERT INTO EVENT(ID, TITLE, IMG_URL) VALUES (1000, 'Event1', 'img/1000.jpeg');
INSERT INTO EVENT(ID, TITLE, IMG_URL) VALUES (1001, 'Event2', 'img/1001.jpeg');
INSERT INTO EVENT(ID, TITLE, IMG_URL) VALUES (1002, 'Event3', 'img/1002.jpeg');
INSERT INTO EVENT(ID, TITLE, IMG_URL) VALUES (1003, 'Event4', 'img/1003.jpeg');
INSERT INTO EVENT(ID, TITLE, IMG_URL) VALUES (1004, 'Event5', 'img/1004.jpeg');

INSERT INTO EVENT_BANDS(EVENT_ID, BANDS_ID) VALUES (1000, 1000);
INSERT INTO EVENT_BANDS(EVENT_ID, BANDS_ID) VALUES (1000, 1001);
INSERT INTO EVENT_BANDS(EVENT_ID, BANDS_ID) VALUES (1000, 1002);
INSERT INTO EVENT_BANDS(EVENT_ID, BANDS_ID) VALUES (1000, 1003);
INSERT INTO EVENT_BANDS(EVENT_ID, BANDS_ID) VALUES (1000, 1004);
INSERT INTO EVENT_BANDS(EVENT_ID, BANDS_ID) VALUES (1001, 1005);
INSERT INTO EVENT_BANDS(EVENT_ID, BANDS_ID) VALUES (1002, 1006);
INSERT INTO EVENT_BANDS(EVENT_ID, BANDS_ID) VALUES (1003, 1000);
INSERT INTO EVENT_BANDS(EVENT_ID, BANDS_ID) VALUES (1004, 1007);
INSERT INTO EVENT_BANDS(EVENT_ID, BANDS_ID) VALUES (1004, 1008);
INSERT INTO EVENT_BANDS(EVENT_ID, BANDS_ID) VALUES (1004, 1009);
