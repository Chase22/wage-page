truncate table users, companies, jobs, wages;

insert into users values
('d7d93363-33f1-441c-8fa2-cd8574167adb', 0, 'dalesio0', 'Dannie', 'Alesio', 'dalesio0@wisc.edu', current_timestamp, current_timestamp),
('9d63c78e-db35-4d1c-bbfa-93f999ca3f63', 0, 'hduddell1', 'Horst', 'Duddell', 'hduddell1@marriott.com', current_timestamp, current_timestamp),
('f23bbc1f-ab43-4360-ab42-0430dc35665c', 0, 'maxtonne2', 'Merrilee', 'Axtonne', 'maxtonne2@mail.ru', current_timestamp, current_timestamp),
('e29b6340-bedc-4f21-b3d3-622698a5a490', 0, 'vdeamaya3', 'Vanya', 'de Amaya', 'vdeamaya3@noaa.gov', current_timestamp, current_timestamp),
('af3dcfcc-b743-44ae-8cfc-e87b00416b65', 0, 'lcave4', 'Les', 'Cave', 'lcave4@china.com.cn', current_timestamp, current_timestamp),
('a7c987e2-dd00-431d-a9af-b42be31c6025', 0, 'gfrontczak5', 'Gianni', 'Frontczak', 'gfrontczak5@wikia.com', current_timestamp, current_timestamp),
('1d1e493a-4a9c-4a18-930c-5dc814a38218', 0, 'cmcfeat6', 'Charline', 'McFeat', 'cmcfeat6@feedburner.com', current_timestamp, current_timestamp),
('2b7c4139-f663-4b8a-844d-04abff8a36ed', 0, 'ckeeri7', 'Cornelle', 'Keeri', 'ckeeri7@geocities.com', current_timestamp, current_timestamp),
('77b213f5-7016-4ff7-bde5-35edcc33591d', 0, 'bdriffill8', 'Bucky', 'Driffill', 'bdriffill8@freewebs.com', current_timestamp, current_timestamp),
('7dbc2211-7467-479d-aad7-17324d389217', 0, 'gbarnwille9', 'Ganny', 'Barnwille', 'gbarnwille9@salon.com', current_timestamp, current_timestamp);

insert into companies
VALUES ('f8084933-a478-4f4c-86b6-8c6db5a77240'::uuid, 0, 'my company', 'cologne', current_timestamp, current_timestamp);
VALUES ('ddd4a570-42c7-4615-b7d6-d2e44ceb4441'::uuid, 0, 'company gmbh', 'berlin', current_timestamp, current_timestamp);

insert into jobs
VALUES ('0bef5146-2dc9-4ab7-8337-c60a33fcc71a'::uuid, 0, 'software developer', '2020-10-10', null, current_timestamp,
        current_timestamp, 'f8084933-a478-4f4c-86b6-8c6db5a77240', 'd7d93363-33f1-441c-8fa2-cd8574167adb');

insert into wages
VALUES ('e8c1bb65-a60e-4aac-95a6-bb907b658c50'::uuid, 0, 12, 'EUR', 35, 0, '2020-10-10', null, current_timestamp,
        current_timestamp, '0bef5146-2dc9-4ab7-8337-c60a33fcc71a');