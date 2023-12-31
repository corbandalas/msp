﻿--CREATE SCHEMA msp_scheme;
--CREATE SCHEMA test_scheme;
--ALTER SCHEMA msp_scheme OWNER TO msp_db;
--ALTER SCHEMA test_scheme OWNER TO msp_db;

/*SET search_path = msp_scheme, test_scheme, pg_catalog;*/


CREATE TABLE property (
    id character varying(255) NOT NULL,
    value character varying(255) NOT NULL,
    description character varying(255) NOT NULL,
    category character varying(255) NOT NULL
);
ALTER TABLE ONLY property
    ADD CONSTRAINT property_pkey PRIMARY KEY (id);



CREATE TABLE currency (
    id character varying(255) NOT NULL,
    displayText character varying(255) NOT NULL,
    code smallint NOT NULL,
    active boolean NOT NULL DEFAULT false,
    euroIndex numeric NOT NULL
);
ALTER TABLE ONLY currency
    ADD CONSTRAINT currency_pkey PRIMARY KEY (id);

CREATE SEQUENCE exchange_rate_history_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

CREATE TABLE exchange_rate_history
(
    id bigint NOT NULL,
    euro_index numeric NOT NULL,
    date timestamp without time zone NOT NULL,
    currency_id character varying(3) NOT NULL,
    CONSTRAINT exchange_rate_history_pkey PRIMARY KEY (id),
    CONSTRAINT exchange_rate_history_currency_key FOREIGN KEY (currency_id)
    REFERENCES currency (id) MATCH SIMPLE
    ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT exchange_rate_history_key UNIQUE (currency_id, date)
);

CREATE TABLE customer (
    id character varying(255) NOT NULL,
    title character varying(255),
    firstName character varying(255),
    lastName character varying(255),
    registrationDate timestamp with time zone DEFAULT now(),
    dateBirth timestamp with time zone,
    active boolean,
    address1 character varying(255),
    address2 character varying(255),
    postcode character varying(255),
    city character varying(255),
    email character varying(255),
    kyc character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    tempPassword boolean
);
ALTER TABLE ONLY customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (id);



CREATE TABLE country (
    id character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    phoneCode SMALLINT NOT NULL,
    active boolean NOT NULL DEFAULT false,
    currency_id character varying(255) NOT NULL
);
ALTER TABLE ONLY country
    ADD CONSTRAINT country_pkey PRIMARY KEY (id);

ALTER TABLE country
  ADD CONSTRAINT country_currency FOREIGN KEY (currency_id)
      REFERENCES currency (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

CREATE SEQUENCE card_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

ALTER TABLE card_seq
OWNER TO msp_db;

CREATE TABLE card (
    id bigint NOT NULL,
    token character varying(255) NOT NULL,
    cardtype character varying(255) NOT NULL,
    brand character varying(255) NOT NULL,
    createDate timestamp with time zone DEFAULT now(),
    is_default boolean NOT NULL DEFAULT false,
    active boolean,
    customer_id character varying(255) NOT NULL,
    alias character varying(255) NOT NULL,
    info character varying(255) NOT NULL,
    deliveryAddress1 character varying(255) NOT NULL,
    deliveryAddress2 character varying(255) NOT NULL,
    deliveryAddress3 character varying(255) NOT NULL,
    deliveryCountry character varying(255) NOT NULL,
    currency_id character varying(255) NOT NULL
);
ALTER TABLE ONLY card
    ADD CONSTRAINT card_pkey PRIMARY KEY (id);

ALTER TABLE card
  ADD CONSTRAINT card_customer FOREIGN KEY (customer_id)
      REFERENCES customer (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE card
  ADD CONSTRAINT card_currency FOREIGN KEY (currency_id)
      REFERENCES currency (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
      
CREATE SEQUENCE operation_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
      
CREATE TABLE operation (
    id bigint NOT NULL,
    orderId character varying(255) NOT NULL,
    description text,
    type character varying(255) NOT NULL,
    createdate timestamp with time zone DEFAULT now()
);
ALTER TABLE ONLY operation
    ADD CONSTRAINT operation_pkey PRIMARY KEY (id);



CREATE TABLE account (
    id bigint NOT NULL,
    currency_id character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    createdate timestamp with time zone DEFAULT now(),
    active boolean
);
ALTER TABLE ONLY account
    ADD CONSTRAINT account_pkey PRIMARY KEY (id);

ALTER TABLE account
  ADD CONSTRAINT account_currency FOREIGN KEY (currency_id)
      REFERENCES currency (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

CREATE SEQUENCE transaction_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

ALTER TABLE transaction_seq
OWNER TO msp_db;

CREATE TABLE transaction (
    id bigint NOT NULL,
    operation_id bigint NOT NULL,
    amount bigint NOT NULL,
    currency_id character varying(255) NOT NULL,
    from_account_id integer NOT NULL,
    to_account_id integer NOT NULL,
    card_id integer,
    from_exchange_rate numeric,
    to_exchange_rate numeric,
    type character varying(255) NOT NULL
);
ALTER TABLE ONLY transaction
    ADD CONSTRAINT transaction_pkey PRIMARY KEY (id);

ALTER TABLE transaction
  ADD CONSTRAINT transaction_operation FOREIGN KEY (operation_id)
      REFERENCES operation (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE transaction
  ADD CONSTRAINT transaction_from_account FOREIGN KEY (from_account_id)
      REFERENCES account (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE transaction
  ADD CONSTRAINT transaction_to_account FOREIGN KEY (to_account_id)
      REFERENCES account (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE transaction
  ADD CONSTRAINT transaction_currency FOREIGN KEY (currency_id)
      REFERENCES currency (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE transaction
  ADD CONSTRAINT transaction_card FOREIGN KEY (card_id)
      REFERENCES card (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;


ALTER TABLE property OWNER TO msp_db;
ALTER TABLE currency OWNER TO msp_db;
ALTER TABLE exchange_rate_history OWNER TO msp_db;
ALTER TABLE customer OWNER TO msp_db;
ALTER TABLE country OWNER TO msp_db;
ALTER TABLE card OWNER TO msp_db;
ALTER TABLE operation OWNER TO msp_db;
ALTER TABLE account OWNER TO msp_db;
ALTER TABLE transaction OWNER TO msp_db;