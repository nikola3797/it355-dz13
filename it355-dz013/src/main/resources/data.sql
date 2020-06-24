LOCK TABLES `automobili` WRITE;
INSERT INTO `automobili` VALUES (1, 'Mercedes', 'S class', '100.000e', 'USA', '1000 km');
INSERT INTO `automobili` VALUES (2, 'Mercedes', 'E class', '70.000e', 'USA', '200 km');
INSERT INTO `automobili` VALUES (3, 'Mercedes', 'C class', '50.000e', 'USA', '100 km');
INSERT INTO `automobili` VALUES (4, 'Mercedes', 'GLE', '80.000e', 'USA', '0 km');
INSERT INTO `automobili` VALUES (5, 'Mercedes', 'G', '110.000e', 'USA', '0 km');
UNLOCK TABLES;



LOCK TABLES `vlasnici` WRITE;
INSERT INTO `vlasnici` VALUES (1, 'Jovan', 'Popovic', 'jovanpopovic@gmail', 'kralja milana 23', '06345323423');
INSERT INTO `vlasnici` VALUES (2, 'Milan', 'Jovic', 'milanjovic@gmail', 'bulevar oslobodjenja 44', '0644234253');
INSERT INTO `vlasnici` VALUES (3, 'Goran', 'Pavlovic', 'goranpavlovic@gmail', 'narodnih heroja 76', '067345235');
INSERT INTO `vlasnici` VALUES (4, 'Marija', 'Opacic', 'marijaopacic@gmail', 'gandijeva 3', '0623123213');
INSERT INTO `vlasnici` VALUES (5, 'Lidija', 'Vukotic', 'lidijavukotic@gmail', 'nehruova 65', '06623432532');
UNLOCK TABLES;