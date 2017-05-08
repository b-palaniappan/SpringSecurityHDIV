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
package io.c12.bala.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import io.c12.bala.email.EmailAddress;

/**
 * @author b.palaniappan
 *
 */
@Component("mailHelper")
public class MailHelper {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private Configuration freemarkerConfiguration;
	
	/**
	 * @param mimeMessage Custom objects to be added to FreeMarker template
	 * @param template path with file name
	 * @param emailAddress collection of email address (from, reply to, cc, bcc)
	 * @param emailSubject subject line for email address
	 * @param attachments Attachment files
	 * @param inlineImages Inline images for html based emails
	 * @throws IOException
	 * @throws TemplateException
	 * 
	 * Prepare and send email using Freemarker template
	 */
	public void sendTemplatedMimeMessage(final Map<String, Object> mimeMessage, final String template, final Map<EmailAddress, List<String>> emailAddress, final String emailSubject, final Map<String, File> attachments, final Map<String, String> inlineImages) throws IOException, TemplateException {
		FileTemplateLoader templateLoader = new FileTemplateLoader(new File("src/main/resources/emails"));
		freemarkerConfiguration.setTemplateLoader(templateLoader);
		
		final String messageText = FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerConfiguration.getTemplate(template), mimeMessage);
		
		MimeMessagePreparator preparator = new MimeMessagePreparator(){

			public void prepare(MimeMessage message) throws Exception {
				MimeMessageHelper helper = new MimeMessageHelper(message, true);
				
				// -- To Address
				if (emailAddress.get(EmailAddress.TO_ADDRESS) != null && !emailAddress.get(EmailAddress.TO_ADDRESS).isEmpty()) {
					for(String address : emailAddress.get(EmailAddress.TO_ADDRESS)){
						helper.addTo(address);
					}
				} else {
					throw new Exception("To Address list is null or empty");
				}
				
				// -- CC
				if (emailAddress.get(EmailAddress.CC_ADDRESS) != null && !emailAddress.get(EmailAddress.CC_ADDRESS).isEmpty()) {
					for(String address : emailAddress.get(EmailAddress.CC_ADDRESS)){
						helper.addCc(address);
					}
				} 
				
				// -- BCC
				if (emailAddress.get(EmailAddress.BCC_ADDRESS) != null && !emailAddress.get(EmailAddress.BCC_ADDRESS).isEmpty()) {
					for(String address : emailAddress.get(EmailAddress.BCC_ADDRESS)){
						helper.addBcc(address);;
					}
				}
				
				// -- From Address
				if (emailAddress.get(EmailAddress.FROM_ADDRESS) != null && !emailAddress.get(EmailAddress.FROM_ADDRESS).isEmpty() && emailAddress.get(EmailAddress.FROM_ADDRESS).size() ==1) {
					helper.setFrom(emailAddress.get(EmailAddress.FROM_ADDRESS).get(0));
				} else {
					throw new Exception("From Address list is null or empty or more than one");
				}
				
				// -- Reply to Address
				if (emailAddress.get(EmailAddress.REPLY_TO_ADDRESS) != null && !emailAddress.get(EmailAddress.REPLY_TO_ADDRESS).isEmpty() && emailAddress.get(EmailAddress.REPLY_TO_ADDRESS).size() ==1) {
					helper.setReplyTo(emailAddress.get(EmailAddress.REPLY_TO_ADDRESS).get(0));
				}
				
				// -- email Subject
				helper.setSubject(emailSubject);
				
				// -- Attachments
				if(attachments!=null){
					for(Entry<String, File> attachment : attachments.entrySet()){
						helper.addAttachment(attachment.getKey(), attachment.getValue());
					}
				}
				helper.setText(messageText, true);
				
				// -- add inline images if any
				if (inlineImages != null && inlineImages.size() > 0) {
					for (String identifierName : inlineImages.keySet()) {
						helper.addInline(identifierName, new ClassPathResource(inlineImages.get(identifierName)));
					}
				}				
			}
		};
		this.mailSender.send(preparator);;
	}
	
}
