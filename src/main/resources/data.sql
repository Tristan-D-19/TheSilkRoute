insert into tsr_user (first_name, last_name, password, email, IS_ACTIVE, DATE_JOINED) values ('Admin', 'Admin', '$lowJaguar29', 'tristand.thomas19@gmail.com',1 ,CURRENT_TIMESTAMP);
insert into tsr_role ( role, role_access) values ( 'ADMIN', 1);
insert into tsr_role ( role, role_access) values ( 'USER', 0);