/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  sh
 * Created: Aug 13, 2016
 */



INSERT INTO `c_security_role` (`id`, `name`, `description`) VALUES 
('admin', 'admin', 'Applicatipn Admin'),
('user', 'user', 'Applicatipn User');

INSERT INTO `c_security_permission` (`id`,`permission_label`,`permission_value`) VALUES
('notes_update','Edit Notes','ROLE_NOTES_UPDATE'),
('notes_view','View Notes','ROLE_NOTES_VIEW'),
('notes_create','Create Notes','ROLE_NOTES_CREATE'),
('notes_delete','Delete Notes','ROLE_NOTES_DELETE'),
('user_view','View User','ROLE_USER_VIEW');

INSERT INTO `c_security_role_permission` (`id_role`, `id_permission`) VALUES
('admin','notes_update'),
('admin','notes_view'),
('admin','notes_create'),
('admin','notes_delete'),
('user','notes_view'),
('user','user_view'),
('admin','user_view');

INSERT INTO `c_security_user` (`id`,`username`,`password`,`active`,`id_role`) VALUES
('1','sh','admin',true,'admin'),
('2','shsh','user',true,'user');

