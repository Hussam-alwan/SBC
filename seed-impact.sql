BEGIN;

-- Reset existing app data so this script can be re-run safely.
TRUNCATE TABLE campaign_photo, attendance, application, progress, campaign, "user", category, college RESTART IDENTITY CASCADE;

-- 1) Colleges
INSERT INTO college (name, description, created_at, updated_at)
VALUES
('College of Engineering', 'Engineering and applied sciences.', NOW(), NOW()),
('College of Business', 'Business administration and economics.', NOW(), NOW()),
('College of Arts', 'Humanities, arts, and social sciences.', NOW(), NOW());

-- 2) Categories
INSERT INTO category (name, created_at, updated_at)
VALUES
('Environment', NOW(), NOW()),
('Education', NOW(), NOW()),
('Health', NOW(), NOW()),
('Community', NOW(), NOW()),
('Technology', NOW(), NOW());

-- 3) Users (at least 5)
INSERT INTO "user" (
    student_number, first_name, last_name, email, phone, academic_year,
    is_banned, created_at, updated_at, college_id
)
VALUES
('STU1001', 'Aisha', 'Rahman', 'aisha.rahman@uni.edu', '0100000001', 2, false, NOW(), NOW(), (SELECT college_id FROM college WHERE name = 'College of Engineering')),
('STU1002', 'Omar', 'Hassan', 'omar.hassan@uni.edu', '0100000002', 3, false, NOW(), NOW(), (SELECT college_id FROM college WHERE name = 'College of Business')),
('STU1003', 'Lina', 'Khaled', 'lina.khaled@uni.edu', '0100000003', 1, false, NOW(), NOW(), (SELECT college_id FROM college WHERE name = 'College of Arts')),
('STU1004', 'Yousef', 'Nabil', 'yousef.nabil@uni.edu', '0100000004', 4, false, NOW(), NOW(), (SELECT college_id FROM college WHERE name = 'College of Engineering')),
('STU1005', 'Mariam', 'Adel', 'mariam.adel@uni.edu', '0100000005', 2, false, NOW(), NOW(), (SELECT college_id FROM college WHERE name = 'College of Business'));

-- 4) Campaigns (at least 5)
INSERT INTO campaign (
    title, description, location, start_date, end_date, max_volunteers, status,
    published_at, created_at, updated_at,
    proposed_by_id, approved_by_id, managed_by_id, category_id
)
VALUES
(
    'Green Campus Cleanup',
    'Student-led cleanup and recycling drive across campus zones.',
    'Main Campus',
    CURRENT_DATE - INTERVAL '10 day',
    CURRENT_DATE + INTERVAL '20 day',
    50,
    'ONGOING',
    NOW() - INTERVAL '9 day',
    NOW(), NOW(),
    (SELECT user_id FROM "user" WHERE email = 'aisha.rahman@uni.edu'),
    (SELECT user_id FROM "user" WHERE email = 'omar.hassan@uni.edu'),
    (SELECT user_id FROM "user" WHERE email = 'yousef.nabil@uni.edu'),
    (SELECT category_id FROM category WHERE name = 'Environment')
),
(
    'Weekend Math Tutoring',
    'Volunteers teach school students core math skills.',
    'City Learning Center',
    CURRENT_DATE - INTERVAL '15 day',
    CURRENT_DATE + INTERVAL '30 day',
    35,
    'APPROVED',
    NOW() - INTERVAL '14 day',
    NOW(), NOW(),
    (SELECT user_id FROM "user" WHERE email = 'lina.khaled@uni.edu'),
    (SELECT user_id FROM "user" WHERE email = 'omar.hassan@uni.edu'),
    (SELECT user_id FROM "user" WHERE email = 'mariam.adel@uni.edu'),
    (SELECT category_id FROM category WHERE name = 'Education')
),
(
    'Blood Donation Drive',
    'Coordinate donor registration and support with local hospitals.',
    'University Hospital',
    CURRENT_DATE - INTERVAL '40 day',
    CURRENT_DATE - INTERVAL '5 day',
    80,
    'COMPLETED',
    NOW() - INTERVAL '39 day',
    NOW(), NOW(),
    (SELECT user_id FROM "user" WHERE email = 'omar.hassan@uni.edu'),
    (SELECT user_id FROM "user" WHERE email = 'mariam.adel@uni.edu'),
    (SELECT user_id FROM "user" WHERE email = 'aisha.rahman@uni.edu'),
    (SELECT category_id FROM category WHERE name = 'Health')
),
(
    'Neighborhood Food Bank Support',
    'Sort, package, and distribute food parcels for families in need.',
    'Downtown Food Bank',
    CURRENT_DATE - INTERVAL '7 day',
    CURRENT_DATE + INTERVAL '25 day',
    60,
    'ONGOING',
    NOW() - INTERVAL '6 day',
    NOW(), NOW(),
    (SELECT user_id FROM "user" WHERE email = 'yousef.nabil@uni.edu'),
    (SELECT user_id FROM "user" WHERE email = 'mariam.adel@uni.edu'),
    (SELECT user_id FROM "user" WHERE email = 'lina.khaled@uni.edu'),
    (SELECT category_id FROM category WHERE name = 'Community')
),
(
    'Senior Digital Literacy',
    'Help senior citizens use smartphones and online services safely.',
    'Community Tech Hub',
    CURRENT_DATE + INTERVAL '5 day',
    CURRENT_DATE + INTERVAL '35 day',
    25,
    'APPROVED',
    NOW() - INTERVAL '2 day',
    NOW(), NOW(),
    (SELECT user_id FROM "user" WHERE email = 'mariam.adel@uni.edu'),
    (SELECT user_id FROM "user" WHERE email = 'aisha.rahman@uni.edu'),
    (SELECT user_id FROM "user" WHERE email = 'omar.hassan@uni.edu'),
    (SELECT category_id FROM category WHERE name = 'Technology')
);

-- 5) Progress updates
INSERT INTO progress (percentage, notes, created_at, updated_at, campaign_id, updated_by_id)
VALUES
(35, 'Cleanup teams assigned and first phase completed.', NOW(), NOW(), (SELECT campaign_id FROM campaign WHERE title = 'Green Campus Cleanup'), (SELECT user_id FROM "user" WHERE email = 'yousef.nabil@uni.edu')),
(20, 'Tutor onboarding complete, weekly schedule published.', NOW(), NOW(), (SELECT campaign_id FROM campaign WHERE title = 'Weekend Math Tutoring'), (SELECT user_id FROM "user" WHERE email = 'mariam.adel@uni.edu')),
(100, 'Campaign completed successfully with strong turnout.', NOW(), NOW(), (SELECT campaign_id FROM campaign WHERE title = 'Blood Donation Drive'), (SELECT user_id FROM "user" WHERE email = 'aisha.rahman@uni.edu')),
(45, 'Distribution pipeline stabilized with partner NGOs.', NOW(), NOW(), (SELECT campaign_id FROM campaign WHERE title = 'Neighborhood Food Bank Support'), (SELECT user_id FROM "user" WHERE email = 'lina.khaled@uni.edu')),
(10, 'Training materials prepared and venue confirmed.', NOW(), NOW(), (SELECT campaign_id FROM campaign WHERE title = 'Senior Digital Literacy'), (SELECT user_id FROM "user" WHERE email = 'omar.hassan@uni.edu'));

-- 6) Campaign photos
INSERT INTO campaign_photo (photo_url, uploaded_at, created_at, updated_at, campaign_id, progress_id)
VALUES
('/uploads/campaigns/cleanup-1.jpg', NOW(), NOW(), NOW(), (SELECT campaign_id FROM campaign WHERE title = 'Green Campus Cleanup'), (SELECT progress_id FROM progress WHERE notes LIKE 'Cleanup teams assigned%')),
('/uploads/campaigns/cleanup-2.jpg', NOW(), NOW(), NOW(), (SELECT campaign_id FROM campaign WHERE title = 'Green Campus Cleanup'), (SELECT progress_id FROM progress WHERE notes LIKE 'Cleanup teams assigned%')),
('/uploads/campaigns/math-1.jpg', NOW(), NOW(), NOW(), (SELECT campaign_id FROM campaign WHERE title = 'Weekend Math Tutoring'), (SELECT progress_id FROM progress WHERE notes LIKE 'Tutor onboarding complete%')),
('/uploads/campaigns/blood-1.jpg', NOW(), NOW(), NOW(), (SELECT campaign_id FROM campaign WHERE title = 'Blood Donation Drive'), (SELECT progress_id FROM progress WHERE notes LIKE 'Campaign completed successfully%')),
('/uploads/campaigns/foodbank-1.jpg', NOW(), NOW(), NOW(), (SELECT campaign_id FROM campaign WHERE title = 'Neighborhood Food Bank Support'), (SELECT progress_id FROM progress WHERE notes LIKE 'Distribution pipeline stabilized%')),
('/uploads/campaigns/digital-1.jpg', NOW(), NOW(), NOW(), (SELECT campaign_id FROM campaign WHERE title = 'Senior Digital Literacy'), (SELECT progress_id FROM progress WHERE notes LIKE 'Training materials prepared%'));

-- 7) Applications
INSERT INTO application (
    motivation_letter, status, admin_notes, rejection_reason, applied_at, withdrawn_at,
    created_at, updated_at, reviewed_at, removal_reason, removed_at,
    student_id, campaign_id, reviewed_by_id, removed_by_id
)
VALUES
(
    'I care deeply about campus sustainability and want to lead by example.',
    'APPROVED',
    'Strong motivation and previous volunteer experience.',
    NULL,
    NOW() - INTERVAL '8 day',
    NULL,
    NOW(), NOW(), NOW() - INTERVAL '7 day', NULL, NULL,
    (SELECT user_id FROM "user" WHERE email = 'lina.khaled@uni.edu'),
    (SELECT campaign_id FROM campaign WHERE title = 'Green Campus Cleanup'),
    (SELECT user_id FROM "user" WHERE email = 'yousef.nabil@uni.edu'),
    NULL
),
(
    'I can support younger students in algebra and geometry.',
    'PENDING',
    NULL,
    NULL,
    NOW() - INTERVAL '5 day',
    NULL,
    NOW(), NOW(), NULL, NULL, NULL,
    (SELECT user_id FROM "user" WHERE email = 'aisha.rahman@uni.edu'),
    (SELECT campaign_id FROM campaign WHERE title = 'Weekend Math Tutoring'),
    NULL,
    NULL
),
(
    'I want to help coordinate donors and logistics.',
    'APPROVED',
    'Assigned to registration desk.',
    NULL,
    NOW() - INTERVAL '35 day',
    NULL,
    NOW(), NOW(), NOW() - INTERVAL '34 day', NULL, NULL,
    (SELECT user_id FROM "user" WHERE email = 'yousef.nabil@uni.edu'),
    (SELECT campaign_id FROM campaign WHERE title = 'Blood Donation Drive'),
    (SELECT user_id FROM "user" WHERE email = 'aisha.rahman@uni.edu'),
    NULL
),
(
    'I am available on weekends for food sorting shifts.',
    'REJECTED',
    'Capacity reached for this role.',
    'No remaining slots in preferred shift.',
    NOW() - INTERVAL '3 day',
    NULL,
    NOW(), NOW(), NOW() - INTERVAL '2 day', NULL, NULL,
    (SELECT user_id FROM "user" WHERE email = 'omar.hassan@uni.edu'),
    (SELECT campaign_id FROM campaign WHERE title = 'Neighborhood Food Bank Support'),
    (SELECT user_id FROM "user" WHERE email = 'lina.khaled@uni.edu'),
    NULL
),
(
    'I enjoy helping seniors with digital tools and apps.',
    'APPROVED',
    'Great communication skills.',
    NULL,
    NOW() - INTERVAL '1 day',
    NULL,
    NOW(), NOW(), NOW() - INTERVAL '10 hour', NULL, NULL,
    (SELECT user_id FROM "user" WHERE email = 'lina.khaled@uni.edu'),
    (SELECT campaign_id FROM campaign WHERE title = 'Senior Digital Literacy'),
    (SELECT user_id FROM "user" WHERE email = 'omar.hassan@uni.edu'),
    NULL
);

-- 8) Attendance records
INSERT INTO attendance (
    attendance_date, status, hours_that_day, notes, recorded_at,
    created_at, updated_at, student_id, campaign_id, recorded_by_id
)
VALUES
(CURRENT_DATE - INTERVAL '2 day', 'PRESENT', 4.0, 'Helped with waste sorting.', NOW() - INTERVAL '2 day', NOW(), NOW(), (SELECT user_id FROM "user" WHERE email = 'lina.khaled@uni.edu'), (SELECT campaign_id FROM campaign WHERE title = 'Green Campus Cleanup'), (SELECT user_id FROM "user" WHERE email = 'yousef.nabil@uni.edu')),
(CURRENT_DATE - INTERVAL '1 day', 'PRESENT', 3.5, 'Managed collection point B.', NOW() - INTERVAL '1 day', NOW(), NOW(), (SELECT user_id FROM "user" WHERE email = 'lina.khaled@uni.edu'), (SELECT campaign_id FROM campaign WHERE title = 'Green Campus Cleanup'), (SELECT user_id FROM "user" WHERE email = 'yousef.nabil@uni.edu')),
(CURRENT_DATE - INTERVAL '6 day', 'PRESENT', 2.5, 'Supported tutoring session 1.', NOW() - INTERVAL '6 day', NOW(), NOW(), (SELECT user_id FROM "user" WHERE email = 'aisha.rahman@uni.edu'), (SELECT campaign_id FROM campaign WHERE title = 'Weekend Math Tutoring'), (SELECT user_id FROM "user" WHERE email = 'mariam.adel@uni.edu')),
(CURRENT_DATE - INTERVAL '5 day', 'EXCUSED', 0.0, 'Medical appointment.', NOW() - INTERVAL '5 day', NOW(), NOW(), (SELECT user_id FROM "user" WHERE email = 'aisha.rahman@uni.edu'), (SELECT campaign_id FROM campaign WHERE title = 'Weekend Math Tutoring'), (SELECT user_id FROM "user" WHERE email = 'mariam.adel@uni.edu')),
(CURRENT_DATE - INTERVAL '20 day', 'PRESENT', 5.0, 'Handled donor check-in.', NOW() - INTERVAL '20 day', NOW(), NOW(), (SELECT user_id FROM "user" WHERE email = 'yousef.nabil@uni.edu'), (SELECT campaign_id FROM campaign WHERE title = 'Blood Donation Drive'), (SELECT user_id FROM "user" WHERE email = 'aisha.rahman@uni.edu')),
(CURRENT_DATE - INTERVAL '19 day', 'PRESENT', 4.5, 'Assisted medical team logistics.', NOW() - INTERVAL '19 day', NOW(), NOW(), (SELECT user_id FROM "user" WHERE email = 'yousef.nabil@uni.edu'), (SELECT campaign_id FROM campaign WHERE title = 'Blood Donation Drive'), (SELECT user_id FROM "user" WHERE email = 'aisha.rahman@uni.edu')),
(CURRENT_DATE - INTERVAL '2 day', 'ABSENT', 0.0, 'No show.', NOW() - INTERVAL '2 day', NOW(), NOW(), (SELECT user_id FROM "user" WHERE email = 'omar.hassan@uni.edu'), (SELECT campaign_id FROM campaign WHERE title = 'Neighborhood Food Bank Support'), (SELECT user_id FROM "user" WHERE email = 'lina.khaled@uni.edu')),
(CURRENT_DATE - INTERVAL '1 day', 'PRESENT', 3.0, 'Packed 40 food boxes.', NOW() - INTERVAL '1 day', NOW(), NOW(), (SELECT user_id FROM "user" WHERE email = 'omar.hassan@uni.edu'), (SELECT campaign_id FROM campaign WHERE title = 'Neighborhood Food Bank Support'), (SELECT user_id FROM "user" WHERE email = 'lina.khaled@uni.edu')),
(CURRENT_DATE, 'PRESENT', 2.0, 'Prepared digital literacy handouts.', NOW(), NOW(), NOW(), (SELECT user_id FROM "user" WHERE email = 'lina.khaled@uni.edu'), (SELECT campaign_id FROM campaign WHERE title = 'Senior Digital Literacy'), (SELECT user_id FROM "user" WHERE email = 'omar.hassan@uni.edu')),
(CURRENT_DATE, 'PRESENT', 1.5, 'Tested workshop laptops and projectors.', NOW(), NOW(), NOW(), (SELECT user_id FROM "user" WHERE email = 'mariam.adel@uni.edu'), (SELECT campaign_id FROM campaign WHERE title = 'Senior Digital Literacy'), (SELECT user_id FROM "user" WHERE email = 'omar.hassan@uni.edu'));

COMMIT;

