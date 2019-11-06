select ProductID, ProductName, ProductTypeName, ProductBrandName
from Product p
join ProductBrand pb on p.ProductBrandID = pb.ProductBrandID
join ProductType pt on p.ProductTypeID = pt.ProductTypeID

UPDATE Customer
SET CustomerName = 'Zoro'
WHERE CustomerID = 'CU011'

DELETE FROM Staff
where StaffID = 'ST011'