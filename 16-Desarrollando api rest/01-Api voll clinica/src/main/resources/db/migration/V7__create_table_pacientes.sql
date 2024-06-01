create table pacientes(

    id bigint not null auto_increment,
    nombre varchar(100) not null,
    email varchar(100) not null unique,
    telefono varchar(100) not null unique,
    documento varchar(20) not null unique,
    calle varchar(100) not null,
    numero varchar(30),
    complemento varchar(100),
    distrito varchar(100) not null,
    ciudad varchar(100) not null,
    barrio varchar(100) not null,
    codigo_postal varchar(100) not null,

    primary key (id)
);


