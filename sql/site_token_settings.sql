use hssw;

CREATE TABLE stie_token_settings
(id INT NOT NULL AUTO_INCREMENT,
domain varchar(64) NOT NULL,
token varchar(256) NOT NULL,
update_time timestamp NOT NULL,
PRIMARY KEY(id),
UNIQUE(domain)
);