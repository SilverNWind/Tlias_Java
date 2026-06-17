DROP TABLE t1;
CREATE TABLE t1(id1 INTEGER, id2 INTEGER, data TEXT);
CREATE OR REPLACE FUNCTION indexsetup() RETURNS VOID AS '
  BEGIN
    FOR i IN 1..500 LOOP
      FOR j IN 1..500 LOOP
        INSERT INTO t1 VALUES(i, j, ''data_''||i||''_''||j);
      END LOOP;
    END LOOP;
    RETURN;
  END;
' LANGUAGE PLPGSQL;
SELECT indexsetup();
SELECT count(*) FROM t1;