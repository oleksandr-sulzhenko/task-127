package api;

import org.example.api.dto.StandardIpLookupDto;
import org.example.api.extensions.IpLookupExtension;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Demonstrates the following task:
 *
 *   2) Go to https://freegeoip.io/ and get a free API key (be aware that it is limited to 100 requests / mo).
 *   Call their API with that key, using JSON format, and perform the following actions:
 *     a) Assert the response code;
 *     b) Parse the response;
 *     c) Assert your latitude and longitude with a 0.01° tolerance (assume you know your actual lat and lon).
 *
 */
public class IpLookupStandardScenarioTest {
    IpLookupExtension lookupExtension = new IpLookupExtension(
            BaseScenario.CONFIG.apiDomain(),
            BaseScenario.CONFIG.ipv4(),
            BaseScenario.CONFIG.accessKey());
    private static double TOLERANCE = 0.01;

    @Test
    public void verifyHardcodedLocationWithAccessKey() {
        double expectedLatitude = 50.43333053588867;
        double expectedLongitude = 30.51667022705078;
        StandardIpLookupDto standardIpLookup = lookupExtension
                .getStandardIpLookup()
                .assertStatus(200)
                .getResponseBody(StandardIpLookupDto.class);
        assertTrue(Math.abs(standardIpLookup.getLatitude() - expectedLatitude) <= TOLERANCE,
                String.format("expected latitude %f, but was %f", expectedLatitude, standardIpLookup.getLatitude()));
        assertTrue(Math.abs(standardIpLookup.getLongitude() - expectedLongitude) <= TOLERANCE,
                String.format("expected longitude %f, but was %f", expectedLongitude, standardIpLookup.getLongitude()));
    }
}