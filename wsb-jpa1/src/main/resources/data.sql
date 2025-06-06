-- Doctors
insert into doctor (id, doctor_number, email, first_name, last_name, telephone_number, specialization)
values (1, 'DOC001', 'anna.kowalska@example.com', 'Anna', 'Kowalska', '123456789', 'Kardiologia');

insert into doctor (id, doctor_number, email, first_name, last_name, telephone_number, specialization)
values (2, 'DOC002', 'jan.nowak@example.com', 'Jan', 'Nowak', '987654321', 'Neurologia');

insert into doctor (id, doctor_number, email, first_name, last_name, telephone_number, specialization)
values (3, 'DOC003', 'ewa.marek@example.com', 'Ewa', 'Marek', '555666777', 'Ortopedia');

insert into doctor (id, doctor_number, email, first_name, last_name, telephone_number, specialization)
values (4, 'DOC004', 'piotr.kowalczyk@example.com', 'Piotr', 'Kowalczyk', '444555666', 'Pediatria');

insert into doctor (id, doctor_number, email, first_name, last_name, telephone_number, specialization)
values (5, 'DOC005', 'katarzyna.adamska@example.com', 'Katarzyna', 'Adamska', '333444555', 'Dermatologia');

-- Patients
insert into patient (date_of_birth, id, email, first_name, last_name, patient_number, telephone_number, blood_type, version)
values ('1985-05-15', 1, 'adam.nowak@example.com', 'Adam', 'Nowak', 'PAT001', '123456789', 'A_POSITIVE', 1);

insert into patient (date_of_birth, id, email, first_name, last_name, patient_number, telephone_number, blood_type, version)
values ('1990-07-20', 2, 'beata.kowalska@example.com', 'Beata', 'Kowalska', 'PAT002', '987654321', 'B_NEGATIVE', 1);

insert into patient (date_of_birth, id, email, first_name, last_name, patient_number, telephone_number, blood_type, version)
values ('1978-02-10', 3, 'carl.martin@example.com', 'Carl', 'Martin', 'PAT003', '555666777', 'AB_NEGATIVE', 1);

insert into patient (date_of_birth, id, email, first_name, last_name, patient_number, telephone_number, blood_type, version)
values ('2000-11-30', 4, 'diana.zieminska@example.com', 'Diana', 'Ziemińska', 'PAT004', '444555666', 'A_POSITIVE', 1);

insert into patient (date_of_birth, id, email, first_name, last_name, patient_number, telephone_number, blood_type, version)
values ('1995-09-05', 5, 'ewa.nowicka@example.com', 'Ewa', 'Nowicka', 'PAT005', '333444555', 'ZERO_POSITIVE', 1);

-- Addresses
insert into address (id, address_line1, address_line2, city, postal_code, doctor_id)
values (901, 'ul. Przykładowa 1', 'mieszkanie 1', 'Warszawa', '00-001', 1);

insert into address (id, address_line1, address_line2, city, postal_code, doctor_id)
values (902, 'ul. Słoneczna 10', 'blok 5', 'Kraków', '30-001', 2);

insert into address (id, address_line1, address_line2, city, postal_code, doctor_id)
values (903, 'ul. Leśna 5', 'apartament 2', 'Gdańsk', '80-001', 3);

insert into address (id, address_line1, address_line2, city, postal_code, doctor_id)
values (904, 'ul. Polna 3', 'dom 1', 'Wrocław', '50-001', 4);

insert into address (id, address_line1, address_line2, city, postal_code, doctor_id)
values (905, 'ul. Mickiewicza 8', 'mieszkanie 3', 'Poznań', '60-001', 5);

insert into address (id, address_line1, address_line2, city, postal_code)
values (906, 'ul. Nowa 12', 'apartament 4', 'Łódź', '90-001');

insert into address (id, address_line1, address_line2, city, postal_code)
values (907, 'ul. Wiosenna 15', 'blok 10', 'Szczecin', '70-001');

insert into address (id, address_line1, address_line2, city, postal_code)
values (908, 'ul. Kopernika 6', 'dom 2', 'Bydgoszcz', '85-001');

insert into address (id, address_line1, address_line2, city, postal_code)
values (909, 'ul. Piłsudskiego 9', 'mieszkanie 5', 'Lublin', '20-001');

insert into address (id, address_line1, address_line2, city, postal_code)
values (910, 'ul. Sienkiewicza 4', 'apartament 6', 'Katowice', '40-001');

-- Visits
-- 1 wizyta dla patient_id 1
insert into visit (doctor_id, id, patient_id, time, description)
values (1, 1, 1, '2025-03-17 09:00:00', 'Konsultacja kontrolna');

-- 2 wizyty dla patient_id 2
insert into visit (doctor_id, id, patient_id, time, description)
values (2, 2, 2, '2025-03-17 10:30:00', 'Wizyta diagnostyczna');
insert into visit (doctor_id, id, patient_id, time, description)
values (3, 3, 2, '2025-03-18 09:00:00', 'Kontrola po badaniach');

-- 3 wizyty dla patient_id 3
insert into visit (doctor_id, id, patient_id, time, description)
values (4, 4, 3, '2025-03-17 11:45:00', 'Konsultacja ortopedyczna');
insert into visit (doctor_id, id, patient_id, time, description)
values (5, 5, 3, '2025-03-18 13:00:00', 'Wizyta rehabilitacyjna');
insert into visit (doctor_id, id, patient_id, time, description)
values (5, 6, 3, '2025-03-19 10:00:00', 'Konsultacja końcowa');

-- 4 wizyty dla patient_id 4
insert into visit (doctor_id, id, patient_id, time, description)
values (1, 7, 4, '2025-03-17 13:15:00', 'Wizyta pediatryczna');
insert into visit (doctor_id, id, patient_id, time, description)
values (4, 8, 4, '2025-03-18 09:30:00', 'Szczepienie');
insert into visit (doctor_id, id, patient_id, time, description)
values (5, 9, 4, '2025-03-19 12:00:00', 'Kontrola stanu zdrowia');
insert into visit (doctor_id, id, patient_id, time, description)
values (5, 10, 4, '2025-03-20 11:00:00', 'Konsultacja żywieniowa');

-- 5 wizyt dla patient_id 5
insert into visit (doctor_id, id, patient_id, time, description)
values (4, 11, 5, '2025-03-17 15:00:00', 'Kontrola dermatologiczna');
insert into visit (doctor_id, id, patient_id, time, description)
values (2, 12, 5, '2025-03-18 14:00:00', 'Konsultacja alergologiczna');
insert into visit (doctor_id, id, patient_id, time, description)
values (3, 13, 5, '2025-03-19 16:00:00', 'Konsultacja kontrolna');
insert into visit (doctor_id, id, patient_id, time, description)
values (3, 14, 5, '2025-03-20 10:30:00', 'Wizyta kontrolna po leczeniu');
insert into visit (doctor_id, id, patient_id, time, description)
values (2, 15, 5, '2025-03-21 09:00:00', 'Konsultacja końcowa');

-- Medical treatments
insert into medical_treatment (id, visit_id, description, type)
values (1, 1, 'Leczenie kardiologiczne', 'USG');

insert into medical_treatment (id, visit_id, description, type)
values (2, 2, 'Diagnostyka neurologiczna', 'EKG');

insert into medical_treatment (id, visit_id, description, type)
values (3, 3, 'Fizjoterapia i rehabilitacja', 'RTG');

insert into medical_treatment (id, visit_id, description, type)
values (4, 4, 'Podanie szczepionki', 'USG');

insert into medical_treatment (id, visit_id, description, type)
values (5, 5, 'Leczenie dermatologiczne', 'USG');

-- Patient addresses
insert into patients_addresses (address_id, patient_id)
values (906, 1);

insert into patients_addresses (address_id, patient_id)
values (907, 2);

insert into patients_addresses (address_id, patient_id)
values (908, 3);

insert into patients_addresses (address_id, patient_id)
values (909, 4);

insert into patients_addresses (address_id, patient_id)
values (910, 5);
