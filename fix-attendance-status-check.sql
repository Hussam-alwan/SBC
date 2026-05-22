-- One-time fix for the attendance.status CHECK constraint.
-- Hibernate generates a CHECK (status IN (...)) constraint for @Enumerated(STRING) columns
-- at table creation time, and ddl-auto=update does NOT alter it when new enum values are added.
-- So inserts with newly-added values (e.g. LATE) fail with attendance_status_check.
-- This script drops the stale constraint; Hibernate will re-create it on next startup
-- with the current set of enum values.
--
-- Run once against the impact database, e.g.:
--   psql -h localhost -p 5433 -U postgres -d impact -f fix-attendance-status-check.sql

ALTER TABLE attendance DROP CONSTRAINT IF EXISTS attendance_status_check;
