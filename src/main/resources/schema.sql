CREATE TABLE "PUBLIC"."STATUS"(
    "ID" BIGINT AUTO_INCREMENT PRIMARY KEY,
    "NAME" VARCHAR2(50)
);

CREATE TABLE "PUBLIC"."DRIVER"(
    "ID" BIGINT AUTO_INCREMENT PRIMARY KEY,
    "NAME" VARCHAR2(50),
    "PHONE" VARCHAR2(20),
    "EMAIL" VARCHAR2(50),
    "ADDRESS" TEXT,
    "NOTES" TEXT,
    "CREATED" TIMESTAMP,
    "UPDATED" TIMESTAMP,
    "STATE" INT
);

CREATE TABLE "PUBLIC"."UNIT"(
    "ID" BIGINT AUTO_INCREMENT PRIMARY KEY,
    "BRAND" VARCHAR2(50),
    "MODEL" VARCHAR2(50),
    "FUEL_TYPE" VARCHAR2(20),
    "YEAR" INT,
    "LICENSE_NUMBER" VARCHAR2(50),
    "ELD_NUMBER" VARCHAR2(50),
    "NOTES" TEXT,
    "CREATED" TIMESTAMP,
    "UPDATED" TIMESTAMP,
    "STATE" INT
);

CREATE TABLE "PUBLIC"."LOAD"(
    "ID" BIGINT AUTO_INCREMENT PRIMARY KEY,
    "REFERENCE_NUMBER" VARCHAR2(50),
    "BROKER_NAME" VARCHAR2(50),
    "ORIGIN" VARCHAR2(50),
    "DESTINATION" VARCHAR2(50),
    "MILES" DOUBLE,
    "PICKUP_TIME" TIMESTAMP,
    "DELIVERY_TIME" TIMESTAMP,
    "RATE" DOUBLE,
    "NOTES" TEXT,
    "CREATED" TIMESTAMP,
    "UPDATED" TIMESTAMP,
    "STATE" INT
);

CREATE TABLE "PUBLIC"."FLEET"(
    "ID" BIGINT AUTO_INCREMENT PRIMARY KEY,
    "DRIVER_ID" BIGINT,
    "LOAD_ID" BIGINT,
    "UNIT_ID" BIGINT,
    "STATUS_ID" BIGINT,
    "LOCATION" VARCHAR2(50),
    "ETA" TIMESTAMP,
    "READY_TIME" TIMESTAMP,
    "NOTES" TEXT,
    "CREATED" TIMESTAMP,
    "UPDATED" TIMESTAMP,
    "STATE" INT
);

CREATE TABLE "PUBLIC"."USER"(
    "ID" BIGINT AUTO_INCREMENT PRIMARY KEY,
    "COMPANY_ID" BIGINT,
    "USERNAME" VARCHAR2(50),
    "PASSWORD" VARCHAR2(50)
);

CREATE TABLE "PUBLIC"."USER_SESSION"(
    "ID" VARCHAR2(32) PRIMARY KEY,
    "VALUE" VARCHAR2(4000)
);

CREATE TABLE "PUBLIC"."COMPANY"(
    "ID" BIGINT AUTO_INCREMENT PRIMARY KEY,
    "NAME" VARCHAR2(50),
    "MC" VARCHAR2(50),
    "US_DOT" VARCHAR2(50),
    "PHONE_NUMBER" VARCHAR2(50),
    "MAIL_ADDRESS" VARCHAR2(50),
    "CREATED" TIMESTAMP,
    "UPDATED" TIMESTAMP,
    "STATE" INT
);
