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

package org.wso2.carbon.identity.oauth2.grant.rest.endpoint.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.oauth2.grant.rest.core.exception.AuthenticationClientException;
import org.wso2.carbon.identity.oauth2.grant.rest.endpoint.constant.Constants;
import org.wso2.carbon.identity.oauth2.grant.rest.endpoint.dto.RestAuthEndpointErrorDTO;
import java.io.File;
import java.util.Properties;

/**
 * This class contains the configurations from properties file.
 */
public class ConfigUtil {

    private static final Log LOG = LogFactory.getLog(ConfigUtil.class);
    private static boolean isPropertyFileAvailable  = false;

    public static boolean isIsPropertyFileAvailable() {
        return isPropertyFileAvailable;
    }

    public static boolean checkPropertyFileAvailability() {

        String configFilePath = Constants.CONFIG_FILE_PATH + Constants.CONFIG_FILE_NAME;
        File configFile = new File(configFilePath);
        if (configFile.exists()) {
            if (LOG.isDebugEnabled()) {
                LOG.debug(String.format(" %s file loaded from %s.", Constants.CONFIG_FILE_NAME,
                        Constants.CONFIG_FILE_PATH + Constants.CONFIG_FILE_NAME));
            }
            isPropertyFileAvailable = true;
            return true;
        } else {
            LOG.info("Default configurations are taken");
            return false;
        }
    }

    public RestAuthEndpointErrorDTO sanitizeAndPopulateConfigs
            (Properties properties, AuthenticationClientException ex) {

        RestAuthEndpointErrorDTO errorDTO = new RestAuthEndpointErrorDTO();

        String clientMandatoryParamsEmptyValue =
                StringUtils.trim(properties.getProperty(Constants.CLIENT_MANDATORY_PARAMS_EMPTY));
        String clientInvalidAuthenticatorValue =
                StringUtils.trim(properties.getProperty(Constants.CLIENT_INVALID_AUTHENTICATOR));
        String clientInvalidClientIdValue =
                StringUtils.trim(properties.getProperty(Constants.CLIENT_INVALID_CLIENT_ID));
        String clientIncorrectUserCredentialsValue =
                StringUtils.trim(properties.getProperty(Constants.CLIENT_INCORRECT_USER_CREDENTIALS));
        String clientInactiveFlowIdValue =
                StringUtils.trim(properties.getProperty(Constants.CLIENT_INACTIVE_FLOW_ID));
        String clientInvalidFlowIdValue =
                StringUtils.trim(properties.getProperty(Constants.CLIENT_INVALID_FLOW_ID));
        String clientAuthStepOutOfBoundValue =
                StringUtils.trim(properties.getProperty(Constants.CLIENT_AUTH_STEP_OUT_OF_BOUND));
        String clientUnSupportedAuthenticatorValue =
                StringUtils.trim(properties.getProperty(Constants.CLIENT_UNSUPPORTED_AUTHENTICATOR));
        String clientExpiredFlowIdValue =
                StringUtils.trim(properties.getProperty(Constants.CLIENT_EXPIRED_FLOW_ID));
        String clientLockedUserAccountValue =
                StringUtils.trim(properties.getProperty(Constants.CLIENT_LOCKED_USER_ACCOUNT));
        String clientDisabledUserAccountValue =
                StringUtils.trim(properties.getProperty(Constants.CLIENT_DISABLED_USER_ACCOUNT));
        String clientFlowIdMismatchValue =
                StringUtils.trim(properties.getProperty(Constants.CLIENT_FLOW_ID_MISMATCH));
        String clientInvalidUserCredentialsValue =
                StringUtils.trim(properties.getProperty(Constants.CLIENT_INVALID_USER_CREDENTIALS));
        String clientCrossTenantAccessRestrictionValue =
                StringUtils.trim(properties.getProperty(Constants.CLIENT_CROSS_TENANT_ACCESS_RESTRICTION));
        String clientUsernameResolveFailedValue =
                StringUtils.trim(properties.getProperty(Constants.CLIENT_USERNAME_RESOLVE_FAIL));
        String eventHandlerFailureValue = StringUtils.trim(properties.getProperty
                (Constants.CLIENT_EVENT_HANDLER));


        String clientMandatoryParamsEmpty = StringUtils.isNotEmpty(clientMandatoryParamsEmptyValue) ?
                clientMandatoryParamsEmptyValue : errorFormatter(ex);
        errorDTO.setClientMandatoryParamsEmpty(clientMandatoryParamsEmpty);

        String clientInvalidAuthenticator = StringUtils.isNotEmpty(clientInvalidAuthenticatorValue) ?
                clientInvalidAuthenticatorValue : errorFormatter(ex);
        errorDTO.setClientInvalidAuthenticator(clientInvalidAuthenticator);

        String clientInvalidClientId = StringUtils.isNotEmpty(clientInvalidClientIdValue) ?
                clientInvalidClientIdValue : errorFormatter(ex);
        errorDTO.setClientInvalidClientId(clientInvalidClientId);

        String clientIncorrectUserCredentials = StringUtils.isNotEmpty(clientIncorrectUserCredentialsValue) ?
                clientIncorrectUserCredentialsValue : errorFormatter(ex);
        errorDTO.setClientIncorrectUserCredentials(clientIncorrectUserCredentials);

        String clientInactiveFlowId = StringUtils.isNotEmpty(clientInactiveFlowIdValue) ? clientInactiveFlowIdValue :
                errorFormatter(ex);
        errorDTO.setClientInactiveFlowId(clientInactiveFlowId);

        String clientInvalidFlowId = StringUtils.isNotEmpty(clientInvalidFlowIdValue) ? clientInvalidFlowIdValue :
                errorFormatter(ex);
        errorDTO.setClientInvalidFlowId(clientInvalidFlowId);

        String clientAuthStepOutOfBound = StringUtils.isNotEmpty(clientAuthStepOutOfBoundValue) ?
                clientAuthStepOutOfBoundValue : errorFormatter(ex);
        errorDTO.setClientAuthStepOutOfBound(clientAuthStepOutOfBound);

        String clientUnSupportedAuthenticator = StringUtils.isNotEmpty(clientUnSupportedAuthenticatorValue) ?
                clientUnSupportedAuthenticatorValue : errorFormatter(ex);
        errorDTO.setClientUnSupportedAuthenticator(clientUnSupportedAuthenticator);

        String clientExpiredFlowId = StringUtils.isNotEmpty(clientExpiredFlowIdValue) ? clientExpiredFlowIdValue :
                errorFormatter(ex);
        errorDTO.setClientExpiredFlowId(clientExpiredFlowId);

        String clientLockedUserAccount = StringUtils.isNotEmpty(clientLockedUserAccountValue) ?
                clientLockedUserAccountValue : errorFormatter(ex);
        errorDTO.setClientLockedUserAccount(clientLockedUserAccount);

        String clientDisabledUserAccount = StringUtils.isNotEmpty(clientDisabledUserAccountValue) ?
                clientDisabledUserAccountValue : errorFormatter(ex);
        errorDTO.setClientDisabledUserAccount(clientDisabledUserAccount);

        String clientFlowIdMismatch = StringUtils.isNotEmpty(clientFlowIdMismatchValue) ? clientFlowIdMismatchValue :
                errorFormatter(ex);
        errorDTO.setClientFlowIdMismatch(clientFlowIdMismatch);

        String clientInvalidUserCredentials = StringUtils.isNotEmpty(clientInvalidUserCredentialsValue) ?
                clientInvalidUserCredentialsValue : errorFormatter(ex);
        errorDTO.setClientInvalidUserCredentials(clientInvalidUserCredentials);

        String clientCrossTenantAccessRestriction = StringUtils.isNotEmpty(clientCrossTenantAccessRestrictionValue) ?
                clientCrossTenantAccessRestrictionValue : errorFormatter(ex);
        errorDTO.setClientCrossTenantAccessRestriction(clientCrossTenantAccessRestriction);

        String clientUsernameResolveFailed = StringUtils.isNotEmpty(clientUsernameResolveFailedValue) ?
                clientUsernameResolveFailedValue : errorFormatter(ex);
        errorDTO.setClientUsernameResolveFailed(clientUsernameResolveFailed);

        String  eventHandlerFailed = StringUtils.isNotEmpty(eventHandlerFailureValue) ? eventHandlerFailureValue :
                errorFormatter(ex);
        errorDTO.setClientEventHandlerFailure(eventHandlerFailed);

        return errorDTO;
    }

    public String errorFormatter(AuthenticationClientException ex) {
        return ex.getErrorCode() + ";" + ex.getMessage() + ";" + ex.getDescription();
    }

}
