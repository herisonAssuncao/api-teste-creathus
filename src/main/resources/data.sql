INSERT INTO usuarios (id, login, senha)
SELECT 1,'admin','$2y$12$OHDYJOx52eIMmFzvSKQJMePGPitm1on2bz295dP6R2XyD4UOb7EOK'
WHERE NOT EXISTS (SELECT 1 FROM usuarios WHERE login = 'admin');