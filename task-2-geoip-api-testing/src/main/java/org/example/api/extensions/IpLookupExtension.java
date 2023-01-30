package org.example.api.extensions;

import org.example.api.dto.StandardIpLookupDto;
import org.example.api.response.AssertableResponse;

/*
  Designed to simplify work with API and process responses
 */
public class IpLookupExtension extends Extension<StandardIpLookupDto> {

    public IpLookupExtension(String domain, String ip, String token) {
        super(domain, "/" + ip + "?" + "access_key=" + token, StandardIpLookupDto.class);
    }

    public AssertableResponse getStandardIpLookup() {
        return new AssertableResponse(sentGeneralGetRequest(baseEndpoint));
    }
}
