create database quanlyhanghoa;

use quanlyhanghoa;

create table phieuxuat(
	SoPX int not null auto_increment primary key,
    NgayXuat date
);

create table vattu(
	MaVTU int not null auto_increment primary key,
    TenVTU varchar(50)
);

create table phieunhap(
	SoPN int not null auto_increment primary key,
    NgayNhap date
);

create table dondh(
	SoDH int not null auto_increment primary key,
    NgayDH date
);

create table nhacc(
	MaNCC int not null auto_increment primary key,
    TenNCC varchar(50),
    DiaChi text
);


-- Thuoc tinh da tri ( sdt )
create table SDT(
	SDT_ID int auto_increment primary key,
    MaNCC int not null,
    SDT varchar(15) not null,
    foreign key (MaNCC) references nhacc(MaNCC)
);

create table chi_Tiet_Phieu_Xuat(
	SoPX int not null,
    MaVTU int not null,
    DGXuat float not null,
    SLXuat int not null,
    primary key(SoPX,MaVTU),
    foreign key (SoPX) references phieuxuat(SoPX),
    foreign key (MaVTU) references vattu(MaVTU)
);

create table chi_Tiet_Phieu_Nhap(
	SoPN int not null,
    MaVTU int not null,
    DGNhap float not null,
    SLNhap int not null,
    primary key(SoPN,MaVTU),
    foreign key (SoPN) references phieunhap(SoPN),
    foreign key (MaVTU) references vattu(MaVTU)
);

create table chi_Tiet_Don_Hang(
	SoDH int not null,
    MaVTU int not null,
    primary key(SoDH,MaVTU),
    foreign key (SoDH) references dondh(SoDH),
    foreign key (MaVTU) references vattu(MaVTU)
);

create table cung_Cap(
	SoDH int not null,
    MaNCC int not null,
    primary key(SoDH,MaNCC),
    foreign key (SoDH) references dondh(SoDH),
    foreign key (MaNCC) references nhacc(MaNCC)
);
