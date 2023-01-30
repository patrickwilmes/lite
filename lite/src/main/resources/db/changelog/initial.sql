-- liquibase formatted sql

-- changeset sevdesk:1667831597
-- preconditions onFail:MARK_RAN onError:MARK_RAN
-- precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'INVOICES' LIMIT 1;

CREATE TABLE IF NOT EXISTS INVOICES
(
    ID             BIGINT AUTO_INCREMENT PRIMARY KEY,
    INVOICE_NUMBER VARCHAR(50) NOT NULL,
    RECIPIENT      VARCHAR(50) NOT NULL,
    INVOICE_DATE   DATE        NOT NULL,
    PAY_DATE       DATE
)

-- rollback drop table INVOICES;