INSERT INTO JOB_TARGET (id, name)
VALUES (1, 'Software Developer');

INSERT INTO JOB_TARGET (id, name)
VALUES (2, 'Entry');

INSERT INTO JOB_MATCH (id, name, dateFound, referenceId)
VALUES (1, 'Entry Level Software Developer', )


CREATE TABLE IF NOT EXISTS JOB_MATCH (
                                         id SERIAL PRIMARY KEY,
                                         job_name VARCHAR(255) NOT NULL,
    date_found VARCHAR(255) NOT NULL,
    job_id_number VARCHAR(255) NOT NULL
    );

CREATE INDEX IF NOT EXISTS idx_job_match_id ON JOB_MATCH(id);
