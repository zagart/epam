CREATE TABLE "user" (
	"id" serial(100) NOT NULL,
	"first_name" character varying(100) NOT NULL,
	"second_name" character varying(100) NOT NULL,
	"login" character varying(100) NOT NULL,
	"e-mail" character varying(100) NOT NULL,
	"password" character varying(100) NOT NULL,
	"balance" integer NOT NULL,
	"country_id" integer NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "country" (
	"id" serial(100) NOT NULL,
	"name" character varying(100) NOT NULL,
	"iso_code" integer NOT NULL,
	CONSTRAINT country_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "black_list" (
	"id" integer NOT NULL,
	"user_id" integer NOT NULL,
	"date_of_blocking" DATE(100) NOT NULL,
	"date_of_unlocking" DATE(100) NOT NULL,
	CONSTRAINT black_list_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "shop" (
	"id" serial(100) NOT NULL,
	"name" character varying(100) NOT NULL,
	"description" character varying(100) NOT NULL,
	CONSTRAINT shop_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "product" (
	"id" serial(100) NOT NULL,
	"name" character varying(100) NOT NULL,
	"description" character varying(100) NOT NULL,
	"cost" integer NOT NULL,
	"shop_id" integer NOT NULL,
	"deliver_price" integer NOT NULL,
	"products_quantity_left" integer NOT NULL,
	"product_quantity_for_order" integer NOT NULL,
	CONSTRAINT product_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "coupon" (
	"id" serial(100) NOT NULL,
	"value" integer NOT NULL,
	"user_id" integer NOT NULL,
	"shop_id" integer NOT NULL,
	"user_coupon_quantity" integer NOT NULL,
	CONSTRAINT coupon_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "order" (
	"id" serial(100) NOT NULL,
	"cost" integer NOT NULL,
	"user_id" integer NOT NULL,
	"product_id" integer NOT NULL,
	CONSTRAINT order_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



ALTER TABLE "user" ADD CONSTRAINT "user_fk0" FOREIGN KEY (country_id) REFERENCES country(id);


ALTER TABLE "black_list" ADD CONSTRAINT "black_list_fk0" FOREIGN KEY (user_id) REFERENCES user(id);


ALTER TABLE "product" ADD CONSTRAINT "product_fk0" FOREIGN KEY (shop_id) REFERENCES shop(id);

ALTER TABLE "coupon" ADD CONSTRAINT "coupon_fk0" FOREIGN KEY (user_id) REFERENCES user(id);
ALTER TABLE "coupon" ADD CONSTRAINT "coupon_fk1" FOREIGN KEY (shop_id) REFERENCES shop(id);

ALTER TABLE "order" ADD CONSTRAINT "order_fk0" FOREIGN KEY (user_id) REFERENCES user(id);
ALTER TABLE "order" ADD CONSTRAINT "order_fk1" FOREIGN KEY (product_id) REFERENCES product(id);

