INSERT INTO roles (id, name) VALUES (nextval('role_ids_sequence'), 'REGISTERED_USER');
INSERT INTO roles (id, name) VALUES (nextval('role_ids_sequence'), 'SYSTEM_ADMINISTRATOR');
INSERT INTO roles (id, name) VALUES (nextval('role_ids_sequence'), 'COMPANY_ADMINISTRATOR');

INSERT INTO users (id, email, password, first_name, last_name, phone_number, role_id)
VALUES (nextval('user_ids_sequence'), 'user@example.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'John', 'Doe', '1234567890', 1);

INSERT INTO registered_users (id, email, password, first_name, last_name, phone_number, points, penalties, category, country, city, occupation, hospital_information, , role_id)
VALUES (currval('user_ids_sequence'), 'user@example.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'John', 'Doe', '1234567890', 0, 0, 'REGULAR', 'Serbia', 'Novi Sad', 'Doctor', 'General Hospital Info', 1);