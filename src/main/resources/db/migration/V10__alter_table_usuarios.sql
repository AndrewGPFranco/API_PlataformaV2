DROP TRIGGER IF EXISTS before_insert_usuarios;

CREATE TRIGGER before_insert_usuarios
BEFORE INSERT ON usuarios
FOR EACH ROW
BEGIN

    IF NEW.genero = '0' THEN
        SET NEW.genero = 'MASCULINO';
    ELSEIF NEW.genero = '1' THEN
        SET NEW.genero = 'FEMININO';
    END IF;

    IF NEW.nivel = '0' THEN
        SET NEW.nivel = 'BRONZE';
    ELSEIF NEW.nivel = '1' THEN
        SET NEW.nivel = 'PRATA';
    ELSEIF NEW.nivel = '2' THEN
        SET NEW.nivel = 'OURO';
    ELSEIF NEW.nivel = '3' THEN
        SET NEW.nivel = 'PLATINA';
    ELSEIF NEW.nivel = '4' THEN
        SET NEW.nivel = 'DIAMANTE';
    END IF;
END;