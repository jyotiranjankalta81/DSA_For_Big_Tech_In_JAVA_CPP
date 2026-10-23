
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Locale;


public class LocaleTimeAndDate {

    public static void main(String[] args) {

        // ============================================================
        // 1. CHOOSING THE CORRECT TYPE
        // ============================================================
        // LocalDate     → date only: birthday, admission, attendance date
        // LocalTime     → time only: daily opening or meal time
        // LocalDateTime → date + time, WITHOUT offset or time zone
        // Instant       → a specific moment on the global timeline
        // OffsetDateTime→ date + time + UTC offset, such as +05:30
        // ZonedDateTime → date + time + regional time-zone rules
        //
        // IMPORTANT:
        // LocalDateTime alone does NOT identify a unique global moment.

        LocalDate birthday = LocalDate.of(2000, 5, 15);
        LocalTime openingTime = LocalTime.of(9, 30);
        LocalDateTime appointment =
                LocalDateTime.of(2026, 10, 6, 13, 30);

        Instant eventTime = Instant.parse("2026-10-06T08:00:00Z");

        OffsetDateTime offsetTime =
                OffsetDateTime.parse("2026-10-06T13:30:00+05:30");

        ZoneId indiaZone = ZoneId.of("Asia/Kolkata");
        ZonedDateTime indiaTime = eventTime.atZone(indiaZone);

        System.out.println(birthday);    // 2000-05-15
        System.out.println(openingTime); // 09:30
        System.out.println(appointment); // 2026-10-06T13:30
        System.out.println(eventTime);   // 2026-10-06T08:00:00Z
        System.out.println(indiaTime);
        // 2026-10-06T13:30+05:30[Asia/Kolkata]


        // ============================================================
        // 2. UTC VS OFFSET VS TIME ZONE
        // ============================================================
        // UTC: global reference time; Z means zero UTC offset.
        // Offset: fixed difference from UTC, such as +05:30.
        // ZoneId: region's rules, including historical/DST changes.
        //
        // Use "Asia/Kolkata", not ambiguous abbreviations like "IST".

        ZoneOffset indiaOffset = ZoneOffset.of("+05:30");

        ZonedDateTime londonTime =
                eventTime.atZone(ZoneId.of("Europe/London"));

        // Different local displays can represent the SAME instant.
        System.out.println(indiaTime.toInstant()
                .equals(londonTime.toInstant())); // true

        // OffsetDateTime also identifies an instant.
        System.out.println(offsetTime.toInstant().equals(eventTime)); // true


        // ============================================================
        // 3. CONVERTING BETWEEN TYPES
        // ============================================================

        // Attach a regional zone to a local date/time.
        // DST gaps/overlaps use Java's default resolution rules.
        ZonedDateTime zonedAppointment = appointment.atZone(indiaZone);

        // Convert to a global timestamp.
        Instant appointmentInstant = zonedAppointment.toInstant();

        // Convert a timestamp to a user's local date.
        LocalDate userDate = eventTime.atZone(indiaZone).toLocalDate();

        // Convert zones while preserving the SAME instant.
        ZonedDateTime sameMomentInLondon =
                indiaTime.withZoneSameInstant(ZoneId.of("Europe/London"));

        // withZoneSameLocal() attempts to preserve local clock fields;
        // it generally changes the instant. Use only when that is intended.


        // ============================================================
        // 4. IMMUTABILITY
        // ============================================================
        // Main java.time value types are immutable and thread-safe.
        // Methods return a result; they do not modify the original.

        LocalDate original = LocalDate.of(2026, 10, 6);

        original.plusDays(5); // Result ignored
        System.out.println(original); // 2026-10-06

        LocalDate updated = original.plusDays(5);
        System.out.println(updated);  // 2026-10-11


        // ============================================================
        // 5. PARSING AND FORMATTING
        // ============================================================
        // Parsing:    String → date/time
        // Formatting: date/time → String
        //
        // DateTimeFormatter is immutable and thread-safe.
        // SimpleDateFormat is mutable and NOT thread-safe.

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/uuuu")
                        .withResolverStyle(ResolverStyle.STRICT);

        LocalDate parsed = LocalDate.parse("06/10/2026", formatter);
        String formatted = parsed.format(formatter);

        System.out.println(formatted); // 06/10/2026

        // Use an explicit locale for textual month/day names.
        DateTimeFormatter readable =
                DateTimeFormatter.ofPattern("dd MMM uuuu", Locale.ENGLISH);

        System.out.println(parsed.format(readable)); // 06 Oct 2026

        // IMPORTANT PATTERNS:
        // uuuu → year
        // yyyy → year of era
        // YYYY → week-based year; may differ near New Year!
        // MM   → month
        // mm   → minute
        // dd   → day of month
        // DD   → day of year
        // HH   → 24-hour clock
        // hh   → 12-hour clock, usually paired with "a"

        try {
            LocalDate.parse("31/02/2026", formatter);
        } catch (DateTimeParseException exception) {
            System.out.println("Invalid date rejected");
        }


        // ============================================================
        // 6. DATE ARITHMETIC AND MONTH BOUNDARIES
        // ============================================================

        LocalDate date = LocalDate.of(2026, 1, 31);

        System.out.println(date.plusMonths(1)); // 2026-02-28
        // Adjusts to the last valid day of the target month.

        LocalDate firstDay =
                date.with(TemporalAdjusters.firstDayOfMonth());

        LocalDate lastDay =
                date.with(TemporalAdjusters.lastDayOfMonth());

        LocalDate nextMonday =
                date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));

        boolean leapYear = Year.isLeap(2028); // true

        YearMonth billingMonth = YearMonth.of(2026, 2);
        System.out.println(billingMonth.lengthOfMonth()); // 28

        // Business-day calculations need your weekend/holiday rules.
        // plusDays(1) means the next calendar day, not next working day.


        // ============================================================
        // 7. PERIOD VS DURATION VS TOTAL DAYS
        // ============================================================
        // Period   → calendar amount: years, months, days
        // Duration → time-based amount: seconds and nanoseconds

        LocalDate referenceDate = LocalDate.of(2026, 10, 6);
        int age = Period.between(birthday, referenceDate).getYears();

        System.out.println(age); // 26

        Instant finishedAt = eventTime.plusSeconds(90);
        Duration elapsed = Duration.between(eventTime, finishedAt);

        System.out.println(elapsed.toSeconds()); // 90

        long totalDays = ChronoUnit.DAYS.between(
                LocalDate.of(2026, 1, 1),
                LocalDate.of(2026, 2, 2)
        );
        System.out.println(totalDays); // 32

        Period calendarDifference = Period.between(
                LocalDate.of(2026, 1, 1),
                LocalDate.of(2026, 2, 2)
        );
        System.out.println(calendarDifference);           // P1M1D
        System.out.println(calendarDifference.getDays()); // 1, NOT 32


        // ============================================================
        // 8. DAYLIGHT SAVING: ONE DAY IS NOT ALWAYS 24 HOURS
        // ============================================================
        // Example: New York moves clocks forward on 2026-03-08.

        ZonedDateTime beforeDst = ZonedDateTime.of(
                2026, 3, 7, 12, 0, 0, 0,
                ZoneId.of("America/New_York")
        );

        ZonedDateTime nextDay = beforeDst.plusDays(1);
        ZonedDateTime after24Hours = beforeDst.plusHours(24);

        System.out.println(nextDay.getHour());      // 12
        System.out.println(after24Hours.getHour()); // 13

        System.out.println(Duration.between(
                beforeDst.toInstant(), nextDay.toInstant()
        ).toHours()); // 23

        // Detect ambiguous/nonexistent local appointment times.
        LocalDateTime localBooking =
                LocalDateTime.of(2026, 3, 8, 2, 30);

        int validOffsetCount = ZoneId.of("America/New_York")
                .getRules()
                .getValidOffsets(localBooking)
                .size();

        // 0 → gap: local time does not exist
        // 1 → normal: one valid instant
        // 2 → overlap: local time occurs twice
        System.out.println(validOffsetCount); // 0

        // Enterprise rule:
        // Explicitly decide whether to reject, shift, or disambiguate
        // bookings during DST gaps and overlaps.


        // ============================================================
        // 9. COMPARISON AND EXPIRY BOUNDARIES
        // ============================================================

        Instant expiresAt = eventTime.plus(Duration.ofMinutes(5));
        Instant now = eventTime.plus(Duration.ofMinutes(5));

        // Expired when now >= expiresAt, including exact equality.
        boolean expired = !now.isBefore(expiresAt);
        System.out.println(expired); // true

        System.out.println(eventTime.isBefore(expiresAt)); // true

        // ZonedDateTime equality:
        System.out.println(indiaTime.isEqual(londonTime)); // true
        // Same instant

        System.out.println(indiaTime.equals(londonTime));  // false
        // Different zone/local representation


        // ============================================================
        // 10. QUERYING ALL EVENTS FOR A LOCAL DATE
        // ============================================================
        // Convert the user's local day boundaries to instants.
        // Query using [start inclusive, end exclusive).

        LocalDate reportDay = LocalDate.of(2026, 10, 6);

        Instant from = reportDay.atStartOfDay(indiaZone).toInstant();
        Instant until = reportDay.plusDays(1)
                .atStartOfDay(indiaZone).toInstant();

        // SQL:
        // WHERE created_at >= :from AND created_at < :until
        //
        // Avoid:
        // ... <= 23:59:59.999
        //
        // Benefits:
        // - Handles timestamp precision differences.
        // - Avoids overlap between consecutive date ranges.
        // - Handles days whose length changes due to DST.


        // ============================================================
        // 11. CLOCK: MAKE CURRENT TIME TESTABLE
        // ============================================================
        // Production: Clock.systemUTC()
        // Tests: Clock.fixed(...)
        //
        // Inject Clock into services instead of hardcoding now() calls.

        Clock fixedClock = Clock.fixed(
                Instant.parse("2026-10-06T08:00:00Z"),
                ZoneOffset.UTC
        );

        ExpiryService expiryService = new ExpiryService(fixedClock);

        System.out.println(expiryService.isExpired(
                Instant.parse("2026-10-06T08:00:00Z")
        )); // true

        // Derive today's date in the business region.
        LocalDate branchToday =
                LocalDate.now(fixedClock.withZone(indiaZone));

        System.out.println(branchToday); // 2026-10-06

        // Test important boundaries:
        // - Just before expiry
        // - Exactly at expiry
        // - Just after expiry
        // - Midnight in the business zone
        // - Leap day and month end
        // - DST gaps and overlaps


        // ============================================================
        // 12. EPOCH SECONDS VS MILLISECONDS
        // ============================================================
        // Unix epoch starts at 1970-01-01T00:00:00Z.
        // Always specify units in API contracts and variable names.

        long epochSeconds = eventTime.getEpochSecond();
        long epochMillis = eventTime.toEpochMilli();

        Instant fromSeconds = Instant.ofEpochSecond(epochSeconds);
        Instant fromMillis = Instant.ofEpochMilli(epochMillis);

        // Mixing seconds and milliseconds produces incorrect dates.
        // Millisecond conversion also loses sub-millisecond precision.


        // ============================================================
        // 13. LEGACY DATE INTEROPERABILITY
        // ============================================================
        // java.util.Date represents a timestamp, not a region zone.
        // Its displayed text may use the JVM's default zone.

        Date legacyDate = Date.from(eventTime);
        Instant convertedBack = legacyDate.toInstant();

        System.out.println(convertedBack.equals(eventTime)); // true
        // This example has no precision below milliseconds.


        // ============================================================
        // 14. MEASURE EXECUTION TIME WITH nanoTime()
        // ============================================================
        // Wall clocks can be adjusted.
        // nanoTime() differences are intended for elapsed-time measurement.
        // Do not persist nanoTime() as a timestamp.

        long startNanos = System.nanoTime();

        performWork();

        long elapsedNanos = System.nanoTime() - startNanos;
        System.out.println("Elapsed nanoseconds: " + elapsedNanos);


        // ============================================================
        // 15. ENTERPRISE MODELING RULES
        // ============================================================
        // Birthday          → LocalDate; do not convert it to UTC midnight
        // Attendance day    → LocalDate interpreted in the school zone
        // Daily meal time   → LocalTime + branch ZoneId
        // Post created time → Instant
        // OTP expiry        → Instant + Duration
        // Billing month     → YearMonth
        // Future appointment→ local date/time + region ZoneId
        //
        // Store global event moments consistently, commonly in UTC.
        // Preserve regional scheduling intent separately when required.
        //
        // Additional concerns:
        // - DB timestamp precision may truncate nanoseconds.
        // - Server clocks can differ across distributed instances.
        // - Timestamps alone do not guarantee event ordering.
        // - Decide whether app or database owns audit timestamps.
        // - Maintain time-zone data because governments can change rules.
    }

    static void performWork() {
        // Your operation goes here.
    }

    // Runnable core example; can also be a Spring @Service.
    static class ExpiryService {
        private final Clock clock;

        ExpiryService(Clock clock) {
            this.clock = clock;
        }

        boolean isExpired(Instant expiresAt) {
            return !Instant.now(clock).isBefore(expiresAt);
        }
    }


    /*
    ================================================================
    16. SPRING BOOT: REGISTER CLOCK FOR DEPENDENCY INJECTION
    ================================================================
    Place in a configuration class.

    Imports:
      org.springframework.context.annotation.Bean
      org.springframework.context.annotation.Configuration

    @Configuration
    class TimeConfiguration {
        @Bean
        Clock clock() {
            return Clock.systemUTC();
        }
    }

    Inject Clock using constructor injection into your @Service.
    Use Instant.now(clock) for global timestamps.
    Use LocalDate.now(clock.withZone(branchZone)) for a branch's date.


    ================================================================
    17. SPRING MVC: QUERY PARAMETER BINDING
    ================================================================
    Place in a @RestController.

    Imports:
      org.springframework.web.bind.annotation.*
      org.springframework.format.annotation.DateTimeFormat

    @GetMapping("/attendance")
    public String attendance(
            @RequestParam("date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate date) {

        return "Attendance for " + date;
    }

    Request:
      GET /attendance?date=2026-10-06

    @DateTimeFormat controls Spring string-to-date binding.
    It does NOT control JSON request/response serialization.


    ================================================================
    18. SPRING BOOT: JSON REQUESTS AND VALIDATION
    ================================================================
    JSON is handled by the configured JSON mapper, commonly Jackson.
    Ensure support for java.time and test your actual mapper configuration.

    Imports:
      jakarta.validation.Valid
      jakarta.validation.constraints.NotNull
      jakarta.validation.constraints.PastOrPresent
      org.springframework.web.bind.annotation.*

    public record AdmissionRequest(
            @NotNull @PastOrPresent LocalDate birthDate,
            @NotNull OffsetDateTime submittedAt
    ) {}

    @PostMapping("/admissions")
    public String createAdmission(
            @Valid @RequestBody AdmissionRequest request) {

        return "Received";
    }

    Example JSON:
    {
      "birthDate": "2000-05-15",
      "submittedAt": "2026-10-06T13:30:00+05:30"
    }

    Requires a Bean Validation provider, usually supplied through
    the application's validation starter.

    Useful constraints:
      @Past
      @PastOrPresent
      @Future
      @FutureOrPresent

    These temporal constraints allow null by themselves.
    Add @NotNull when the field is required.

    Validation uses its configured clock/time zone.
    For branch-specific "today", apply the branch's business-zone rule.
    Cross-field rules such as start < end need additional validation.

    For custom Jackson JSON formatting, @JsonFormat is available.
    Prefer explicit ISO contracts unless a different format is required.

    For trusted audit timestamps such as createdAt:
      Generate them server-side instead of trusting client input.


    ================================================================
    19. JPA / HIBERNATE: ENTITY FIELD TYPES
    ================================================================
    Example entity fields:

      private LocalDate birthDate;   // Typically SQL DATE
      private LocalTime openingTime; // Typically SQL TIME
      private Instant createdAt;     // Global event moment
      private Instant updatedAt;

      // Preserve a future appointment's regional intent:
      private LocalDateTime appointmentLocal;
      private String appointmentZoneId; // "Europe/London"

    OffsetDateTime / ZonedDateTime storage depends on Hibernate,
    dialect, configuration, driver, and database column type.

    Do not assume a timezone-aware SQL column preserves an original
    region name such as "Europe/London".

    @Temporal is for legacy Date/Calendar mappings.
    Do NOT apply it to java.time fields.

    Common application.properties setting:

      spring.jpa.properties.hibernate.jdbc.time_zone=UTC

    This controls relevant JDBC time-zone conversions.
    It does not give LocalDateTime a zone or make all storage correct.

    Verify:
      - Java → database → Java round trips
      - Column type and fractional-second precision
      - Session/JDBC time-zone configuration
      - Whether original offsets or region IDs must be retained


    ================================================================
    20. SPRING DATA JPA AUDITING
    ================================================================
    Typical setup:

    @Configuration
    @EnableJpaAuditing
    class AuditConfiguration {}

    @Entity
    @EntityListeners(AuditingEntityListener.class)
    class Post {
        @Id
        @GeneratedValue
        private Long id;

        @CreatedDate
        @Column(nullable = false, updatable = false)
        private Instant createdAt;

        @LastModifiedDate
        private Instant updatedAt;

        protected Post() {}
    }

    Relevant imports:
      jakarta.persistence.*
      org.springframework.data.annotation.CreatedDate
      org.springframework.data.annotation.LastModifiedDate
      org.springframework.data.jpa.domain.support.AuditingEntityListener
      org.springframework.data.jpa.repository.config.EnableJpaAuditing

    Auditing requires the listener/configuration and relevant dependencies.
    Merely adding @CreatedDate to a field is not the complete setup.

    Choose a consistent audit-time source.
    Spring Data auditing can use a custom DateTimeProvider.
    Injecting Clock into your own service does not automatically change
    the clock used by auditing or Bean Validation.

    Bulk JPQL/native updates bypass normal entity lifecycle callbacks;
    account for audit fields in those paths.


    ================================================================
    21. SPRING DATA: QUERY EVENTS FOR A LOCAL DAY
    ================================================================
    First compute "from" and "until" as shown in section 10.

    public interface PostRepository extends JpaRepository<Post, Long> {

        @Query("select p from Post p " +
               "where p.createdAt >= :from and p.createdAt < :until")
        List<Post> findInRange(
                @Param("from") Instant from,
                @Param("until") Instant until);
    }

    Relevant imports:
      java.util.List
      org.springframework.data.jpa.repository.JpaRepository
      org.springframework.data.jpa.repository.Query
      org.springframework.data.repository.query.Param

    Consider an index on created_at for frequent range queries.
    For large results, use pagination.


    ================================================================
    22. SPRING SCHEDULING
    ================================================================
    Enable using @EnableScheduling on a configuration class.
    Put the scheduled method on a Spring-managed bean.

    @Scheduled(cron = "0 0 9 * * *", zone = "Asia/Kolkata")
    public void sendDailyReminder() {
        // Run at 09:00 in this zone.
    }

    Spring cron has SIX fields:
      second, minute, hour, day-of-month, month, day-of-week

    Other scheduling modes:

    @Scheduled(fixedDelay = 5000)
    public void pollAfterCompletion() {
        // Next execution starts 5 seconds after the previous finishes.
    }

    @Scheduled(fixedRate = 5000)
    public void pollAtFixedRate() {
        // Targets a 5-second period; actual timing depends on execution
        // duration and scheduler resources.
    }

    Relevant imports:
      org.springframework.scheduling.annotation.EnableScheduling
      org.springframework.scheduling.annotation.Scheduled

    ENTERPRISE CONCERNS:
      - Multiple app instances may each execute the scheduled method.
      - Use coordination when work must run only once across instances.
      - Make processing idempotent.
      - Define retries and handling of missed executions.
      - Decide DST gap/overlap behavior for regional schedules.
      - @Scheduled alone does not provide durable job storage.

    ================================================================
    */
}