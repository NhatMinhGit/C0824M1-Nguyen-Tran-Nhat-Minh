create database quanlybanhang;

use quanlybanhang;

create table customer(
	cID int not null auto_increment primary key,
    cName varchar(50),
    cAge int
);

create table ordeer(
	oID int not null auto_increment primary key,
    cID int,
    oDate date,
    oTotalPrice float,
    foreign key (cID) references customer(cID)
);

create table product(
	pID int not null auto_increment primary key,
    pName varchar(50),
    pPrice float
);

create table order_detail(
	oID int,
    pID int,
    odQTY int not null,
    primary key(oID,pID),
    foreign key (oID) references ordeer(oID),
	foreign key (pID) references product(pID)
);

