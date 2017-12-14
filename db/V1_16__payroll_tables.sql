CREATE SEQUENCE payroll_request_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

ALTER TABLE payroll_request_seq
OWNER TO msp_db;

CREATE TABLE payroll_request (
    id bigint NOT NULL,
    orderid character varying(255) NOT NULL,
    description character varying(255) NOT NULL,
    createdate timestamp with time zone DEFAULT now(),
    daysequence character varying(255) NOT NULL,
    accountid integer NOT NULL,
    errorstatus character varying(255) NOT NULL
);

ALTER TABLE payroll_request
OWNER TO msp_db;

ALTER TABLE ONLY payroll_request
    ADD CONSTRAINT payroll_request_pkey PRIMARY KEY (id);

ALTER TABLE payroll_request
  ADD CONSTRAINT payroll_request_account FOREIGN KEY (accountid)
      REFERENCES account (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

CREATE TABLE payroll_request_sequence (
    id bigint NOT NULL,
    lastdate timestamp with time zone,
    currentvalue bigint NOT NULL
);

ALTER TABLE ONLY payroll_request_sequence
    ADD CONSTRAINT payroll_request_sequence_pkey PRIMARY KEY (id);

ALTER TABLE payroll_request_sequence
OWNER TO msp_db;


CREATE SEQUENCE payroll_card_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

ALTER TABLE payroll_card_seq
OWNER TO msp_db;

CREATE TABLE payroll_card (
    id bigint NOT NULL,
    payrollrequestid bigint NOT NULL,
    accno character varying(255) NOT NULL,
    pubtoken character varying(255),
    pan character varying(255),
    title character varying(255) NOT NULL,
    lastname character varying(255) NOT NULL,
    firstname character varying(255) NOT NULL,
    dob character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    mobtel character varying(255) NOT NULL,
    addrl1 character varying(255),
    addrl2 character varying(255),
    addrl3 character varying(255),
    city character varying(255) NOT NULL,
    islive character varying(255) NOT NULL,
    postcode character varying(255) NOT NULL,
    country character varying(255) NOT NULL,
    amount character varying(255),
    currency character varying(255),
    cardname character varying(255),
    expdate character varying(255),
    cvv character varying(255),
    error character varying(255),
    payrollcardtype character varying(255) NOT NULL,
    payrollcardstatus character varying(255) NOT NULL
);

ALTER TABLE payroll_card
OWNER TO msp_db;

ALTER TABLE ONLY payroll_card
    ADD CONSTRAINT payroll_card_pkey PRIMARY KEY (id);

ALTER TABLE payroll_card
  ADD CONSTRAINT payroll_card_request FOREIGN KEY (payrollrequestid)
      REFERENCES payroll_request (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
