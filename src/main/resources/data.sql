/*
USERS TABLE
*/
SET foreign_key_checks = 0;
TRUNCATE TABLE `timeless_finds`.`users`;
INSERT INTO `users` (`user_id`,`email`,`is_admin`,`password`,`username`,`cart_id`) SELECT 1,'abcdef@gmail.com',1,'jon','jon',1 FROM dual WHERE NOT EXISTS (SELECT 1 FROM users WHERE username = 'jon'); 
INSERT INTO `users` (`user_id`,`email`,`is_admin`,`password`,`username`,`cart_id`) SELECT 2,'yangyu@gmail.com',0,'yangyu','yangyu',2 FROM dual WHERE NOT EXISTS (SELECT 1 FROM users WHERE username = 'yangyu'); 
INSERT INTO `users` (`user_id`,`email`,`is_admin`,`password`,`username`,`cart_id`) SELECT 3,'wq@gmail.com',1,'123','wq',3 FROM dual WHERE NOT EXISTS (SELECT 1 FROM users WHERE username = 'wq'); 

/*
CART TABLE
 */
INSERT INTO `cart` (`cart_id`, cart_date) VALUES (15, '2022-12-30 00:38:54');
INSERT INTO `cart` (`cart_id`, cart_date) VALUES (16, '2022-12-30 00:38:54');

/*
PRODUCTS TABLE
*/

TRUNCATE TABLE `timeless_finds`.`products`;
INSERT INTO `timeless_finds`.`products` (`product_id`,`category`,`description`,`image`,`name`,`price`,`quantity`) VALUES (9,'Cabinet','* Cubical wine rack sideboard from MOVO, a popular Swiss brand in the 90s.\n* Condition: 8/10\n* Minor scratches and chipped corners on the bottom left of cabinet. \n* Originally from a local resident.\n* 78 (H) x 94 (W) x 35 (D)\n\nDelivery method:\nOnly to ground level or lift-landing floor which this item can fit into your service lift.','https://drive.google.com/uc?id=1bFZ0mhTFQ2UrFin8adPibPGjyPmg8kMT','Cubical Wine Rack Cabinet',780.12,2);
INSERT INTO `timeless_finds`.`products` (`product_id`,`category`,`description`,`image`,`name`,`price`,`quantity`) VALUES (10,'Mirror','* Mango Wood mirror from Java, Indonesia.\n* Mirror surface free of scratches, wooden frame retouched with rose gold paint matching original.\n* Originally from Tapas Hotel\n* 162 (H) x 84 (W) x 3 (D)','https://drive.google.com/uc?id=1s-S2GyKcjLk9QU14hjL-9K7_YnrjXl6P','Java Antique Rose Gold',320.01,3);
INSERT INTO `timeless_finds`.`products` (`product_id`,`category`,`description`,`image`,`name`,`price`,`quantity`) VALUES (11,'Table','* Teak wood side table from Java, Indonesia.\n* Handcrafted by Javanese craftsmen, firmly held together with traditional butt joints to retain the old school charm of the furniture. On top of that, the butt joints are further reinforced with epoxy resin and nailed in for extra security.\n* Varnish touchups done in-house, some tables have minor chipped corners on inconspicuous parts of the table. \n* Originally from closed Begia Hotel in Indonesia\n* 72 (H) x 41 (W) x 34 (D)','https://drive.google.com/uc?id=1HHSuJzbETuIb_THsg6epFfD32IjtfOa-','Oval Table (3-Drawer)',130.00,6);
INSERT INTO `timeless_finds`.`products` (`product_id`,`category`,`description`,`image`,`name`,`price`,`quantity`) VALUES (12,'Table','* Grade A Oak sewing table made locally in Singapore in the 80s.\n* Condition: 7/10\n* Minor scratches and weathering, retouched in-house\n* Originally from local residence\n* 78 (H) x 86 (W) x 45 (D)','https://drive.google.com/uc?id=1Ga0DA_UAtcvUigUZXS8K8EDzC38NqfbJ','Vintage Sewing Machine Table',250.00,1);
INSERT INTO `timeless_finds`.`products` (`product_id`,`category`,`description`,`image`,`name`,`price`,`quantity`) VALUES (13,'Chair','* Original Pine wood chair set of 4 made by Nishigishi Furniture in Kyoto\n* Condition 9/10\nMinor scratches and weather, retouched in-house\n* Originally from local Japanese residence\n* 78 (H) x 60 (W) x 48 (D); 43 (Seat Height and Depth)','https://drive.google.com/uc?id=1GdpDsF8wvMYolLroLgGR-KaT6UppQIWU','Nishigishi Chair',522.00,4);
INSERT INTO `timeless_finds`.`products` (`product_id`,`category`,`description`,`image`,`name`,`price`,`quantity`) VALUES (14,'Chair','* Hand-crafted Mahogany bench by Design Toscano\n* Condition: 9/10\n*Originally from Johor residence\n78 (H) x 126 (W) x 47 (D); 43 (Seat Depth)\n\n','https://drive.google.com/uc?id=1GqFq9VMvR6hn8FeNmxmYEUmA-UROgiz3','Design Toscano Verona Filigree Bench',790.00,1);
INSERT INTO `timeless_finds`.`products` (`product_id`,`category`,`description`,`image`,`name`,`price`,`quantity`) VALUES (15,'Chair','* Old Nanyang style arm chair\n* Condition 9/10\n* Originally from local residence\n* 69 (H) x 60 (W) x 48 (D); 43 (Seat Depth)','https://drive.google.com/uc?id=1IYDv4YckqaKwYn_3syPRi0iwmCW8u6Oh','Nanyang Vintage Chair',450.00,2);
INSERT INTO `timeless_finds`.`products` (`product_id`,`category`,`description`,`image`,`name`,`price`,`quantity`) VALUES (16,'Cabinet','* Teak Motif Java Cabinet, made in Yogyakarta by local artisans ','https://drive.google.com/uc?id=1yWhevooqUnpVz1gFklAY19zL5gVkxUId','Teak Motif Java Cabinet ',1100.00,1);
INSERT INTO `timeless_finds`.`products` (`product_id`,`category`,`description`,`image`,`name`,`price`,`quantity`) VALUES (17,'Wares','* Old Brass Standing and Hanging Lantern\n* Condition 7/10, Metal surface with natural patina. Door is fixed with new hinges\n* Originally from local residence\n* 24 (H) x 14 (W) x 14 (L); 0.7kg ','https://drive.google.com/uc?id=1AeaOppi9uJ42VTUea_qT-B1gc7ZrLmB5','Antique Brass Gothic Standing Lantern',40.00,6);
INSERT INTO `timeless_finds`.`products` (`product_id`,`category`,`description`,`image`,`name`,`price`,`quantity`) VALUES (18,'Wares','* Old Brass Hanging Lantern\n* Condition 8/10, Metal surface with natural patina. Door is fixed with new hinges\n* Originally from local residence\n* 35 (H) x 16 (W) x 16 (L); 0.9kg ','https://drive.google.com/uc?id=1mR6jlwPSLCjJ-WlqApMW81B_21mjYNs3','Antique Brass Hanging Lantern',40.00,6);
INSERT INTO `timeless_finds`.`products` (`product_id`,`category`,`description`,`image`,`name`,`price`,`quantity`) VALUES (19,'Table','* This beautifully crafted red wood desk dates back to the mid 20th century Southeast Asia and boasts intricate carvings and brass hardware. The roll-top design provides ample storage for papers and office supplies, while the multiple drawers and compartments keep everything organized.\n* Condition 9/10, new coat of wood-protection varnish','https://drive.google.com/uc?id=1DayFirtHLFPf42wSr_whnGMTtG8LHV-O','Antique Roll-Top Desk',1030.00,1);
INSERT INTO `timeless_finds`.`products` (`product_id`,`category`,`description`,`image`,`name`,`price`,`quantity`) VALUES (20,'Chair','* This stylish armchair from the mid-20th century features clean lines and a sleek design. Made from rich, warm-toned wood, it has a comfortably upholstered seat and backrest in a neutral, textured fabric.\n* Condition 8/10, upholstery repaired.\n* Originally from local residence','https://drive.google.com/uc?id=18m0YGNGrKf-lWXy5ntcV4XltGxsjyO61','Mid-Century Modern Armchair',300.00,2);

/*
CART TABLE
*/

TRUNCATE TABLE `timeless_finds`.`cart`;
INSERT INTO `timeless_finds`.`cart` (`cart_id`, `cart_date`) VALUES ('1', '2023-06-06 08:43:30.131000');
INSERT INTO `timeless_finds`.`cart` (`cart_id`, `cart_date`) VALUES ('2', '2023-06-06 08:43:30.131000');
INSERT INTO `timeless_finds`.`cart` (`cart_id`, `cart_date`) VALUES ('3', '2023-06-06 08:43:30.131000');

SET foreign_key_checks = 1;