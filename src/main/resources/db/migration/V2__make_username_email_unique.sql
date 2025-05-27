ALTER TABLE account
    ADD CONSTRAINT unique_username UNIQUE (username);

ALTER TABLE account
    ADD CONSTRAINT unique_email UNIQUE (email);
