create table airports (

    id bigint not null  auto_increment,
    airport_iata char(3) not null,
    airport_name varchar(255),
    country_name varchar(50),
    city_name varchar(100),
    latitude decimal(9.6) not null,
    longitude decimal(9.6) not null,
    elevation decimal(4,2),
    time_zone varchar(50) not null,
    google_maps varchar(255) not null,

    primary key(id)

);