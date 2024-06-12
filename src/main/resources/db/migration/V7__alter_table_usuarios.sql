CREATE TRIGGER before_insert_usuarios
BEFORE INSERT ON usuarios
FOR EACH ROW
BEGIN
    IF NEW.genero = '0' THEN
        SET NEW.genero = 'MASCULINO';
    ELSEIF NEW.genero = '1' THEN
        SET NEW.genero = 'FEMININO';
    END IF;
END;