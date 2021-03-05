CREATE TABLE activities (id BIGINT AUTO_INCREMENT,
                         start_time TIMESTAMP,
                         activity_desc VARCHAR(255),
                         activity_type VARCHAR(255),
                         PRIMARY KEY (id));

CREATE TABLE track_points(id BIGINT AUTO_INCREMENT,
                          act_time Date,
                          lat DOUBLE,
                          lon DOUBLE,
                          activityId BIGINT,
                          PRIMARY KEY(id),
                          FOREIGN KEY (activityId) REFERENCES activities(id));

insert into activities(start_time, activity_desc, activity_type) values ('2021-02-01 14:30:00','Bikikng in Mecsek','BIKING');
insert into activities(start_time, activity_desc, activity_type) values ('2020-02-01 14:30:00','Hikikng in Mecsek','HIKING');
insert into activities(start_time, activity_desc, activity_type) values ('2020-01-31 14:30:00','Running in Mecsek','RUNNING');