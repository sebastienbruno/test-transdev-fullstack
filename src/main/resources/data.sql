INSERT INTO bus (numero_bus) 
VALUES 17, 34, 45, 198, 255, 2, 77;

INSERT INTO client (email, nom)
VALUES ('user1@email.com', 'One');

INSERT INTO trajet (date_depart, nbr_place, prix, bus_id_fk, est_remise, prix_remise)
VALUES 
    (TO_TIMESTAMP('2022-08-01 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), 45, 13.4, 1, false, 0),
    (TO_TIMESTAMP('2022-08-01 08:35:00', 'YYYY-MM-DD HH24:MI:SS'), 42, 22.5, 1, false, 0),
    (TO_TIMESTAMP('2022-08-01 11:45:00', 'YYYY-MM-DD HH24:MI:SS'), 55, 25, 1, false, 0),
    (TO_TIMESTAMP('2022-08-01 14:12:00', 'YYYY-MM-DD HH24:MI:SS'), 45, 55.99, 1, false, 0),
    (TO_TIMESTAMP('2022-08-08 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), 45, 13.4, 1, false, 0),
    (TO_TIMESTAMP('2022-08-08 08:35:00', 'YYYY-MM-DD HH24:MI:SS'), 42, 22.5, 1, false, 0),
    (TO_TIMESTAMP('2022-08-08 11:45:00', 'YYYY-MM-DD HH24:MI:SS'), 55, 25, 1, false, 0),
    (TO_TIMESTAMP('2022-08-08 14:12:00', 'YYYY-MM-DD HH24:MI:SS'), 45, 55.99, 1, false, 0),
    (TO_TIMESTAMP('2022-08-08 21:00:00', 'YYYY-MM-DD HH24:MI:SS'), 45, 13.4, 1, false, 0),
    (TO_TIMESTAMP('2022-08-12 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), 15, 99.99, 2, false, 0),
    (TO_TIMESTAMP('2022-08-16 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), 15, 95, 2, false, 0),
    (TO_TIMESTAMP('2022-08-01 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), 45, 13.4, 3, false, 0),
    (TO_TIMESTAMP('2022-08-01 08:35:00', 'YYYY-MM-DD HH24:MI:SS'), 42, 22.5, 3, false, 0),
    (TO_TIMESTAMP('2022-08-01 11:45:00', 'YYYY-MM-DD HH24:MI:SS'), 55, 25, 3, false, 0),
    (TO_TIMESTAMP('2022-08-01 14:12:00', 'YYYY-MM-DD HH24:MI:SS'), 45, 55.99, 3, false, 0),
    (TO_TIMESTAMP('2022-08-08 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), 45, 13.4, 3, false, 0),
    (TO_TIMESTAMP('2022-08-08 08:35:00', 'YYYY-MM-DD HH24:MI:SS'), 42, 22.5, 3, false, 0),
    (TO_TIMESTAMP('2022-08-08 11:45:00', 'YYYY-MM-DD HH24:MI:SS'), 55, 25, 3, false, 0),
    (TO_TIMESTAMP('2022-08-08 14:12:00', 'YYYY-MM-DD HH24:MI:SS'), 45, 55.99, 3, false, 0),
    (TO_TIMESTAMP('2022-08-08 21:00:00', 'YYYY-MM-DD HH24:MI:SS'), 45, 13.4, 3, false, 0),
    (TO_TIMESTAMP('2022-08-12 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), 1, 99.99, 4, false, 0),
    (TO_TIMESTAMP('2022-08-16 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), 1, 95, 4, false, 0),
    (TO_TIMESTAMP('2022-08-01 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), 45, 13.4, 5, false, 0),
    (TO_TIMESTAMP('2022-08-01 08:35:00', 'YYYY-MM-DD HH24:MI:SS'), 42, 22.5, 5, false, 0),
    (TO_TIMESTAMP('2022-08-01 11:45:00', 'YYYY-MM-DD HH24:MI:SS'), 55, 25, 5, false, 0),
    (TO_TIMESTAMP('2022-08-01 14:12:00', 'YYYY-MM-DD HH24:MI:SS'), 45, 55.99, 5, false, 0),
    (TO_TIMESTAMP('2022-08-08 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), 45, 13.4, 5, false, 0),
    (TO_TIMESTAMP('2022-08-08 08:35:00', 'YYYY-MM-DD HH24:MI:SS'), 42, 22.5, 5, false, 0),
    (TO_TIMESTAMP('2022-08-08 11:45:00', 'YYYY-MM-DD HH24:MI:SS'), 55, 25, 5, false, 0),
    (TO_TIMESTAMP('2022-08-08 14:12:00', 'YYYY-MM-DD HH24:MI:SS'), 45, 55.99, 5, false, 0),
    (TO_TIMESTAMP('2022-08-08 21:00:00', 'YYYY-MM-DD HH24:MI:SS'), 45, 13.4, 5, false, 0),
    (TO_TIMESTAMP('2022-08-12 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), 15, 99.99, 6, false, 0),
    (TO_TIMESTAMP('2022-08-16 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), 15, 95, 6, false, 0);

INSERT INTO trajet (date_depart, nbr_place, prix, bus_id_fk, est_remise, prix_remise)
VALUES 
    (TO_TIMESTAMP('2022-08-10 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), 12, 108.25, 2, true, 102.84),
    (TO_TIMESTAMP('2022-08-14 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), 12, 150, 2, true, 142.5),
    (TO_TIMESTAMP('2022-08-18 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), 12, 143, 2, true, 135.85),
    (TO_TIMESTAMP('2022-08-10 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), 1, 108.25, 4, true, 102.84),
    (TO_TIMESTAMP('2022-08-14 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), 1, 150, 4, true, 142.5),
    (TO_TIMESTAMP('2022-08-18 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), 1, 143, 4, true, 135.85),
    (TO_TIMESTAMP('2022-08-10 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), 12, 108.25, 6, true, 102.84),
    (TO_TIMESTAMP('2022-08-14 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), 12, 150, 6, true, 142.5),
    (TO_TIMESTAMP('2022-08-18 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), 12, 143, 6, true, 135.85);
