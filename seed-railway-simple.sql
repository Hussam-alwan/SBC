-- ============================================================================
-- RAILWAY DATABASE SEED SCRIPT (Simple Blocks)
-- ============================================================================
-- Paste each block separately into Railway Data UI console
-- Wait for "Query run successfully" before moving to the next block
-- ============================================================================

-- BLOCK 1: INSERT COLLEGES
-- Run this first, wait for success, then move to BLOCK 2
INSERT INTO college (name, description, created_at, updated_at)
VALUES
('College of Engineering', 'Engineering and applied sciences.', NOW(), NOW()),
('College of Business', 'Business administration and economics.', NOW(), NOW()),
('College of Arts', 'Humanities, arts, and social sciences.', NOW(), NOW());

-- Verify BLOCK 1: Run this to confirm colleges were inserted
SELECT COUNT(*) as college_count FROM college;

-- ============================================================================

-- BLOCK 2: INSERT CATEGORIES
-- Run this second
INSERT INTO category (name, created_at, updated_at)
VALUES
('Environment', NOW(), NOW()),
('Education', NOW(), NOW()),
('Health', NOW(), NOW()),
('Community', NOW(), NOW()),
('Technology', NOW(), NOW());

-- Verify BLOCK 2: Run this to confirm categories were inserted
SELECT COUNT(*) as category_count FROM category;

-- ============================================================================

-- BLOCK 3: INSERT USERS
-- Run this third
INSERT INTO "user" (
    student_number, first_name, last_name, email, phone, academic_year,
    is_banned, created_at, updated_at, college_id
)
VALUES
('STU1001', 'Aisha', 'Rahman', 'aisha.rahman@uni.edu', '0100000001', 2, false, NOW(), NOW(), 1),
('STU1002', 'Omar', 'Hassan', 'omar.hassan@uni.edu', '0100000002', 3, false, NOW(), NOW(), 2),
('STU1003', 'Lina', 'Khaled', 'lina.khaled@uni.edu', '0100000003', 1, false, NOW(), NOW(), 3),
('STU1004', 'Yousef', 'Nabil', 'yousef.nabil@uni.edu', '0100000004', 4, false, NOW(), NOW(), 1),
('STU1005', 'Mariam', 'Adel', 'mariam.adel@uni.edu', '0100000005', 2, false, NOW(), NOW(), 2);

-- Verify BLOCK 3: Run this to confirm users were inserted
SELECT COUNT(*) as user_count FROM "user";

-- ============================================================================

-- BLOCK 4: INSERT CAMPAIGNS
-- Run this fourth
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
    1, 2, 4, 1
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
    3, 2, 5, 2
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
    2, 5, 1, 3
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
    4, 5, 3, 4
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
    5, 1, 2, 5
);

-- Verify BLOCK 4: Run this to confirm campaigns were inserted
SELECT COUNT(*) as campaign_count FROM campaign;

-- ============================================================================

-- BLOCK 5: INSERT PROGRESS UPDATES
-- Run this fifth
INSERT INTO progress (percentage, notes, created_at, updated_at, campaign_id, updated_by_id)
VALUES
(35, 'Cleanup teams assigned and first phase completed.', NOW(), NOW(), 1, 4),
(20, 'Tutor onboarding complete, weekly schedule published.', NOW(), NOW(), 2, 5),
(100, 'Campaign completed successfully with strong turnout.', NOW(), NOW(), 3, 1),
(45, 'Distribution pipeline stabilized with partner NGOs.', NOW(), NOW(), 4, 3),
(10, 'Training materials prepared and venue confirmed.', NOW(), NOW(), 5, 2);

-- Verify BLOCK 5: Run this to confirm progress records were inserted
SELECT COUNT(*) as progress_count FROM progress;

-- ============================================================================

-- BLOCK 6: INSERT CAMPAIGN PHOTOS
-- Run this sixth
INSERT INTO campaign_photo (photo_url, uploaded_at, created_at, updated_at, campaign_id, progress_id)
VALUES
('/uploads/campaigns/cleanup-1.jpg', NOW(), NOW(), NOW(), 1, 1),
('/uploads/campaigns/cleanup-2.jpg', NOW(), NOW(), NOW(), 1, 1),
('/uploads/campaigns/math-1.jpg', NOW(), NOW(), NOW(), 2, 2),
('/uploads/campaigns/blood-1.jpg', NOW(), NOW(), NOW(), 3, 3),
('/uploads/campaigns/foodbank-1.jpg', NOW(), NOW(), NOW(), 4, 4),
('/uploads/campaigns/digital-1.jpg', NOW(), NOW(), NOW(), 5, 5);

-- Verify BLOCK 6: Run this to confirm campaign photos were inserted
SELECT COUNT(*) as photo_count FROM campaign_photo;

-- ============================================================================

-- BLOCK 7: INSERT APPLICATIONS
-- Run this seventh
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
    3, 1, 4, NULL
),
(
    'I can support younger students in algebra and geometry.',
    'PENDING',
    NULL,
    NULL,
    NOW() - INTERVAL '5 day',
    NULL,
    NOW(), NOW(), NULL, NULL, NULL,
    1, 2, NULL, NULL
),
(
    'I want to help coordinate donors and logistics.',
    'APPROVED',
    'Assigned to registration desk.',
    NULL,
    NOW() - INTERVAL '35 day',
    NULL,
    NOW(), NOW(), NOW() - INTERVAL '34 day', NULL, NULL,
    4, 3, 1, NULL
),
(
    'I am available on weekends for food sorting shifts.',
    'REJECTED',
    'Capacity reached for this role.',
    'No remaining slots in preferred shift.',
    NOW() - INTERVAL '3 day',
    NULL,
    NOW(), NOW(), NOW() - INTERVAL '2 day', NULL, NULL,
    2, 4, 3, NULL
),
(
    'I enjoy helping seniors with digital tools and apps.',
    'APPROVED',
    'Great communication skills.',
    NULL,
    NOW() - INTERVAL '1 day',
    NULL,
    NOW(), NOW(), NOW() - INTERVAL '10 hour', NULL, NULL,
    3, 5, 2, NULL
);

-- Verify BLOCK 7: Run this to confirm applications were inserted
    SELECT COUNT(*) as application_count FROM application;

-- ============================================================================

-- BLOCK 8: INSERT ATTENDANCE RECORDS
-- Run this eighth (final block)
INSERT INTO attendance (
    attendance_date, status, hours_that_day, notes, recorded_at,
    created_at, updated_at, student_id, campaign_id, recorded_by_id
)
VALUES
(CURRENT_DATE - INTERVAL '2 day', 'PRESENT', 4.0, 'Helped with waste sorting.', NOW() - INTERVAL '2 day', NOW(), NOW(), 3, 1, 4),
(CURRENT_DATE - INTERVAL '1 day', 'PRESENT', 3.5, 'Managed collection point B.', NOW() - INTERVAL '1 day', NOW(), NOW(), 3, 1, 4),
(CURRENT_DATE - INTERVAL '6 day', 'PRESENT', 2.5, 'Supported tutoring session 1.', NOW() - INTERVAL '6 day', NOW(), NOW(), 1, 2, 5),
(CURRENT_DATE - INTERVAL '5 day', 'EXCUSED', 0.0, 'Medical appointment.', NOW() - INTERVAL '5 day', NOW(), NOW(), 1, 2, 5),
(CURRENT_DATE - INTERVAL '20 day', 'PRESENT', 5.0, 'Handled donor check-in.', NOW() - INTERVAL '20 day', NOW(), NOW(), 4, 3, 1),
(CURRENT_DATE - INTERVAL '19 day', 'PRESENT', 4.5, 'Assisted medical team logistics.', NOW() - INTERVAL '19 day', NOW(), NOW(), 4, 3, 1),
(CURRENT_DATE - INTERVAL '2 day', 'ABSENT', 0.0, 'No show.', NOW() - INTERVAL '2 day', NOW(), NOW(), 2, 4, 3),
(CURRENT_DATE - INTERVAL '1 day', 'PRESENT', 3.0, 'Packed 40 food boxes.', NOW() - INTERVAL '1 day', NOW(), NOW(), 2, 4, 3),
(CURRENT_DATE, 'PRESENT', 2.0, 'Prepared digital literacy handouts.', NOW(), NOW(), NOW(), 3, 5, 2),
(CURRENT_DATE, 'PRESENT', 1.5, 'Tested workshop laptops and projectors.', NOW(), NOW(), NOW(), 5, 5, 2);

-- Verify BLOCK 8: Run this to confirm attendance records were inserted
SELECT COUNT(*) as attendance_count FROM attendance;

-- ============================================================================
-- FINAL VERIFICATION: Check all tables have data
-- ============================================================================
SELECT
    (SELECT COUNT(*) FROM college) as college_count,
    (SELECT COUNT(*) FROM category) as category_count,
    (SELECT COUNT(*) FROM "user") as user_count,
    (SELECT COUNT(*) FROM campaign) as campaign_count,
    (SELECT COUNT(*) FROM progress) as progress_count,
    (SELECT COUNT(*) FROM campaign_photo) as photo_count,
    (SELECT COUNT(*) FROM application) as application_count,
    (SELECT COUNT(*) FROM attendance) as attendance_count;

