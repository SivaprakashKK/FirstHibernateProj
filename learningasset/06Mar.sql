show databases;
use hibernatedb;
show tables;

select * from Vehicle;
select * from TwoWheeler;
select * from FourWheeler;

drop table vehicle;
---------------------------------------
show databases;
use hibernatedb;
show tables;
select * from user_details;
select * from user_collection;
select * from user_address;
select * from Vehicle;
select * from USER_VEHICLE;
select * from VEHICLE_USER_COLL;
select * from user_collection_vehicle;

drop table USER_VEHICLE ;
drop table  user_entity;
drop table  user_collection;
drop table  user_address;
drop table vehicle;
drop table vehicle_user_collection;
drop table user_collection_vehicle;