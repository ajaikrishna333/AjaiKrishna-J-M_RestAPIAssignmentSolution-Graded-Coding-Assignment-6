INSERT INTO EMPLOYEE_TABLE (EMPLOYEE_ID,EMAIL_ID,FIRSTNAME,LASTNAME) VALUES (1,'emp1@gl.com','A-employee1','emp1');
INSERT INTO EMPLOYEE_TABLE (EMPLOYEE_ID,EMAIL_ID,FIRSTNAME,LASTNAME) VALUES (2,'emp2@gl.com','D-employee2','emp2');
INSERT INTO EMPLOYEE_TABLE (EMPLOYEE_ID,EMAIL_ID,FIRSTNAME,LASTNAME) VALUES (3,'emp3@gl.com','F-employee3','emp3');
INSERT INTO EMPLOYEE_TABLE (EMPLOYEE_ID,EMAIL_ID,FIRSTNAME,LASTNAME) VALUES (4,'emp4@gl.com','E-employee4','emp4');
INSERT INTO EMPLOYEE_TABLE (EMPLOYEE_ID,EMAIL_ID,FIRSTNAME,LASTNAME) VALUES (5,'emp5@gl.com','C-employee5','emp5');
INSERT INTO EMPLOYEE_TABLE (EMPLOYEE_ID,EMAIL_ID,FIRSTNAME,LASTNAME) VALUES (6,'emp6@gl.com','B-employee6','emp6');

INSERT INTO USER_TABLE (USER_ID,PASSWORD,USERNAME) VALUES (1,'$2a$12$U4ifUs0CZzDBpOrGMH5P5.XrQR543/v6/a7uznbiWLInLVSqy4a2O','one');
INSERT INTO USER_TABLE (USER_ID,PASSWORD,USERNAME) VALUES (2,'$2a$12$YBPDEp0VgC2fqPV3yFaAw.x4I8hF5sJpM9gSktJOVRJ1G/GIwTYam','two');

INSERT INTO ROLE_TABLE (ROLE_ID,ROLENAME) VALUES (1,'ADMIN');
INSERT INTO ROLE_TABLE (ROLE_ID,ROLENAME) VALUES (2,'USER');

INSERT INTO USERS_ROLES (USER_ID,ROLE_ID) VALUES (1,1);
INSERT INTO USERS_ROLES (USER_ID,ROLE_ID) VALUES (2,2);