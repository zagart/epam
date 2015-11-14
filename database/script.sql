CREATE TABLE "user" (
	"id" serial(100) NOT NULL,
	"first_name" character varying(100) NOT NULL,
	"second_name" character varying(100) NOT NULL,
	"login" character varying(100) NOT NULL,
	"e-mail" character varying(100) NOT NULL,
	"password" character varying(100) NOT NULL,
	"balance" int(100) NOT NULL,
	"country_id" int(100) NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY ("id","first_name","second_name","login","e-mail","password","balance")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "country" (
	"id" serial(100) NOT NULL,
	"name" character varying(100) NOT NULL,
	"iso_code" int(100) NOT NULL,
	CONSTRAINT country_pk PRIMARY KEY ("id","name","iso_code")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "black_list" (
	"id" int(100) NOT NULL,
	"user_id" int(100) NOT NULL,
	"date_of_blocking" DATE(100) NOT NULL,
	"date_of_unlocking" DATE(100) NOT NULL,
	CONSTRAINT black_list_pk PRIMARY KEY ("id","date_of_blocking","date_of_unlocking")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "shop" (
	"id" serial(100) NOT NULL,
	"name" character varying(100) NOT NULL,
	"description" character varying(100) NOT NULL,
	CONSTRAINT shop_pk PRIMARY KEY ("id","name","description")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "product" (
	"id" serial(100) NOT NULL,
	"name" character varying(100) NOT NULL,
	"description" character varying(100) NOT NULL,
	"cost" int(100) NOT NULL,
	"shop_id" int(100) NOT NULL,
	"deliver_price" int(100) NOT NULL,
	CONSTRAINT product_pk PRIMARY KEY ("id","name","description","cost","deliver_price")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "coupon" (
	"id" serial(100) NOT NULL,
	"value" int(100) NOT NULL,
	"shop_id" int(100) NOT NULL,
	"user_id" int(100) NOT NULL,
	CONSTRAINT coupon_pk PRIMARY KEY ("id","value")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "order" (
	"id" serial(100) NOT NULL,
	"cost" int(100) NOT NULL,
	"user_id" int(100) NOT NULL,
	"product_id" int(100) NOT NULL,
	"product_quantity" int(100) NOT NULL,
	CONSTRAINT order_pk PRIMARY KEY ("id","cost","product_quantity")
) WITH (
  OIDS=FALSE
);



ALTER TABLE "user" ADD CONSTRAINT "user_fk0" FOREIGN KEY (country_id) REFERENCES country(id);


ALTER TABLE "black_list" ADD CONSTRAINT "black_list_fk0" FOREIGN KEY (user_id) REFERENCES user(id);


ALTER TABLE "product" ADD CONSTRAINT "product_fk0" FOREIGN KEY (shop_id) REFERENCES shop(id);

ALTER TABLE "coupon" ADD CONSTRAINT "coupon_fk0" FOREIGN KEY (shop_id) REFERENCES shop(id);
ALTER TABLE "coupon" ADD CONSTRAINT "coupon_fk1" FOREIGN KEY (user_id) REFERENCES user(id);

ALTER TABLE "order" ADD CONSTRAINT "order_fk0" FOREIGN KEY (user_id) REFERENCES user(id);
ALTER TABLE "order" ADD CONSTRAINT "order_fk1" FOREIGN KEY (product_id) REFERENCES product(id);

