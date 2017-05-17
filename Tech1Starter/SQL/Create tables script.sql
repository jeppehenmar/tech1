USE Tech1DB;

CREATE TABLE users(
	username VARCHAR(30) NOT NULL UNIQUE,
    user_password VARCHAR(30) NOT NULL,
    user_type VARCHAR(20) NOT NULL,
    PRIMARY KEY (username)
);

INSERT INTO users VALUES
('Jeppe','Henmar123','admin'),
('Henrik','Henrik123','user'),
('Ulrik','Testmann123','user'),
('Jurgen','Haha123','admin');

DROP TABLE users;