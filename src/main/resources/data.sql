INSERT INTO "PUBLIC"."STATUS"("NAME")
        VALUES ('READY'),
               ('at TA-SHOP'),
               ('BOBTAILING'), 
               ('BOOKED'),
               ('BROKEN'),
               ('BROKEN + BOOKED'),
               ('COVERED'),
               ('DISPATCHED'),
               ('HOME'),
               ('ILL'),
               ('NO RESPONSE'),
               ('READY NOW 1'),
               ('READY NOW 2'),
               ('RESTING zZzZzZ...'),
               ('SHOPPING'),
               ('WILL LET US KNOW');

INSERT INTO "PUBLIC"."DRIVER"("NAME", "PHONE", "EMAIL", "ADDRESS", "NOTES", "CREATED", "STATE")
        VALUES  ('John Doe', '+998711234567', 'john@doe.com', 'some address', 'something about john doe', CURRENT_TIMESTAMP(), 0),
                ('Alice Stevens', '+998711234567', 'alice@stevens.com', 'some address', 'something about alice stevens', CURRENT_TIMESTAMP(), 0);

INSERT INTO "PUBLIC"."UNIT"("BRAND", "MODEL", "FUEL_TYPE", "YEAR", "LICENSE_NUMBER", "ELD_NUMBER", "NOTES", "CREATED", "STATE")
        VALUES  ('Volvo', 'VNL 860', 'GAS', 2018, 'LN12345', 'ELD12345', 'Gray', CURRENT_TIMESTAMP(), 0);

INSERT INTO "PUBLIC"."LOAD"("REFERENCE_NUMBER", "BROKER_NAME", "ORIGIN", "DESTINATION", "MILES", "PICKUP_TIME", "DELIVERY_TIME", "RATE", "NOTES", "CREATED", "STATE")
        VALUES  ('#123456', 'JB HUNT', 'CA Pasadena', 'IL Whiting', 5.5, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1.5, 'some notes', CURRENT_TIMESTAMP(), 0);

INSERT INTO "PUBLIC"."FLEET"("DRIVER_ID", "LOAD_ID", "UNIT_ID", "STATUS_ID", "LOCATION", "ETA", "READY_TIME", "NOTES", "CREATED", "STATE")
        VALUES  (1, 1, 1, 1, 'some location', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'some notes', CURRENT_TIMESTAMP(), 0);

INSERT INTO "PUBLIC"."COMPANY"("NAME", "MC", "US_DOT", "PHONE_NUMBER", "MAIL_ADDRESS", "CREATED", "STATE")
        VALUES  ('Admiral US', '1119286', '3443954', '+1 (415) 392-3639', 'Admiralus2020@gmail.com', CURRENT_TIMESTAMP(), 0);
INSERT INTO "PUBLIC"."COMPANY"("NAME", "MC", "US_DOT", "PHONE_NUMBER", "MAIL_ADDRESS", "CREATED", "STATE")
        VALUES  ('All Good Trucking', '1251791', '3641869', '+1 (415) 392-3639', 'allgoodtrucking2021@gmail.com', CURRENT_TIMESTAMP(), 0);

INSERT INTO "PUBLIC"."USER"("COMPANY_ID", "USERNAME", "PASSWORD")
        VALUES  (1, 'test 1', 'test 1');

INSERT INTO "PUBLIC"."USER"("COMPANY_ID", "USERNAME", "PASSWORD")
        VALUES  (2, 'test 2', 'test 2');
