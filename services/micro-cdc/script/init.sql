ALTER SYSTEM SET wal_level = 'logical';
ALTER SYSTEM SET max_wal_senders = 10;
ALTER SYSTEM SET max_replication_slots = 10;
ALTER ROLE postgres WITH REPLICATION;
GRANT ALL PRIVILEGES ON DATABASE cuentasdb TO postgres;

CREATE PUBLICATION dbz_publication FOR ALL TABLES;





-- curl -i -X POST -H "Accept:application/json" -H "Content-Type:application/json" http://localhost:8083/connectors/ -d @services/micro-cdc/debezium-connector/register-connector.json


curl -H "Accept:application/json" localhost:8083/connectors/