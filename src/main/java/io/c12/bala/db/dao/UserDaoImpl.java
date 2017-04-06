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
package io.c12.bala.db.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.arangodb.ArangoCollection;
import com.arangodb.ArangoCursor;
import com.arangodb.ArangoDB;
import com.arangodb.ArangoDatabase;
import com.arangodb.util.MapBuilder;

import io.c12.bala.db.domain.User;

/**
 * @author b.palaniappan
 *
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	private static final String DB_NAME = "mydb";
	
	private static final String COLLECTION_NAME = "USER";
	
	private String passwordHash = null;

	@Override
	public final User addUser(User user) {
		getDbCollection().insertDocument(user);
		return user;
	}

	@Override
	public final String getPasswordHashByUserId(String userId) {
		String query = "for u in user filter u.auth.userId == @userId return u.auth.password";
		Map<String, Object> bindVars = new MapBuilder().put("userId", userId).get();
		ArangoCursor<String> passwordHashCursor = getDb().query(query, bindVars, null, String.class);
		if (passwordHashCursor.getCount() != 1) {
			return null;
		} else {
			passwordHashCursor.forEachRemaining(password -> {
				passwordHash = password;
			});
		}
		return passwordHash;
	}

	@Override
	public final boolean updatePassword(String paswordHash, String userKey) {
		// TODO Auto-generated method stub
		return false;
	}
	
	// TODO: DB and Collection config as spring inject
	private final ArangoDatabase getDb() {
		return new ArangoDB.Builder().user("root").build().db(DB_NAME);
	}
	
	private final ArangoCollection getDbCollection() {
		return new ArangoDB.Builder().user("root").build().db(DB_NAME).collection(COLLECTION_NAME);
	}

}
