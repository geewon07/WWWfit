DROP database if exists wwwfit;

create database if not exists wwwfit;
use  wwwfit;
-- 카카오소셜 로그인 토큰 정보 헤더 페이로드 서명 형식,64비트 디코딩 해야한다고 함 페이로드 : sub:사용자의 회원번호, exp:만료시간, (닉네임, picture 사진, email 사용자 동의 별도 필요)-- 
CREATE TABLE IF NOT EXISTS users (
  `userNo` INT AUTO_INCREMENT PRIMARY KEY,
  `userId` varchar(100) NOT NULL UNIQUE, 
  `password` varchar(100) not null,
  `name` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  `img` varchar(40) DEFAULT NULL, 
  `userRank` varchar(40) default 'Unranked',
  `experience` int default 0,
  `challengedays` int default 0,
  `token` varchar(400),
  `regDate` datetime default CURRENT_TIMESTAMP,
  `kakaoToken` varchar(400)
);


-- 동영상도 저장만 안할 뿐이지 정보를 수집할 필요는 있음 유저가 북마크하고 싶다고 하면 뭔지 알려줘야 할 것 아닌가? 고유 videoId string만 저장하기,,나머지는 뷰가 해줄거야,,-- 
create table if not exists posters(
	  `posterSeq` INT AUTO_INCREMENT PRIMARY KEY,
	  `title` varchar(100) NOT NULL,
    `difficulty` int NOT NULL,
    `fitPartName` varchar(20),
    `postersrc` varchar(200) NOT NULL,
    `likeCount` INT
);
CREATE TABLE IF NOT EXISTS likeposters (
    `likeposterId` INT AUTO_INCREMENT PRIMARY KEY,
    `posterSeq` INT NOT NULL,
    `userNo` INT NOT NULL, 
    `likedate` datetime
);

create table if not exists bookmarks(
	`userNo` int Not null,
    `bookmarkId` int auto_increment primary key NOT NULL,
    `posterSeq` varchar(100),
    `bname` varchar(20) default "default",
    `description` varchar(100),
    `regDate` datetime default CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS rating (
    `userNo` INT NOT NULL,  
    `ratingId` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `contentSeq` INT NOT NULL,
    `score` int not null,
    `review` varchar(100),
    `regDate` datetime default CURRENT_TIMESTAMP
);
 

insert into rating (userNo, contentSeq ,score,review)
values( "2", "5 ","5","너무 시원하니 좋네요!");

insert into rating (userNo, contentSeq ,score,review)
values( "2", "5 ","3"," 그냥 그래요 운동한 느낌도 안들어요");

insert into rating (userNo, contentSeq ,score,review)
values( "2", "9 ","4"," 컴퓨터 많이 만져서 뻐근했는데 굳");

insert into rating (userNo, contentSeq ,score,review)
values( "2", "9 ","5","타자를 더 잘치게 되었어요ㅎㅎ");


create table if not exists follow(
	 `userNo` INT NOT NULL,  
    `followId` int primary key auto_increment NOT NULL,
    `followsWho` varchar(20) NOT NULL,
    `regDate` datetime default CURRENT_TIMESTAMP
);

 create table if not exists settings(
	  `userNo` INT NOT NULL,  
    `latest` varchar(20) not null,
    `pushconsent` boolean default true
);

create table if not exists havingbadge( -- 유저가 가진 뱃지 -- 
	  `userNo` INT NOT NULL, 
    `havingbadgeId` int primary key auto_increment,
    `neck_count5` boolean default false,
    `neck_count10` boolean default false,
    `neck_count20` boolean default false,
    `neck_count50` boolean default false,
    `neck_count100` boolean default false,
    `shoulder_count5` boolean default false,
    `shoulder_count10` boolean default false,
    `shoulder_count20` boolean default false,
    `shoulder_count50` boolean default false,
    `shoulder_count100` boolean default false,
    `back_count5` boolean default false,
    `back_count10` boolean default false,
    `back_count20` boolean default false,
    `back_count50` boolean default false,
    `back_count100` boolean default false,
    `hand_count5` boolean default false,
    `hand_count10` boolean default false,
    `hand_count20` boolean default false,
    `hand_count50` boolean default false,
    `hand_count100` boolean default false,
    `eye_count5` boolean default false,
    `eye_count10` boolean default false,
    `eye_count20` boolean default false,
    `eye_count50` boolean default false,
	`eye_count100` boolean default false,
	`leg_count5` boolean default false,
	`leg_count10` boolean default false,
	`leg_count20` boolean default false,
	`leg_count50` boolean default false,
	`leg_count100` boolean default false
);

create table if not exists calendars(
    `calendarId` INT NOT NULL PRIMARY KEY auto_increment,
    `userNo` INT NOT NULL, 
    `challenge` BOOLEAN DEFAULT FALSE,
    `fitPartName` varchar(20),
    `calendarStart` DATETIME NOT NULL
);

DESC calendars;

-- INSERT INTO calendars ( userNo, challenge, fitPartName, calendarStart )
-- VALUES ("1", true, "leg", "2023-05-15");

-- INSERT INTO calendars ( userNo, challenge, fitPartName, calendarStart )
-- VALUES ("1", true, "shoulder", "2023-05-12");

SELECT * FROM calendars;
-- INSERT INTO calendars ( userNo, challenge, fitPartName, calendarStart )
-- VALUES ("0", true, "shoulder", "2023-05-12");
-- SELECT date_format(calendarStart, '%Y-%m-%d') as calendarStart
-- FROM calendars
-- WHERE userNo = 1  AND  DATE_FORMAT(calendarStart, '%Y-%m-%d') = DATE_FORMAT( '2023-05-22', '%Y-%m-%d');

-- DELETE FROM calendars
-- WHERE calendarId >=5;

create table if not exists badgesprogress(
    `badgesNo` INT NOT NULL  PRIMARY KEY auto_increment,
    `userNo` INT NOT NULL, 
    `neck` INT DEFAULT 0,
    `shoulder` INT DEFAULT 0,
	  `back` INT DEFAULT 0,
    `hand` INT DEFAULT 0,
    `eye`  INT DEFAULT 0,
    `leg` INT DEFAULT 0
);
create table if not exists Notification(
    `NotificationNo` INT NOT NULL  PRIMARY KEY auto_increment,
    `userNo` INT NOT NULL, 
    `context` varchar(200) NOT NULL,
	`regDate` datetime default CURRENT_TIMESTAMP
);

SELECT * FROM badgesprogress;
SELECT * FROM havingbadge;
select * from users;
select * from calendars;
select * from Notification;
select * from bookmarks;
-- 제출횽 db 더미 --

-- 포스터 컨텐츠 --
insert into posters (title, difficulty, fitPartName, postersrc)
values("Airplane Workout", 1, "back","airplane-workout.jpg");

insert into posters (title, difficulty, fitPartName, postersrc)
values("Eye Workout", 1, "eye","eye-workout.jpg");
insert into posters (title, difficulty, fitPartName, postersrc)
values("Sore Neck Workout", 1, "neck","sore-neck-workout.jpg");

insert into posters (title, difficulty, fitPartName, postersrc)
values("Stiff Neck Workout", 1, "neck","stiff-neck-workout.jpg");
insert into posters (title, difficulty, fitPartName, postersrc)
values("Wrist Mobility", 1, "hand","wrist-mobility-workout.jpg");
insert into posters (title, difficulty, fitPartName, postersrc)
values("Neck Mobility", 1, "neck","neck-mobility-workout.jpg");
insert into posters (title, difficulty, fitPartName, postersrc)
values("Reset Stretch", 1, "shoulder","reset-stretch-workout.jpg");
insert into posters (title, difficulty, fitPartName, postersrc)
values("Eye rest", 1, "eye","eye-rest-workout.jpg");
insert into posters (title, difficulty, fitPartName, postersrc)
values("Talk to the Hand", 1, "hand","hand-workout.jpg");
insert into posters (title, difficulty, fitPartName, postersrc)
values("Seated Mobility", 1, "shoulder","seated-mobility-workout.jpg");
insert into posters (title, difficulty, fitPartName, postersrc)
values("Neck & Shoulders", 1, "neck","neck-and-shoulders-workout.jpg");
insert into posters (title, difficulty, fitPartName, postersrc)
values("Back Pain Relief", 1, "back","back-pain-yoga-chair-workout.jpg");
insert into posters (title, difficulty, fitPartName, postersrc)
values("Lower Back", 1, "back","lower-back-chair-workout.jpg");
insert into posters (title, difficulty, fitPartName, postersrc)
values("Back Fix", 1, "back","back-fix-workout.jpg");
insert into posters (title, difficulty, fitPartName, postersrc)
values("Seated Yoga", 1, "shoulders","seated-yoga-workout.jpg");
insert into posters (title, difficulty, fitPartName, postersrc)
values("Neck", 1, "neck","neck-workout.jpg");
-- 1. calendars 업뎃 --
INSERT INTO users (userId, password, name, email, userRank,experience,challengedays)
 VALUES ("ssafy", "1234", "김싸피", "ssafy@naver.com","VIP","62","4");
 INSERT INTO calendars ( userNo, challenge, fitPartName, calendarStart )
 VALUES ("1", true, "shoulder", "2023-03-1");
  INSERT INTO calendars ( userNo, challenge, fitPartName, calendarStart )
 VALUES ("1", true, "shoulder", "2023-03-8");
  INSERT INTO calendars ( userNo, challenge, fitPartName, calendarStart )
 VALUES ("1", true, "shoulder", "2023-03-15");
  INSERT INTO calendars ( userNo, challenge, fitPartName, calendarStart )
 VALUES ("1", true, "shoulder", "2023-03-22");
INSERT INTO calendars ( userNo, challenge, fitPartName, calendarStart )
 VALUES ("1", true, "neck", "2023-04-18");
 INSERT INTO calendars ( userNo, challenge, fitPartName, calendarStart )
 VALUES ("1", true, "back", "2023-04-20");
 INSERT INTO calendars ( userNo, challenge, fitPartName, calendarStart )
 VALUES ("1", true, "back", "2023-04-24");
 INSERT INTO calendars ( userNo, challenge, fitPartName, calendarStart )
 VALUES ("1", true, "back", "2023-04-25");
 INSERT INTO calendars ( userNo, challenge, fitPartName, calendarStart )
 VALUES ("1", true, "back", "2023-04-27");
 INSERT INTO calendars ( userNo, challenge, fitPartName, calendarStart )
 VALUES ("1", true, "neck", "2023-05-01");
  INSERT INTO calendars ( userNo, challenge, fitPartName, calendarStart )
 VALUES ("1", true, "back", "2023-05-02");
  INSERT INTO calendars ( userNo, challenge, fitPartName, calendarStart )
 VALUES ("1", true, "back", "2023-05-03");
  INSERT INTO calendars ( userNo, challenge, fitPartName, calendarStart )
 VALUES ("1", true, "back", "2023-05-08");
 INSERT INTO calendars ( userNo, challenge, fitPartName, calendarStart )
 VALUES ("1", true, "neck", "2023-05-11");
 INSERT INTO calendars ( userNo, challenge, fitPartName, calendarStart )
 VALUES ("1", true, "back", "2023-05-15");
 INSERT INTO calendars ( userNo, challenge, fitPartName, calendarStart )
 VALUES ("1", true, "back", "2023-05-17");
INSERT INTO calendars ( userNo, challenge, fitPartName, calendarStart )
 VALUES ("1", true, "back", "2023-05-18");
 INSERT INTO calendars ( userNo, challenge, fitPartName, calendarStart )
 VALUES ("1", true, "neck", "2023-05-19");
  INSERT INTO calendars ( userNo, challenge, fitPartName, calendarStart )
 VALUES ("1", true, "neck", "2023-05-22");
-- INSERT INTO calendars ( userNo, challenge, fitPartName, calendarStart )
--  VALUES ("1", true, "neck", "2023-05-22");
--  INSERT INTO badgesprogress (userNo, neck,shoulder, back)
--  VALUES ("1", "5", "4","10");
 -- 어깨 4번 목 5번 등 10번 -- 
 -- 시연보여줄때 운동을 어깨로 등록해서 뱃지 얻은거 보여주기! --
-- INSERT INTO havingbadge ( userNo, neck_count5, back_count5, back_count10 )
-- VALUES ("1", true, true, true);
INSERT INTO havingbadge ( userNo, back_count5, back_count10, neck_count5)
VALUES ("1", true, true,true);
INSERT INTO badgesprogress ( userNo, neck, shoulder, back )
VALUES ("1", "5", "4", "10");
insert into Notification (userNo, context,regDate)
values( "1", "[경험치 5] 연속 4회 운동을 달성하여 경험치 5를 획득하셨습니다.","2023-05-22");
UPDATE havingbadge
SET neck_count5 = true
WHERE userNo = "1";
UPDATE badgesprogress
SET neck = "5"
WHERE userNo = "1";

INSERT INTO users (userId, password, name, email, userRank,experience,challengedays)
 VALUES ("ddd", "1234", "김싸피d", "ssafdy@naver.com","VIP","62","3");