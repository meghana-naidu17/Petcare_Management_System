CREATE TABLE admins (
    admin_id INT PRIMARY KEY,
    username VARCHAR(100),
    password VARCHAR(100)
);

CREATE TABLE managers (
    manager_id INT PRIMARY KEY,
    username VARCHAR(100),
    password VARCHAR(100)
);

CREATE TABLE users (
    user_id INT PRIMARY KEY,
    name VARCHAR(100),
    password VARCHAR(100)
);

CREATE TABLE pets (
    pet_id INT PRIMARY KEY,
    pet_name VARCHAR(100),
    species VARCHAR(100),
    age INT,
    owner_id INT REFERENCES users(user_id)
);

CREATE TABLE veterinarians (
    vet_id INT PRIMARY KEY,
    vet_name VARCHAR(100),
    specialization VARCHAR(100)
);

CREATE TABLE appointments (
    appointment_id INT PRIMARY KEY,
    pet_id INT REFERENCES pets(pet_id),
    appointment_date VARCHAR(50)
);

CREATE TABLE treatments (
    treatment_id INT PRIMARY KEY,
    pet_id INT REFERENCES pets(pet_id),
    diagnosis VARCHAR(255)
);
SELECT * FROM pets;
INSERT INTO users
VALUES (101, 'Test User', '123');
SELECT * FROM users;
SELECT * FROM appointments;
SELECT * FROM admins;
-- USERS
CREATE TABLE IF NOT EXISTS users (
    user_id INT PRIMARY KEY,
    name VARCHAR(100),
    password VARCHAR(100)
);

INSERT INTO users VALUES
(100, 'Meghana', 'pass123'),
(102, 'Rahul', 'rahul123'),
(103, 'Priya', 'priya123');

-- ADMINS
CREATE TABLE IF NOT EXISTS admins (
    admin_id INT PRIMARY KEY,
    username VARCHAR(100),
    password VARCHAR(100)
);

INSERT INTO admins VALUES
(4, 'admin1', 'admin123'),
(2, 'admin2', 'admin123'),
(3, 'admin3', 'admin123');

-- MANAGERS
CREATE TABLE IF NOT EXISTS managers (
    manager_id INT PRIMARY KEY,
    username VARCHAR(100),
    password VARCHAR(100)
);

INSERT INTO managers VALUES
(201, 'manager1', 'manager123'),
(202, 'manager2', 'manager123'),
(203, 'manager3', 'manager123');

-- PETS
CREATE TABLE IF NOT EXISTS pets (
    pet_id INT PRIMARY KEY,
    pet_name VARCHAR(100),
    species VARCHAR(100),
    age INT,
    owner_id INT REFERENCES users(user_id)
);

INSERT INTO pets VALUES
(301, 'Bruno', 'Dog', 3, 101),
(302, 'Kitty', 'Cat', 2, 102),
(303, 'Rocky', 'Dog', 5, 103);

-- APPOINTMENTS
CREATE TABLE IF NOT EXISTS appointments (
    appointment_id INT PRIMARY KEY,
    pet_id INT REFERENCES pets(pet_id),
    appointment_date VARCHAR(50)
);

INSERT INTO appointments VALUES
(401, 301, '2026-06-30'),
(402, 302, '2026-07-01'),
(403, 303, '2026-07-02');

-- TREATMENTS
CREATE TABLE IF NOT EXISTS treatments (
    treatment_id INT PRIMARY KEY,
    pet_id INT REFERENCES pets(pet_id),
    diagnosis VARCHAR(255)
);

INSERT INTO treatments VALUES
(501, 301, 'Vaccination'),
(502, 302, 'Skin Allergy'),
(503, 303, 'Regular Checkup');

-- VETERINARIANS
CREATE TABLE IF NOT EXISTS veterinarians (
    vet_id INT PRIMARY KEY,
    vet_name VARCHAR(100),
    specialization VARCHAR(100)
);

INSERT INTO veterinarians VALUES
(601, 'Dr. Sharma', 'Surgery'),
(602, 'Dr. Reddy', 'Dermatology'),
(603, 'Dr. Kumar', 'General Medicine');

-- VERIFY DATA
SELECT * FROM users;
SELECT * FROM admins;
SELECT * FROM managers;
SELECT * FROM pets;
SELECT * FROM appointments;
SELECT * FROM treatments;
SELECT * FROM veterinarians;