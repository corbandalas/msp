--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.4
-- Dumped by pg_dump version 9.4.4
-- Started on 2016-01-31 20:31:37 MSK

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 7 (class 2615 OID 24578)
-- Name: msp_scheme; Type: SCHEMA; Schema: -; Owner: msp_db
--

CREATE SCHEMA msp_scheme;


ALTER SCHEMA msp_scheme OWNER TO msp_db;

--
-- TOC entry 174 (class 3079 OID 12123)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2266 (class 0 OID 0)
-- Dependencies: 174
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = msp_scheme, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 173 (class 1259 OID 24587)
-- Name: property; Type: TABLE; Schema: msp_scheme; Owner: msp_db; Tablespace: 
--

CREATE TABLE property (
    id character varying(255) NOT NULL,
    value character varying(255) NOT NULL,
    description character varying(255) NOT NULL,
    category character varying(255) NOT NULL
);


ALTER TABLE property OWNER TO msp_db;

--
-- TOC entry 2258 (class 0 OID 24587)
-- Dependencies: 173
-- Data for Name: property; Type: TABLE DATA; Schema: msp_scheme; Owner: msp_db
--

COPY property (id, value, description, category) FROM stdin;
msp.gps.integration.key	1234	123	123
\.


--
-- TOC entry 2148 (class 2606 OID 24594)
-- Name: property_pkey; Type: CONSTRAINT; Schema: msp_scheme; Owner: msp_db; Tablespace: 
--

ALTER TABLE ONLY property
    ADD CONSTRAINT property_pkey PRIMARY KEY (id);


--
-- TOC entry 2265 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-01-31 20:31:37 MSK

--
-- PostgreSQL database dump complete
--

