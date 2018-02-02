-- Dumping database structure for concretepage
CREATE DATABASE IF NOT EXISTS `concretepage`; 
USE `concretepage`;
-- Dumping structure for table concretepage.users
CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `role` varchar(50) NOT NULL,
  `country` varchar(100) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
-- Dumping data for table concretepage.users: ~3 rows (approximately)
INSERT INTO `users` (`username`, `password`, `full_name`, `role`, `country`, `enabled`) VALUES
	('arvind', '$2a$10$Vfs8YMQx1YHI.d0x4WO8n.C.K3prfllnP2uS/j8ChpRirS17y.N42', 'Arvind Rai', 'ROLE_USER', 'India', 1),
	('mahesh', '$2a$10$N0eqNiuikWCy9ETQ1rdau.XEELcyEO7kukkfoiNISk/9F7gw6eB0W', 'Mahesh Sharma', 'ROLE_ADMIN', 'India', 1),
	('trump', '$2a$10$QifQnP.XqXDW0Lc4hSqEg.GhTqZHoN2Y52/hoWr4I5ePxK7D2Pi8q', 'Donald Trump', 'ROLE_ADMIN', 'US', 1); 
