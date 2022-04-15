INSERT INTO "PUBLIC"."STATUS"("NAME")
        VALUES ('ready'),
               ('resting');

INSERT INTO "PUBLIC"."DRIVER"("NAME", "PHONE", "EMAIL", "ADDRESS", "NOTES", "CREATED", "STATE")
        VALUES  ('John Doe', '+998711234567', 'john@doe.com', 'some address', 'something about john doe', CURRENT_TIMESTAMP(), 0),
                ('Alice Stevens', '+998711234567', 'alice@stevens.com', 'some address', 'something about alice stevens', CURRENT_TIMESTAMP(), 0);

INSERT INTO "PUBLIC"."UNIT"("BRAND", "MODEL", "FUEL_TYPE", "YEAR", "LICENSE_NUMBER", "ELD_NUMBER", "NOTES", "CREATED", "STATE")
        VALUES  ('Volvo', 'model 1', 'electric', 1997, 'LN12345', 'ELD12345', 'some notes', CURRENT_TIMESTAMP(), 0);

INSERT INTO "PUBLIC"."LOAD"("REFERENCE_NUMBER", "BROKER_NAME", "ORIGIN", "DESTINATION", "MILES", "PICKUP_TIME", "DELIVERY_TIME", "RATE", "NOTES", "CREATED", "STATE")
        VALUES  ('#ABC123', 'JB HUNT', 'CA Pasadena', 'IL Whiting', 5.5, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1.5, 'some notes', CURRENT_TIMESTAMP(), 0);

INSERT INTO "PUBLIC"."FLEET"("DRIVER_ID", "LOAD_ID", "UNIT_ID", "STATUS_ID", "LOCATION", "ETA", "READY_TIME", "NOTES", "CREATED", "STATE")
        VALUES  (1, 1, 1, 1, 'some location', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'some notes', CURRENT_TIMESTAMP(), 0);

