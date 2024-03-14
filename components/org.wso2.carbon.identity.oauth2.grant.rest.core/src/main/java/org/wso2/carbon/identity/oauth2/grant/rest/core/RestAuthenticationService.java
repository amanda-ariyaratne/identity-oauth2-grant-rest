/*
 * Copyright (c) 2024, WSO2 LLC. (http://www.wso2.com).
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.oauth2.grant.rest.core;
import org.wso2.carbon.identity.oauth2.grant.rest.core.dto.AuthenticationInitializationResponseDTO;
import org.wso2.carbon.identity.oauth2.grant.rest.core.dto.AuthenticationStepsResponseDTO;
import org.wso2.carbon.identity.oauth2.grant.rest.core.dto.UserAuthenticationResponseDTO;
import org.wso2.carbon.identity.oauth2.grant.rest.core.exception.AuthenticationException;

/**
 * This interface holds back-channel authentication services to process step based authentication.
 */
public interface RestAuthenticationService {

    /**
     * This method returns the Steps for the Authentication flow.
     *
     * @param clientId                          UUID to track the flow.
     * @throws AuthenticationException          If any server or client error occurred.
     * @return AuthenticationStepsResponseDTO   Returns an AuthenticationStepsResponseDTO object.
     */
    AuthenticationStepsResponseDTO getAuthenticationStepsFromSP(String clientId) throws AuthenticationException;

    /**
     * This method initialize the authentication flow with BasicAuth or Identifier First.
     *
     * @param clientId                          Client id of the service provider.
     * @param authenticator                     Authenticator Name.
     * @param password                          Password to be validated.
     * @param userIdentifier                    User Identifier attribute.
     * @param requestTenantDomain               Initiated tenant domain.
     * @return UserAuthenticationResponseDTO    Returns a UserAuthenticationResponseDTO object.
     * @throws AuthenticationException          If any server or client error occurred.
     */
    UserAuthenticationResponseDTO initializeAuthFlow
    (String clientId, String authenticator, String password, String userIdentifier, String requestTenantDomain)
            throws AuthenticationException;

    /**
     * This method initialize the authentication flow for the current step.
     *
     * @param flowId                                    UUID to track the flow.
     * @param authenticator                             Authenticator Name.
     * @return AuthenticationInitializationResponseDTO  Returns an AuthenticationInitializationResponseDTO object.
     * @throws AuthenticationException                  If any server or client error occurred.
     */
    AuthenticationInitializationResponseDTO executeAuthStep(String flowId,
            String authenticator) throws AuthenticationException;

    /**
     * This method process the authentication response from the client.
     *
     * @param flowId                            UUID to track the flow.
     * @param authenticator                     Authenticator Name.
     * @param password       	                Password to be validated.
     * @return UserAuthenticationResponseDTO    Returns a UserAuthenticationResponseDTO object.
     * @throws AuthenticationException          If any server or client error occurred.
     */
    UserAuthenticationResponseDTO processAuthStepResponse(String flowId, String authenticator, String password)
            throws AuthenticationException;

}
