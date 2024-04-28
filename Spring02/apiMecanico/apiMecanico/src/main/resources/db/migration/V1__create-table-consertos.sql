
create table consertos(
    id bigint not null auto_increment,
    data_entrada_oficina varchar(10) not null,
    data_saida_oficina varchar(10) not null,
    nome varchar(100) not null,
    anos_experiencia int not null,
    marca varchar(100) not null,
    modelo varchar(100) not null,
    ano varchar(4) not null,

    primary key(id)
);
