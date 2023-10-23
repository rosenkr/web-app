-- This file represents the whole database schema, it is made up of DDL statements
-- beware of potential pitfall, if using Pgresql as a service on cloud provider, I may not be able to create some extensions
CREATE EXTENSION IF NOT EXISTS "uuid-ossp"; -- better than bigserial for private keys
CREATE EXTENSION IF NOT EXISTS "pgcrypto"; -- passwords should be hashed for security, requires OpenSSL on server-side, which I have enabled. uuid_generate_v4(); to be used for primary key generation

CREATE TABLE user_account (
    user_uid UUID NOT NULL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    pswhash TEXT NOT NULL,
    date_of_creation DATE NOT NULL,
    UNIQUE (username)
);

-- Not necessary to include the salt itself as a table entry, as the crypt() includes the salt during encryption of the hash. Thus the hash contains the salt as the first 29 characters, and crypt() uses these for decryption

-- inserts: insert into user (user_uid, username, pswhash, date_of_creation) values (uuid_generate_v4(), entered name, crypt(password), DATE as currentTime in proper format..);

-- pw hash: to set new password, UPDATE ... SET pswhash = crypt('new password', gen_salt('bf')); where bf is my algorithm of choice. Authentication : SELECT (pswhash = crypt('entered password', pswhash)) AS pswmatch FROM ... ; returns true if the entered password  is correct
