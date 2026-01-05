create table airports (

    id bigint not null  auto_increment,
    airport_iata char(3),
    airport_name varchar(150) not null,
    country_name varchar(50) not null,
    city_name varchar(100)not null,
    latitude decimal(9.6) not null,
    longitude decimal(9.6) not null,
    elevation int(4),
    timezone varchar(50),
    googleMaps varchar(255),

    primary key(id)

);