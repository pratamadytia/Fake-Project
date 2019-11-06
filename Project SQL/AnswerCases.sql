--5.1
select StaffName, StaffSalary, [Transaction Date] = convert(varchar(20), TransactionDate, 107 ), [Product Type Count] = count(st.SalesTransactionID)
from Staff s 
join SalesTransaction st on s.StaffID = st.StaffID
where DATEPART(MONTH,TransactionDate) = 2
group by StaffName, StaffSalary,TransactionDate

--5.2
select StaffName,  CustomerName, CustomerPhone = replace(CustomerPhone, '0', '+62'),  [Count of Sales Transaction] = count(st.SalesTransactionID)
from Staff s
join SalesTransaction st on s.StaffID = st.StaffID
join Customer c on c.CustomerID = st.CustomerID
where StaffSalary <= 3000000
group by StaffName, CustomerName, CustomerPhone 

--5.3
select ProductName, ProductStock, SUM(Quantity) as [Product Sales Total], [Transaction Count] = count(pt.PurchaseTransactionID) 
from Product p 
join PurchaseTransaction pt on p.ProductID = pt.ProductID

--5.4
select [Product Name] = ProductName +' '+ pb.ProductBrandName +' '+ pt.ProductTypeName, ProductTypeName, [Product Count] = count(ptr.PurchaseTransactionID), [Benefit] = SUM(p.ProductPriceOfPurchase + p.ProductPriceOfSales)
from Product p
join ProductType pt on p.ProductTypeID = pt.ProductTypeID
join PurchaseTransaction ptr on p.ProductID = ptr.ProductID
join ProductBrand pb on p.ProductBrandID = pb.ProductBrandID
group by ProductName, ProductTypeName, ProductBrandName, ProductTypeName

--5.5
select ProductName, [Brand Name] = REPLACE(ProductBrandName,'', UPPER(LEFT(ProductBrandName,''))), ProductTypeName, ProductPriceOfSales, ProductStock, [Product Price] = avg(ProductPriceOfSales)
from Product p
join ProductBrand pb on p.ProductBrandID = pb.ProductBrandID
join ProductType pt on p.ProductTypeID = pt.ProductTypeID,
(
	select [Product AVG] = avg(ProductPriceOfSales)
	from Product
	where ProductStock <= 10
	)x
group by ProductName, ProductBrandName, ProductTypeName, ProductPriceOfSales, ProductStock, x.[Product AVG]
having ProductPriceOfSales > x.[Product AVG]

--5.6
select CustomerName, ProductName, [Sales Price] = 'Rp. '+CAST(ProductPriceOfSales as varchar), [Product Stock] = cast(ProductStock as varchar)+' pc(s)', st.TransactionDate, [Product Price] = avg(ProductPriceOfSales)
from Customer c
join SalesTransaction st on c.CustomerID = st.CustomerID
join Product p on p.ProductID = st.ProductID,
(
	select [Product AVG] = avg(ProductPriceOfSales)
	from Product
)x
group by CustomerName, ProductName, ProductPriceOfSales, ProductStock, TransactionDate, x.[Product AVG]
having ProductPriceOfSales >= x.[Product AVG]

--5.7
select StaffName, StaffSalary = 'Rp. '+ CAST(s.StaffSalary as varchar), StaffPhone = replace(StaffPhone, '0', '+62'), [Count Transaction] = cast(count(PurchaseTransactionID)as varchar ) + ' Transaction(s)', StaffSalary = avg(s.StaffSalary)
from Staff s
join SalesTransaction st on s.StaffID = st.StaffID
join PurchaseTransaction pt on s.StaffID = pt.StaffID,
(
	select StaffSalary = avg(StaffSalary)
	from Staff
)x
group by StaffName, s.StaffSalary, StaffPhone, x.StaffSalary
having s.StaffSalary <= x.StaffSalary

--5.8
select StaffName, ProductName, [Transaction Count] = count(pt.PurchaseTransactionID), [Transaction Date] = convert(varchar(20), TransactionDate, 106 ), StaffSalary = avg(s.StaffSalary), s.StaffAddress
from Staff s
join PurchaseTransaction pt on s.StaffID = pt.StaffID
join Product p on p.ProductID = pt.ProductID,
(
	select StaffSalary = avg(StaffSalary)
	from Staff
)x
where StaffAddress like '#%'
group by StaffName, ProductName, TransactionDate, x.StaffSalary, s.StaffSalary, s.StaffAddress
having s.StaffSalary <= x.StaffSalary

--5.9
go
create view [viewStaffCustomerTransaction] as
select StaffName, CustomerName, [Item Count] = (ProductStock-st.Quantity), [AVG Quantity] = avg(st.Quantity)
from Staff s
join SalesTransaction st on s.StaffID = st.StaffID
join Customer c on st.CustomerID = c.CustomerID
join Product p on p.ProductID = st.ProductID,
(
	select Quantity = avg(Quantity)
	from SalesTransaction
)x
group by StaffName, CustomerName, st.Quantity, ProductStock, x.Quantity
having x.Quantity >= 1

--5.10
go
create view [viewSalesTransaction] as
select StaffName, ProductName, pt.TransactionDate, [Item Count] = count(pt.PurchaseTransactionID), [AVG Quantity] = AVG(pt.Quantity), x.[Product Brand Odd]
from Staff s
join PurchaseTransaction pt on s.StaffID = pt.StaffID
join Product p on p.ProductID = pt.ProductID
join ProductBrand pb on p.ProductBrandID = pb.ProductBrandID,
(
	select [Product Brand Odd] = cast(replace(pb.ProductBrandID,'BR', '') as int), Quantity = avg(pt.Quantity)
	from ProductBrand pb
	join Product p on p.ProductBrandID = pb.ProductBrandID
	join PurchaseTransaction pt on p.ProductID = pt.ProductID
	group by pb.ProductBrandID
)x
where x.[Product Brand Odd]%2 = 1
group by StaffName, ProductName, pt.TransactionDate, x.[Product Brand Odd]