/**
 * CREATE Script for init of DB
 */



-- Create 1 Car
insert into car (name) values ('Tesla')



-- Create 4 Model
insert into model (name,base_color_code, base_price, image_link, car_id) values ('Model Y','#23398A',219000,'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MTY13,$PPSB,$WY19B,$INPB0&view=FRONT34&model=my&size=512&bkba_opt=1&crop=0,0,0,0&version=v0121-078c13b0d202212151058',1)
insert into model (name,base_color_code, base_price, image_link, car_id) values ('Model 3','#AF4A4A',184000,'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MT322,$PPMR,$W41B,$IBB1&view=STUD_FRONT34&model=m3&size=512&bkba_opt=1&crop=0,0,0,0&version=v0121-078c13b0d202212151058',1)
insert into model (name,base_color_code, base_price, image_link, car_id) values ('Model X','#D4D4D4',477000,'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MTX14,$PPSW,$WX00,$IBC00&view=FRONT34&model=mx&size=512&bkba_opt=1&crop=0,0,0,0&version=v0121-078c13b0d202212151058',1)
insert into model (name,base_color_code, base_price, image_link, car_id) values ('Model S','#45525C',467000,'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MTS14,$PBSB,$WS90,$IWC00&view=FRONT34&model=ms&size=512&bkba_opt=1&crop=0,0,0,0&version=v0121-078c13b0d202212151058',1)

-- Create Feature
insert into feature (name) values ('Performance')
insert into feature (name) values ('Long Range')


-- Create Model_Feature
insert into model_feature (feature_id, price, model_id) values (1,235000,2)
insert into model_feature (feature_id, price, model_id) values (2,215000,2)
insert into model_feature (feature_id, price, model_id) values (1,269000,1)
insert into model_feature (feature_id, price, model_id) values (2,246000,1)
insert into model_feature (feature_id, price, model_id) values (1,477000,3)
insert into model_feature (feature_id, price, model_id) values (2,467000,4)

-- Create Color
insert into color (name,type) values ('Pearl White','EXTERIOR')
insert into color (name,type) values ('Solid Black','EXTERIOR')
insert into color (name,type) values ('Midnight Silver','EXTERIOR')
insert into color (name,type) values ('Deep Blue','EXTERIOR')
insert into color (name,type) values ('Red Multi-Coat','EXTERIOR')
insert into color (name,type) values ('Black and White','INTERIOR')
insert into color (name,type) values ('All Black','INTERIOR')

-- Exterior Colors
insert into model_color (color_id, color_code, price, included, image_url, model_id) values (1,'#F2F5F8',0,true,'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MTY13,$PPSW,$WY19B,$INPB0&view=STUD_SIDE&model=my&size=512&bkba_opt=1&crop=0,0,0,0&version=v0121-078c13b0d202212151058',1)
insert into model_color (color_id, color_code, price, included, image_url, model_id) values (1,'#F2F5F8',0,true,'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MT322,$PPSW,$W41B,$IBB1&view=STUD_SIDE&model=m3&size=512&bkba_opt=1&crop=0,0,0,0&version=v0121-078c13b0d202212151058',2)
insert into model_color (color_id, color_code, price, included, image_url, model_id) values (1,'#F2F5F8',0,true,'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MTS14,$PPSW,$WS90,$IWC00&view=STUD_SIDE&model=ms&size=512&bkba_opt=1&crop=0,0,0,0&version=v0121-078c13b0d202212151058',3)
insert into model_color (color_id, color_code, price, included, image_url, model_id) values (1,'#F2F5F8',0,true,'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MTX14,$PPSW,$WX00,$IBC00&view=STUD_SIDE&model=mx&size=512&bkba_opt=1&crop=0,0,0,0&version=v0121-078c13b0d202212151058',4)

insert into model_color (color_id, color_code, price, included, image_url, model_id) values (2,'#000000',4500,false,'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MTY13,$PBSB,$WY19B,$INPB0&view=STUD_SIDE&model=my&size=512&bkba_opt=1&crop=0,0,0,0&version=v0121-078c13b0d202212151058',1)
insert into model_color (color_id, color_code, price, included, image_url, model_id) values (2,'#000000',4500,false,'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MT322,$PBSB,$W41B,$IBB1&view=STUD_SIDE&model=m3&size=512&bkba_opt=1&crop=0,0,0,0&version=v0121-078c13b0d202212151058',2)
insert into model_color (color_id, color_code, price, included, image_url, model_id) values (2,'#000000',6000,false,'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MTS14,$PBSB,$WS90,$IWC00&view=STUD_SIDE&model=ms&size=512&bkba_opt=1&crop=0,0,0,0&version=v0121-078c13b0d202212151058',3)
insert into model_color (color_id, color_code, price, included, image_url, model_id) values (2,'#000000',6000,false,'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MTX14,$PBSB,$WX00,$IBC00&view=STUD_SIDE&model=mx&size=512&bkba_opt=1&crop=0,0,0,0&version=v0121-078c13b0d202212151058',4)

insert into model_color (color_id, color_code, price, included, image_url, model_id) values (3,'#45525C',6000,false,'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MTY13,$PMNG,$WY19B,$INPB0&view=STUD_SIDE&model=my&size=512&bkba_opt=1&crop=0,0,0,0&version=v0121-078c13b0d202212151058',1)
insert into model_color (color_id, color_code, price, included, image_url, model_id) values (3,'#45525C',6000,false,'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MT322,$PMNG,$W41B,$IBB1&view=STUD_SIDE&model=m3&size=512&bkba_opt=1&crop=0,0,0,0&version=v0121-078c13b0d202212151058',2)
insert into model_color (color_id, color_code, price, included, image_url, model_id) values (3,'#45525C',7500,false,'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MTS14,$PMNG,$WS90,$IWC00&view=STUD_SIDE&model=ms&size=512&bkba_opt=1&crop=0,0,0,0&version=v0121-078c13b0d202212151058',3)
insert into model_color (color_id, color_code, price, included, image_url, model_id) values (3,'#45525C',7500,false,'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MTX14,$PMNG,$WX00,$IBC00&view=STUD_SIDE&model=mx&size=512&bkba_opt=1&crop=0,0,0,0&version=v0121-078c13b0d202212151058',4)

insert into model_color (color_id, color_code, price, included, image_url, model_id) values (4,'#044BB6',6000,false,'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MTY13,$PPSB,$WY19B,$INPB0&view=STUD_SIDE&model=my&size=512&bkba_opt=1&crop=0,0,0,0&version=v0121-078c13b0d202212151058',1)
insert into model_color (color_id, color_code, price, included, image_url, model_id) values (4,'#044BB6',6000,false,'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MT322,$PPSB,$W41B,$IBB1&view=STUD_SIDE&model=m3&size=512&bkba_opt=1&crop=0,0,0,0&version=v0121-078c13b0d202212151058',2)
insert into model_color (color_id, color_code, price, included, image_url, model_id) values (4,'#044BB6',7500,false,'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MTS14,$PPSB,$WS90,$IWC00&view=STUD_SIDE&model=ms&size=512&bkba_opt=1&crop=0,0,0,0&version=v0121-078c13b0d202212151058',3)
insert into model_color (color_id, color_code, price, included, image_url, model_id) values (4,'#044BB6',7500,false,'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MTX14,$PPSB,$WX00,$IBC00&view=STUD_SIDE&model=mx&size=512&bkba_opt=1&crop=0,0,0,0&version=v0121-078c13b0d202212151058',4)

insert into model_color (color_id, color_code, price, included, image_url, model_id) values (5,'#D01000',7500,false,'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MTY13,$PPMR,$WY19B,$INPB0&view=STUD_SIDE&model=my&size=512&bkba_opt=1&crop=0,0,0,0&version=v0121-078c13b0d202212151058',1)
insert into model_color (color_id, color_code, price, included, image_url, model_id) values (5,'#D01000',7500,false,'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MT322,$PPMR,$W41B,$IBB1&view=STUD_SIDE&model=m3&size=512&bkba_opt=1&crop=0,0,0,0&version=v0121-078c13b0d202212151058',2)
insert into model_color (color_id, color_code, price, included, image_url, model_id) values (5,'#D01000',7500,false,'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MTS14,$PPMR,$WS90,$IWC00&view=STUD_SIDE&model=ms&size=512&bkba_opt=1&crop=0,0,0,0&version=v0121-078c13b0d202212151058',3)
insert into model_color (color_id, color_code, price, included, image_url, model_id) values (5,'#D01000',7500,false,'https://static-assets.tesla.com/configurator/compositor?context=design_studio_2&options=$MTX14,$PPMR,$WX00,$IBC00&view=STUD_SIDE&model=mx&size=512&bkba_opt=1&crop=0,0,0,0&version=v0121-078c13b0d202212151058',4)

-- Interior Colors


insert into model_color (color_id, color_code, price, included, image_url, model_id) values (6,'#F2F5F8',4500,false,'',1)
insert into model_color (color_id, color_code, price, included, image_url, model_id) values (6,'#F2F5F8',4500,false,'',2)
insert into model_color (color_id, color_code, price, included, image_url, model_id) values (6,'#F2F5F8',8100,false,'',3)
insert into model_color (color_id, color_code, price, included, image_url, model_id) values (6,'#F2F5F8',8100,false,'',4)

insert into model_color (color_id, color_code, price, included, image_url, model_id) values (7,'#000000',0,true,'',1)
insert into model_color (color_id, color_code, price, included, image_url, model_id) values (7,'#000000',0,true,'',2)
insert into model_color (color_id, color_code, price, included, image_url, model_id) values (7,'#000000',0,true,'',3)
insert into model_color (color_id, color_code, price, included, image_url, model_id) values (7,'#000000',0,true,'',4)

-- Create Autopilot

insert into autopilot (name) values ('Full Self-Driving')
insert into autopilot (name) values ('Autopilot')


-- Create Model-Autopilot

insert into model_autopilot (auto_pilot_id, price, model_id) values (1,28000,1)
insert into model_autopilot (auto_pilot_id, price, model_id) values (2,14000,1)
insert into model_autopilot (auto_pilot_id, price, model_id) values (1,28000,2)
insert into model_autopilot (auto_pilot_id, price, model_id) values (2,14000,2)
insert into model_autopilot (auto_pilot_id, price, model_id) values (1,28000,3)
insert into model_autopilot (auto_pilot_id, price, model_id) values (2,14000,3)
insert into model_autopilot (auto_pilot_id, price, model_id) values (1,28000,4)
insert into model_autopilot (auto_pilot_id, price, model_id) values (2,14000,4)