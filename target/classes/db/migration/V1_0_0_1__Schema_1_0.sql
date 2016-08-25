/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  sh
 * Created: Aug 13, 2016
 */


DROP TABLE IF EXISTS `notes`;
CREATE TABLE `notes`(
`id` varchar(255) NOT NULL,
`tittle` varchar(255) NOT NULL,
`date` varchar(255) NOT NULL,
`content` varchar(255) NOT NULL,
`created_by` varchar(255) NOT NULL,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `c_security_permission` (
    `id` varchar(255) NOT NULL,
    `permission_label` varchar(255) NOT NULL,
    `permission_value` varchar(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_7ddf32e17a6ac5ce04a8ecbf782ca509` (`permission_value`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `c_security_role`(
    `id` VARCHAR (255) NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `description` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_b068931cc450442b63f5b3d276ea4297` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `c_security_role_permission` (
    `id_role` varchar(255) NOT NULL,
    `id_permission` varchar(255) NOT NULL,
    PRIMARY KEY (`id_role`,`id_permission`),
    KEY `FK_4b65ca0f8b76e7181a12bf1fabc48532` (`id_permission`),
    CONSTRAINT `FK_4b65ca0f8b76e7181a12bf1fabc48532` FOREIGN KEY (`id_permission`) 
REFERENCES `c_security_permission` (`id`),
    CONSTRAINT `e91e6348157868de9dd8b25c81aebfb9` FOREIGN KEY (`id_role`) 
REFERENCES `c_security_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `c_security_user`(
    `id` varchar(255) NOT NULL,
    `username` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    `active` BOOLEAN NOT NULL,
    `id_role` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_14c4b06b824ec593239362517f538b29` (`username`),
    KEY `abcdefghijklmnopqrstuvwxyz12` (`id_role`),
    CONSTRAINT `FK_29a7e96467b69a9f5a93332e29e9b0de` FOREIGN KEY (`id_role`) REFERENCES `c_security_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

