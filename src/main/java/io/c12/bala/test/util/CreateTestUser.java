/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package io.c12.bala.test.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.arangodb.ArangoCursor;
import com.arangodb.ArangoDB;
import com.arangodb.util.MapBuilder;
import com.lambdaworks.crypto.SCryptUtil;

import io.c12.bala.db.domain.Auth;
import io.c12.bala.db.domain.PhoneNumber;
import io.c12.bala.db.domain.PhoneType;
import io.c12.bala.db.domain.Status;
import io.c12.bala.db.domain.User;

/**
 * @author b.palaniappan
 *
 */
public class CreateTestUser {

	private static final String DB_NAME = "SpringHDIV";

	private static final String COLLECTION_NAME = "USER";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final ArangoDB arangoDB = new ArangoDB.Builder().user("root").build();

		// Create a Database
		// arangoDB.createDatabase(DB_NAME);

		// Create a Collection
		// final CollectionEntity myArangoCollection =
		// arangoDB.db(DB_NAME).createCollection(COLLECTION_NAME);

		// Drop collection
		// arangoDB.db(DB_NAME).collection(COLLECTION_NAME).drop();
		
		User user = new User();
		
		user.set_key(UUID.randomUUID().toString());
		user.setFirstName("Jack");
		user.setLastName("Daniel");
		user.setMiddleInitial("R");
		
		Auth auth = new Auth();
		auth.setUserId("jack@c12.io");
		auth.setPassword(SCryptUtil.scrypt("Password1", 16, 16, 16));
		auth.setPasswordReset(false);
		auth.setStatus(Status.ACTIVE);
		auth.setWrongLoginAttempts(0);
		
		user.setAuth(auth);
		
		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setPhoneNumber("641-555-5555");
		phoneNumber.setPhoneType(PhoneType.MOBILE);
		
		List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
		phoneNumbers.add(phoneNumber);
		
		user.setPhoneNumbers(phoneNumbers);
		
		// insert user to collection
//		arangoDB.db(DB_NAME).collection(COLLECTION_NAME).insertDocument(user);
		
		String query = "for u in USER filter u.auth.status =='ACTIVE' and u.auth.userId == @userId return u.auth.password";
		Map<String, Object> bindVars = new MapBuilder().put("userId", "jack@c12.io").get();
		ArangoCursor<String> passwordHashCursor = arangoDB.db(DB_NAME).query(query, bindVars, null, String.class);
		passwordHashCursor.forEachRemaining(password -> {
			System.out.println(password);
		});

		// Shutdown connection when done
		arangoDB.shutdown();

	}

}
