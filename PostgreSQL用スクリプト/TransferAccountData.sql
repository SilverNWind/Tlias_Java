UPDATE account SET balance = balance - 100 WHERE emp_id = 6;
SELECT pg_sleep(10);
UPDATE account SET balance = balance + 100 WHERE emp_id = 8;
SELECT * FROM account;