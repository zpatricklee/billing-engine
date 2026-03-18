-- Sample data for Policy table
INSERT INTO policy (policy_id, first_name, last_name, policy_type, status, premium_amount)
VALUES ('POL123', 'John', 'Doe', 'AUTO', 'ACTIVE', 500.00),
       ('POL456', 'Jane', 'Smith', 'HOME', 'DELINQUENT', 600.00),
       ('POL789', 'Alice', 'Brown', 'LIFE', 'INACTIVE', 200.00),
       ('POL321', 'Jack', 'Johnson', 'AUTO', 'ACTIVE', 900.00);

-- Sample data for PremiumSchedule table
INSERT INTO premium_schedule (policy_id, currency, amount, status, billing_frequency, due_date)
VALUES ('POL123', 'USD', 100.00, 'PAID', 'MONTHLY', '2026-03-01'),
       ('POL123', 'USD', 100.00, 'UPCOMING', 'MONTHLY', '2026-04-01'),
       ('POL456', 'USD', 200.00, 'PAST_DUE', 'MONTHLY', '2026-03-10'),
       ('POL456', 'USD', 200.00, 'UPCOMING', 'MONTHLY', '2026-04-10'),
       ('POL321', 'USD', 150.00, 'UPCOMING', 'MONTHLY', '2026-04-01');

-- Sample data for PaymentRecord table
INSERT INTO payment_record (payment_id, policy_id, amount, payment_method, payment_status, payment_date_time)
VALUES ('a1b2c3d4e5f6g7h8', 'POL123', 100.00, 'CREDIT_CARD', 'PROCESSED', '2026-03-16T10:00:00'),
       ('i9j0k1l2m3n4o5p6', 'POL456', 200.00, 'DEBIT_CARD', 'FAILED', '2026-03-17T11:00:00');
