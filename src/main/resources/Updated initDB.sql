DROP TABLE IF EXISTS PUBLIC.CLIENTS;

CREATE TABLE PUBLIC.CLIENTS (
                                ID         INTEGER      NOT NULL AUTO_INCREMENT,
                                NAME       VARCHAR(255) NOT NULL,
                                SURNAME       VARCHAR(255) NOT NULL,
                                EMAIL       VARCHAR(255) NOT NULL,
                                CONSTRAINT CLIENTS_PRIMARY_KEY PRIMARY KEY (ID)
);

DROP TABLE IF EXISTS PUBLIC.CL_ACCOUNTS;

CREATE TABLE PUBLIC.CL_ACCOUNTS (
                                    ID          INTEGER      NOT NULL AUTO_INCREMENT,
                                    AC_NUMBER VARCHAR(255) NOT NULL,
                                    BALANCE DOUBLE(255),
                                    CLIENT_ID     INTEGER      NOT NULL UNIQUE,
                                    CONSTRAINT CL_ACCOUNTS_PRIMARY_KEY PRIMARY KEY (ID),
                                    CONSTRAINT CLIENTS_FOREIGN_KEY FOREIGN KEY (CLIENT_ID) REFERENCES CLIENTS (ID)
);

DROP TABLE IF EXISTS PUBLIC.CARDS;
CREATE TABLE PUBLIC.CARDS (
                              ID          INTEGER      NOT NULL AUTO_INCREMENT,
                              CARD_NUMBER VARCHAR(255) NOT NULL,
                              CL_ACCOUNT_ID     INTEGER      NOT NULL UNIQUE,
                              CONSTRAINT CARDS_PRIMARY_KEY PRIMARY KEY (ID),
                              CONSTRAINT CL_ACCOUNTS_FOREIGN_KEY FOREIGN KEY (CL_ACCOUNT_ID) REFERENCES CL_ACCOUNTS (ID)
);