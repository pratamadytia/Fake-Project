create database ComputerManiac

create table Staff(
	StaffID char(5) primary key,
	StaffName varchar(50),
	StaffAddress varchar(50),
	StaffPhone varchar(13),
	StaffSalary int,
	StaffGender varchar(6),
	constraint c1 check(StaffID like 'ST[0-9][0-9][0-9]'),
	constraint c2 check(StaffGender = 'Male' or StaffGender = 'Female'),
	constraint c3 check(StaffAddress like '% Street')
)

create table Customer(
	CustomerID char(5) primary key,
	CustomerName varchar(50),
	CustomerAddress varchar(50) not null,
	CustomerGender varchar(6),
	CustomerPhone varchar(13),
	constraint c4 check(CustomerID like 'CU[0-9][0-9][0-9]'),
	constraint c5 check(CustomerGender = 'Male' or CustomerGender = 'Female'),
	constraint c6 check(CustomerAddress like '% Street'),
	constraint c7 check(len(CustomerName) > 3 and len(CustomerName) < 50),
	constraint c8 check(len(CustomerPhone) >= 10 and len(CustomerPhone) <= 13)
)

create table ProductType(
	ProductTypeID char(5) primary key,
	ProductTypeName varchar(25),
	constraint c9 check(ProductTypeID like 'PT[0-9][0-9][0-9]'),
)

create table ProductBrand(
	ProductBrandID char(5) primary key,
	ProductBrandName varchar(25),
	constraint c10 check(ProductBrandID like 'BR[0-9][0-9][0-9]'),
)

create table Product(
	ProductID char(5) primary key,
	ProductTypeID char(5),
	ProductBrandID char(5),
	ProductName varchar(25),
	ProductPriceOfSales int,
	ProductPriceOfPurchase int,
	ProductStock int,
	constraint c11 check(ProductID like 'PR[0-9][0-9][0-9]'),
	constraint c12 check(ProductPriceOfSales >= ProductPriceOfPurchase),
	constraint c13 check(ProductPriceOfSales > 0),
	constraint c14 check(ProductPriceOfPurchase > 0),
	constraint FKProductTypeIDtoProduct foreign key(ProductTypeID) references ProductType(ProductTypeID),
	constraint FKProductBrandIDtoProduct foreign key(ProductBrandID) references ProductBrand(ProductBrandID),
)

create table SalesTransaction(
	SalesTransactionID char(5) primary key,
	StaffID char(5),
	CustomerID char(5),
	ProductID char(5),
	TransactionDate date,
	Quantity int,
	constraint c15 Check(SalesTransactionID like 'SA[0-9][0-9][0-9]'),
	constraint FKStaffIDtoSalesTransaction foreign key(StaffID) references Staff(StaffID),
	constraint FKCustomerIDtoSalesTransaction foreign key(CustomerID) references Customer(CustomerID),
	constraint FKProductIDtoSalesTransaction foreign key(ProductID) references Product(ProductID),
)

create table PurchaseTransaction(
	PurchaseTransactionID char(5) primary key,
	StaffID char(5),
	ProductID char(5),
	TransactionDate date,
	Quantity int,
	constraint FKStaffIDtoPurchaseTransaction foreign key(StaffID) references Staff(StaffID),
	constraint FKProductIDtoPurchaseTransaction foreign key(ProductID) references Product(ProductID),
	constraint c16 Check(PurchaseTransactionID like 'PU[0-9][0-9][0-9]')
)
