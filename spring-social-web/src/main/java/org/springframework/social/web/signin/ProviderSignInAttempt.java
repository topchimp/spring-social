/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.web.signin;

import java.io.Serializable;

/**
 * Models an attempt to sign-in to the application using a provider account.
 * Instances are created when the sign-in process could not be completed because no local account is associated with the provider account.
 * This could happen because the user has not yet signed up with the application, or has not yet connected their application account with the their provider account.
 * For the former scenario, callers should all {@link #connect(Serializable)} post-signup to establish a connection between a new user account and the provider account.
 * For the latter, existing users should sign-in using their local application credentials and formally connect to the provider they also wish to authenticate with. 
 * @author Keith Donald
 */
public interface ProviderSignInAttempt extends Serializable {

	/**
	 * Name of the session attribute ProviderSignInAttempt instances are indexed under.
	 */
	static final String SESSION_ATTRIBUTE = ProviderSignInAttempt.class.getName();
	
	/**
	 * Connect the local account with this provider account.
	 * @param accountId the local account
	 */
	void connect(Serializable accountId);

}
