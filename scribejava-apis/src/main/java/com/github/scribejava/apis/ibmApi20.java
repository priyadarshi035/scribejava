package com.github.scribejava.apis;

import com.github.scribejava.apis.google.ibmJsonTokenExtractor;
import com.github.scribejava.core.builder.api.DefaultApi20;
import com.github.scribejava.core.extractors.TokenExtractor;
import com.github.scribejava.core.model.OAuth2AccessToken;

public class ibmApi20 extends DefaultApi20 {

    protected ibmApi20() {
    }

    private static class InstanceHolder {
        private static final ibmApi20 INSTANCE = new ibmApi20();
    }

    public static ibmApi20 instance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public String getAccessTokenEndpoint() {
        return "https://op.isam.example.com/isam/oidc/endpoint/FIMDOMAINName-FederationName/token";   //pattern for IBM
    }

    @Override
    protected String getAuthorizationBaseUrl() {
        return "https://op.isam.example.com/isam/oidc/endpoint/FIMDOMAINName-FederationName/authorize";    //pattern for IBM
    }

    @Override
    public TokenExtractor<OAuth2AccessToken> getAccessTokenExtractor() {
        return ibmJsonTokenExtractor.instance();
    }
}
