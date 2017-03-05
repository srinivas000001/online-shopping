create table Product
(id IDENTITY,
name varchar(50),
description varchar(100),
image_url varchar(50),
is_active BOOLEAN,

CONSTRAINT pk_product_id primary key(id)

);



create table Category
(id IDENTITY,
name varchar(50),
description varchar(100),
image_url varchar(50),
is_active BOOLEAN,

CONSTRAINT pk_category_id primary key(id)

);





