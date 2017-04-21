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
package io.c12.bala.spring.controller;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import io.c12.bala.service.UserService;
import io.c12.bala.view.form.RegistrationForm;

/**
 * @author palanib2
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {
	
	@InjectMocks
	private LoginController loginController;
	
	@Mock
	private UserService userService;
	
	private MockMvc mockMvc;
	
	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
	    this.mockMvc = MockMvcBuilders.standaloneSetup(loginController)
	    		.setViewResolvers(viewResolver)
	    		.build();
	}

	/**
	 * Test method for {@link io.c12.bala.spring.controller.LoginController#login()}.
	 * @throws Exception 
	 */
	@Test
	public void testLogin() throws Exception {
		this.mockMvc.perform(get("/login"))
			.andExpect(status().isOk())
			.andExpect(view().name("login"));
	}

	/**
	 * Test method for {@link io.c12.bala.spring.controller.LoginController#welcome()}.
	 * @throws Exception 
	 */
	@Test
	public void testWelcome() throws Exception {
		this.mockMvc.perform(get("/welcome"))
			.andExpect(status().isOk())
			.andExpect(view().name("welcome"));
	}

	/**
	 * Test method for {@link io.c12.bala.spring.controller.LoginController#error()}.
	 * @throws Exception 
	 */
	@Test
	public void testError() throws Exception {
		this.mockMvc.perform(get("/error"))
			.andExpect(status().isOk())
			.andExpect(view().name("error"));
	}

	/**
	 * Test method for {@link io.c12.bala.spring.controller.LoginController#register(org.springframework.ui.Model)}.
	 * @throws Exception 
	 */
	@Test
	public void testRegister() throws Exception {
		this.mockMvc.perform(get("/register"))
			.andExpect(status().isOk())
			.andExpect(view().name("register"))
			.andExpect(model().attribute("registrationForm", allOf(
					hasProperty("firstName", isEmptyOrNullString()),
					hasProperty("lastName", isEmptyOrNullString()),
					hasProperty("email", isEmptyOrNullString())
		)));
	}

	/**
	 * Test method for {@link io.c12.bala.spring.controller.LoginController#registerUser(io.c12.bala.view.form.RegistrationForm, org.springframework.ui.Model)}.
	 * @throws Exception 
	 */
	@Test
	public void testRegisterUser() throws Exception {
		RegistrationForm registrationForm = new RegistrationForm();
		when(userService.addUser(any(RegistrationForm.class))).thenReturn(true);
		this.mockMvc.perform(post("/registerUser").sessionAttr("formRegister", registrationForm))
			.andExpect(status().isOk())
			.andExpect(model().attribute("success", "User registered successfully"))
			.andExpect(view().name("register"));
	}
	
	/**
	 * Test method for {@link io.c12.bala.spring.controller.LoginController#registerUser(io.c12.bala.view.form.RegistrationForm, org.springframework.ui.Model)}.
	 * @throws Exception 
	 */
	@Test
	public void testNegativeRegisterUser() throws Exception {
		RegistrationForm registrationForm = new RegistrationForm();
		when(userService.addUser(any(RegistrationForm.class))).thenReturn(false);
		this.mockMvc.perform(post("/registerUser").sessionAttr("formRegister", registrationForm))
			.andExpect(status().isOk())
			.andExpect(model().attribute("Failed", "Error occured during registration, Try again later"))
			.andExpect(view().name("register"));
	}

}
